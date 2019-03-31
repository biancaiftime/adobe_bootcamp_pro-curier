package com.procourier.handlers;

import com.google.gson.Gson;
import com.procourier.model.Order;
import service.OrderService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class GetOrdersHandler implements Route {
    private OrderService orderService;
    private Gson gson = new Gson();

    public GetOrdersHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        response.header("Content-Type", "application/json;charset=utf-8");
        List<Order> order = orderService.getOrders();
        return gson.toJson(order);
    }
}
