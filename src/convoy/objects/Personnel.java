package convoy.objects;

public class Personnel {
    
    private String firstName;
    private String lastName;
    private String rank;
    private String type;
    
    /**
     * Constructor Personnel() sets personnel type to the default
     */    
    public Personnel(){
        
        this.type = "driver";
        
    }
    
    /**
     * Constructor Personnel(String fName, String lName, String rank, String type) creates specified personnel
     * @param fName person's first name
     * @param lName person's last name
     * @param rank person's rank
     * @param type person's type
     */    
    public Personnel(String fName, String lName, String rank, String type) {
        
        this.firstName = fName;
        this.lastName = lName;
        this.rank = rank;
        this.type = type;
        
    }
    
    /**
     * Method setFirstName(String fName) sets person's first name
     * @param fName person's first name
     */
    public void setFirstName(String fName) {
        
        this.firstName = fName;
        
    }
    
    /**
     * Method setLastName(String lName) sets person's last name
     * @param lName person's last name
     */
    public void setLastName(String lName) {
        
        this.lastName = lName;
        
    }
    
    /**
     * Method setRank(String rank) sets person's rank
     * @param rank person's rank 
     */
    public void setRank(String rank) {
        
        this.rank = rank;
        
    }
    
    /**
     * Method setType(String type)
     * @param type sets person's type
     */
    public void setType(String type) {
        
        this.type = type;
        
    }
    
    /**
     * Method getFirstName() get person's first name
     * @return firstName returns person's first name
     */
    public String getFirstName() {
        
        return firstName;
        
    }
    
    /**
     * Method getLastName() get person's last name
     * @return lastName returns person's last name
     */
    public String getLastName() {
        
        return lastName;
        
    }
    
    /**
     * Method getRank() get person's rank
     * @return rank returns person's rank
     */
    public String getRank() {
        
        return rank;
        
    }
    
    /**
     * Method setType() sets person's type
     * @return type return person's type
     */
    public String setType() {
        
        return this.type;
        
    }
    
}
