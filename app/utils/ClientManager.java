package utils;

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
}
