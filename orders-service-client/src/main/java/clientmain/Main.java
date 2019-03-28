package clientmain;

import com.procourier.model.Order;
import http.GetOrderByIdClient;

public class Main {
    public static void main(String[] args) {
        GetOrderByIdClient client = new GetOrderByIdClient();


        Order order = client.getOrder(1L);
        System.out.println(order);
    }
}
