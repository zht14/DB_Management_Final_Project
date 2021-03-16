import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WorkoutLogController {
    private WorkoutLog workoutLog;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private ConnectionManager conMag = new ConnectionManager();

    public WorkoutLogController() {
        con = conMag.getConnection();
        try {
            stmt = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Exercise> getPossibleExercises(){
        ArrayList<Exercise> possibleExercises = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM tbl_exercises");
            while(rs.next()){
                possibleExercises.add(new Exercise(rs.getString("name"), rs.getString("description")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return possibleExercises;
    }

    public ArrayList<Exercise> getLogExercises(){
        ArrayList<Exercise> logExercises = new ArrayList<>();
        try {
            //TODO: Create list of exercises and use GUI to populate list.
            rs = stmt.executeQuery("SELECT * FROM tbl_workoutLog");
            while(rs.next()){
                logExercises.add(new Exercise(rs.getString("exerciseName"), rs.getString("description"), rs.getDouble("weight"), rs.getInt("sets"), rs.getInt("reps")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return logExercises;
    }

    public boolean addExerciseToLog(Exercise e){
        try {
            String query = "INSERT INTO tbl_workoutLog (`exerciseName`, `description`, `weight`, `sets`, `reps`) VALUES ('"+e.getName()+"', '"+e.getDescription()+"', '"+e.getWeight()+"', '"+e.getSets()+"', '"+e.getReps()+"');";
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean removeExerciseFromLog(Exercise e){
        try {
            String query = "DELETE FROM tbl_workoutLog WHERE exerciseName = '" + e.getName() + "'AND weight = '" + e.getWeight() + "'";
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean updateExercise(Exercise e){
        try {
            String query = "UPDATE tbl_workoutLog SET reps = '"+e.getReps()+"', sets = '"+e.getSets()+"', weight = '"+e.getWeight()+"' WHERE exerciseName = '"+e.getName()+"'";
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean resetLog(){
        try {
            String query = "DELETE FROM tbl_workoutLog";
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
