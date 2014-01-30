package convoy.quick;

class Classification {
    private String type;
    private String status;
    
    public Classification() {
        type = "default";
        status = "For Official Use Only";
    }
    
    public Classification(String t, String s) {
        type = t;
        status = s;
    }
    
    public void setType(String s) {
        type = s;
    }
    
    public void setStatus(String t) {
        type = t;
    }
    
    public String getType() {
        return type;
    }
    
    public String getStatus() {
        return status;
    }
}
