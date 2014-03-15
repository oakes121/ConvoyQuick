package convoy.objects;

import java.io.Serializable;

public class Personnel implements Serializable {
    
    private String name;
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
     * @param name person's first name
     * @param rank person's rank
     * @param type person's type
     */    
    public Personnel(String name, String rank, String type) {
        
        this.name = name;
        this.rank = rank;
        this.type = type;
        
    }
    
    /**
     * Method setFirstName(String fName) sets person's first name
     * @param fName person's first name
     */
    public void setName(String name) {
        this.name = name;
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
    public String getName() {
        
        return name;
        
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
