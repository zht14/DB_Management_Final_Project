

public class Profile{
	
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private double feet;
    private double inches;
    private double weight;
    private String units;
    private double BMI;
    private double cm;


    public Profile() {
        firstName = "";
        lastName = "";
        username = "";
        password = "";
        feet = 0;
        inches = 0;
        weight = 0;
        units = "";
        BMI = 0;
        cm = 0;
    }
    
    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
    	return this.firstName;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public String getUserName() {
    	return this.username;
    }
    
    public String getUnits() {
    	return this.units;
    }
    
    public double getFeet() {
    	return this.feet;
    }
    
    public double getInches() {
    	return this.inches;
    }
    
    public double getWeight() {
    	return this.weight;
    }

    public double getCM(){ return this.cm; }
    
    
    

    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setUsername(String user) {
    	this.username = user;
    }

    
    public void setUnits(String units) {
    	this.units = units;
    }
    

    public void setCM(double cm){ this.cm = cm; }

    public void setFeet(double feet) {
    	this.feet = feet;
    }
    
    public void setInches(double inch) {
    	this.inches = inch;
    }
    
    public void setWeight(double weight) {
    	this.weight = weight;
    }
	
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String pass) {
    	this.password = pass;
    }

    public void setBMI(double BMI)
    {
        this.BMI = BMI;
    }

    public double getBMI()
    {
        return this.BMI;
    }


	
	
}