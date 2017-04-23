package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import utils.ResultManager;

public class MinMonitorController extends Controller {
    public Result initialize() {
        JsonNode json = request().body().asJson();

        if(json == null) {
            return ResultManager.badRequestHandler(0);
        }

        String client = json.findPath("client").textValue();
        String key = json.findPath("key").textValue();
        double min = json.findPath("min").asDouble(Double.POSITIVE_INFINITY);

        // Check all required param values
        if(client == null || key == null || min == Double.POSITIVE_INFINITY) {
            return ResultManager.badRequestHandler(1);
        }

        
        return ok("Hello " + client);
    }
}