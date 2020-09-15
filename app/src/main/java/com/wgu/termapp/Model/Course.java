package com.wgu.termapp.Model;

public class Course {

    private long courseID;
    private long courseTermID;
    private String courseName;
    private String courseDesc;
    private String courseStart;
    private String courseEnd;
    private String courseStatus;
    private String courseMentor;
    private String courseMentorPhone;
    private String courseMentorEmail;
    private int courseNotification;
    private String courseCreated;

    public Course(long courseID, long courseTermID, String courseName, String courseDesc,
                  String courseStart, String courseEnd, String courseStatus, String courseMentor,
                  String courseMentorPhone, String courseMentorEmail, int courseNotification){

        setCourseID(courseID);
        setCourseTermID(courseTermID);
        setCourseName(courseName);
        setCourseDesc(courseDesc);
        setCourseStart(courseStart);
        setCourseEnd(courseEnd);
        setCourseStatus(courseStatus);
        setCourseMentor(courseMentor);
        setCourseMentorPhone(courseMentorPhone);
        setCourseMentorEmail(courseMentorEmail);
        setCourseNotification(courseNotification);
    }

    /**
     * _______________________________________________________________________
     *                                  SETTERS
     * -----------------------------------------------------------------------
     */

    public void setCourseID(long courseID){
        this.courseID = courseID;
    }

    public void setCourseTermID(long courseTermID){
        this.courseTermID = courseTermID;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setCourseDesc(String courseDesc){
        this.courseDesc = courseDesc;
    }

    public void setCourseStart (String courseStart){
        this.courseStart = courseStart;
    }

    public void setCourseEnd(String courseEnd){
        this.courseEnd = courseEnd;
    }

    public void setCourseStatus(String courseStatus){
        this.courseStatus = courseStatus;
    }

    public void setCourseMentor(String courseMentor){
        this.courseMentor = courseMentor;
    }

    public void setCourseMentorPhone(String courseMentorPhone){
        this.courseMentorPhone = courseMentorPhone;
    }

    public void setCourseMentorEmail(String courseMentorEmail){
        this.courseMentorEmail = courseMentorEmail;
    }

    public void setCourseNotification(int courseNotification){
        this.courseNotification = courseNotification;
    }

    public  void setCourseCreated(String courseCreated){
        this.courseCreated = courseCreated;
    }

    /**
     * _______________________________________________________________________
     *                                  GETTERS
     * -----------------------------------------------------------------------
     */

    public long getCourseID(){
        return courseID;
    }

    public long getCourseTermID(){
        return courseTermID;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseDesc(){
        return courseDesc;
    }

    public String getCourseStart(){
        return courseStart;
    }

    public String getCourseEnd(){
        return courseEnd;
    }

    public String getCourseStatus(){
        return courseStatus;
    }

    public String getCourseMentor(){
        return courseMentor;
    }

    public String getCourseMentorPhone(){
        return courseMentorPhone;
    }

    public String getCourseMentorEmail(){
        return courseMentorEmail;
    }

    public int getCourseNotification(){
        return courseNotification;
    }

    public String getCourseCreated(){
        return courseCreated;
    }

}
