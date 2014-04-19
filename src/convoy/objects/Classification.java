package convoy.objects;

import java.io.Serializable;

class Classification implements Serializable {

    private int type;
    private String status;

    /**
     * Constructor Classification() creates default classification object
     */
    public Classification() {

        type = 0;
        status = "For Official Use Only";

    }

    /**
     * Constructor Classification(String type, String status) creates specified
     * classification object
     *
     * @param type classification type
     * @param status classification status
     */
    public Classification(int type, String status) {

        this.type = type;
        this.status = status;

    }

    /**
     * Method setType(String type) sets classification type
     *
     * @param type classification type
     */
    public void setType(int type) {

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
    public int getType() {

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
