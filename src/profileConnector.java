
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


public class profileConnector {
    private WorkoutLog workoutLog;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    private ConnectionManager conMag = new ConnectionManager();


    
    public Profile profile = new Profile();
    
    public profileConnector() {
        con = conMag.getConnection();
        //System.out.println("connection made");
        try {
            stmt = con.createStatement();
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
    }
    
    public boolean addProfile(Profile e){
        try {
            String query = "INSERT INTO `tbl_login` (`userName`, `password`, `firstName`, `lastName`, `weight`, `feet`, `inches`,`units`) VALUES ('"+e.getUsername()+"', '"+e.getPassword()+"', '"+e.getFirstName()+"', '"+e.getLastName()+"', '"+e.getWeight()+"', '"+e.getFeet()+"', '"+e.getInches()+"', '"+e.getUnits()+"');";
        	stmt.executeUpdate(query);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean usernameExists(String username){
        boolean exists = false;
        try {
            String query = "SELECT userName FROM tbl_login";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                String userName = rs.getString("userName");
                if(userName.equals(username)) {
                    exists = true;
                }
            }

        } catch (SQLException throwables) {
            //return false;
        }
        return exists;
    }

    public boolean passwordValid(String passwordEntered, String username){
        boolean isValid = false;
        try {

            String query = "SELECT userName, password, firstName, lastName, weight, feet, inches, units FROM tbl_login";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                String userName = rs.getString("userName");
                String pass = rs.getString("password");


                if(userName.equals(username) && pass.equals(passwordEntered)) {
                    // add values to profile
                    profile.setUsername(rs.getString("userName"));
                    profile.setPassword(rs.getString("password"));
                    profile.setFirstName(rs.getString("firstName"));
                    profile.setLastName(rs.getString("lastName"));
                    profile.setWeight(rs.getDouble("weight"));
                    profile.setFeet(rs.getDouble("feet"));
                    profile.setInches(rs.getDouble("inches"));
                    profile.setUnits(rs.getString("units"));
                    isValid = true;
                }
            }

        } catch (SQLException throwables) {
            //return false;
        }
        return isValid;
    }
    
	
}