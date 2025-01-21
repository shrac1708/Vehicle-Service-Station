import java.io.*;
import java.util.*;

public class Program {
    private static final String FILE_PATH = "customer.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<String, Customer> customerMap = loadCustomersFromFile();
         Service Service = new Service();
         
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add Customer");
            System.out.println("2. Find Customer by Name and Display Vehicles");
           
           
           int choice = sc.nextInt();
           String customername;
     	   String address;
     	   String name;
     	   int mobile1;
           sc.nextLine();  

            switch (choice) {
                case 1:
                    // Add Customer
                    System.out.print("Enter Customer ID: ");
                    String customerId = sc.nextLine();
                    System.out.println("Enter name: ");
         		 
         		    name = sc.next();
         		   
         		    System.out.println("Enter address: ");
         		 
         		    address = sc.next();
         		    System.out.println("Enter mobile: ");
         		    mobile1 = sc.nextInt();

                    Customer customer = new Customer(customerId, name , address , mobile1);
                    customerMap.put(customerId, customer);
                    System.out.println(customerMap.toString());
                    saveCustomersToFile(customerMap);
                    System.out.println("Customer added: " + customer);  
                    break;

                case 2:
                    // Find Customer by Name and Display Vehicles
                    System.out.print("Enter Customer Name to search: ");
                    String customerNameSearch = sc.nextLine();

                    Customer foundCustomerByName = null;
                    for (Customer c : customerMap.values()) {
                        if (c.getName().equalsIgnoreCase(customerNameSearch)) {
                            foundCustomerByName = c;
                            break;
                        }
                    }

                    if (foundCustomerByName != null) {
                        System.out.println("Customer found: " + foundCustomerByName);
                        System.out.println("Vehicles:");
                        HashMap<String, Vehicle> vehicles = foundCustomerByName.getVehicleList();
                        if (vehicles.isEmpty()) {
                            System.out.println("No vehicles found for this customer.");
                        } else {
                            for (Vehicle v : vehicles.values()) {
                                System.out.println(v);
                                Service.display();
                            }
                        }

                        
                        System.out.print("Do you want to add a new vehicle? (yes/no): ");
                        String response = sc.nextLine();
                        if (response.equalsIgnoreCase("yes")) {
                            System.out.print("Enter Vehicle ID: ");
                            String vehicleId = sc.nextLine();
                            System.out.print("Enter Vehicle Type: ");
                            String vehicleType = sc.nextLine();
                            System.out.print("Enter Vehicle Number: ");
                            String vehicleNumber = sc.nextLine();
                            System.out.print("Enter Vehicle Company: ");
                            String vehicleCompany = sc.nextLine();
                            System.out.print("Enter Vehicle Model: ");
                            String vehicleModel = sc.nextLine();

                            Vehicle newVehicle = new Vehicle( vehicleId,  vehicleType, vehicleNumber,  vehicleCompany ,  vehicleModel);
                            foundCustomerByName.addVehicle(newVehicle);
                            saveCustomersToFile(customerMap);
                            System.out.println("Vehicle added to customer: " + foundCustomerByName);
                            Service.display();
                        }
                        
                       
                        
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static Map<String, Customer> loadCustomersFromFile() {
        Map<String, Customer> customerMap = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            customerMap = (Map<String, Customer>) ois.readObject();
            
            System.out.println("Loaded customers from file: " + customerMap); 
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing customer data found, starting fresh.");
        }
        return customerMap;
    }

    private static void saveCustomersToFile(Map<String, Customer> customerMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(customerMap);
            System.out.println("Customers saved to file: " + customerMap); 
        } catch (IOException e) {
            System.out.println("Error saving customer data.");
        }
    }
}
