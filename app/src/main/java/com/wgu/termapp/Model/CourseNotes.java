package com.wgu.termapp.Model;

public class CourseNotes {

    private long courseNotesID;
    private long courseNotesCourseID;
    private String courseNotesText;
    private String courseNotesURI;
    private String courseNotesCreated;

    public CourseNotes(long courseNotesID, long courseNotesCourseID, String courseNotesText, String courseNotesURI){
        setCourseNotesID(courseNotesID);
        setCourseNotesCourseID(courseNotesCourseID);
        setCourseNotesText(courseNotesText);
        setCourseNotesURI(courseNotesURI);
    }

    /**
     * _______________________________________________________________________
     *                                  SETTERS
     * -----------------------------------------------------------------------
     */

    public void setCourseNotesID(long courseNotesID){
        this.courseNotesID = courseNotesID;
    }

    public void setCourseNotesCourseID(long courseNotesCourseID){
        this.courseNotesCourseID = courseNotesCourseID;
    }

    public void setCourseNotesText(String courseNotesText){
        this.courseNotesText = courseNotesText;
    }

    public void setCourseNotesURI(String courseNotesURI){
        this.courseNotesURI = courseNotesURI;
    }

    public void setCourseNotesCreated(String courseNotesCreated){
        this.courseNotesCreated = courseNotesCreated;
    }

    /**
     * _______________________________________________________________________
     *                                  GETTERS
     * -----------------------------------------------------------------------
     */

    public long getCourseNotesID(){
        return courseNotesID;
    }

    public long getCourseNotesCourseID(){
        return courseNotesCourseID;
    }

    public String getCourseNotesText(){
        return courseNotesText;
    }

    public String getCourseNotesURI(){
        return courseNotesURI;
    }

    public String getCourseNotesCreated(){
        return courseNotesCreated;
    }

}
