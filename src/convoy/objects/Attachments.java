package convoy.objects;

import java.io.File;
import java.util.ArrayList;

//import java.util.List; //Dont need this
public class Attachments {

    private ArrayList<File> attachments;
    //private List<File> attachments;

    /**
     * This constructor initializes attachments
     */
    public Attachments() {

        attachments = new ArrayList<>();
        //attachments = new ArrayList<File>();

    }

    /**
     * Method addAttachment(File file) adds attachment
     *
     * @param file file to be attached
     * 
     * @return attachments.add(file)
     */
    public boolean addAttachment(File file) {

        return attachments.add(file);

    }

    /**
     * Method removeAttachment(File file)
     *
     * @param file file to be removed
     */
    public void removeAttachment(File file) {

        int i = attachments.indexOf(file);

        if (i >= 0) {

            attachments.remove(i);

        }

    }

    /**
     * Method removeAllAttachments() re-instantiates attachments
     */
    public void removeAllAttachments() {

       attachments.clear();

    }

    /**
     * Method getSingleAttachment(File file) gets a single file
     *
     * @param file file to be retrieved
     * @return attachments.get(i) returns selected file or returns null
     */
    public File getSingleAttachment(File file) {

        int i = attachments.indexOf(file);

        if (i >= 0) {

            return attachments.get(i);

        }

        return null;

    }

    /**
     * Method getAllAttachments() gets all attachments
     *
     * @return attachments returns the arrayList of attachments
     */
    public ArrayList<File> getAllAttachments() {

        return attachments;

    }

}
