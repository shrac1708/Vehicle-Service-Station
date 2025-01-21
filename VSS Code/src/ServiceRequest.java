import java.util.ArrayList;
import java.util.List;

public class ServiceRequest {
    // Fields
    private String custName;
    private String vehNumber;
    private List<Service> servList;

    // Constructor
    public ServiceRequest(String custName, String vehNumber) {
        this.custName = custName;
        this.vehNumber = vehNumber;
        this.servList = new ArrayList<>();
    }

    // Add a service to the service list
    public void addItem(Service serv) {
        if (serv != null) {
            servList.add(serv);
        }
    }

    // Getter for customer name
    public String getCustName() {
        return custName;
    }

    // Setter for customer name
    public void setCustName(String custName) {
        this.custName = custName;
    }

    // Getter for vehicle number
    public String getVehNumber() {
        return vehNumber;
    }

    // Setter for vehicle number
    public void setVehNumber(String vehNumber) {
        this.vehNumber = vehNumber;
    }

    // Getter for service list
    public List<Service> getServList() {
        return servList;
    }

    // Calculate total service cost
    public double getServiceCost() {
        double totalCost = 0.0;
        for (Service serv : servList) {
            totalCost += serv.getCost(); // Assuming Service has a getCost() method
        }
        return totalCost;
    }

    // Print service request details
    public void printDetails() {
        System.out.println("Customer Name: " + custName);
        System.out.println("Vehicle Number: " + vehNumber);
        System.out.println("Services:");
        for (Service serv : servList) {
            serv.printDetails(); // Assuming Service has a printDetails() method
        }
        System.out.println("Total Service Cost: " + getServiceCost());
    }
}
