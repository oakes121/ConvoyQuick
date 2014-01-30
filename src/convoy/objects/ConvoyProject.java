package convoy.objects;

public class ConvoyProject {

    private String projectName;
    private Mission convoyMission;

    /**
     * Constructor ConvoyProject() creates convoy project
     */
    public ConvoyProject() {

    }

    /**
     * Constructor ConvoyProject(String projectName) creates convoy project with
     * specified
     *
     * @param projectName convoy project name
     */
    public ConvoyProject(String projectName) {

        createNewProject(projectName);

    }

    /**
     * createNewProject(String projectName) creates a new convoy project
     *
     * @param projectName name of new convoy project
     */
    private void createNewProject(String projectName) {

        setProjectName(projectName);

        // TODO code logic goes here
    }

    /**
     * Method setProjectName(String projectName) sets convoy project name
     *
     * @param projectName convoy project name
     */
    private void setProjectName(String projectName) {

        this.projectName = projectName;

    }

    /**
     * Method editProject(String projectName) makes changes to a convoy project
     *
     * @param projectName convoy project name to be edited
     */
    public void editProject(String projectName) {

        // TODO code logic goes here
    }

    /**
     * Method deleteProject(String projectName)
     *
     * @param projectName convoy project name to be deleted
     * @return boolean whether or not the project was deleted successfully
     */
    public boolean deleteProject(String projectName) {

        /*
        
         delete project;
        
         if(project deletion complete){
                
         return true;
        
         }
         else{
                
         return false;
        
         }
        
         */
        return true;

    }

    /**
     * Method setConvoyMission(Mission mission) sets convoy mission for the
     * convoy project
     *
     * @param mission convoy mission to be set to convoy project
     */
    public void setConvoyMission(Mission mission) {

        this.convoyMission = mission;

    }

    /**
     * Method getConvoyMission() gets the convoy mission
     *
     * @return this.convoyMission returns current convoy mission
     */
    public Mission getConvoyMission() {

        return this.convoyMission;

    }

}
