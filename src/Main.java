public class Main {
    public static void main(String[] args){
        Property.fillPropertiesFromFile();
        Property.addRentalDays();
        Property.printAllProperties();
//        Property.calculateTotalIncome();
    }
}
