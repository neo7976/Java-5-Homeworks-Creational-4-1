package adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import product.ProductImp;

import java.io.IOException;
import java.util.Map;

public class ProductTypeAdapter extends TypeAdapter<Map<ProductImp, Integer>> {

    @Override
    public void write(JsonWriter out, Map<ProductImp, Integer> value) throws IOException {

    }

    @Override
    public Map<ProductImp, Integer> read(JsonReader in) throws IOException {
        return null;
    }
}
