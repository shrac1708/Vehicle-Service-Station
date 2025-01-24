package servicestation.code;

import java.util.LinkedList;
import java.util.Scanner;

public class ServiceRequest {
   
	private String cust_name;
	private Vehicle vehicle;
	   
	LinkedList<Service> linkservice = new LinkedList<>();
      
	public ServiceRequest(String cust_name, Vehicle vehicle ) {
		
		super();
		         
		this.cust_name = cust_name;
		this.vehicle = vehicle;
		this.linkservice = linkservice;
		
	}
       
	public String getCust_name() {
		return cust_name;
	}
     
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
     
	
      
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LinkedList<Service> getLinkservice() {
		return linkservice;
	}
     
	public void setLinkservice(LinkedList<Service> linkservice) {
		this.linkservice = linkservice;
	}
	
	public void add_item(Service servicing) {
		linkservice.add(servicing);
		 
	}
	
	public double calculateTotal() {
	    double totalCost = 0.0;
	    for (Service service : linkservice) {
	        totalCost += service.price(); // Add the cost of each service
	    }
	    return totalCost;
	}

	
	public void displayRequest() {
        System.out.println("Customer Name: " + cust_name);
        System.out.println("Vehicle Details: " + vehicle); 
     
        if (linkservice.isEmpty()) {
            System.out.println("No services added yet.");
        } else {
            for (Service service : linkservice) {
                System.out.println(service.getDescription());
            }
        }

        System.out.println("\nTotal Cost of Services: " + calculateTotal());
    }
	
	
	
	 
	
	
	
	
}
