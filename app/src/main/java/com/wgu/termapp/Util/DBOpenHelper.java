package com.wgu.termapp.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "wgu_ABM1.db";
    private static int DATABASE_VERSION = 1;

    //TERMS TABLE CONSTANTS
    public static final String TABLE_TERMS = "terms";
    public static final String TERMS_TABLE_ID = "_ID";
    public static final String TERM_NAME = "termName";
    public static final String TERM_START = "termStart";
    public static final String TERM_END = "termEnd";
    public static final String TERM_ACTIVE = "termActivate";
    public static final String TERM_CREATED = "termCreated";
    public static final String[] TERMS_COLS = {TERMS_TABLE_ID, TERM_NAME, TERM_START,
                                                TERM_END, TERM_ACTIVE, TERM_CREATED, };

    //COURSES TABLE CONSTANTS
    public static final String TABLE_COURSE = "course";
    public static final String COURSE_TABLE_ID = "_ID";
    public static final String COURSE_TERM_ID = "courseTermID";
    public static final String COURSE_NAME = "courseName";
    public static final String COURSE_DESC = "courseDesc";
    public static final String COURSE_START = "courseStart";
    public static final String COURSE_END = "courseEnd";
    public static final String COURSE_STATUS = "courseStatus";
    public static final String COURSE_MENTOR = "courseMentor";
    public static final String COURSE_MENTOR_PHONE = "courseMentorPhone";
    public static final String COURSE_MENTOR_EMAIL = "courseMentorEmail";
    public static final String COURSE_NOTIFICATION = "courseNotification";
    public static final String COURSE_CREATED = "courseCreated";
    public static final String[] COURSES_COLS = {COURSE_TABLE_ID, COURSE_TERM_ID, COURSE_NAME,
            COURSE_DESC, COURSE_START, COURSE_END, COURSE_STATUS, COURSE_MENTOR, COURSE_MENTOR_PHONE,
            COURSE_MENTOR_EMAIL, COURSE_NOTIFICATION, COURSE_CREATED};

    //COURSE NOTES TABLE CONSTANTS
    public static final String TABLE_COURSE_NOTES = "courseNotes";
    public static final String COURSE_NOTES_TABLE_ID = "_ID";
    public static final String COURSE_NOTES_COURSE_ID = "courseNotesCourseID";
    public static final String COURSE_NOTES_TEXT = "courseNotesText";
    public static final String COURSE_NOTES_URI = "courseNotesURI";
    public static final String COURSE_NOTES_CREATED = "courseNotesCreated";
    public static final String[] COURSE_NOTES_COLS = {COURSE_NOTES_TABLE_ID, COURSE_NOTES_COURSE_ID,
                                        COURSE_NOTES_TEXT, COURSE_NOTES_URI, COURSE_NOTES_CREATED};

    //ASSESSMENTS TABLE CONSTANTS
    public static final String TABLE_ASSESSMENTS = "assessments";
    public static final String ASSESSMENTS_TABLE_ID = "_ID";
    public static final String ASSESSMENTS_COURSE_ID = "assCourseID";
    public static final String ASSESSMENT_NAME = "assName";
    public static final String ASSESSMENT_CODE = "assCode";
    public static final String ASSESSMENT_DESC = "assDesc";
    public static final String ASSESSMENT_NOTIFICATION = "assNotification";
    public static final String ASSESSMENT_CREATED = "assCreated";
    public static final String[] ASSESSMENT_COLS = {ASSESSMENTS_TABLE_ID, ASSESSMENTS_COURSE_ID,
                                                ASSESSMENT_NAME, ASSESSMENT_CODE, ASSESSMENT_DESC,
                                                ASSESSMENT_NOTIFICATION, ASSESSMENT_CREATED};

    //ASSESSMENTS NOTES TABLE CONSTANTS
    public static final String TABLE_ASSESSMENT_NOTES = "assessmentsNotes";
    public static final String ASSESSMENT_NOTES_TABLE_ID = "_ID";
    public static final String ASSESSMENT_NOTES_ASSESSMENT_ID = "assessmentNotesAssessmentID";
    public static final String ASSESSMENT_NOTES_TEXT = "assessmentNotesText";
    public static final String ASSESSMENT_NOTES_URI = "assessmentNoteURI";
    public static final String ASSESSMENT_NOTES_CREATED = "assessmentNotesCreated";
    public static final String[] ASSESSMENT_NOTES_COLS = {ASSESSMENT_NOTES_TABLE_ID, ASSESSMENT_NOTES_ASSESSMENT_ID,
                                 ASSESSMENT_NOTES_TEXT, ASSESSMENT_NOTES_URI, ASSESSMENT_NOTES_CREATED};

    //IMAGES TABLE CONSTANTS
    public static final String TABLE_IMAGES = "images";
    public static final String IMAGE_TABLE_ID = "_ID";
    public static final String IMAGE_URI = "imgURI";
    public static final String IMAGE_TIMESTAMP = "imgTS";
    public static final String IMAGE_CREATED = "imgCreated";
    public static final String[] IMAGE_COLS = {IMAGE_TABLE_ID, IMAGE_URI, IMAGE_TIMESTAMP, IMAGE_CREATED};

    //TERMS TABLE CREATE STRING
    private static final String TERM_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
                                        TABLE_TERMS + " ( " +
                                        TERMS_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        TERM_NAME + " TEXT, " +
                                        TERM_START + " DATE, " +
                                        TERM_END + " DATE, " +
                                        TERM_ACTIVE + " INTEGER, " +
                                        TERM_CREATED + "TEXT default CURRENT_TIMESTAMP );";

    //COURSES TABLE CREATE STRING
    private static final String COURSE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
                                        TABLE_COURSE + " ( " +
                                        COURSE_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        COURSE_TERM_ID + " INTEGER, " +
                                        COURSE_NAME + " TEXT, " +
                                        COURSE_DESC + " TEXT, " +
                                        COURSE_START + " DATE, " +
                                        COURSE_END + " DATE, " +
                                        COURSE_STATUS + " TEXT, " +
                                        COURSE_MENTOR + " TEXT, " +
                                        COURSE_MENTOR_PHONE + " TEXT, " +
                                        COURSE_MENTOR_EMAIL + " TEXT, " +
                                        COURSE_NOTIFICATION + " INTEGER, " +
                                        COURSE_CREATED + "TEXT default CURRENT_TIMESTAMP, " +
                                        "FOREIGN KEY (" + COURSE_TERM_ID +
                                        ") REFERENCES " + TABLE_TERMS +
                                        " ( " +  TERMS_TABLE_ID + " ));";

    //COURSE NOTES TABLE CREATE STRING
    private static final String COURSE_NOTES_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
                                        TABLE_COURSE_NOTES + " ( " +
                                        COURSE_NOTES_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        COURSE_NOTES_COURSE_ID + " INTEGER, " +
                                        COURSE_NOTES_TEXT + " TEXT, " +
                                        COURSE_NOTES_URI + " TEXT, " +
                                        COURSE_NOTES_CREATED + "TEXT default CURRENT_TIMESTAMP, " +
                                        "FOREIGN KEY (" + COURSE_NOTES_COURSE_ID +
                                        ") REFERENCES " + TABLE_COURSE +
                                        " ( " +  COURSE_TABLE_ID + " ));";

    //ASSESSMENTS TABLE CREATE STRING
    private static final String ASSESSMENT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
                                        TABLE_ASSESSMENTS + " ( " +
                                        ASSESSMENTS_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ASSESSMENTS_COURSE_ID + " INTEGER, " +
                                        ASSESSMENT_NAME + " TEXT, " +
                                        ASSESSMENT_CODE + " TEXT, " +
                                        ASSESSMENT_DESC + " TEXT, " +
                                        ASSESSMENT_NOTIFICATION + " INTEGER, " +
                                        ASSESSMENT_CREATED + "TEXT default CURRENT_TIMESTAMP, " +
                                        "FOREIGN KEY (" + ASSESSMENTS_COURSE_ID +
                                        ") REFERENCES " + TABLE_COURSE +
                                        " ( " +  COURSE_TABLE_ID + " ));";

    //ASSESSMENTS NOTES TABLE CREATE STRING
    private static final String ASSESSMENT_NOTES_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
                                        TABLE_ASSESSMENT_NOTES + " ( " +
                                        ASSESSMENT_NOTES_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ASSESSMENT_NOTES_ASSESSMENT_ID + " INTEGER, " +
                                        ASSESSMENT_NOTES_TEXT + " TEXT, " +
                                        ASSESSMENT_NOTES_URI + " TEXT, " +
                                        ASSESSMENT_NOTES_CREATED + "TEXT default CURRENT_TIMESTAMP, " +
                                        "FOREIGN KEY (" + ASSESSMENT_NOTES_ASSESSMENT_ID +
                                        ") REFERENCES " + TABLE_ASSESSMENTS +
                                        " ( " +  ASSESSMENTS_TABLE_ID + " ));";

    //IMAGES TABLE CREATE STRING
    private static final String IMAGES_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
                                        TABLE_IMAGES + " ( " +
                                        IMAGE_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        IMAGE_URI + " TEXT, " +
                                        IMAGE_TIMESTAMP + " INTEGER, " +
                                        IMAGE_CREATED + "TEXT default CURRENT_TIMESTAMP );";

    /**
     * DEFAULT CONSTRUCTOR FOR DBOpenHelper Class
     * @param context -
     */
    public DBOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * CREATE NEW DB
     * @param db sqlLitedb
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COURSE_TABLE_CREATE);
        db.execSQL(COURSE_NOTES_TABLE_CREATE);
        db.execSQL(ASSESSMENT_TABLE_CREATE);
        db.execSQL(ASSESSMENT_NOTES_TABLE_CREATE);
        db.execSQL(IMAGES_TABLE_CREATE);
    }

    /**
     * UPGRADE DB FROM OLD TO NEW VERSION
     * @param db sqlLite db
     * @param oldVersion old db version
     * @param newVersion new db version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSESSMENT_NOTES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSESSMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE_NOTES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TERMS);
        onCreate(db);
    }
}
