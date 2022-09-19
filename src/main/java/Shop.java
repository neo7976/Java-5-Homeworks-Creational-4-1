import product.Product;
import product.ProductFactory;
import product.ProductType;

public class Shop {
    public static void main(String[] args) {
        ProductFactory pf = new ProductFactory();
        System.out.println("Добро пожаловать в наш магазин!");
        while (true) {
            System.out.println("Для совершения покупки нажмите 1 или \"end\" для выхода");
            String type = pf.scanner.nextLine();
            if (type.toLowerCase().equals("end")) {
                break;
            }
            try {
                switch (type) {
                    case "1" -> {
                        System.out.println("В нашем магазине доступны следующие категории продуктов: ");
                        pf.getList();
                        pf.getProduct(Enum.valueOf(ProductType.class, pf.scanner.nextLine().toUpperCase()));
                        pf.getListBasket();
                    }
                    case "2" -> System.out.println("Меню ещё в разработке");
                    default -> System.out.println("Повторите ввод команды");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        pf.scanner.close(); // закрываем сканер, если дальше не будем его использовать
        //todo Прописать корзину, какие продукты и в каком количестве получили и счёт за них
    }
}
