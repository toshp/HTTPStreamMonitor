package utils;

import java.sql.*;

/**
 * Created by toshitpanigrahi on 4/24/17.
 */
public class QueryManager {
    /**
     * Static method to run the query and get resultSet
     *
     * @param query the sql statement to be run
     * @return
     */
    public static ResultSet runQuery(String query) throws SQLException {
        // Connect to db
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stream_monitor", "root", "root");
        Statement stmt = connection.createStatement();

        // Run the query and close the conn
        ResultSet resultSet = stmt.executeQuery(query);

        return resultSet;
    }
}
