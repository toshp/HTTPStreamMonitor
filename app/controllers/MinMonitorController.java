package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import utils.ClientManager;
import utils.MonitorManager;
import utils.ResultManager;

import java.net.MalformedURLException;
import java.net.URL;

public class MinMonitorController extends Controller {
    public Result initialize() {
        JsonNode json = request().body().asJson();

        if(json == null) {
            return ResultManager.badRequestHandler(0);
        }

        String client = json.findPath("client").textValue();
        String key = json.findPath("key").textValue();
        String endpoint = json.findPath("endpoint").textValue();
        double min = json.findPath("min").asDouble(Double.POSITIVE_INFINITY);

        // Check all required param values
        if(client == null || key == null || endpoint == null || min == Double.POSITIVE_INFINITY) {
            return ResultManager.badRequestHandler(1);
        }

        // Client key does not match
        if (!ClientManager.verifyClient(client)) {
            return ResultManager.badRequestHandler(3);
        }

        // Check if url is valid
        URL url;
        try {
            url = new URL(endpoint);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ResultManager.badRequestHandler(4);
        }

        if (MonitorManager.newMinMonitor(client, key, min, url)) {
            return ResultManager.okHandler(0);
        }

        return ResultManager.badRequestHandler(2);
    }
}