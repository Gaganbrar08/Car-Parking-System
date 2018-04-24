package com.example.macstudent.carparkingsystem.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by macstudent on 2018-04-18.
 */


public class DBHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME  = "dbCollege";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String userTable = "CREATE TABLE " + DBUser.TABLE_USER
                + "(" + DBUser.KEY_USER_EMAIL + " TEXT PRIMARY KEY, "
                + DBUser.KEY_USER_PASSWORD + " TEXT )";

        db.execSQL(userTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE " + DBUser.TABLE_USER);

        onCreate(db);
    }



}