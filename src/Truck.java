import java.util.ArrayList;

public class Truck extends Vehicle {
    private int cargoWeight;
    private static ArrayList<Truck> truckArrayList = new ArrayList<Truck>();

    public Truck(String ownersName, int costPerDay, int rentalDays, int cargoWeight) {
        super(ownersName, costPerDay, rentalDays);
        this.cargoWeight = cargoWeight;
        truckArrayList.add(this);
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public static ArrayList<Truck> getTruckArrayList() {
        return truckArrayList;
    }

    public static void setTruckArrayList(ArrayList<Truck> truckArrayList) {
        Truck.truckArrayList = truckArrayList;
    }

    @Override
    public int getIncome(){
        return super.getIncome() + (this.cargoWeight * this.getRentalDays());
    }

    @Override
    public String toString(){
        return super.toString() + "\nVehicle Type: Truck\nCargo Weight: " + this.cargoWeight;
    }
}
