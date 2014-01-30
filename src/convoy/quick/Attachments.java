package convoy.quick;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Attachments {
    private List<File> attachments;
    
    /**
     * This constructor initializes attachments 
     */
    public Attachments() {
        attachments = new ArrayList<File>();
    }
    
    public void addAttachment(File f) {
        attachments.add(f);        
    }
	
    public void removeAttachment(File f) {
        int i = attachments.indexOf(f);
        if (i >= 0) {
            attachments.remove(i);
        }
    }
    
    public File getAttachment(File f) {
        int i = attachments.indexOf(f);
        if (i >= 0) {
            return attachments.get(i);
        }
        return null;
    }
}
