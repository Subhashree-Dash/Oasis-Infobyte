package task1;

import java.util.Scanner;

public class Main {
		    public static void main(String[] args) {
	        ReservationSystem system = new ReservationSystem();
	        system.addUser(new User("admin", "admin123"));

	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to the Online Reservation System");

	        System.out.println("Enter User ID:");
	        String userId = scanner.nextLine();

	        System.out.println("Enter Password:");
	        String password = scanner.nextLine();

	        if (system.authenticate(userId, password)) {
	            System.out.println("Login successful!");

	            while (true) {
	                System.out.println("1. Make a Reservation");
	                System.out.println("2. Cancel a Reservation");
	                System.out.println("3. Exit");
	                System.out.println("Enter your choice:");
	                int choice = scanner.nextInt();
	                scanner.nextLine();  // Consume newline

	                if (choice == 1) {
	                    System.out.println("Enter PNR:");
	                    String pnr = scanner.nextLine();

	                    System.out.println("Enter Name:");
	                    String name = scanner.nextLine();

	                    System.out.println("Enter Train Number:");
	                    String trainNumber = scanner.nextLine();

	                    System.out.println("Enter Train Name:");
	                    String trainName = scanner.nextLine();

	                    System.out.println("Enter Class Type:");
	                    String classType = scanner.nextLine();

	                    System.out.println("Enter Date of Journey:");
	                    String dateOfJourney = scanner.nextLine();

	                    System.out.println("Enter From (Place):");
	                    String from = scanner.nextLine();

	                    System.out.println("Enter To (Destination):");
	                    String to = scanner.nextLine();

	                    system.makeReservation(pnr, name, trainNumber, trainName, classType, dateOfJourney, from, to);
	                } else if (choice == 2) {
	                    System.out.println("Enter PNR:");
	                    String pnr = scanner.nextLine();
	                    system.cancelReservation(pnr);
	                } else if (choice == 3) {
	                    System.out.println("Exiting...");
	                    break;
	                } else {
	                    System.out.println("Invalid choice. Please try again.");
	                }
	            }
	        } else {
	            System.out.println("Invalid login credentials. Access denied.");
	        }
	        scanner.close();
	    }
	}
