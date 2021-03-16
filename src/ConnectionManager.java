import java.lang.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    private static Connection conn = null;

    private static String hostName = "healthytracks.czlpoipw8bmp.us-east-2.rds.amazonaws.com"; // server address + port number
    private static String dbName = "HealthyTracks"; // default database name
    private static String dbUserName = "PAPA"; // login name for the database server
    private static String dbPassword = "VZ10121314"; // password for the database server
    private static String mySqlConn = "jdbc:mysql://" + hostName + "/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword;

    public static void main(String[] args)
    {
        getConnection();
    }

    public static Connection getConnection(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(mySqlConn);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (Exception ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return conn;
    }

}
