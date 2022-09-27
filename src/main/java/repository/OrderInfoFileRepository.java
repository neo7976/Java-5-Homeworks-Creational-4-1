package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import order.OrderInfo;


import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.*;

public class OrderInfoFileRepository implements OrderInfoRepository {

    private final File repoFile;
    private final ObjectMapper mapper;
    private List<OrderInfo> infoList = new ArrayList<>();

    public OrderInfoFileRepository(File repoFile, ObjectMapper mapper) {
        createRepoFileIfNotExists(repoFile);
        this.repoFile = repoFile;
        this.mapper = mapper;
    }

    @Override
    public OrderInfo getById(String id) throws IOException {
        for (OrderInfo orderInfo : infoList) {
            if (orderInfo.getId().equals(id))
                return orderInfo;
        }
        update();
        for (OrderInfo orderInfo : infoList) {
            if (orderInfo.getId().contains(id))
                return orderInfo;
        }
        return null;
    }


    @Override
    public String add(OrderInfo orderInfo) throws IOException {
        update();
        OrderInfo order = new OrderInfo(UUID.randomUUID().toString(),
                orderInfo.getData(),
                orderInfo.getListOrder(),
                orderInfo.getPriceTotal());
        infoList.add(order);

        Gson gson = new GsonBuilder().setPrettyPrinting()
                .create();
        String json = gson.toJson(infoList);
        writeString(json);

        System.out.printf("Ваш заказ оформлен!\nНомер заказа %s ", order.getId());
        return order.getId();
    }

    private void update() throws IOException {
        if (repoFile.exists() && repoFile.length() != 0) {
            String json = readString(String.valueOf(repoFile));
            infoList = jsonToList(json);
        }
    }

    @Override
    public OrderInfo remove(String id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void returnOrder(String id) throws IOException {
        update();
        if (infoList.removeIf(orderNext -> orderNext.getId().contains(id))) {
            System.out.printf("Заказ под номером %s удален!\n", id);
            Gson gson = new GsonBuilder().setPrettyPrinting()
                    .create();
            String json = gson.toJson(infoList);
            writeString(json);
        } else
            System.out.println("Заказ не найдет!");
    }

    private static void createRepoFileIfNotExists(File repoFile) {
        if (!Files.exists(repoFile.toPath())) {
            try {
                Files.createFile(repoFile.toPath());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void writeString(String json) {
        try (FileWriter writer = new FileWriter(repoFile)) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readString(String jsonWay) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonWay));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s);
        }
        bufferedReader.close();
        return sb.toString();
    }


    public List<OrderInfo> jsonToList(String json) throws IOException {
        Gson gson = new GsonBuilder()
                .create();
        Type type = new TypeToken<List<OrderInfo>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
