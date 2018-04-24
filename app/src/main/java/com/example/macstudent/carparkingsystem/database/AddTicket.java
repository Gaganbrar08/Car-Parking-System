package com.example.macstudent.carparkingsystem.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by macstudent on 2018-04-19.
 */


    @Entity(tableName = "AddTicket")
    public class AddTicket {

        @PrimaryKey(autoGenerate = true)
        public int id;
        @ColumnInfo(name = "date")
        public String date;
        @ColumnInfo(name = "amount")
        public String amount;
        @ColumnInfo(name = "vehicleNo")
        public String vehicleNo;
        @ColumnInfo(name = "vehicleBrand")
        public String vehicleBrand;
        @ColumnInfo(name = "colour")
        public String colour;
        @ColumnInfo(name = "timing")
        public String timing;
        @ColumnInfo(name = "lane")
        public String lane;
        @ColumnInfo(name = "position")
        public String position;
        @ColumnInfo(name = "payment")
        public String payment;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getVehicleNo() {
            return vehicleNo;
        }

        public void setVehicleNo(String vehicleNo) {
            this.vehicleNo = vehicleNo;
        }

        public String getVehicleBrand() {
            return vehicleBrand;
        }

        public void setVehicleBrand(String vehicleBrand) {
            this.vehicleBrand = vehicleBrand;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public String getTiming() {
            return timing;
        }

        public void setTiming(String timing) {
            this.timing = timing;
        }

        public String getLane() {
            return lane;
        }

        public void setLane(String lane) {
            this.lane = lane;
        }

        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }



        @Override
        public String toString() {
            return "AddTicket{" +
                    "id=" + id +
                    ", date='" + date + '\'' +
                    ", amount='" + amount + '\'' +
                    ", vehicleNo='" + vehicleNo + '\'' +
                    ", vehicleBrand='" + vehicleBrand + '\'' +
                    ", colour='" + colour + '\'' +
                    ", timing='" + timing + '\'' +
                    ", lane='" + lane + '\'' +
                    ", position='" + position + '\'' +
                    ", payment='" + payment + '\'' +
                    '}';
        }



    }

