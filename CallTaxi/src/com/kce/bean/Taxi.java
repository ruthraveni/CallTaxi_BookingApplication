package com.kce.bean;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    private int taxiId;
    private char currentLocation;
    private int freeTime;
    private int totalEarnings;
    private List<Booking> bookings;

    public Taxi(int taxiId) {

        this.taxiId = taxiId;          
        this.currentLocation = 'A';   
        this.freeTime = 0;           
        this.totalEarnings = 0;       
        this.bookings = new ArrayList<>();
    }

    public int getTaxiId() {
        return taxiId;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}