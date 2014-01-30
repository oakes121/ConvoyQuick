package convoy.objects;

import java.sql.Time;
import java.util.ArrayList;

public class Mission {
    private int missionNumber;                       // The designated mission number for the convoy
    private String missionName;                      // The designated mission name for the convoy 
    private int numberOfPersonnel;                   // The number of personnel in the convoy
    private int numberOfVehicles;                    // The number of vehicles in the convoy
    private Classification missionClassification;    // The classification of the mission 
    private Time missionLinkUpTime;                  // The meeting time of the convoy 
    private Time missionDepartureTime;               // The departure time of the convoy
    private String missionStagingArea;               // The meeting location of the convoy 
    private String unitName;                         // The unit name of all personnel
    private ArrayList<Vehicle> vehicles;             // All of the vehicles in the convoy
    private ArrayList<Personnel> people;             // All of the personnel in the convoy
    private Attachments attachments;                 // All of the attachments associated with the convoy
    
    /**
     * This constructor initializes all class variables
     */
    public Mission() {
        missionNumber = 0;
        missionName = "Mission Name";
        numberOfPersonnel = 2;
        numberOfVehicles = 2;
        missionStagingArea = "Staging Area";
        unitName = "Unit Name";
        vehicles = new ArrayList<>();
        people = new ArrayList<>();
        attachments = new Attachments();
        missionClassification = new Classification();
        missionLinkUpTime = new Time(7,0,0);
        missionDepartureTime = new Time(7,30,0);        
    }
    
    /**
     * This constructor sets initializes all class variables
     * @param missionNumber int value that missionNumber will be set to 
     * @param missionName  string value that missionName will be set to
     * @param numberOfPersonnel int value that numberOfPersonnel will be set to
     * @param numberOfVehicles int value that numberOfVehicles will be set to
     * @param missionStagingArea string value that missionStagingArea will be set to
     * @param unitName string value that unitName will be set to
     * @param lUH int value representing hours use to instantiate missionLinkUpTime
     * @param lUM int value representing minutes use to instantiate missionLinkUpTime
     * @param lUS int value representing seconds use to instantiate missionLinkUpTime
     * @param dTH int value representing hours use to instantiate missionDepartureTime
     * @param dTM int value representing minutes use to instantiate missionDepartureTime
     * @param dTS int value representing seconds use to instantiate missionDepartureTime
     */
    public Mission(int missionNumber, String missionName, int numberOfPersonnel, int numberOfVehicles,
            String missionStagingArea, String unitName, int lUH, int lUM, int lUS,
            int dTH, int dTM, int dTS) {
        this.missionNumber = missionNumber;
        this.missionName = missionName;
        this.numberOfPersonnel = numberOfPersonnel;
        this.numberOfVehicles = numberOfVehicles;
        this.missionStagingArea = missionStagingArea;
        this.unitName = unitName;
        vehicles = new ArrayList<>();
        people = new ArrayList<>();
        attachments = new Attachments();
        missionClassification = new Classification();
        missionLinkUpTime = new Time(lUH,lUM,lUS);
        missionDepartureTime = new Time(dTH,dTM,dTS);        
    }
    
    public void addPersonnel(Personnel p) {
        people.add(p);
    }
    
    public void removePersonnel(Personnel p) {
        int i = people.indexOf(p);
        if (i >= 0) {
            people.remove(i);
        }
    } 
    
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }
    
    public void removeVehicle(Vehicle v) {
        int i = vehicles.indexOf(v);
        if (i >= 0) {
            vehicles.remove(i);
        }
    }        
    
    public void setMissionNumber(int missionNumber) {
        this.missionNumber = missionNumber;
    }
    
    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }
    
    public void setNumberOfPersonnel(int numberOfPersonnel) {
        this.numberOfPersonnel = numberOfPersonnel;
    }
    
    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }
    
    public void setMissionClassification(Classification classification) {
        this.missionClassification = classification;
    }
    
    public void setmissionLinkUptime(int h, int m, int s) {
        missionLinkUpTime.setHours(h);
        missionLinkUpTime.setMinutes(m);
        missionLinkUpTime.setSeconds(s);
    }
    
    public void setMissionDepartureTime(int h, int m, int s){
        missionDepartureTime.setHours(h);
        missionDepartureTime.setMinutes(m);
        missionDepartureTime.setSeconds(s);
    }
    
    public void setMissionStagingArea(String stagingArea){
        this.missionStagingArea = stagingArea;
    }
    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    public int getMissionNumber() {
        return missionNumber;
    }
    
    public String getMissionName() {
        return missionName;
    }
    
    public int getNumberOfPersonnel() {
        return numberOfPersonnel;
    }
    
    public int getNumberOfVehicles(){
        return numberOfVehicles;
    }
    public Classification getMissionClassification() {
        return missionClassification;
    }
    
    public String getMissionLinkUpTime() {
        return missionLinkUpTime.toString();
    }
    
    public String getMissionDepartureTime() {
        return missionDepartureTime.toString();
    }
    
    public String getMissionstagingArea() {
        return missionStagingArea;
    }
    
    public String getUnitName() {
        return unitName;
    }
    
}
