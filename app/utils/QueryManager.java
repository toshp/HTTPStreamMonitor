package utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by toshitpanigrahi on 4/24/17.
 */
public class QueryManager {
    /**
     * Static method to run the query and get ResultSet
     *
     * @param query the sql statement to be run
     * @return
     */
    public static ResultSet runQuery(Connection connection, String query) throws SQLException {
        Statement stmt = connection.createStatement();

        // Run the query
        ResultSet resultSet = stmt.executeQuery(query);
        return resultSet;
    }

    public static int runUpdate(Connection connection, String query) throws SQLException {
        Statement stmt = connection.createStatement();

        // Run the query
        return stmt.executeUpdate(query);
    }
}
