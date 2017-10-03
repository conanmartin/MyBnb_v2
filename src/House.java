import javax.swing.*;
import java.util.ArrayList;


public class House extends Property {
    private int numberOfStories;
    private int cleaningFees;
    private static ArrayList<House> houseArrayList = new ArrayList<House>();
    public final static int maxHouseCount = 3;


    public House(String startOwnersName, String startAddress,
                 int startCostPerDay, int startNumberOfStories, int startCleaningFees, int startRentalDays){
        super(startOwnersName, startAddress, startCostPerDay, startRentalDays);
        numberOfStories = startNumberOfStories;
        cleaningFees = startCleaningFees;
        houseArrayList.add(this);
    }

    public void setCleaningFees(int newCleaningFees) {
        this.cleaningFees = newCleaningFees;
    }

    public void setNumberOfStories(int newNumberOfStories) {
        this.numberOfStories = newNumberOfStories;
    }

    public int getCleaningFees() {
        return cleaningFees;
    }

    public int getNumberOfStories() {
        return numberOfStories;
    }

    public static ArrayList<House> getHouseArrayList() {
        return houseArrayList;
    }

//    public static void fillProperties(){
//        int houseCount = 0;
//        while (houseCount < maxHouseCount) {
//            String ownerName = JOptionPane.showInputDialog(null, "House owner's name");
//            String propertyAddress = JOptionPane.showInputDialog(null, "House address");
//            int propertyCost;
//            int numberOfStories;
//            int cleaningFee;
//            try {
//                propertyCost = Integer.parseInt(JOptionPane.showInputDialog(null, "Cost per day"));
//                numberOfStories = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of stories"));
//                cleaningFee = Integer.parseInt(JOptionPane.showInputDialog(null, "Cleaning fee"));
//            }
//            catch (NumberFormatException e){
//                JOptionPane.showMessageDialog(null, "Invalid entry: not an integer!");
//                continue;
//            }
//            House created = new House(ownerName, propertyAddress, propertyCost, numberOfStories, cleaningFee);
//            houseCount = houseArrayList.size();
//            JOptionPane.showMessageDialog(null, "Property added with registration number " + created.getRegistrationNumber());
//
//        }
//    }

    @Override
    public int getIncome() {
        return super.getIncome() - (this.cleaningFees * this.getRentalDays());
    }

    @Override
    public String toString() {
        return super.toString() + "\nProperty Type: House"  + "\nNumber of stories: " + this.numberOfStories + "\nCleaning fee: " + this.cleaningFees;
    }
}


