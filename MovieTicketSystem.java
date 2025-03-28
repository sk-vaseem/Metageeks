import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketSystem {
    public static void main(String[] args) {
        ArrayList<Integer> bookedSeats = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovie Ticket Booking System");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Cancel a Ticket");
            System.out.println("3. View Booked Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Book a ticket
                    System.out.print("Enter seat number to book: ");
                    int seatToBook = scanner.nextInt();
                    if (bookedSeats.contains(seatToBook)) {
                        System.out.println("Seat already booked!");
                    } else {
                        bookedSeats.add(seatToBook);
                        System.out.println("Seat " + seatToBook + " booked successfully!");
                    }
                    break;

                case 2: // Cancel a ticket
                    System.out.print("Enter seat number to cancel: ");
                    int seatToCancel = scanner.nextInt();
                    if (bookedSeats.remove(Integer.valueOf(seatToCancel))) {
                        System.out.println("Seat " + seatToCancel + " canceled successfully!");
                    } else {
                        System.out.println("Seat not found!");
                    }
                    break;

                case 3: // View booked tickets
                    System.out.println("Booked seats: " + bookedSeats);
                    break;

                case 4: // Exit
                    System.out.println("Exiting the system. Have a great day!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
