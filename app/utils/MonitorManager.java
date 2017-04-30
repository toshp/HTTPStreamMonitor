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

    /**
     * Registers a new max distance monitor from a origin point.
     * The distance is in terms of the coordinate system units, not meters or miles, etc.
     * Conversion should be done on client side to lat/long if needed.
     * @param client
     * @param key
     * @param max_distance
     * @param x_origin
     * @param y_origin
     * @param endpoint
     * @return
     */
    public static boolean newDisMonitor(String client, String key, double max_distance, double x_origin, double y_origin, URL endpoint) {
        try {
            max_distance = Math.abs(max_distance);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            StringBuilder query = new StringBuilder("INSERT INTO dis_monitors (client_key, monitor_key, " +
                    "max_distance, x_origin, y_origin, endpoint) VALUES (\"" + client + "\", ");
            query.append("\"" + key + "\", \"" + max_distance + "\", \"" + x_origin + "\", \"" + y_origin +
                    "\", \"" + endpoint + "\")");

            QueryManager.runUpdate(connection, query.toString());
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Registers a new geofence monitor. (x1, y1) is top left of rectangle and
     * (x2, y2) is bottom left of rectangle.
     * @param client
     * @param key
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param endpoint
     * @return
     */
    public static boolean newGeoMonitor(String client, String key,
                                        double x1, double y1,
                                        double x2, double y2, URL endpoint) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            StringBuilder query = new StringBuilder("INSERT INTO geo_monitors (client_key, monitor_key, " +
                    "x1, y1, x2, y2, endpoint) VALUES (\"" + client + "\", ");
            query.append("\"" + key + "\", \"" + x1 + "\", \"" + y1 + "\", \"" + x2 + "\", \"" + y2 +
                    "\", \"" + endpoint + "\")");

            QueryManager.runUpdate(connection, query.toString());
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Standard data checking when it arrives to monitor
     * and launches async task
     * @param monitor   which monitor to direct data to
     * @param json      the incoming json data
     * @return          badRequest if malformed, ok Result if data valid
     */
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

            System.out.println("Received data: " + client + " " + key + " " + timestamp + " " + value);
            CompletableFuture.supplyAsync(() -> MonitorManager.checkMinMonitor(client, key, timestamp, value));
        } else if (monitor.equals("max")) {
            double value = json.findPath("value").asDouble(Double.NEGATIVE_INFINITY);
            if (value == Double.NEGATIVE_INFINITY) {
                return ResultManager.badRequestHandler(1);
            }

            System.out.println("Received data: " + client + " " + key + " " + timestamp + " " + value);
            CompletableFuture.supplyAsync(() -> MonitorManager.checkMaxMonitor(client, key, timestamp, value));
        } else if (monitor.equals("dis")) {
            double x = json.findPath("x").asDouble(Double.POSITIVE_INFINITY);
            double y = json.findPath("y").asDouble(Double.POSITIVE_INFINITY);
            if (x == Double.POSITIVE_INFINITY || y == Double.POSITIVE_INFINITY) {
                return ResultManager.badRequestHandler(1);
            }

            System.out.println("Received data: " + client + " " + key + " " + timestamp + " " + x + " " + y);
            CompletableFuture.supplyAsync(() -> MonitorManager.checkDisMonitor(client, key, timestamp, x, y));
        } else if (monitor.equals("geo")) {
            double x = json.findPath("x").asDouble(Double.POSITIVE_INFINITY);
            double y = json.findPath("y").asDouble(Double.POSITIVE_INFINITY);
            if (x == Double.POSITIVE_INFINITY || y == Double.POSITIVE_INFINITY) {
                return ResultManager.badRequestHandler(1);
            }

            System.out.println("Received data: " + client + " " + key + " " + timestamp + " " + x + " " + y);
            CompletableFuture.supplyAsync(() -> MonitorManager.checkGeoMonitor(client, key, timestamp, x, y));
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
                    ClientManager.notifyClientValue("min", endpoint, key, value, timestamp);
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
                    ClientManager.notifyClientValue("max", endpoint, key, value, timestamp);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Void checkDisMonitor(String client, String key, String timestamp, double x, double y) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            String query = "SELECT x_origin, y_origin, max_distance, endpoint FROM dis_monitors WHERE client_key = \"" + client + "\" AND monitor_key = \"" + key + "\"";

            ResultSet resultSet = QueryManager.runQuery(connection, query);
            while (resultSet.next()) {
                double max_distance = resultSet.getDouble("max_distance");
                double x_origin = resultSet.getDouble("x_origin");
                double y_origin = resultSet.getDouble("y_origin");

                double distance = Math.abs(Math.sqrt(Math.pow((x - x_origin), 2) + Math.pow((y - y_origin), 2)));

                if (distance > max_distance) {
                    // Distance threshold has been crossed
                    URL endpoint = resultSet.getURL("endpoint");
                    System.out.println("NOTIFYING");
                    ClientManager.notifyClientPoint("dis", endpoint, key, x, y, timestamp);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Void checkGeoMonitor(String client, String key, String timestamp, double x, double y) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            String query = "SELECT x1, y1, x2, y2, endpoint FROM geo_monitors WHERE client_key = \"" + client + "\" AND monitor_key = \"" + key + "\"";

            ResultSet resultSet = QueryManager.runQuery(connection, query);
            while (resultSet.next()) {
                double x1 = resultSet.getDouble("x1");
                double y1 = resultSet.getDouble("y1");
                double x2 = resultSet.getDouble("x2");
                double y2 = resultSet.getDouble("y2");

                if (x1 <= x && x <= x2 && y1 >= y && y >= y2) {
                    // Distance threshold has been crossed
                    URL endpoint = resultSet.getURL("endpoint");
                    System.out.println("NOTIFYING");
                    ClientManager.notifyClientPoint("dis", endpoint, key, x, y, timestamp);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
