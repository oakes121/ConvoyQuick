package convoy.objects;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

public class Mission implements Serializable {

    private static Mission uniqueInstance;            
    private static String constructorUsed;
    private String missionNumber;                    // The designated mission name for the convoy
    private Classification missionClassification;    // The classification of the mission 
    private Time missionLinkUpTime;                  // The meeting time of the convoy 
    private Time missionDepartureTime;               // The departure time of the convoy
    private String missionStagingArea;               // The meeting location of the convoy 
    private String unitName;                         // The unit name of all personnel
    private ArrayList<Vehicle> vehicles;             // All of the vehicles in the convoy
    private ArrayList<Personnel> people;             // All of the personnel in the convoy
    private Attachments attachments;                 // All of the attachments associated with the convoy
    private String leftTo;
    private String rightTo;
    private String leftFrom;
    private String rightFrom;

    /**
     *  constructor Mission() initializes all class variables
     */
    private Mission() {
        constructorUsed = "default";
        missionNumber = "Misson Number";
        leftTo = "";
        rightTo = "";
        leftFrom = "";
        rightFrom = "";
        missionStagingArea = "Staging Area";
        unitName = "Unit Name";
        vehicles = new ArrayList<>();
        people = new ArrayList<>();
        attachments = new Attachments();
        missionClassification = new Classification();
        missionLinkUpTime = new Time(7, 0, 0);
        missionDepartureTime = new Time(7, 30, 0);
    }

    /**
     * constructor Mission(int missionNumber, String missionName,
     * int numberOfPersonnel, int numberOfVehicles, String missionStagingArea,
     * String unitName, int lUH, int lUM, int lUS, int dTH, int dTM, int dTS)
     * initializes all class variables
     *
     * @param missionNumber int value that missionNumber will be set to
     * @param missionName string value that missionName will be set to
     * @param numberOfPersonnel int value that numberOfPersonnel will be set to
     * @param numberOfVehicles int value that numberOfVehicles will be set to
     * @param missionStagingArea string value that missionStagingArea will be
     * set to
     * @param unitName string value that unitName will be set to
     * @param lUH int value representing hours use to instantiate
     * missionLinkUpTime
     * @param lUM int value representing minutes use to instantiate
     * missionLinkUpTime
     * @param lUS int value representing seconds use to instantiate
     * missionLinkUpTime
     * @param dTH int value representing hours use to instantiate
     * missionDepartureTime
     * @param dTM int value representing minutes use to instantiate
     * missionDepartureTime
     * @param dTS int value representing seconds use to instantiate
     * missionDepartureTime
     */
    private Mission(String missionNumber, 
            String missionStagingArea,String leftTo, String rightTo, String leftFrom, String rightFrom, String unitName, int lUH, int lUM, int lUS,
            int dTH, int dTM, int dTS) {
        constructorUsed = "alt1"; 
        this.missionNumber = missionNumber;
        this.missionStagingArea = missionStagingArea;
        this.unitName = unitName;
        this.leftTo = leftTo;
        this.rightTo = rightTo;
        this.leftFrom = leftFrom;
        this.rightFrom = rightFrom;
        vehicles = new ArrayList<>();
        people = new ArrayList<>();
        attachments = new Attachments();
        missionClassification = new Classification();
        missionLinkUpTime = new Time(lUH, lUM, lUS);
        missionDepartureTime = new Time(dTH, dTM, dTS);
    }
    
    /**
     * Method getInstance() will return a static object of Mission() that was  
     *  assigned the name uniqueInstance. 
     * @return if null will return new Mission() ,else return uniqueInstance
     */
    public static synchronized Mission getInstance() {
        
        // if uniqueInstance is null, instantiate it to new Mission()
        if (uniqueInstance == null) {
            uniqueInstance = new Mission();
        }
        
        // if constructorUsed is set to "alt1" then return uniqueInstance else return null
        if (constructorUsed.equals("default")) 
            return uniqueInstance;
        
        return null;
    }
    
