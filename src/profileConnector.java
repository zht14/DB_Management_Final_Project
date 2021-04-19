
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
            if(e.getUnits().equals("customary"))
            {
                e.setUnits("metric");
                System.out.println(e.getFeet()*30.48 + e.getInches() * 2.54);
                e.setCM(e.getFeet()*30.48 + e.getInches() * 2.54);
            }
            String query = "INSERT INTO users(first_name, last_name, user_name, pass_word, height_cm, weight_kg) ";
            query += "VALUES('"+e.getFirstName().toUpperCase()+"', '"+e.getLastName().toUpperCase()+"' , '"+e.getUserName()+"' , '"+e.getPassword()+"', '"+e.getCM()+"', '"+e.getWeight()+"');";

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
            String query = "SELECT user_name FROM users";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                String userName = rs.getString("user_name");
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

            String query = "SELECT first_name, last_name, user_name, pass_word, height_cm, weight_kg FROM users";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                String userName = rs.getString("user_name");
                String pass = rs.getString("pass_word");


                if(userName.equals(username) && pass.equals(passwordEntered)) {
                    // add values to profile
                    profile.setUsername(rs.getString("user_name"));
                    profile.setPassword(rs.getString("pass_word"));
                    profile.setFirstName(rs.getString("first_name"));
                    profile.setLastName(rs.getString("last_name"));
                    profile.setWeight(rs.getDouble("weight_kg"));
                    profile.setCM(rs.getDouble("height_cm"));
                    isValid = true;
                }
            }

        } catch (SQLException throwables) {
            return false;
        }
        return isValid;
    }

    public boolean addIPAddr(Profile e)
    {
        try
        {

            String query = "SELECT user_id FROM users WHERE user_name =";
            query += "'"+e.getUserName()+"';";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();


            int id_rs = rs.getInt("user_id");


            query = "INSERT INTO user_location(fk_user_id, loc_id, ip_addr) ";
            query += "VALUES('"+id_rs+"', '"+id_rs+"' , '"+e.getIP_Addr()+"');";
            stmt.executeUpdate(query);
        }
        catch(SQLException throwables)
        {
            System.out.println("Fail to insert user IP address");
        }

        return false;

    }
    
	
}