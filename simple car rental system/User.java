import java.util.ArrayList;

class User {
    private String name;
    private String emailId;
    private String phoneNum;
    private ArrayList<Car> carsBooked;

    User(String name, String emailId, String phoneNum) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNum = phoneNum;
        this.carsBooked = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public ArrayList<Car> getCarsBooked() {
        return carsBooked;
    }

    public void addCarBooked(Car car) {
        this.carsBooked.add(car);
    }

    public void removeCarBooked(Car car) {
        this.carsBooked.remove(car);
    }
}
