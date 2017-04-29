package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by toshitpanigrahi on 4/24/17.
 * Functions to manage client data
 */
public class ClientManager {
    /**
     * Checks if the client API key is valid
     * @param client    the client's API key
     * @return          true if the client key is valid
     */
    public static boolean verifyClient(String client) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
            ResultSet result = QueryManager.runQuery(connection, "SELECT * FROM clients WHERE client_key = \"" + client + "\"");
            while (result.next()) {
                connection.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Sends a POST notification to the client when a threshold event occurs
     * @param monitor   the monitor sending the notification
     * @param endpoint  the callback URL to notify
     * @param key       the object key that was monitored
     * @param value     the triggering value
     * @param timestamp when the event occurred
     */
    public static void notifyClientValue(String monitor, URL endpoint, String key, double value, String timestamp) {
        notifyClientPoint(monitor, endpoint, key, value, Double.POSITIVE_INFINITY, timestamp);
    }

    /**
     * Sends a POST notification to the client when a point event occurs
     * @param monitor   the monitor sending the notification
     * @param endpoint  the callback URL to notify
     * @param key       the object key that was monitored
     * @param x         point x coordinate
     * @param y         point y coordinate
     * @param timestamp when the event occurred
     */
    public static void notifyClientPoint(String monitor, URL endpoint, String key, double x, double y, String timestamp) {
        try {
            String notification = ResultManager.notificationResult(monitor, key, x, y, timestamp);

            HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(notification.getBytes());
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();
            System.out.println("POST Response Code: " + responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
