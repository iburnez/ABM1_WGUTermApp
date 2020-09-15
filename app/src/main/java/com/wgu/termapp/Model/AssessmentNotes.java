package com.wgu.termapp.Model;

public class AssessmentNotes {

    private long assessmentNotesID;
    private long assessmentNotesAssessmentID;
    private String assessmentNotesText;
    private String assessmentNoteURI;
    private String assessmentNotesCreated;

    public AssessmentNotes(long assessmentNotesID, int assessmentNotesAssessmentID,
                           String assessmentNotesText, String assessmentNoteURI){
        setAssessmentNotesID(assessmentNotesID);
        setAssessmentNotesAssessmentID(assessmentNotesAssessmentID);
        setAssessmentNotesText(assessmentNotesText);
        setAssessmentNoteURI(assessmentNoteURI);
    }

    /**
     * _______________________________________________________________________
     *                                  SETTERS
     * -----------------------------------------------------------------------
     */

    public void setAssessmentNotesID(long assessmentNotesID){
        this.assessmentNotesID = assessmentNotesID;
    }

    public void setAssessmentNotesAssessmentID(long assessmentNotesAssessmentID){
        this.assessmentNotesAssessmentID = assessmentNotesAssessmentID;
    }

    public void setAssessmentNotesText(String assessmentNotesText){
        this.assessmentNotesText = assessmentNotesText;
    }

    public void setAssessmentNoteURI(String assessmentNoteURI){
        this.assessmentNoteURI = assessmentNoteURI;
    }

    public void setAssessmentNotesCreated(String assessmentNotesCreated){
        this. assessmentNotesCreated = assessmentNotesCreated;
    }

    /**
     * _______________________________________________________________________
     *                                  GETTERS
     * -----------------------------------------------------------------------
     */

    public long getAssessmentNotesID(){
        return assessmentNotesID;
    }

    public long getAssessmentNotesAssessmentID(){
        return assessmentNotesAssessmentID;
    }

    public String getAssessmentNotesText(){
        return assessmentNotesText;
    }

    public String getAssessmentNoteURI(){
        return  assessmentNoteURI;
    }

    public String getAssessmentNotesCreated(){
        return assessmentNotesCreated;
    }

}
