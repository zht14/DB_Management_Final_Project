public class Exercise {
    private String name;
    private String description;
    private double weight;
    private int sets;
    private int reps;

    public Exercise(){
        name = "";
        description = "";
        weight = 0.0;
        sets = 0;
        reps = 0;
    }

    public Exercise(String n, String d){
        name = n;
        description = d;
        weight = 0.0;
        sets = 0;
        reps = 0;
    }

    public Exercise(String n, String d, double w, int s, int r){
        name = n;
        description = d;
        weight = w;
        sets = s;
        reps = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

}
