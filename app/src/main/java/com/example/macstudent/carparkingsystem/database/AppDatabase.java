package com.example.macstudent.carparkingsystem.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by macstudent on 2018-04-19.
 */
@Database(entities = {AddTicket.class}, version = 1)
public abstract class AppDatabase  extends RoomDatabase {

    private static AppDatabase appDatabase;
    // public abstract StudentDao student();
    public abstract AddTicketDao addTicket();
    private Context context;

    public  static  AppDatabase getInstance(Context context)
    {
        if(appDatabase == null)
        {

            appDatabase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"AddTicket-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }



}
