package repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import order.OrderInfo;
import product.Product;
import product.ProductImp;
import product.bread.Bread;
import serializer.ProductSerializer;

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
    public OrderInfo getById(String id) {
        try (Scanner scanner = new Scanner(repoFile)) {
            while (scanner.hasNextLine()) {
                OrderInfo orderInfo = mapper.readValue(scanner.nextLine(), OrderInfo.class);
                if (orderInfo.getId().equals(id)) {
                    return orderInfo;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String add(OrderInfo orderInfo) throws IOException {
        if (repoFile.exists() && repoFile.length() != 0) {
            String json = readString(String.valueOf(repoFile));
            infoList = jsonToList(json);
        }

        OrderInfo order = new OrderInfo(UUID.randomUUID().toString(),
                orderInfo.getMapOrder(),
//                orderInfo.getCountSum(),
                orderInfo.getCountTotal());
        infoList.add(order);
        
        //добавить сериализацию для OrderInfo
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(ProductImp.class, new ProductSerializer())
                .create();
        String json = gson.toJson(infoList);
        writeString(json);

//        try (Scanner scanner = new Scanner(repoFile); FileWriter writer = new FileWriter(repoFile, true)) {
////            while (scanner.hasNextLine()) {
////                OrderInfo existValue = mapper.readValue(scanner.nextLine(), OrderInfo.class);
////                if (isOrderExist(orderInfo, existValue))
////                    throw new RuntimeException("Order already exist");
////            }
//            String serializationOrderInfo = mapper.writeValueAsString(order);
//            writer.append(String.format("%s%n", serializationOrderInfo));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.printf("Ваш заказ оформлен!\nНомер заказа %s ", order.getId());
        return order.getId();
    }

    @Override
    public OrderInfo remove(String id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public OrderInfo update(String id) {
        throw new RuntimeException("Not implemented");
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

    private static boolean isOrderExist(OrderInfo orderInfo, OrderInfo existsValue) {
        return existsValue.getMapOrder().equals(orderInfo.getMapOrder())
//                && existsValue.getCountSum() == orderInfo.getCountSum()
                && existsValue.getCountTotal() == orderInfo.getCountTotal();
    }

    public void writeString(String json) {
//        try (FileWriter writer = new FileWriter("src/main/resources/new_data_with_type.json")) {
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
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type type = new TypeToken<List<ProductImp>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
