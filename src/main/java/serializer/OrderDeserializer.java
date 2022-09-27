package serializer;

import com.google.gson.*;
import order.OrderInfo;
import product.ProductImp;

import java.lang.reflect.Type;
import java.util.HashMap;

public class OrderDeserializer implements JsonDeserializer<OrderInfo> {
    @Override
    public OrderInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        OrderInfo order = new OrderInfo();
        order.setId(jsonObject.get("Номер заказа").getAsString());
        System.out.println(order);

        JsonArray products = jsonObject.getAsJsonArray("Состав заказа");

//        for (JsonElement product : products) {
//            order.setMapOrder(new HashMap<ProductImp, Integer>(context.deserialize(product, ProductImp.class),
//                    0 ));
//
//        }
        System.out.println(order);
        order.setPriceTotal(jsonObject.get("Итог").getAsInt());
        System.out.println(order);
        return order;
    }
}
