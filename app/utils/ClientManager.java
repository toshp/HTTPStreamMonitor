package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by toshitpanigrahi on 4/24/17.
 */
public class ClientManager {
    public static boolean verifyClient(String client) {
        try {
            ResultSet result = QueryManager.runQuery("SELECT * FROM clients WHERE client_key = \"" + client + "\"");
            while (result.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
