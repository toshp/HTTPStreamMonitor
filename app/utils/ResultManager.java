package utils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.*;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by toshitpanigrahi on 4/23/17.
 */

public class ResultManager {
    /**
     * Returns a badRequest Result
     * @param c     int code of bad request cause
     * @return      the badRequest object with json body
     */
    public static Result badRequestHandler(int c) {
        ObjectNode json = Json.newObject();
        json.put("result", "failure");
        switch (c) {
            case 0: json.put("message", "Expecting JSON data."); break;
            case 1: json.put("message", "Missing parameters."); break;
            case 2: json.put("message", "Internal error."); break;
            case 3: json.put("message", "Invalid credentials."); break;
            case 4: json.put("message", "Invalid endpoint: check your URL."); break;
        }
        return badRequest(json);
    }

    /**
     * Returns an ok Result
     * @param c     int code of ok result
     * @return      the ok object with json body
     */
    public static Result okHandler(int c) {
        ObjectNode json = Json.newObject();
        json.put("result", "success");
        switch (c) {
            case 0: json.put("message", "Created new min monitor."); break;
            case 1: json.put("message", "Created new max monitor."); break;
            case 2: json.put("message", "Created new distance monitor."); break;
            case 3: json.put("message", "Created new geofence monitor."); break;
            case 4: json.put("message", "Data received."); break;
        }
        return ok(json);
    }
}