    /**
     * getInstance(int missionNumber, String missionName,
            int numberOfPersonnel, int numberOfVehicles,String missionStagingArea,
            String unitName, int lUH, int lUM, int lUS, int dTH, int dTM, int dTS)
     *
     * will return a static object of Mission(int missionNumber, String missionName,
            int numberOfPersonnel, int numberOfVehicles,String missionStagingArea,
            String unitName, int lUH, int lUM, int lUS, int dTH, int dTM, int dTS) 
     * that was assigned the name uniqueInstance. 
     * @param missionNumber int value that missionNumber will be set to
     * @param missionStagingArea string value that missionStagingArea will be
     * set to
     * @param unitName string value that unitName will be set to
     * @param lUH int value representing hours use to instantiate
     * missionLinkUpTime
     * @param lUM int value representing minutes use to instantiate
     * missionLinkUpTime
     * @param lUS int value representing seconds use to instantiate
     * missionLinkUpTime
     * @param dTH int value representing hours use to instantiate
     * missionDepartureTime
     * @param dTM int value representing minutes use to instantiate
     * missionDepartureTime
     * @param dTS int value representing seconds use to instantiate
     * missionDepartureTime
     * @return 
     */
    public static synchronized Mission getInstance(String missionNumber, String missionStagingArea, String leftTo, String rightTo, String leftFrom, String rightFrom,
            String unitName, int lUH, int lUM, int lUS, int dTH, int dTM, int dTS) {
        
        // if uniqueInstance is null, instantiate it to new Mission()
        if (uniqueInstance == null) {
            uniqueInstance = new Mission(missionNumber,  leftTo,  rightTo,  leftFrom,  rightFrom, missionStagingArea, unitName, lUH, lUM, 
                    lUS, dTH, dTM, dTS);
        }
        
        // if constructorUsed is set to "alt1" then return uniqueInstance else return null
        if (constructorUsed.equals("alt1")) 
            return uniqueInstance;
        
        return null;
    }
		
	

    /**
     * Method addPersonnel(Personnel person) adds persons to mission
     * @param person person to be added
     * @return people.add(person) returns whether or not a person was addded
     */
    public boolean addPersonnel(Personnel person) {

        return people.add(person);

    }

    /**
     * Method removePersonnel(Personnel person) removes persons from mission
     * @param person person to be removed
     * @return boolean returns whether or not a person was removed
     */
    public boolean removePersonnel(Personnel person) {

        int i = people.indexOf(person);
        if (i >= 0) {
            people.remove(i);
            return true;
        }

        return false;

    }
    
    /**
     * Method removeAllPersonnel() remove all personnel from the mission
     */
    public void removeAllPersonnel(){
        
        people.clear();
        
    }
    
    /**
     * Method addVehicle(Vehicle vehicle) adds vehicle
     * @param vehicle vehicle to be added
     * @return vehicles.add(vehicle) returns whether or not vehicle was added
     */
    public void addVehicle(Vehicle newVehicle) {
        vehicles.add(newVehicle);        
    }
    
    /**
     * Method removeVehicle(Vehicle vehicle) removes vehicles
     * @param vehicle vehicle to be removed
     * @return boolean returns whether or not vehicle was removed 
     */
    public boolean removeVehicle(Vehicle vehicle) {
        int i = vehicles.indexOf(vehicle);
        if (i >= 0) {
            vehicles.remove(i);
            return true;
        }
        return false;
    }

    /**
     * Method setMissionNumber(int missionNumber) sets this.missionNumber 
     * to missionNumber
     * @param missionNumber 
     */
    public void setMissionNumber(String missionNumber) {
        this.missionNumber = missionNumber;
    }

    /**
     * Method setNumberOfPersonnel(int numberOfPersonnel) sets this.numberOfPersonnel
     * to numberOfPersonnel
     * @param numberOfPersonnel int value that this.numberOfPersonnel is set to
     */
    public void setLeftTo(String leftTo) {
        this.leftTo = leftTo;
    }
    
    public void setLeftFrom(String leftFrom) {
        this.leftFrom = leftFrom;
    }

    /**
     * Method setNumberOfVehicles(int numberOfVehicles) sets this.numberOfVehicles
     * to numberOfVehicles
     * @param numberOfVehicles int value that this.numberOfVehicles is set to
     */
    public void setRightTo(String rightTo) {
        this.rightTo = rightTo;
    }
    
