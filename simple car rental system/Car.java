class Car {
  private int carId;
  private String carModel;
  private String carNumber;
  private int carPricePerDay;
  private Boolean isAvailable;

  public Car(int carId, String carModel, String carNumber, int carPricePerDay, Boolean isAvailable) {
      this.carId = carId;
      this.carModel = carModel;
      this.carNumber = carNumber;
      this.carPricePerDay = carPricePerDay;
      this.isAvailable = isAvailable;
  }

  public int getCarId() {
      return carId;
  }

  public String getCarModel() {
      return carModel;
  }

  public String getCarNumber() {
      return carNumber;
  }

  public int getCarPricePerDay() {
      return carPricePerDay;
  }

  public Boolean getAvailability() {
      return isAvailable;
  }

  public void setAvailability(Boolean isAvailable) {
      this.isAvailable = isAvailable;
  }
}
