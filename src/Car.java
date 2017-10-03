import java.util.ArrayList;

public class Car extends Vehicle {
    private int passengerNumber;
    private static ArrayList<Car> carArrayList = new ArrayList<Car>();


    public Car(String ownersName, int costPerDay, int rentalDays, int passengerNumber) {
        super(ownersName, costPerDay, rentalDays);
        this.passengerNumber = passengerNumber;
        carArrayList.add(this);
    }

    public static ArrayList<Car> getCarArrayListArrayList() {
        return carArrayList;
    }

    public static void setCarArrayListArrayList(ArrayList<Car> carArrayListArrayList) {
        Car.carArrayList = carArrayListArrayList;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    @Override
    public String toString(){
        return super.toString() + "\nVehicle Type: Car\nNumber of Passengers: " + this.passengerNumber;
    }
}
