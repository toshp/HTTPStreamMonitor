package utils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.*;

import static play.mvc.Results.badRequest;

/**
 * Created by toshitpanigrahi on 4/23/17.
 */

public class ResultManager {
    /**
     * Returns a badRequest Result with json body
     * depending on case
     *
     * @param c int code of bad request cause
     * @return
     */
    public static Result badRequestHandler(int c) {
        ObjectNode json = Json.newObject();
        json.put("result", "fail");
        switch (c) {
            case 0: json.put("message", "Expecting JSON data."); break;
            case 1: json.put("message", "Missing parameters."); break;
            case 2: json.put("message", "Internal error."); break;
        }
        return badRequest(json);
    }
}
