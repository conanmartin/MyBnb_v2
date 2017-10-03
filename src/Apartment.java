import javax.swing.*;
import java.util.ArrayList;


public class Apartment extends Property {
    private int storyNumber;
    private int numberOfBeds;
    private static ArrayList<Apartment> apartmentArrayList = new ArrayList<Apartment>();
    public final static int maxApartmentCount = 3;

    public Apartment(String startOwnersName, String startAddress,
                     int startCostPerDay, int startStoryNumber, int startNumberOfBeds, int startRentalDays){
        super(startOwnersName, startAddress, startCostPerDay, startRentalDays);
        storyNumber = startStoryNumber;
        numberOfBeds = startNumberOfBeds;
        apartmentArrayList.add(this);
    }

    public void setStoryNumber(int newStoryNumber){
        this.storyNumber = newStoryNumber;
    }

    public void setNumberOfBeds(int newNumberOfBeds){
        this.numberOfBeds = newNumberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getStoryNumber() {
        return storyNumber;
    }

    public static ArrayList<Apartment> getApartmentArrayList() {
        return apartmentArrayList;
    }

//    public static void fillProperties(){
//        int apartmentCount = 0;
//        while (apartmentCount < maxApartmentCount) {
//            String apartmentOwnerName = JOptionPane.showInputDialog(null, "Apartment owner's name");
//            String apartmentPropertyAddress = JOptionPane.showInputDialog(null, "Apartment address");
//            int apartmentPropertyCost;
//            int storyNumber;
//            int numberOfBeds;
//            try {
//                apartmentPropertyCost = Integer.parseInt(JOptionPane.showInputDialog(null, "Cost per day"));
//                storyNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Story number"));
//                numberOfBeds = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of beds"));
//            }
//            catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Invalid entry: not an integer!");
//                continue;
//            }
//
//            Apartment created = new Apartment(apartmentOwnerName, apartmentPropertyAddress, apartmentPropertyCost, storyNumber, numberOfBeds);
//            apartmentCount = apartmentArrayList.size();
//            JOptionPane.showMessageDialog(null, "Property added with registration number " + created.getRegistrationNumber());
//
//        }
//
//    }

    @Override
    public int getIncome () {
        return super.getIncome();
    }

    @Override
    public String toString() {
        return super.toString() + "\nProperty Type: Apartment" + "\nStory number: " + this.storyNumber + "\nNumber of beds: " + this.numberOfBeds;
    }
}
