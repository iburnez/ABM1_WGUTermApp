package com.wgu.termapp.Util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataProvider extends ContentProvider {

    //Declare SQLite DB Var Name
    private SQLiteDatabase db;

    //Authority & Path String Constants
    private static final String AUTHORITY = "com.wgu.termapp.Model";
    private static final String TERMS_PATH = "Term";
    private static final String COURSE_PATH = "Course";
    private static final String COURSE_NOTES_PATH = "CourseNotes";
    private static final String ASSESSMENT_PATH = "Assessments";
    private static final String ASSESSMENT_NOTES_PATH = "AssessmentsNotes";
    private static final String IMAGES_PATH = "Images";

    //Path URIs
    public static final Uri TERMS_URI = Uri.parse("content://" + AUTHORITY + "/" + TERMS_PATH);
    public static final Uri COURSE_URI = Uri.parse("content://" + AUTHORITY + "/" + COURSE_PATH);
    public static final Uri COURSE_NOTES_URI = Uri.parse("content://" + AUTHORITY + "/" + COURSE_NOTES_PATH);
    public static final Uri ASSESSMENT_URI = Uri.parse("content://" + AUTHORITY + "/" + ASSESSMENT_PATH);
    public static final Uri ASSESSMENT_NOTES_URI = Uri.parse("content://" + AUTHORITY + "/" + ASSESSMENT_NOTES_PATH);
    public static final Uri IMAGES_URI = Uri.parse("content://" + AUTHORITY + "/" + IMAGES_PATH);

    //Constants to identify the requested operations
    private static final int TERMS = 1;
    private static final int TERMS_ID = 2;
    private static final int COURSE = 3;
    private static final int COURSE_ID = 4;
    private static final int COURSE_NOTES = 5;
    private static final int COURSE_NOTES_ID = 6;
    private static final int ASSESSMENT = 7;
    private static final int ASSESSMENT_ID = 8;
    private static final int ASSESSMENT_NOTES = 9;
    private static final int ASSESSMENT_NOTES_ID = 10;
    private static final int IMAGES = 11;
    private static final int IMAGES_ID = 12;

    //UriMatcher Initialization
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        uriMatcher.addURI(AUTHORITY, TERMS_PATH, TERMS);
        uriMatcher.addURI(AUTHORITY, TERMS_PATH + "/", TERMS_ID);
        uriMatcher.addURI(AUTHORITY, COURSE_PATH, COURSE);
        uriMatcher.addURI(AUTHORITY, COURSE_PATH + "/", COURSE_ID);
        uriMatcher.addURI(AUTHORITY, COURSE_NOTES_PATH, COURSE_NOTES);
        uriMatcher.addURI(AUTHORITY, COURSE_NOTES_PATH + "/", COURSE_NOTES_ID);
        uriMatcher.addURI(AUTHORITY, ASSESSMENT_PATH, ASSESSMENT);
        uriMatcher.addURI(AUTHORITY, ASSESSMENT_PATH + "/", ASSESSMENT_ID);
        uriMatcher.addURI(AUTHORITY, ASSESSMENT_NOTES_PATH, ASSESSMENT_NOTES);
        uriMatcher.addURI(AUTHORITY, ASSESSMENT_NOTES_PATH + "/", ASSESSMENT_NOTES_ID);
        uriMatcher.addURI(AUTHORITY, IMAGES_PATH, IMAGES);
        uriMatcher.addURI(AUTHORITY, IMAGES_PATH + "/", IMAGES_ID);
    }

    //URI Initialization
    public static final String TERM_CONTENT_TYPE= "term";
    public static final String COURSE_CONTENT_TYPE= "course";
    public static final String COURSE_NOTES_CONTENT_TYPE= "courseNotes";
    public static final String ASSESSMENT_CONTENT_TYPE= "assessment";
    public static final String ASSESSMENT_NOTES_CONTENT_TYPE= "assessmentNotes";
    public static final String IMAGES_CONTENT_TYPE= "img";

    @Override
    public boolean onCreate() {
        //Create database for app
        DBOpenHelper helper = new DBOpenHelper(getContext());
        db = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch(uriMatcher.match(uri)){
            case TERMS:
                return db.query(DBOpenHelper.TABLE_TERMS, DBOpenHelper.TERMS_COLS, selection, null,
                        null, null, DBOpenHelper.TERMS_TABLE_ID + "ASC");
            case COURSE:
                return db.query(DBOpenHelper.TABLE_COURSE, DBOpenHelper.COURSES_COLS, selection, null,
                        null, null, DBOpenHelper.COURSE_TABLE_ID + "ASC");
            case COURSE_ID:
                return db.query(DBOpenHelper.TABLE_COURSE, DBOpenHelper.COURSES_COLS,
                        DBOpenHelper.COURSE_TABLE_ID + "=" + uri.getLastPathSegment(), null,
                        null, null, DBOpenHelper.COURSE_TABLE_ID + "ASC" );
            case COURSE_NOTES:
                return db.query(DBOpenHelper.TABLE_COURSE_NOTES, DBOpenHelper.COURSE_NOTES_COLS, selection,
                        null, null, null, DBOpenHelper.COURSE_NOTES_COURSE_ID + "ASC");
            case ASSESSMENT:
                return db.query(DBOpenHelper.TABLE_ASSESSMENTS, DBOpenHelper.ASSESSMENT_COLS, selection, null,
                        null, null, DBOpenHelper.ASSESSMENTS_TABLE_ID);
            case ASSESSMENT_NOTES:
                return db.query(DBOpenHelper.TABLE_ASSESSMENT_NOTES, DBOpenHelper.ASSESSMENT_NOTES_COLS, selection,
                null, null, null, DBOpenHelper.ASSESSMENT_NOTES_TABLE_ID);
            case IMAGES:
                return db.query(DBOpenHelper.TABLE_IMAGES, DBOpenHelper.IMAGE_COLS, selection,
                        null, null, null, DBOpenHelper.IMAGE_TABLE_ID);
            default:
                throw new IllegalArgumentException("Unsupported uri: " + uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long id;
        switch (uriMatcher.match(uri)){
            case TERMS:
                id =  db.insert(DBOpenHelper.TABLE_TERMS, null, values);
                return uri.parse(TERMS_PATH + "/" + id);
            case COURSE:
                id = db.insert(DBOpenHelper.TABLE_COURSE, null, values);
                return uri.parse(COURSE_PATH + "/" + id);
            case COURSE_NOTES:
                id = db.insert(DBOpenHelper.TABLE_COURSE_NOTES, null, values);
                return uri.parse(COURSE_NOTES_PATH + "/" + id);
            case ASSESSMENT:
                id = db.insert(DBOpenHelper.TABLE_ASSESSMENTS, null, values);
                return  uri.parse(ASSESSMENT_PATH + "/" + id);
            case ASSESSMENT_NOTES:
                id = db.insert(DBOpenHelper.TABLE_ASSESSMENT_NOTES, null, values);
                return uri.parse(ASSESSMENT_NOTES_PATH + "/" + id);
            case IMAGES:
                id = db.insert(DBOpenHelper.TABLE_IMAGES, null, values);
                return uri.parse(IMAGES_PATH + "/" + id);
            default:
                throw new IllegalArgumentException("Unsupported uri: " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch(uriMatcher.match(uri)){
            case TERMS:
                return db.delete(DBOpenHelper.TABLE_TERMS, selection, selectionArgs);
            case COURSE:
                return db.delete(DBOpenHelper.TABLE_COURSE, selection, selectionArgs);
            case COURSE_NOTES:
                return db.delete(DBOpenHelper.TABLE_COURSE_NOTES, selection, selectionArgs);
            case ASSESSMENT:
                return db.delete(DBOpenHelper.TABLE_ASSESSMENTS, selection, selectionArgs);
            case ASSESSMENT_NOTES:
                return db.delete(DBOpenHelper.TABLE_ASSESSMENT_NOTES, selection, selectionArgs);
            case IMAGES:
                return db.delete(DBOpenHelper.TABLE_IMAGES, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Unsupported uri: " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch(uriMatcher.match(uri)){
            case TERMS:
                return db.update(DBOpenHelper.TABLE_TERMS, values, selection, selectionArgs);
            case COURSE:
                return db.update(DBOpenHelper.TABLE_COURSE, values, selection, selectionArgs);
            case COURSE_NOTES:
                return db.update(DBOpenHelper.TABLE_COURSE_NOTES, values, selection, selectionArgs);
            case ASSESSMENT:
                return db.update(DBOpenHelper.TABLE_ASSESSMENTS, values, selection, selectionArgs);
            case ASSESSMENT_NOTES:
                return db.update(DBOpenHelper.TABLE_ASSESSMENT_NOTES, values, selection, selectionArgs);
            case IMAGES:
                return db.update(DBOpenHelper.TABLE_IMAGES, values, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Unsupported uri: " + uri);
        }
    }
}
