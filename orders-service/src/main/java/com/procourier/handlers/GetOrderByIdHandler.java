package com.procourier.handlers;

import com.procourier.model.Order;
import service.OrderService;
import spark.Request;
import spark.Response;
import spark.Route;

import static java.lang.Long.valueOf;

public class GetOrderByIdHandler implements Route {
    private OrderService orderService;

    public GetOrderByIdHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String id = request.params(":id");
        Order order = orderService.getOrderById(valueOf(id));

    }
}
