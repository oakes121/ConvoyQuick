package convoy.objects;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.Icon;

public class Vehicle implements Serializable {

    private String bumperNumber;
    private String callSign;
    private String additionalInfo;    
    private String iconPath;
    private int numberOfPersonnel;
    private Personnel driver;
    private Personnel vehicleCommander;
    private Icon vehicleIcon;
    private ArrayList<Personnel> passengers;
     private boolean isCC = false;
    private boolean isACC = false;
    private int addVehiclePopUpJComboBox1Selection = 0;
    private int addVehiclePopUpJComboBox2Selection = 0;
    private int addVehiclePopUpJComboBox3Selection = 0;

    /**
     * Constructor Vehicle() sets default vehicle
 */
    public Vehicle() {
        passengers = new ArrayList<>();
        driver = new Personnel("Driver", "", "");
        this.bumperNumber = "";
        this.callSign = "";
        this.additionalInfo = null;
        this.vehicleCommander = null;
    }

    /**
     * Constructor Vehicle(String bumperNumber, String callSign) creates a
     * vehicle with minimum requirements
     *
     * @param bumperNumber
     * @param callSign
     */
    public Vehicle(String bumperNumber, String callSign) {
        passengers = new ArrayList<>();
        this.bumperNumber = bumperNumber;
        this.callSign = callSign;
        this.additionalInfo = null;
        this.vehicleCommander = null;

    }

    /**
     * Constructor Vehicle(int bumperNumber, String callSign, String additionalInfo,
 int numberOfPersonnel, Personnel driver, Personnel vehicleCommander,
 Image vehicleIcon, ArrayList<Personnel> passengers) creates specified
     * vehicle
     *
     * @param bumperNumber vehicle bumper number
     * @param callSign vehicle call sign
     * @param additionalInfo vehicle additionalInfo
     * @param numberOfPersonnel number of persons in vehicle
     * @param driver driver of vehicle
     * @param vehicleCommander commander of vehicle
     * @param vehicleIcon image of vehicle
     * @param passengers all other passengers in vehicle
     */
    public Vehicle(String bumperNumber, String callSign, String additionalInfo, int numberOfPersonnel, Personnel driver, Personnel vehicleCommander, Icon vehicleIcon, ArrayList<Personnel> passengers) {

        this.bumperNumber = bumperNumber;
        this.callSign = callSign;
        this.additionalInfo = additionalInfo;
        this.numberOfPersonnel = numberOfPersonnel;
        this.driver = driver;
        this.vehicleCommander = vehicleCommander;
        this.vehicleIcon = vehicleIcon;
        this.passengers = passengers;

    }

    /**
     * setBumperNumber(String bumperNumber) sets bumper number
     *
     * @param bumperNumber vehicle bumper number
     */
    public void setBumperNumber(String bumperNumber) {

        this.bumperNumber = bumperNumber;

    }

    /**
     * Method setCallSign(String callSign) set vehicle call sign
     *
     * @param callSign vehicle call sign
     */
    public void setCallSign(String callSign) {

        this.callSign = callSign;

    }

    /**
     * Method setadditionalInfo(String additionalInfo) sets vehicle additionalInfo
     *
     * @param additionalInfo vehicle additionalInfo
     */
    public void setAdditionalInfo(String additionalInfo) {

        this.additionalInfo = additionalInfo;

    }

    /**
     * Method setNumberOfPersonnel(int numberOfPersonnel) sets the total number
     * of personnel in vehicle
     *
     * @param numberOfPersonnel number of personnel
     */
    public void setNumberOfPersonnel(int numberOfPersonnel) {

        this.numberOfPersonnel = numberOfPersonnel;

    }

    /**
     * Method setDriver(Personnel driver) sets the driver
     *
     * @param driver vehicle driver
     */
    public void setDriver(String name) {

        this.driver.setName(name);

    }

