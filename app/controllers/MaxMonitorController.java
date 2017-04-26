package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import utils.MonitorManager;
import utils.ResultManager;

import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class MaxMonitorController extends MonitorController {
    public Result createNewMonitor(String client, String key, URL url, JsonNode json) {
        // Verify the initialization values
        double max = json.findPath("max").asDouble(Double.NEGATIVE_INFINITY);
        if(max == Double.NEGATIVE_INFINITY) {
            return ResultManager.badRequestHandler(1);
        }

        if (MonitorManager.newMaxMonitor(client, key, max, url)) {
            return ResultManager.okHandler(0);
        }
        return ResultManager.badRequestHandler(2);
    }

    public CompletionStage<Result> monitor() {
        JsonNode json = request().body().asJson();
        return CompletableFuture.supplyAsync(() -> MonitorManager.preMonitorCheck("max", json));
    }
}