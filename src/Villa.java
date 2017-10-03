import javax.swing.*;
import java.util.ArrayList;

public class Villa extends Property {
    private int roomServiceCostPerDay;
    private int luxuryTaxPerDay;
    private static ArrayList<Villa> villaArrayList = new ArrayList<Villa>();
    public final static int maxVillaCount = 3;


    public Villa(String startOwnersName, String startAddress,
                 int startCostPerDay, int startRoomServiceCostPerDay, int startLuxuryTaxPerDay, int startRentalDays){
        super(startOwnersName, startAddress, startCostPerDay, startRentalDays);
        roomServiceCostPerDay = startRoomServiceCostPerDay;
        luxuryTaxPerDay = startLuxuryTaxPerDay;
        villaArrayList.add(this);
    }

    public void setLuxuryTaxPerDay(int luxuryTaxPerDay) {
        this.luxuryTaxPerDay = luxuryTaxPerDay;
    }

    public void setRoomServiceCostPerDay(int roomServiceCostPerDay) {
        this.roomServiceCostPerDay = roomServiceCostPerDay;
    }

    public int getLuxuryTaxPerDay() {
        return luxuryTaxPerDay;
    }

    public int getRoomServiceCostPerDay() {
        return roomServiceCostPerDay;
    }

    public static ArrayList<Villa> getVillaArrayList() {
        return villaArrayList;
    }

//    public static void fillProperties(){
//        int villaCount = 0;
//        while(villaCount < maxVillaCount){
//            String ownerName = JOptionPane.showInputDialog(null, "Villa owner's name");
//            String propertyAddress = JOptionPane.showInputDialog(null, "Villa address");
//            int propertyCost;
//            int luxuryTax;
//            int roomService;
//            try {
//                propertyCost = Integer.parseInt(JOptionPane.showInputDialog(null, "Cost per day"));
//                luxuryTax = Integer.parseInt(JOptionPane.showInputDialog(null, "Luxury tax"));
//                roomService = Integer.parseInt(JOptionPane.showInputDialog(null, "Room service fee per day"));
//            }
//            catch (NumberFormatException e){
//                JOptionPane.showMessageDialog(null, "Invalid entry: not an integer!");
//                continue;
//            }
//            Villa created = new Villa(ownerName, propertyAddress, propertyCost, luxuryTax, roomService);
//            villaCount = villaArrayList.size();
//            JOptionPane.showMessageDialog(null, "Property added with registration number " + created.getRegistrationNumber());
//
//        }
//    }

    @Override
    public int getIncome() {
        return super.getIncome() - ((this.luxuryTaxPerDay + this.roomServiceCostPerDay) * this.getRentalDays());
    }

    @Override
    public String toString() {
        return super.toString() + "\nProperty Type: Villa"  + "\nLuxury tax per day: " + this.luxuryTaxPerDay + "\nRoom service cost per day: " + this.roomServiceCostPerDay;
    }
}
