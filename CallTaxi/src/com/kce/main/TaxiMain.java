package com.kce.main;

import java.util.Scanner;

import com.kce.service.TaxiService;

public class TaxiMain {

		public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        TaxiService service = new TaxiService(4);

	        while (true) {

	            System.out.println("\n1. Book Taxi");
	            System.out.println("2. Display Taxi Details");
	            System.out.println("3. Exit");
	            System.out.print("Enter choice: ");

	            int choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    System.out.print("Customer ID: ");
	                    int id = sc.nextInt();

	                    System.out.print("Pickup Point (A-F): ");
	                    char pickup = sc.next().charAt(0);

	                    System.out.print("Drop Point (A-F): ");
	                    char drop = sc.next().charAt(0);

	                    System.out.print("Pickup Time: ");
	                    int time = sc.nextInt();

	                    service.bookTaxi(id, pickup, drop, time);
	                    break;

	                case 2:
	                    service.displayTaxiDetails();
	                    break;

	                case 3:
	                    System.exit(0);
	            }
	        }
	    }
	}


