package com.wgu.termapp.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.wgu.termapp.Model.Term;

public class DataManager {

    /**
     * _______________________________________________________________________
     *                            INSERT POJO TO DB
     * -----------------------------------------------------------------------
     */

    public static Uri insertTerms(Context context, String termName, String termStart, String termEnd, String termActive){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.TERM_NAME, termName);
        values.put(DBOpenHelper.TERM_START, termStart);
        values.put(DBOpenHelper.TERM_END, termEnd);
        values.put(DBOpenHelper.TERM_ACTIVE, termActive);
        Uri termUri = context.getContentResolver().insert(DataProvider.TERMS_URI, values);
        return termUri;
    }

    public static Uri insertCourse(Context context, long courseTermID, String courseName,
                                   String courseDesc, String courseStart, String courseEnd, String courseStatus,
                                   String courseMentor, String courseMentorPhone, String courseMentorEmail,
                                   String courseNotification){

        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COURSE_NAME, courseName);
        values.put(DBOpenHelper.COURSE_TERM_ID, courseTermID);
        values.put(DBOpenHelper.COURSE_DESC, courseDesc);
        values.put(DBOpenHelper.COURSE_START, courseStart);
        values.put(DBOpenHelper.COURSE_END, courseEnd);
        values.put(DBOpenHelper.COURSE_STATUS, courseStatus);
        values.put(DBOpenHelper.COURSE_MENTOR, courseMentor);
        values.put(DBOpenHelper.COURSE_MENTOR_PHONE, courseMentorPhone);
        values.put(DBOpenHelper.COURSE_MENTOR_EMAIL, courseMentorEmail);
        values.put(DBOpenHelper.COURSE_NOTIFICATION, courseNotification);
        Uri courseUri = context.getContentResolver().insert(DataProvider.COURSE_URI, values);
        return  courseUri;
    }

    public static Uri insertCourseNotes(Context context, long courseNotesCourseID, String courseNotesText, String courseNotesURI){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COURSE_NOTES_COURSE_ID, courseNotesCourseID);
        values.put(DBOpenHelper.COURSE_NOTES_TEXT, courseNotesText);
        values.put(DBOpenHelper.COURSE_NOTES_URI, courseNotesCourseID);
        values.put(DBOpenHelper.COURSE_NOTES_COURSE_ID, courseNotesURI);
        Uri courseNotesUri = context.getContentResolver().insert(DataProvider.COURSE_NOTES_URI, values);
        return courseNotesUri;
    }

    public static Uri insertAssessment(Context context, long assessmentCourseID, String assessmentCode,
                                        String assessmentName, String assessmentDesc, String assessmentNotification){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.ASSESSMENTS_COURSE_ID, assessmentCourseID);
        values.put(DBOpenHelper.ASSESSMENT_CODE, assessmentCode);
        values.put(DBOpenHelper.ASSESSMENT_NAME, assessmentName);
        values.put(DBOpenHelper.ASSESSMENT_DESC, assessmentDesc);
        values.put(DBOpenHelper.ASSESSMENT_NOTIFICATION, assessmentNotification);
        Uri assessmentUri = context.getContentResolver().insert(DataProvider.ASSESSMENT_URI, values);
        return assessmentUri;
    }

    public static Uri insertAssessmentNotes(Context context, long assessmentNotesAssessmentID, String assessmentNotesText, String assessmentNoteURI){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.ASSESSMENT_NOTES_ASSESSMENT_ID, assessmentNotesAssessmentID);
        values.put(DBOpenHelper.ASSESSMENT_NOTES_TEXT, assessmentNotesText);
        values.put(DBOpenHelper.ASSESSMENT_NOTES_URI, assessmentNoteURI);
        Uri assessmentNotesUri = context.getContentResolver().insert(DataProvider.ASSESSMENT_NOTES_URI, values);
        return assessmentNotesUri;
    }

    public static Uri insertImages(Context context, String imgURI, String imgTS){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.IMAGE_URI, imgURI);
        values.put(DBOpenHelper.IMAGE_TIMESTAMP, imgTS);
        Uri imagesUri = context.getContentResolver().insert(DataProvider.IMAGES_URI, values);
        return imagesUri;
    }

    /**
     * _______________________________________________________________________
     *                            GET POJO FROM DB
     * -----------------------------------------------------------------------
     */

    public static Term getTerms(Context context, long termID){
        Cursor cursor = context.getContentResolver().query(DataProvider.TERMS_URI, DBOpenHelper.TERMS_COLS,
                DBOpenHelper.TERMS_TABLE_ID + " = " + termID, null, null );
        cursor.moveToFirst();
        String termName = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TERM_NAME));
        String termStart = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TERM_START));
        String termEnd = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TERM_END));
        int termActive = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.TERM_ACTIVE));

        Term t = new Term(termID, termName, termStart, termEnd, termActive);
        return t;
    }

    /**
     * _______________________________________________________________________
     *                            DELETE POJO FROM DB
     * -----------------------------------------------------------------------
     */

    public static boolean deleteAssessment(Context context, long assessmentID) {
        return true;
    }

    public static boolean deleteAssessmentNotes(Context context, long assessmentNotesID) {
        return true;
    }

    public static boolean deleteCourseNotes(Context context, long courseNotesID) {
        context.getContentResolver().delete(DataProvider.COURSE_NOTES_URI, DBOpenHelper.COURSE_NOTES_COURSE_ID + " = " + courseNotesID, null);
        return true;
    }

    public static boolean deleteCourse(Context context, long courseID){
        /*Cursor courseCursor = context.getContentResolver().query(DataProvider.COURSE_URI, DBOpenHelper.COURSES_COLS,
                DBOpenHelper.COURSE_TABLE_ID + " = " + courseID, null, null);
        while(courseCursor.moveToNext()){
            deleteCourseNotes(context, cou.getLong(termCursor.getColumnIndex(DBOpenHelper.TERMS_TABLE_ID)));
        }
        context.getContentResolver().delete(DataProvider.TERMS_URI, DBOpenHelper.TERMS_TABLE_ID + " = " + termID, null);*/
        return true;
    }
}
