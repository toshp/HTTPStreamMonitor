package utils;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static void checkMinMonitor(String client, String key, double value, String timestamp) {
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
                    //ClientManager.nofifyClient(endpoint, key, value, timestamp);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
