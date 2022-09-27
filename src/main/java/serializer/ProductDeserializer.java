package serializer;

import com.google.gson.*;
import product.ProductImp;

import java.lang.reflect.Type;

public class ProductDeserializer implements JsonDeserializer<ProductImp> {
    @Override
    public ProductImp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        ProductImp product = new ProductImp();
        product.setName(jsonObject.get("name").getAsString());
        System.out.println(product);
        product.setWeight(jsonObject.get("weight").getAsInt());
        System.out.println(product);
        product.setPrice(jsonObject.get("price").getAsInt());
        System.out.println(product);
        return product;
    }
}
