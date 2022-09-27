import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import order.OrderInfo;
import product.Product;
import product.ProductFactory;
import product.ProductType;
import repository.OrderInfoFileRepository;

import java.io.File;
import java.io.IOException;

public class Shop {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules(new JavaTimeModule(), new ParameterNamesModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

//        File repoFile = new File("src/main/resources/orders.txt");
        File repoFile = new File("src/main/resources/orders.json");
        OrderInfoFileRepository orderInfoFileRepository = new OrderInfoFileRepository(repoFile, mapper);

        ProductFactory pf = new ProductFactory();
        System.out.println("Добро пожаловать в наш магазин!");
        while (true) {
            System.out.println("Для совершения покупки нажмите 1, чтобы оформить заказ нажмите 2 или \"end\" для выхода");
            String type = pf.scanner.nextLine();
            if (type.toLowerCase().equals("end")) {
                break;
            }
            switch (type) {
                case "1" -> {
                    System.out.println("В нашем магазине доступны следующие категории продуктов: ");
                    pf.getList();
                    pf.getProduct(Enum.valueOf(ProductType.class, pf.scanner.nextLine().toUpperCase()));
                    pf.getListBasket();
                }
                case "2" -> {
                    try {
                        String json = orderInfoFileRepository.add(new OrderInfo(pf.getListBasket(), pf.totalPrice()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    pf.remove();
                }
                default -> System.out.println("Повторите ввод команды");
            }
        }

        pf.scanner.close(); // закрываем сканер, если дальше не будем его использовать
        //todo Прописать корзину, какие продукты и в каком количестве получили и счёт за них
    }
}
