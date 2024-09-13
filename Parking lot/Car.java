import java.util.*;

public class Car{
  String carModel;
  String carNumber;

  Car(String carModel, String carNumber){
    this.carModel = carModel;
    this.carNumber = carNumber;
  }

}



public class Parking{
  int parkingSpaceAvailable;
  int parkingSpaceTotal;

  HashMap <Integer, Integer> parkingLots = new HashMap<>();

  Parking(int parkingSpaceTotal){
    this.parkingSpaceAvailable = parkingSpaceTotal;
    this.parkingSpaceTotal = parkingSpaceTotal;
    for(int i = 0; i < parkingSpaceTotal; i++){
      parkingLots.put(i, 0);
    }
  }

  Boolean isParkingLotAvailable(int id) {
    int available = parkingLots.get(id);
    if(available == 0) return true;
    else return false;
  }
  
}


public class ParkingLot {
  public static void main(String[] args) {
    Parking parking = new Parking(5);
  }
}
