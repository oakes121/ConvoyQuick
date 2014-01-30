package convoy.quick;

public class Personnel {
    private String firstName;
    private String lastName;
    private String rank;
    
    public Personnel (String fName, String lName, String rank) {
        this.firstName = fName;
        this.lastName = lName;
        this.rank = rank;
    }
    
    public void setFirstName(String fName) {
        this.firstName = fName;
    }
    
    public void setLastName(String lName) {
        this.lastName = lName;
    }
    
    public void setRank(String rank) {
        this.rank = rank;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getRank() {
        return rank;
    }
}
