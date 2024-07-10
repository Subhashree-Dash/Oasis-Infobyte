package task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class User {
	  private String userId;
	    private String password;

	    public User(String userId, String password) {
	        this.userId = userId;
	        this.password = password;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public String getPassword() {
	        return password;
	    }
	}

	class Reservation {
	    private String pnr;
	    private String name;
	    private String trainNumber;
	    private String trainName;
	    private String classType;
	    private String dateOfJourney;
	    private String from;
	    private String to;

	    public Reservation(String pnr, String name, String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
	        this.pnr = pnr;
	        this.name = name;
	        this.trainNumber = trainNumber;
	        this.trainName = trainName;
	        this.classType = classType;
	        this.dateOfJourney = dateOfJourney;
	        this.from = from;
	        this.to = to;
	    }

	    public String getPnr() {
	        return pnr;
	    }

	    public void displayDetails() {
	        System.out.println("PNR: " + pnr);
	        System.out.println("Name: " + name);
	        System.out.println("Train Number: " + trainNumber);
	        System.out.println("Train Name: " + trainName);
	        System.out.println("Class Type: " + classType);
	        System.out.println("Date of Journey: " + dateOfJourney);
	        System.out.println("From: " + from);
	        System.out.println("To: " + to);
	    }
	}

	class ReservationSystem {
	    private List<User> users;
	    private List<Reservation> reservations;

	    public ReservationSystem() {
	        users = new ArrayList<>();
	        reservations = new ArrayList<>();
	    }

	    public void addUser(User user) {
	        users.add(user);
	    }

	    public boolean authenticate(String userId, String password) {
	        for (User user : users) {
	            if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public void makeReservation(String pnr, String name, String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
	        Reservation reservation = new Reservation(pnr, name, trainNumber, trainName, classType, dateOfJourney, from, to);
	        reservations.add(reservation);
	        System.out.println("Reservation made successfully!");
	    }

	    public void cancelReservation(String pnr) {
	        Reservation reservationToRemove = null;
	        for (Reservation reservation : reservations) {
	            if (reservation.getPnr().equals(pnr)) {
	                reservationToRemove = reservation;
	                break;
	            }
	        }
	        if (reservationToRemove != null) {
	            reservationToRemove.displayDetails();
	            System.out.println("Are you sure you want to cancel this reservation? (yes/no)");
	            try (Scanner scanner = new Scanner(System.in)) {
					String input = scanner.nextLine();
					if (input.equalsIgnoreCase("yes")) {
					    reservations.remove(reservationToRemove);
					    System.out.println("Reservation cancelled successfully!");
					} else {
					    System.out.println("Cancellation aborted.");
					}
				}
	        } else {
	            System.out.println("Reservation not found.");
	        }
	    }
	}

	
