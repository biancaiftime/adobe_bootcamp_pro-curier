package clientmain;

import com.procourier.model.Order;
import http.GetOrderByIdClient;
import http.GetOrdersClient;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GetOrderByIdClient client = new GetOrderByIdClient();
        GetOrdersClient clients = new GetOrdersClient();


        Order order = client.getOrder(1L);
        System.out.println(order);

        List<Order> orders = clients.getOrders();
        orders.forEach(order1 -> {
            System.out.println(order1);
        });
    }
}
