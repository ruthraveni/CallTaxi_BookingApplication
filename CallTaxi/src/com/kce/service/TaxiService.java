package com.kce.service;

import com.kce.bean.*;
import java.util.ArrayList;
import java.util.List;

public class TaxiService {

    private List<Taxi> taxiList = new ArrayList<>();
    private int bookingId = 1;

    public TaxiService(int taxiCount) {

        for (int i = 1; i <= taxiCount; i++) {
            taxiList.add(new Taxi(i));
        }
    }
    public void bookTaxi(int customerId, char pickup, char drop, int pickupTime) {

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxiList) {
            if (taxi.getFreeTime() <= pickupTime) {

                int distance = Math.abs(taxi.getCurrentLocation() - pickup);
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedTaxi = taxi;
                }
                else if (distance == minDistance &&
                         taxi.getTotalEarnings() < selectedTaxi.getTotalEarnings()) {

                    selectedTaxi = taxi;
                }
            }
        }
        if (selectedTaxi == null) {
            System.out.println("No Taxi Available. Booking Rejected.");
            return;
        }

        int pointDistance = Math.abs(pickup - drop);
        int totalKm = pointDistance * 15;

        int amount;
        if (totalKm <= 5) {
            amount = 100;
        } else {
            amount = 100 + (totalKm - 5) * 10;
        }

        int dropTime = pickupTime + pointDistance;
        Booking booking = new Booking(
                bookingId++, customerId,  pickup,  drop,   pickupTime,  dropTime,amount     
        );

        selectedTaxi.getBookings().add(booking);
        selectedTaxi.setCurrentLocation(drop);
        selectedTaxi.setFreeTime(dropTime);
        selectedTaxi.setTotalEarnings(
                selectedTaxi.getTotalEarnings() + amount
        );

        System.out.println("Taxi-" + selectedTaxi.getTaxiId() + " is allotted.");
    }

    public void displayTaxiDetails() {

        for (Taxi taxi : taxiList) {

            System.out.println("\nTaxi-" + taxi.getTaxiId());
            System.out.println("Total Earnings: Rs. " + taxi.getTotalEarnings());

            if (taxi.getBookings().isEmpty()) {
                System.out.println("No Bookings");
            } else {

                System.out.println("BookingID  CustomerID  From  To  Pickup  Drop  Amount");

                for (Booking b : taxi.getBookings()) {

                    System.out.println(
                            b.getBookingId() + "   " + b.getCustomerId() + "  " +
                            b.getFrom() + " " +  b.getTo() + "   " +
                            b.getPickupTime() + " " +   b.getDropTime() + "  " +  b.getAmount()
                    );
                }
            } }}}