import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Booking {
    private int bookingId;
    private User user;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalCost;
    private LocalDateTime bookingTime;
    private String bookingStatus;

    // Constructor
    public Booking(int bookingId, User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = calculateBookingPrice();
        this.bookingTime = LocalDateTime.now();
        this.bookingStatus = "PENDING"; // default status
    }

    // Method to calculate booking price
    public int calculateBookingPrice() {
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return (int) daysBetween * car.getCarPricePerDay();
    }

    // Method to create booking
    public void createBooking() {
        if (car.getAvailability()) {
            this.bookingStatus = "CONFIRMED";
            car.setAvailability(false); // Mark car as unavailable
            user.addCarBooked(car); // Add car to user's booked list
            System.out.println("Booking confirmed!");
        } else {
            System.out.println("Car is not available.");
        }
    }

    // Method to cancel booking
    public void cancelBooking() {
        if ("CONFIRMED".equals(this.bookingStatus)) {
            this.bookingStatus = "CANCELLED";
            car.setAvailability(true); // Mark car as available
            user.removeCarBooked(car); // Remove car from user's booked list
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Cannot cancel a booking that is not confirmed.");
        }
    }

    // Getters and Setters for private attributes
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
