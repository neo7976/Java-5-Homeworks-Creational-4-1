package serializer;

import com.google.gson.*;
import order.OrderInfo;
import product.ProductImp;

import java.lang.reflect.Type;
import java.util.Map;

public class OrderSerializer implements JsonSerializer<OrderInfo> {
    @Override
    public JsonElement serialize(OrderInfo src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("Номер заказа", src.getId());

        //возможно надо переделать
//        result.addProperty("Состав заказа", String.valueOf(context.serialize(src.getMapOrder())));

        JsonArray products = new JsonArray();
        result.add("Состав заказа", products);
        for (Map.Entry<ProductImp, Integer> entry : src.getMapOrder().entrySet()) {
            products.add(context.serialize(entry.getKey()));
            products.add(entry.getValue());
        }

        result.addProperty("Итог", src.getPriceTotal());
        return result;
    }
}
