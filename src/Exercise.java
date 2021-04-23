public class Exercise {
    private String name;
    private String description;
    private double weight;
    private int sets;
    private int reps;

    public Exercise(){
        this.name = "";
        this.description = "";
        this.weight = 0.0;
        this.sets = 0;
        this.reps = 0;
    }

    public Exercise(String n, String d){
        this.name = n;
        this.description = d;
        this.weight = 0.0;
        this.sets = 0;
        this.reps = 0;
    }

    public Exercise(String n, String d, double w, int s, int r){
        this.name = n;
        this.description = d;
        this.weight = w;
        this.sets = s;
        this.reps = r;
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
