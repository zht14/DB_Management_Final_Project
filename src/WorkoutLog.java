import java.time.LocalDateTime;
import java.util.ArrayList;


public class WorkoutLog {
    private ArrayList<Exercise> logExerciseList;
    private LocalDateTime currentDate;


    public WorkoutLog(){
        logExerciseList = new ArrayList<>();
        currentDate = this.getDate();
    }



    public void AddExercise(Exercise e){
        logExerciseList.add(e);
    }

    public void removeExercise(Exercise e){
        logExerciseList.remove(e);
    }

    public void updateExercise(Exercise e){

        //TODO: UPDATE METHOD TO HAVE LOGIC ON WHETHER OR NOT TO UPDATE SETS/REPS/WEIGHT
        return;
    }

    public LocalDateTime getDate(){
        return LocalDateTime.now();
    }

}
