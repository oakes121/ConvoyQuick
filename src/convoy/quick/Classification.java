package convoy.quick;

class Classification {

    private String type;
    private String status;

    public Classification() {

        type = "default";
        status = "For Official Use Only";

    }

    public Classification(String type, String status) {

        this.type = type;
        this.status = status;

    }

    public void setType(String type) {

        this.type = type;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    public String getType() {

        return this.type;

    }

    public String getStatus() {

        return this.status;

    }

}
