package serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import product.Product;
import product.ProductImp;

import java.lang.reflect.Type;

public class ProductSerializer implements JsonSerializer<ProductImp> {
    @Override
    public JsonElement serialize(ProductImp src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject result = new JsonObject();

        result.addProperty("name", src.getName());
        result.addProperty("weight", src.getWeight());
        result.addProperty("price", src.getPrice());
        return result;
    }
}
