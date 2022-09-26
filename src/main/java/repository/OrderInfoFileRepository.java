package repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import order.OrderInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.UUID;

public class OrderInfoFileRepository implements OrderInfoRepository {

    private final File repoFile;
    private final ObjectMapper mapper;

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
    public String add(OrderInfo orderInfo) {
        OrderInfo order = new OrderInfo(UUID.randomUUID().toString(),
                orderInfo.getMapOrder(),
//                orderInfo.getCountSum(),
                orderInfo.getCountTotal());

        try (Scanner scanner = new Scanner(repoFile); FileWriter writer = new FileWriter(repoFile, true)) {
            while (scanner.hasNextLine()) {
                OrderInfo existValue = mapper.readValue(scanner.nextLine(), OrderInfo.class);
                if (isOrderExist(orderInfo, existValue))
                    throw new RuntimeException("Order already exist");
            }

            String serializationOrderInfo = mapper.writeValueAsString(order);
            writer.append(String.format("%s%n", serializationOrderInfo));

        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
