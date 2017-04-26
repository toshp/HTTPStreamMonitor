package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import utils.ClientManager;
import utils.ResultManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletionStage;

public abstract class MonitorController extends Controller {
    public Result initialize() {
        JsonNode json = request().body().asJson();

        if(json == null) {
            return ResultManager.badRequestHandler(0);
        }

        String client = json.findPath("client").textValue();
        String key = json.findPath("key").textValue();
        String endpoint = json.findPath("endpoint").textValue();

        // Check all required param values
        if(client == null || key == null || endpoint == null) {
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

        return createNewMonitor(client, key, url, json);
    }

    public abstract Result createNewMonitor(String client, String key, URL url, JsonNode json);

    public abstract CompletionStage<Result> monitor();
}