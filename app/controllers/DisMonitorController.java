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
public class DisMonitorController extends MonitorController {
    @Override
    public Result createNewMonitor(String client, String key, URL url, JsonNode json) {
        // Verify the initialization values
        double max_distance = json.findPath("max_distance").asDouble(Double.NEGATIVE_INFINITY);
        double x = json.findPath("x").asDouble(Double.NEGATIVE_INFINITY);
        double y = json.findPath("y").asDouble(Double.NEGATIVE_INFINITY);

        if(max_distance == Double.NEGATIVE_INFINITY || x == Double.NEGATIVE_INFINITY || y == Double.NEGATIVE_INFINITY) {
            return ResultManager.badRequestHandler(1);
        }

        if (MonitorManager.newDisMonitor(client, key, max_distance, x, y, url)) {
            return ResultManager.okHandler(3);
        }
        return ResultManager.badRequestHandler(2);
    }

    @Override
    public CompletionStage<Result> monitor() {
        JsonNode json = request().body().asJson();
        return CompletableFuture.supplyAsync(() -> MonitorManager.preMonitorCheck("dis", json));
    }
}
