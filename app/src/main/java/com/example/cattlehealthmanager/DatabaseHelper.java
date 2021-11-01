package com.example.cattlehealthmanager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Initializing the variables
    private static final String DATABASE_NAME = "CattleHM";
    private static final int DATABASE_VERSION = 1;
    public static final String TAG = "DatabaseHelper";

    //columns for user table
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_UEMAIL = "user_email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CONFIRM_PASSWORD = "confirm_password";


    //columns for animal table
    public static final String TABLE_ANIMALS = "animals";
    public static final String COLUMN_TAG_NO = "tag_no";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_METHOD_OBTAINED = "method_obtained";
    public static final String COLUMN_DATE_OF_BIRTH = "DOB";
    public static final String COLUMN_FATHER_TAG = "father_tag";
    public static final String COLUMN_MOTHER_TAG = "mother_tag";

    //columns for vets table
    public static final String TABLE_VETS = "vets";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_CONTACT = "contact";
    public static final String COLUMN_EMAIL = "email";

    //SQL statement for creating users table
    private static final String SQL_CREATE_TABLE_USERS = "CREATE TABLE" + TABLE_USERS + "("
            +COLUMN_USERNAME + "VARCHAR PRIMARY KEY NOT NULL,"
            +COLUMN_UEMAIL + "VARCHAR NOT NULL"
            +COLUMN_PASSWORD + "VARCHAR NOT NULL,"
            +COLUMN_CONFIRM_PASSWORD + "VARCHAR NOT NULL"
            +");";

    //SQL statement for creating animals table
    private static final String SQL_CREATE_TABLE_ANIMALS = "CREATE TABLE" + TABLE_ANIMALS + "("
            +COLUMN_TAG_NO + "VARCHAR PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +COLUMN_CATEGORY + "TEXT NOT NULL,"
            +COLUMN_WEIGHT + "DOUBLE NOT NULL,"
            +COLUMN_GENDER + "BOOLEAN NOT NULL,"
            +COLUMN_METHOD_OBTAINED + "TEXT NOT NULL,"
            +COLUMN_DATE_OF_BIRTH + "DATE,"
            +COLUMN_FATHER_TAG + "VARCHAR,"
            +COLUMN_MOTHER_TAG + "VARCHAR"
            +");";

    //SQL statement for creating vets table
    private static final String SQL_CREATE_TABLE_VETS = "CREATE TABLE" + TABLE_VETS + "("
            +COLUMN_FIRST_NAME + "TEXT NOT NULL,"
            +COLUMN_LAST_NAME + "TEXT NOT NULL,"
            +COLUMN_LOCATION + "TEXT NOT NULL,"
            +COLUMN_CONTACT + "INT NOT NULL,"
            +COLUMN_EMAIL + "VARCHAR NOT NULL"
            +");";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_USERS);
        db.execSQL(SQL_CREATE_TABLE_ANIMALS);
        db.execSQL(SQL_CREATE_TABLE_VETS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading the database from version" + oldVersion + "to" + newVersion);
        //clears all data

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_VETS);

       //recreates the tables
       onCreate(db);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //the next methods are for user only
    public Boolean insertData(String username, String password) {
     SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = db.insert("USERS", null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean insertNewData(String usernamecreate, String email, String createpass, String confirmpass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usernamecreate", usernamecreate);
        contentValues.put("email", email);
        contentValues.put("createpass", createpass);
        contentValues.put("confirmpass", confirmpass);
        long result = db.insert("USERS", null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USERS where username = ?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepass(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USERS where username = ? and password = ?", new String[] {username, password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getData() {
    }
}
