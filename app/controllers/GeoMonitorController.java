package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Result;
import utils.MonitorManager;
import utils.ResultManager;

import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by toshitpanigrahi on 4/29/17.
 */
public class GeoMonitorController extends MonitorController {
    @Override
    public Result createNewMonitor(String client, String key, URL url, JsonNode json) {
        // Verify the initialization values
        double x1 = json.findPath("x1").asDouble(Double.NEGATIVE_INFINITY);
        double y1 = json.findPath("y1").asDouble(Double.NEGATIVE_INFINITY);

        double x2 = json.findPath("x2").asDouble(Double.NEGATIVE_INFINITY);
        double y2 = json.findPath("y2").asDouble(Double.NEGATIVE_INFINITY);

        if(x1 == Double.NEGATIVE_INFINITY || y1 == Double.NEGATIVE_INFINITY
                || x2 == Double.NEGATIVE_INFINITY || y2 == Double.NEGATIVE_INFINITY) {
            return ResultManager.badRequestHandler(1);
        }

        if (x1 >= x2 || y1 <= y2) {
            return ResultManager.badRequestHandler(1);
        }

        if (MonitorManager.newGeoMonitor(client, key, x1, y1, x2, y2, url)) {
            return ResultManager.okHandler(3);
        }
        return ResultManager.badRequestHandler(2);
    }

    @Override
    public CompletionStage<Result> monitor() {
        JsonNode json = request().body().asJson();
        return CompletableFuture.supplyAsync(() -> MonitorManager.preMonitorCheck("geo", json));
    }
}