    /**
     * Method setVehicleCommander(Personnel vehicleCommander) sets the vehicle
     * commander
     *
     * @param vehicleCommander vehicle commander
     */
    public void setVehicleCommander(Personnel vehicleCommander) {

        this.vehicleCommander = vehicleCommander;

    }

    /**
     * Method setVehicleImage(Image image) sets the image of the vehicle
     *
     * @param image vehicle image
     */
    public void setVehicleIcon(Icon image) {

        this.vehicleIcon = image;

    }

    /**
     * setVehiclePassengers(ArrayList<Personnel> passengers) sets vehicle
     * passengers
     *
     * @param passengers vehicle passengers
     */
    public void setVehiclePassengers(ArrayList<Personnel> passengers) {

        this.passengers = passengers;

    }
    
    public void setIconPath(String newIconPath) {
        iconPath = newIconPath;
    }

    /**
     * addPassengers(Personnel passengers) adds passengers to vehicle
     * @param String passenger name
     */
    public void addPassengers(String Name) {

        passengers.add(new Personnel(Name, "", ""));

    }

    /**
     * Method getBumperNumber() gets vehicle bumper number
     *
     * @return this.bumperNumber returns vehicle bumper number
     */
    public String getBumperNumber() {

        return this.bumperNumber;

    }

    /**
     * Method getCallSign() gets vehicle call sign
     *
     * @return this.callSign returns vehicle call sign
     */
    public String getCallSign() {

        return this.callSign;

    }

    /**
     * Method getadditionalInfo() gets vehicle additionalInfo
     *
     * @return this.additionalInfo returns vehicle additionalInfo
     */
    public String getAdditionalInfo() {

        return this.additionalInfo;

    }

    /**
     * Method getNumberOfPersonnel() gets the number of personnel in the vehicle
     *
     * @return this.numberOfPersonnel returns number of personnel in the vehicle
     */
    public int getNumberOfPersonnel() {

        return this.numberOfPersonnel;

    }

    /**
     * Method getDriver() gets vehicle driver
     *
     * @return this.driver returns vehicle driver
     */
    public String getDriverName() {

        return driver.getName();
    }

    /**
     * Method getVehicleCommander() gets vehicle commander
     *
     * @return this.vehicleCommander returns vehicle commander
     */
    public Personnel getVehicleCommander() {

        return this.vehicleCommander;

    }

    /**
     * Method getVehicleIcon() gets image of the vehicle
     *
     * @return this.vehicleIcon return the vehicle image
     */
    public Icon getVehicleIcon() {

        return this.vehicleIcon;

    }

    /**
     * Method getPassengers()
     *
     * @return this.passengers list of passengers
     */
    public ArrayList<Personnel> getPassengers() {

        return this.passengers;

    }
    
    public String getIconPath() {
        return iconPath;
    }
    
    public void setSelections(int one, int two, int three) {
        addVehiclePopUpJComboBox1Selection = one;
        addVehiclePopUpJComboBox2Selection = two;
        addVehiclePopUpJComboBox3Selection = three;
    }
    
    public int getSelection1() {
        return addVehiclePopUpJComboBox1Selection;
    }
    
    public int getSelection2() {
        return addVehiclePopUpJComboBox2Selection;
    }
    
    public int getSelection3() {
        return addVehiclePopUpJComboBox3Selection;
    }
    
    public void setIsCC(boolean truth) {
        isCC = truth;
    }
    
    public void setIsACC(boolean truth) {
        isACC = truth;
    }
    
    public boolean getIsCC() {
        return isCC;
    }
    
    public boolean getIsACC() {
        return isACC;
    }
    
    /**
     * removePassengers(Personnel passenger) removes passengers from vehicle
     * @param passenger passenger to be removed
     * @return passengers.remove(passenger) whether or not passenger was removed
     */
    public boolean removePassengers(Personnel passenger) {
        return passengers.remove(passenger);

    }

}
