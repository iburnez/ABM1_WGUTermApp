package com.wgu.termapp.Model;

public class Images {

    private long imgID;
    private String imgURI;
    private String imgTS;
    private String imgCreated;

    public Images(long imgID, String imgURI, String imgTS){
        setImgID(imgID);
        setImgURI(imgURI);
        setImgTS(imgTS);
    }

    /**
     * _______________________________________________________________________
     *                                  SETTERS
     * -----------------------------------------------------------------------
     */

    public void setImgID(long imgID){
        this.imgID = imgID;
    }

    public void setImgURI(String imgURI){
        this.imgURI = imgURI;
    }

    public void setImgTS(String imgTS){
        this.imgTS = imgTS;
    }

    public void setImgCreated(String imgCreated){
        this.imgCreated = imgCreated;
    }

    /**
     * _______________________________________________________________________
     *                                  GETTERS
     * -----------------------------------------------------------------------
     */

    public long getImgID() {
        return imgID;
    }

    public String getImgURI() {
        return imgURI;
    }

    public String getImgTS() {
        return imgTS;
    }

    public String getImgCreated() {
        return imgCreated;
    }
}
