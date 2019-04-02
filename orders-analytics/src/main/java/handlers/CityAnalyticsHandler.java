package handlers;

import com.google.gson.Gson;
import http.OrdersServiceClient;
import spark.Request;
import spark.Response;
import spark.Route;

public final class CityAnalyticsHandler implements Route {
    private final OrdersServiceClient client;
    private final Gson gson = new Gson();

    public CityAnalyticsHandler(OrdersServiceClient client) {
        this.client = client;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        //write code here
        //parameter "minSold" filter by minimum sold 
        return null;
    }

    private static final class AnalyticsResponse {
        private final String cityName;
        private final Long totalSold;
        private final Long numberOfDifferentBuyers;

        public AnalyticsResponse(String cityName, Long totalSold, Long numberOfDifferentBuyers) {
            this.cityName = cityName;
            this.totalSold = totalSold;
            this.numberOfDifferentBuyers = numberOfDifferentBuyers;
        }

        public String cityName() {
            return cityName;
        }

        public Long totalSold() {
            return totalSold;
        }

        public Long getNumberOfDifferentBuyers() {
            return numberOfDifferentBuyers;
        }
    }
}
