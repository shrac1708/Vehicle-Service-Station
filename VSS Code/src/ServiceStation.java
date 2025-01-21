import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceStation {
    private List<Bill> billList;
    private List<Customer> custList;
    private String name;

    public ServiceStation(String name) {
        this.name = name;
        this.billList = new ArrayList<>();
        this.custList = new ArrayList<>();
    }

   
	public void storeCustomerDetails() {
        String filePath = "customer.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(custList);
            System.out.println("Customer details saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving customer details: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadCustomerDetails() {
        String filePath = "customer.txt";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            custList = (List<Customer>) ois.readObject();
            System.out.println("Customer details loaded from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading customer details: " + e.getMessage());
        }
    }

    
    public void storeBillDetails() {
        String filePath = "bill.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(billList);
            System.out.println("Bill details saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving bill details: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    public void loadBillDetails() {
        String filePath = "bill.txt";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            billList = (List<Bill>) ois.readObject();
            System.out.println("Bill details loaded from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading bill details: " + e.getMessage());
        }
    }

    public void newCustomer(String name) {
        if (findCustomer(name) == null) {
            Customer newCust = new Customer(name);
            custList.add(newCust);
            System.out.println("Customer " + name + " added successfully.");
        } else {
            System.out.println("Customer with the name '" + name + "' already exists.");
        }
    }

    public Customer findCustomer(String name) {
        for (Customer customer : custList) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}
