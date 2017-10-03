import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle implements RentalItems{
    private int registrationNumber;
    private String ownersName;
    private int costPerDay;
    private int rentalDays;
    private static ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();

    public Vehicle(String ownersName, int costPerDay, int rentalDays) {
        this.ownersName = ownersName;
        this.costPerDay = costPerDay;
        this.rentalDays = rentalDays;
        vehicleArrayList.add(this);
        this.registrationNumber = vehicleArrayList.size();
    }

    @Override
    public void RentalItems(int rentalDays){
        this.setRentalDays(rentalDays + this.rentalDays - 1);
    }

    @Override
    public String toString() {
        return "\nVehicle Registration Number: " + this.registrationNumber + "\nOwner: " + this.ownersName + "\nCost per day: " + this.costPerDay + "\nDays rented: " + this.rentalDays;
    }

    public int getIncome () {
        return this.costPerDay * this.rentalDays;
    }


    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnerName() {
        return ownersName;
    }

    public void setOwnerName(String ownerName) {
        this.ownersName = ownerName;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public static ArrayList<Vehicle> getVehicleArrayList() {
        return vehicleArrayList;
    }

    public static void setVehicleArrayList(ArrayList<Vehicle> vehicleArrayList) {
        Vehicle.vehicleArrayList = vehicleArrayList;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public static String calculateTotalIncome() {
        int totalIncome = 0;
        for (Vehicle vehicle : Vehicle.getVehicleArrayList()){
            totalIncome += vehicle.getIncome();
        }
        return "\nTOTAL INCOME\n€" + totalIncome;
    }

    public static void fillVehiclesFromFile(){
        String root = System.getProperty("user.dir");
        String fileName = root + "/files/InputVehicles";
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
                    Car created = new Car(word[4], Integer.parseInt(word[1]), Integer.parseInt(word[3]), Integer.parseInt(word[2]));
                }
                else if(word[0].equals("2")){
                    Truck created = new Truck(word[4], Integer.parseInt(word[1]), Integer.parseInt(word[3]), Integer.parseInt(word[2]));
                }
                else{
                    System.out.println("Error on line " + lineCount + ". Invalid vehicle type.");
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
            myPanel.add(new JLabel("Vehicle Registration No.:"));
            myPanel.add(xField);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Days:"));
            myPanel.add(yField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please enter a vehicle registration number and days to add for booking " + bookingNumber, JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    int regNum = Integer.parseInt(xField.getText());
                    int daysAdded = Integer.parseInt(yField.getText());
                    boolean noneFound = true;
                    for(Vehicle vehicle : vehicleArrayList){
                        if (regNum == vehicle.registrationNumber){
                            vehicle.RentalItems(daysAdded);
                            bookingNumber++;
                            noneFound = false;
                            break;
                        }
                    }
                    if(noneFound) {
                        JOptionPane.showMessageDialog(null, "No vehichle found with registration number. Please try again");
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
        String outputFileName = root + "/files/OutputVehicles";
        try {
            PrintWriter printOut = new PrintWriter(outputFileName);
            String output = "" + dateTime;
            for (Vehicle vehicle : vehicleArrayList) {
                output += vehicle + "\n";
            }
            output += Vehicle.calculateTotalIncome() + "\n---------END----------";
            printOut.print(output);
            printOut.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage() + " error found while printing.");
        }
    }



}
