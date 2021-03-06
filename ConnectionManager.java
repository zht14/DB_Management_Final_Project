import java.sql.*;

public class ConnectionManager {
    private static String url = "jdbc:mysql://axxb6a0z2kydkco3.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/nkfszrrxkyw5jypd";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "z2hl7aklk6bs8bl0";
    private static String password = "d397ug19mkb2lksa";
    private static Connection con;

    public static Connection getConnection(){
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }

}
