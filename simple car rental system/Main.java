import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create Users
        User user1 = new User("John Doe", "john.doe@example.com", "123-456-7890");
        User user2 = new User("Jane Smith", "jane.smith@example.com", "098-765-4321");

        // Create Cars
        Car car1 = new Car(1, "Toyota Corolla", "ABC123", 50, true);
        Car car2 = new Car(2, "Honda Civic", "XYZ789", 60, true);

        // Create Bookings
        Booking booking1 = new Booking(1, user1, car1, LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15));
        Booking booking2 = new Booking(2, user2, car2, LocalDate.of(2024, 9, 20), LocalDate.of(2024, 9, 25));
        Booking booking3 = new Booking(3, user2, car1, LocalDate.of(2024, 9, 18), LocalDate.of(2024, 9, 25));

        // Test Creating Bookings
        booking1.createBooking();
        booking2.createBooking();

        // Output Current Status
        System.out.println("Booking 1 Status: " + booking1.getBookingStatus());
        System.out.println("Booking 2 Status: " + booking2.getBookingStatus());

        // Test Canceling a Booking
        booking1.createBooking();
        System.out.println("Booking 1 Status: " + booking1.getBookingStatus());
        booking1.cancelBooking();

        System.out.println("Booking 1 Status after cancellation: " + booking1.getBookingStatus());

        // Output User and Car Information
        System.out.println("User 1 Cars Booked: " + user1.getCarsBooked().size());
        System.out.println("Car 1 Availability: " + car1.getAvailability());
    }
}
