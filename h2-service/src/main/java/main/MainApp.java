package main;

import com.procourier.model.*;
import service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Server.createWebServer("-webPort", "10500").start();
        OrderService orderService = OrderService.getInstance();

        Product phone = new Product(1000L, "Huawei P30", "New phone", 270L);
        Product laptop = new Product(1500L, "Sony Vayo", "Old laptop", 1200L);

        Address emagAddress = new Address("Bucuresti", "Bucuresti", "Soseaua Virtutii", "20A");
        Address johnAddress = new Address("Dolj", "Craiova", "Ecaterina Teodoroiu", "11");
        Address proCourierAddress = new Address("Timis", "Timisoara", "AI Cuza", "86");

        Buyer john = new Buyer("John", johnAddress);
        Seller emag = new Seller("Emag", emagAddress);

        OrderLine olPhone = new OrderLine(phone, 10L);
        OrderLine olLaptop = new OrderLine(laptop, 7L);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(olPhone);
        orderLines.add(olLaptop);

        Courier courier = new Courier("ProCourier",proCourierAddress,9L,13L);
        Order order = new Order(emag, john, courier, orderLines);
        orderService.addOrder(order);
        System.out.println("Order delivered successfully");
    }
}
