package utils;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Result;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 * Created by toshitpanigrahi on 4/25/17.
 *
 * Static functions to manage monitors
 */
public class MonitorManager {
    /**
     * Registers a new minimum threshold monitor
     * @param client    the client's API key
     * @param key       the key to bind threshold to
     * @param min       the monitored value
     * @return          true on success
     */
    public static boolean newMinMonitor(String client, String key, double min, URL endpoint) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            StringBuilder query = new StringBuilder("INSERT INTO min_monitors (client_key, monitor_key, " +
                    "value, endpoint) VALUES (\"" + client + "\", ");
            query.append("\"" + key + "\", \"" + min + "\", \"" + endpoint + "\")");

            QueryManager.runUpdate(connection, query.toString());
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Registers a new maximum threshold monitor
     * @param client    the client's API key
     * @param key       the key to bind threshold to
     * @param max       the monitored value
     * @return          true on success
     */
    public static boolean newMaxMonitor(String client, String key, double max, URL endpoint) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            StringBuilder query = new StringBuilder("INSERT INTO max_monitors (client_key, monitor_key, " +
                    "value, endpoint) VALUES (\"" + client + "\", ");
            query.append("\"" + key + "\", \"" + max + "\", \"" + endpoint + "\")");

            QueryManager.runUpdate(connection, query.toString());
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Result preMonitorCheck(String monitor, JsonNode json) {
        if (json == null) {
            return ResultManager.badRequestHandler(0);
        }

        String client = json.findPath("client").textValue();
        String key = json.findPath("key").textValue();
        String timestamp = json.findPath("timestamp").textValue();

        // Check all required param values
        if(client == null || key == null || timestamp == null) {
            return ResultManager.badRequestHandler(1);
        }

        // Client key does not exist
        if (!ClientManager.verifyClient(client)) {
            return ResultManager.badRequestHandler(3);
        }

        // Match the monitor and launch async task
        if (monitor.equals("min")) {
            double value = json.findPath("value").asDouble(Double.POSITIVE_INFINITY);
            if (value == Double.POSITIVE_INFINITY) {
                return ResultManager.badRequestHandler(1);
            }
            CompletableFuture.supplyAsync(() -> MonitorManager.checkMinMonitor(client, key, timestamp, value));
        } else if (monitor.equals("max")) {
            double value = json.findPath("value").asDouble(Double.NEGATIVE_INFINITY);
            if (value == Double.NEGATIVE_INFINITY) {
                return ResultManager.badRequestHandler(1);
            }
            CompletableFuture.supplyAsync(() -> MonitorManager.checkMaxMonitor(client, key, timestamp, value));
        } else if (monitor.equals("dis")) {
            double x = json.findPath("x_coordinate").asDouble(Double.POSITIVE_INFINITY);
            double y = json.findPath("y_coordinate").asDouble(Double.POSITIVE_INFINITY);
            if (x == Double.POSITIVE_INFINITY || y == Double.POSITIVE_INFINITY) {
                return ResultManager.badRequestHandler(1);
            }

            //CompletableFuture.supplyAsync(() -> MonitorManager.checkDisMonitor(client, key, timestamp, x, y));
        } else if (monitor.equals("geo")) {
            double x = json.findPath("x_coordinate").asDouble(Double.POSITIVE_INFINITY);
            double y = json.findPath("y_coordinate").asDouble(Double.POSITIVE_INFINITY);
            if (x == Double.POSITIVE_INFINITY || y == Double.POSITIVE_INFINITY) {
                return ResultManager.badRequestHandler(1);
            }

            //CompletableFuture.supplyAsync(() -> MonitorManager.checkGeoMonitor(client, key, timestamp, x, y));
        }

        // Let the client know data was successfully received for processing
        return ResultManager.okHandler(4);
    }

    private static Void checkMinMonitor(String client, String key, String timestamp, double value) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            String query = "SELECT value, endpoint FROM min_monitors WHERE client_key = \"" + client + "\" AND monitor_key = \"" + key + "\"";

            ResultSet resultSet = QueryManager.runQuery(connection, query);
            while (resultSet.next()) {
                double min = resultSet.getDouble("value");

                if (value < min) {
                    // Min threshold has been crossed
                    URL endpoint = resultSet.getURL("endpoint");
                    System.out.println("NOTIFYING");
                    ClientManager.notifyClient(endpoint, key, value, timestamp);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Void checkMaxMonitor(String client, String key, String timestamp, double value) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            String query = "SELECT value, endpoint FROM max_monitors WHERE client_key = \"" + client + "\" AND monitor_key = \"" + key + "\"";

            ResultSet resultSet = QueryManager.runQuery(connection, query);
            while (resultSet.next()) {
                double max = resultSet.getDouble("value");

                if (value > max) {
                    // Min threshold has been crossed
                    URL endpoint = resultSet.getURL("endpoint");
                    System.out.println("NOTIFYING");
                    ClientManager.notifyClient(endpoint, key, value, timestamp);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
