package com.example.macstudent.carparkingsystem.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by macstudent on 2018-04-19.
 */

@Dao
public interface AddTicketDao
{
    @Query("Select * from AddTicket")
    public List<AddTicket> getAllAddTicket();

    @Insert(onConflict = REPLACE)
    public void insertNewAddTicket(AddTicket addTicket);

}