    public void setRightFrom(String rightFrom) {
        this.rightFrom = rightFrom;
    }

    /**
     * Method setMissionClassification(Classification classification) sets
     * this.missionClassification to classification
     * @param classification Classification value that this.missionClassification
     * is set to
     */
    public void setMissionClassification(Classification classification) {
        this.missionClassification = classification;
    }

    /**
     * Method setmissionLinkUptime(int hours, int minutes, int seconds) sets the time of the 
     * missionLinkUpTime to hours:minutes:seconds
     * @param hours int value that will be passed to setHours
     * @param minutes int value that will be passed to setMinutes
     * @param seconds int value that will be passed to setSeconds
     */
    public void setmissionLinkUptime(int hours, int minutes, int seconds) {
        missionLinkUpTime.setHours(hours);
        missionLinkUpTime.setMinutes(minutes);
        missionLinkUpTime.setSeconds(seconds);
    }

    /**
     * Method setMissionDepartureTime(int hours, int minutes, int seconds) sets the time of the 
     * setMissionDepartureTime to hours:minutes:seconds
     * @param hours int value that will be passed to setHours
     * @param minutes int value that will be passed to setMinutes
     * @param seconds int value that will be passed to setSeconds
     */
    public void setMissionDepartureTime(int hours, int minutes, int seconds) {
        missionDepartureTime.setHours(hours);
        missionDepartureTime.setMinutes(minutes);
        missionDepartureTime.setSeconds(seconds);
    }

    /**
     * Method setMissionStagingArea(String stagingArea) sets this.missionStagingArea
     * to stagingArea
     * @param stagingArea String value that missionStagingArea will be set to
     */
    public void setMissionStagingArea(String stagingArea) {
        this.missionStagingArea = stagingArea;
    }

    /**
     * Method setUnitName(String unitName) sets this.unitName to unitName
     * @param unitName String value that unitName will be set to
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * Method getMissionNumber() will return missionNumber
     * @return missionNumber
     */
    public String getMissionNumber() {
        return missionNumber;
    }

    /**
     * Method getNumberOfPersonnel() will return numberOfPersonnel
     * @return numberOfPersonnel
     */
    public String getLeftTo() {
        return leftTo;
    }

    /**
     * Method getNumberOfVehicles() will return numberOfVehicles
     * @return numberOfVehicles
     */
    public String getRightTo() {
        return rightTo;
    }
    
    /**
     * Method getNumberOfPersonnel() will return numberOfPersonnel
     * @return numberOfPersonnel
     */
    public String getLeftFrom() {
        return leftFrom;
    }

    /**
     * Method getNumberOfVehicles() will return numberOfVehicles
     * @return numberOfVehicles
     */
    public String getRightFrom() {
        return rightFrom;
    }

    /**
     * Method getMissionClassification() will return missionClassification
     * @return missionClassification
     */
    public Classification getMissionClassification() {
        return missionClassification;
    }

    /**
     * Method getMissionLinkUpTime() will return missionLinkUpTime.toString()
     * @return missionLinkUpTime.toString()
     */
    public String getMissionLinkUpTime() {
        return missionLinkUpTime.toString();
    }

    /**
     * Method getMissionDepartureTime() will return missionDepartureTime.toString()
     * @return missionDepartureTime.toString();
     */
    public String getMissionDepartureTime() {
        return missionDepartureTime.toString();
    }

    /**
     * Method getMissionstagingArea() will return missionStagingArea
     * @return missionStagingArea
     */
    public String getMissionstagingArea() {
        return missionStagingArea;
    }
    
    /**
     * Method getVehicles() will return vehicles
     * @return vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    
    /**
     * 
     * @param index position in vehicles ArrayList
     * @return vehicle object
     */
    public Vehicle getVehicleAtIndex(int index) {
        Vehicle tempVehicle = this.vehicles.get(index);
        
        if (tempVehicle != null)
            return tempVehicle;
        
        return null;
    }

    /**
     * Method getUnitName() will return unitName
     * @return unitName
     */
    public String getUnitName() {
        return unitName;
    }

}
