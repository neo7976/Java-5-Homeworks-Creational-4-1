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
        File repoFile = new File("src/main/resources/orders1.json");
        OrderInfoFileRepository orderInfoFileRepository = new OrderInfoFileRepository(repoFile, mapper);

        ProductFactory pf = new ProductFactory();
        System.out.println("Добро пожаловать в наш магазин!");
        while (true) {
            System.out.println("\nДля совершения покупки нажмите 1;\n" +
                    "Чтобы оформить заказ нажмите 2;\n" +
                    "Найти свой заказ нажмите 3;\n" +
                    "Сделать возврат заказа нажмите 4\n;" +
                    "\"end\" для завершения работы.");
            String type = pf.scanner.nextLine();
            if (type.toLowerCase().equals("end")) {
                break;
            }
            switch (type) {
                case "1" -> {
                    System.out.println("В нашем магазине доступны следующие категории продуктов: ");
                    pf.getList();
                    pf.getProduct(Enum.valueOf(ProductType.class, pf.scanner.nextLine().toUpperCase()));
                    pf.printListBasket();
                }
                case "2" -> {
                    try {
                        String json = orderInfoFileRepository.add(new OrderInfo(pf.getListBasket(), pf.totalPrice()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    pf.remove();
                }
                case "3"->{
                    System.out.println("Введите номер заказа:");
                    try {
                        System.out.println(orderInfoFileRepository.getById(pf.scanner.nextLine()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case "4" -> {
                    System.out.println("Введите номер заказа для возврата товара:");
                    try {
                        orderInfoFileRepository.returnOrder(pf.scanner.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                default -> System.out.println("Повторите ввод команды");
            }
        }

        pf.scanner.close(); // закрываем сканер, если дальше не будем его использовать
        //todo Прописать корзину, какие продукты и в каком количестве получили и счёт за них
    }
}
