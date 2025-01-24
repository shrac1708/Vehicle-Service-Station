package servicestation.code;
	
	import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ServiceStation {

    private static final String FILE_PATH = "customers.txt";
    private static final String billFilePath = "bills.txt";
    	

    private String name;
    private Vehicle vehicle;
    private List<Bill> billList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private Map<String, Customer> customerMap = loadCustomersFromFile();
    private Scanner sc = new Scanner(System.in);

    // Constructors
    public ServiceStation() {
        super();
    }

    public ServiceStation(String name) {
        super();
        this.name = name;
    }

    // Getters and Setters
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Customer Operations
    public void displayCustomerList() {
        for (Customer customer : customerMap.values()) {
            System.out.println(customer);
        }
    }

    public void findCustomer(String name) {
        boolean found = false;
        for (Customer customer : customerMap.values()) {
            if (customer.getName().equalsIgnoreCase(name)) {
                System.out.println(customer);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Customer not found.");
        }
    }

    public void newCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter mobile: ");
        int mobile = sc.nextInt();
        sc.nextLine(); // Consume newline

        Customer customer = new Customer(customerId, name, address, mobile);
        customerMap.put(customerId, customer);
        saveCustomersToFile(customerMap);
        System.out.println("Customer added: " + customer);
    }

    // Service Request Handling
    public void handleServiceRequest() {
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

            Vehicle selectedVehicle = null;

            if (vehicles.isEmpty()) {
                System.out.println("No vehicles found for this customer.");
                System.out.print("Do you want to add a new vehicle? (yes/no): ");
                String response = sc.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    selectedVehicle = addNewVehicleToCustomer(foundCustomerByName);
                } else {
                    System.out.println("Cannot proceed without a vehicle.");
                    return;
                }
            } else {
                System.out.println("Select a vehicle by ID:");
                for (Vehicle v : vehicles.values()) {
                    System.out.println(v);
                }
                System.out.print("Enter Vehicle ID to select: ");
                String vehicleId = sc.nextLine();

                selectedVehicle = vehicles.get(vehicleId);
                if (selectedVehicle == null) {
                    System.out.println("Invalid Vehicle ID. Adding a new vehicle.");
                    selectedVehicle = addNewVehicleToCustomer(foundCustomerByName);
                }
            }

            // Create a Service Request
            processServiceRequest(foundCustomerByName, selectedVehicle);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private Vehicle addNewVehicleToCustomer(Customer customer) {
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

        Vehicle newVehicle = new Vehicle(vehicleId, vehicleType, vehicleNumber, vehicleCompany, vehicleModel);
        customer.addVehicle(newVehicle);
        saveCustomersToFile(customerMap);
        System.out.println("Vehicle added to customer: " + customer.getName());
        return newVehicle;
    }


    private void processServiceRequest(Customer customer, Vehicle selectedVehicle) {
        ServiceRequest request = new ServiceRequest(customer.getName(), selectedVehicle);

        while (true) {
            System.out.println("\n--- Service Menu ---");
            System.out.println("0. Servicing Done");
            System.out.println("1. Oil Servicing");
            System.out.println("2. Maintenance Servicing");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    completeServicing(request);
                    return;
                case 1:
                    OilService oilService = new OilService();
                    oilService.input();
                    request.add_item(oilService);
                    break;
                case 2:
                    processMaintenanceServicing(request);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private void completeServicing(ServiceRequest request) {
        System.out.println("Servicing completed.");
        request.displayRequest();

        Bill bill = new Bill(request);
        bill.calculateBill(); 
        
        System.out.println("Generating detailed bill...");
        bill.printBill(); 

       
        System.out.print("Enter amount paid by customer: ");
        double paidAmount = sc.nextDouble();
        sc.nextLine(); 

        bill.calculateRemainingAmount(paidAmount); 
        
        billList.add(bill); 
        System.out.println("Thank you! The payment has been processed.");
        if (bill.getRemainingAmount() > 0) {
            System.out.println("Remaining Amount: " + bill.getRemainingAmount());
        } else {
            System.out.println("No outstanding balance.");
        }
    }



    private void processMaintenanceServicing(ServiceRequest request) {
    	MaintenanceService maintenance = new MaintenanceService();
        maintenance.input();

        while (true) {
            System.out.println("0. Maintenance Done");
            System.out.println("1. Add New Part");
            System.out.print("Enter your choice: ");
            int maintenanceChoice = sc.nextInt();
            sc.nextLine();

            if (maintenanceChoice == 0) {
                System.out.println("Maintenance completed.");
                break;
            } else if (maintenanceChoice == 1) {
                maintenance.addpart();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        request.add_item(maintenance);
    }

    
    public void DisplayTodaysBusiness() {
    	LocalDate today = LocalDate.now();
    	displaytodaysbusiness(today);
    }
    
    public  void displaytodaysbusiness(LocalDate date) {
		// TODO Auto-generated method stub
    	  System.out.println("Bills for " + date + ":");
    	    boolean found = false;

    	    for (Bill bill : billList) {
    	        if (bill.getDate().equals(date)) {
    	            bill.printBill();
    	            found = true;
    	        }
    	    }

    	    if (!found) {
    	        System.out.println("No bills found for the given date.");
    	    }
	}

	// File Operations
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
    
    
    public void storeBillDetails() throws Exception {
		FileOutputStream fout = null;
		ObjectOutputStream oout = null;
		try {
			fout = new FileOutputStream(billFilePath);
			oout = new ObjectOutputStream(fout);
			oout.writeObject(billList);
			oout.flush();
		} catch (Exception e) {
			throw new Exception("Billing Store Failed", e);
		} finally {
			try {
				if (oout != null)
					oout.close();
				if (fout != null)
					fout.close();
			} catch (Exception e2) {
			}
		}
	}
	public void loadBillDetails() throws Exception {
		FileInputStream fin = null;
		ObjectInputStream oin = null;
		try {
			fin = new FileInputStream(billFilePath);
			oin = new ObjectInputStream(fin);
			billList = (ArrayList<Bill>) oin.readObject();
		} catch(FileNotFoundException e) {
			System.out.println("Bill File Not Found.");
			System.out.println("Bill List will be Empty.");
			return;
		} catch (Exception e) {
			throw new Exception("Billing Load Failed", e);
		} finally {
			try {
				if (oin != null)
					oin.close();
				if (fin != null)
					fin.close();
			} catch (Exception e2) {
			}
		}
		
	}
	
}


	

