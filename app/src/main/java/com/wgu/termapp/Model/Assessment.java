package com.wgu.termapp.Model;

public class Assessment {

    private long assessmentID;
    private long assessmentCourseID;
    private String assessmentCode;
    private String assessmentName;
    private String assessmentDesc;
    private String assessmentNotification;
    private String assessmentCreated;

    public Assessment(long assessmentID, int assessmentCourseID, String assessmentCode,
                      String assessmentName, String assessmentDesc, String assessmentNotification){
        setAssessmentID(assessmentID);
        setAssessmentCourseID(assessmentCourseID);
        setAssessmentCode(assessmentCode);
        setAssessmentName(assessmentName);
        setAssessmentDesc(assessmentDesc);
        setAssessmentNotification(assessmentNotification);
    }

    /**
     * _______________________________________________________________________
     *                                  SETTERS
     * -----------------------------------------------------------------------
     */

    public void setAssessmentID(long assessmentID){
        this.assessmentID = assessmentID;
    }

    public void setAssessmentCourseID(long assessmentCourseID) {
        this.assessmentCourseID = assessmentCourseID;
    }

    public void setAssessmentCode(String assessmentCode){
        this.assessmentCode = assessmentCode;
    }

    public void setAssessmentName(String assessmentName){
        this.assessmentName = assessmentName;
    }

    public void setAssessmentDesc(String assessmentDesc){
        this.assessmentDesc = assessmentDesc;
    }

    public void setAssessmentNotification(String assessmentNotification){
        this.assessmentNotification = assessmentNotification;
    }

    public void setAssessmentCreated(String assessmentCreated){
        this.assessmentCreated = assessmentCreated;
    }

    /**
     * _______________________________________________________________________
     *                                  GETTERS
     * -----------------------------------------------------------------------
     */

    public long getAssessmentID(){
        return assessmentID;
    }

    public long getAssessmentCourseID(){
        return assessmentCourseID;
    }

    public String getAssessmentCode(){
        return assessmentCode;
    }

    public String getAssessmentName(){
        return assessmentName;
    }

    public String getAssessmentDesc(){
        return assessmentDesc;
    }

    public String getAssessmentNotification(){
        return  assessmentNotification;
    }

    public String getAssessmentCreated(){
        return  assessmentCreated;
    }
}
