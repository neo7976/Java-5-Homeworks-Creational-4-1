package adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import order.OrderInfo;

import java.io.IOException;

public class OrderTypeAdapter extends TypeAdapter<OrderInfo> {
    @Override
    public void write(JsonWriter out, OrderInfo value) throws IOException {

    }

    @Override
    public OrderInfo read(JsonReader in) throws IOException {
        return null;
    }
}
