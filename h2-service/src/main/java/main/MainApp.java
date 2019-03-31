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



        Product phone1 = new Product(1500L, "iPhone XS", "Best phone", 270L);
        Product make_up = new Product(500L, "Anastasia Palette", "New eyeshadow palette", 200L);

        Address evomagAddress = new Address("Bucuresti", "Bucuresti", "Splaiul Unirii", "257");
        Address fredAddress = new Address("Iasi", "Iasi", "Palat", "15");
        Address proCourierAddress1 = new Address("Cluj", "Cluj", "AI Cuza", "20");

        Buyer Fred = new Buyer("Fred", fredAddress);
        Seller evomag = new Seller("Evomag", evomagAddress);

        OrderLine olPhone1 = new OrderLine(phone1, 5L);
        OrderLine olmake_up = new OrderLine(make_up, 17L);

        List<OrderLine> orderLines1 = new ArrayList<>();
        orderLines1.add(olPhone1);
        orderLines1.add(olmake_up);

        Courier courier1 = new Courier("ProCourier",proCourierAddress1,8L,18L);
        Order order1 = new Order(evomag, Fred, courier1, orderLines1);
        orderService.addOrder(order1);
        System.out.println("Orders delivered successfully");
    }
}
