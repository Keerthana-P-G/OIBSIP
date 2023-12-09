// ONLINE RESERVATION SYSTEM //


import java.util.*;

class Reservation {
    private String passengerName;
    private int trainNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String source;
    private String destination;
    private String reservationCode;

    public Reservation(String passengerName, int trainNumber, String classType, String journeyDate, String source, String destination) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = getTrainName(trainNumber);
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.source = source;
        this.destination = destination;
        this.reservationCode = generateReservationCode();
    }

    public String getReservationCode() {
        return reservationCode;
    }

    private String generateReservationCode() {
        return "RC" + (int) (Math.random() * 10000);
    }

    private String getTrainName(int trainNumber) {
        return "Train" + trainNumber;
    }

    @Override
    public String toString() {
        return "Reservation Details:\n" +
                "Reservation Code: " + reservationCode + "\n" +
                "Passenger Name: " + passengerName + "\n" +
                "Train Number: " + trainNumber + "\n" +
                "Train Name: " + trainName + "\n" +
                "Class: " + classType + "\n" +
                "Journey Date: " + journeyDate + "\n" +
                "Source: " + source + "\n" +
                "Destination: " + destination + "\n";
    }
}

class ReservationSystem {
    private ArrayList<Reservation> reservations;

    public ReservationSystem() {
        this.reservations = new ArrayList<>();
    }

    public void makeReservation(String passengerName, int trainNumber, String classType, String journeyDate, String source, String destination) {
        Reservation reservation = new Reservation(passengerName, trainNumber, classType, journeyDate, source, destination);
        reservations.add(reservation);
        System.out.println("Reservation successful! Your Reservation Code is: " + reservation.getReservationCode());
    }

    public void cancelReservation(String reservationCode) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationCode().equals(reservationCode)) {
                System.out.println(reservation);
                System.out.print("Are you sure you want to cancel? (Press 'OK' to confirm): ");
                Scanner scanner = new Scanner(System.in);
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("OK")) {
                    reservations.remove(reservation);
                    System.out.println("Cancellation successful!");
                } else {
                    System.out.println("Cancellation aborted.");
                }
                return;
            }
        }
        System.out.println("No reservation found with Reservation Code: " + reservationCode);
    }
}

public class OnlineReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        while (true) {
            System.out.println("\nOnline Reservation System Menu:");
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter train number: ");
                    int trainNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter class type: ");
                    String classType = scanner.nextLine();
                    System.out.print("Enter journey date: ");
                    String journeyDate = scanner.nextLine();
                    System.out.print("Enter source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();

                    reservationSystem.makeReservation(passengerName, trainNumber, classType, journeyDate, source, destination);
                    break;

                case 2:
                    System.out.print("Enter your Reservation Code for cancellation: ");
                    String reservationCode = scanner.nextLine();
                    reservationSystem.cancelReservation(reservationCode);
                    break;

                case 3:
                    System.out.println("Exiting Online Reservation System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

