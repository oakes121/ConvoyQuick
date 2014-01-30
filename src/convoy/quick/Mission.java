package convoy.quick;

import java.sql.Time;

public class Mission {
    private int missionNumber;
    private String missionName;
    private int numberOfPersonnel;
    private int numberOfVehicles;
    private Classification classification;
    private Time meetingTime;
    private String location;
    private Time sp;
    private String unitName;
    
    public Mission (int mNumber, String mName, int nOP, int nOV, Classification c, Time mT,
            String l, Time sP, String uM) {
        this.missionNumber = mNumber;
        this.missionName = mName;
        this.numberOfPersonnel = nOP;
        this.numberOfVehicles = nOV;
        this.classification = c;
        this.meetingTime = mT; 
        this.location = l;
        this.sp = sP;
        this.unitName = uM;
    }
    
    public void setMissionNumber(int number) {
        missionNumber = number;
    }
    
    public void setMissionName(String name) {
        missionName = name;
    }
    public int getMissionNumber() {
        return missionNumber;
    }
    
    public String getMissionName() {
        return missionName;
    }

    
}
