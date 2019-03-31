package http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.procourier.model.Order;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GetOrdersClient {
    private Gson gson = new Gson();
    private HttpClient httpClient;

    public GetOrdersClient() {
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public List<Order> getOrders() {
        final HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8082/orders"))
                .build();
        try {
            Type listType = new TypeToken<List<Order>>() {}.getType();
            final HttpResponse response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body().toString(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
