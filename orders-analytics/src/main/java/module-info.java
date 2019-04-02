module orders.service.client {
    requires core.model;
    requires gson;
    requires java.net.http;
    requires spark.core;

    //For Gson
    requires java.sql;
}