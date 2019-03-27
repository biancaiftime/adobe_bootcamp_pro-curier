package com.procourier.app;

import com.procourier.model.*;
import com.procourier.repository.CollectionRepository;
import spark.Spark;

import java.util.List;

public final class OrderServiceMain {

    public static void main(String[] args) {
        final var repository = new CollectionRepository();
        final var handler = new OrdersHandler(repository);

        final Address address = new Address("DJ", "Craiova", "Nicolae Titulescu");
        final Seller seller = new Seller("Evomag", address);

        final Address cosminAddress = new Address("DJ", "Craiova", "Ilean Consanzeana");
        final Buyer buyer = new Buyer("Cosmin", cosminAddress);

        final Address courierAddress = new Address("OT", "Slatina", "Cantemir");
        final Courier courier = new Courier("ExpressFan", courierAddress,
                5L, 7L);


        final List<OrderLine> products = List.of(new OrderLine(new Product(20L, "Jeans", "Men Jeans", 22L), 4L));

        final Order order = new Order(seller, buyer, courier, products);
        order.setId(6L);
        repository.put(order);

        Spark.port(8082);
        Spark.threadPool(26, 10, 2000);
        Spark.get("/orders/:id", handler);
    }
}
