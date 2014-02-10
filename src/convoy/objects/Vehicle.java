package convoy.objects;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

public class Vehicle implements Serializable {

    private String bumperNumber;
    private String callSign;
    private String equipment;
    private int numberOfPersonnel;
    private Personnel driver;
    private Personnel vehicleCommander;
    private Image vehicleImage;
    private ArrayList<Personnel> passengers;

    /**
     * Constructor Vehicle() sets default vehicle
 */
    public Vehicle() {
        passengers = new ArrayList<>();
        driver = new Personnel("The", "Driver", "Driver", "");
        this.bumperNumber = "";
        this.callSign = "";
        this.equipment = null;
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
        this.equipment = null;
        this.vehicleCommander = null;

    }

    /**
     * Constructor Vehicle(int bumperNumber, String callSign, String equipment,
     * int numberOfPersonnel, Personnel driver, Personnel vehicleCommander,
     * Image vehicleImage, ArrayList<Personnel> passengers) creates specified
     * vehicle
     *
     * @param bumperNumber vehicle bumper number
     * @param callSign vehicle call sign
     * @param equipment vehicle equipment
     * @param numberOfPersonnel number of persons in vehicle
     * @param driver driver of vehicle
     * @param vehicleCommander commander of vehicle
     * @param vehicleImage image of vehicle
     * @param passengers all other passengers in vehicle
     */
    public Vehicle(String bumperNumber, String callSign, String equipment, int numberOfPersonnel, Personnel driver, Personnel vehicleCommander, Image vehicleImage, ArrayList<Personnel> passengers) {

        this.bumperNumber = bumperNumber;
        this.callSign = callSign;
        this.equipment = equipment;
        this.numberOfPersonnel = numberOfPersonnel;
        this.driver = driver;
        this.vehicleCommander = vehicleCommander;
        this.vehicleImage = vehicleImage;
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
     * Method setEquipment(String equipment) sets vehicle equipment
     *
     * @param equipment vehicle equipment
     */
    public void setEquipment(String equipment) {

        this.equipment = equipment;

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
    public void setDriver(Personnel driver) {

        this.driver = driver;

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
    public void setVehicleImage(Image image) {

        this.vehicleImage = image;

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

    /**
     * addPassengers(Personnel passengers) adds passengers to vehicle
     * @param passenger passenger to be added
     * @return passengers.add(passenger) whether or not passenger was added
     */
    public boolean addPassengers(Personnel passenger) {

        return passengers.add(passenger);

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
     * Method getEquipment() gets vehicle equipment
     *
     * @return this.equipment returns vehicle equipment
     */
    public String getEquipment() {

        return this.equipment;

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

        return driver.getFirstName() + " "+ driver.getLastName();
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
     * Method getVehicleImage() gets image of the vehicle
     *
     * @return this.vehicleImage return the vehicle image
     */
    public Image getVehicleImage() {

        return this.vehicleImage;

    }

    /**
     * Method getPassengers()
     *
     * @return this.passengers list of passengers
     */
    public ArrayList<Personnel> getPassengers() {

        return this.passengers;

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
