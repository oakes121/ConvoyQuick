package convoy.objects;

import java.io.Serializable;

class Classification implements Serializable {

    private String type;
    private String status;

    /**
     * Constructor Classification() creates default classification object
     */
    public Classification() {

        type = "default";
        status = "For Official Use Only";

    }

    /**
     * Constructor Classification(String type, String status) creates specified
     * classification object
     *
     * @param type classification type
     * @param status classification status
     */
    public Classification(String type, String status) {

        this.type = type;
        this.status = status;

    }

    /**
     * Method setType(String type) sets classification type
     *
     * @param type classification type
     */
    public void setType(String type) {

        this.type = type;

    }

    /**
     * Method setStatus(String status) sets classification status
     *
     * @param status classification status
     */
    public void setStatus(String status) {

        this.status = status;

    }

    /**
     * Method getType() gets classification type
     *
     * @return this.type returns classification type
     */
    public String getType() {

        return this.type;

    }

    /**
     * Method getStatus()
     *
     * @return this.status returns classification status
     */
    public String getStatus() {

        return this.status;

    }

}
