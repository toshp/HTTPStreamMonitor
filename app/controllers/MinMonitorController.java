package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import utils.ResultManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

        //boolean authorized = ClientAuthenticator.verifyClient(client);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM clients");

            while (resultSet.next()) {
                return ok("Hello " + resultSet.getString("client_key"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultManager.badRequestHandler(2);
        }

        return ok("No client key");
    }
}