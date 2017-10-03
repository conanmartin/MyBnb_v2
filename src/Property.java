import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;


public class Property implements RentalItems {
    private int registrationNumber;
    private String ownersName;
    private String address;
    private int costPerDay;
    private int rentalDays;
    private static ArrayList<Property> propertyArrayList = new ArrayList<Property>();

    public Property(String startOwnersName,
                                 String startAddress, int startCostPerDay, int startRentalDays){
        ownersName = startOwnersName;
        address = startAddress;
        costPerDay = startCostPerDay;
        rentalDays = startRentalDays;
        propertyArrayList.add(this);
        registrationNumber = propertyArrayList.size();
    }

    public void setRegistationNumber(int newRegistrationNumber){
        this.registrationNumber = newRegistrationNumber;
    }

    public void setOwnersName(String newOwnersName){
        this.ownersName = newOwnersName;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    public void setCostPerDay(int newCostPerDay){
        this.costPerDay = newCostPerDay;
    }

    public void setRentalDays(int newRentalDays){
        this.rentalDays = newRentalDays;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public String getAddress() {
        return address;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public static ArrayList<Property> getPropertyArrayList() {
        return propertyArrayList;
    }

    @Override
    public void RentalItems(int rentalDays) {
        this.setRentalDays(rentalDays + this.rentalDays);
    }

    public static void fillPropertiesFromFile(){
        String root = System.getProperty("user.dir");
        String fileName = root + "/files/InputProperties";
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner fileScanner = new Scanner(fileReader);
            String line;
            int lineCount = 0;
            while (fileScanner.hasNext()) {
                lineCount++;
                line = fileScanner.nextLine();

                String[] word = line.split(" ");
                if(word[0].equals("1")){
                    Apartment created = new Apartment(word[5], word[6], Integer.parseInt(word[3]), Integer.parseInt(word[1]), Integer.parseInt(word[2]), Integer.parseInt(word[4]));
                }
                else if(word[0].equals("2")){
                    House created = new House(word[5], word[6], Integer.parseInt(word[3]), Integer.parseInt(word[1]), Integer.parseInt(word[2]), Integer.parseInt(word[4]));
                }
                else if(word[0].equals("3")){
                    Villa created = new Villa(word[6], word[7], Integer.parseInt(word[4]), Integer.parseInt(word[3]), Integer.parseInt(word[2]), Integer.parseInt(word[5]));
                }
                else{
                    System.out.println("Error on line " + lineCount + ". Invalid property type.");
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Exception: " + e.getMessage() + " caught.");
        }
    }

    public static void addRentalDays(){
        int bookingNumber = 1;
        boolean keepGoing = true;
        while(keepGoing){
//            https://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
            JTextField xField = new JTextField(5);
            JTextField yField = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Property Registration No.:"));
            myPanel.add(xField);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Days:"));
            myPanel.add(yField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please enter a property registration number and days to add for booking " + bookingNumber, JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    int regNum = Integer.parseInt(xField.getText());
                    int daysAdded = Integer.parseInt(yField.getText());
//                    System.out.println(regNum);
//                    System.out.println(daysAdded);
                    boolean noneFound = true;
                    for(Property property : propertyArrayList){
                        if (regNum == property.registrationNumber){
                            property.RentalItems(daysAdded);
                            bookingNumber++;
                            noneFound = false;
                            break;
                        }
                    }
                    if(noneFound) {
                        JOptionPane.showMessageDialog(null, "No property found with registration number. Please try again");
                    }
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Non number used, booking not added. Please try again");
                    continue;
                }
            }
            else if (result == JOptionPane.CANCEL_OPTION){
                keepGoing = false;
            }
        }
    }


    public static void printAllProperties() {
        ZonedDateTime dateTime = ZonedDateTime.now();
        String root = System.getProperty("user.dir");
        String outputFileName = root + "/files/OutputProperties";
        try {
            PrintWriter printOut = new PrintWriter(outputFileName);
            String output = "" + dateTime;
            for (Property property : propertyArrayList) {
                output += property + "\n";
            }
            output += Property.calculateTotalIncome() + "\n---------END----------";
            printOut.print(output);
            printOut.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage() + " error found while printing.");
        }
    }

    public static String calculateTotalIncome() {
        int totalIncome = 0;
        for (Property property : Property.getPropertyArrayList()){
            totalIncome += property.getIncome();
        }
        return "\nTOTAL INCOME\n€" + totalIncome;
    }

    public int getIncome () {
        return this.costPerDay * this.rentalDays;
    }

    @Override
    public String toString() {
        return "\nProperty Registration Number: " + this.registrationNumber + "\nOwner: " + this.ownersName + "\nAddress: " + this.address + "\nCost per day: " + this.costPerDay + "\nDays rented: " + this.rentalDays;
    }
}
