package servicestation.code;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {

	 private static final long serialVersionUID = 1L; 
	 
    private double amount;
    private double paidAmount;
    private double tax;
    private double totalBillAmount;
    private double remainingAmount;
    private ServiceRequest request;
    private LocalDate date;

    // Constructor
    public Bill(ServiceRequest request) {
        this.request = request;
        this.date = LocalDate.now();
    }

    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    
    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    public void setRequest(ServiceRequest request) {
        this.request = request;
    }

    
    public void calculateBill() {
        this.amount = request.calculateTotal();
        this.tax = amount * 0.18; 
        this.totalBillAmount = amount + tax;
    }

    public void calculateRemainingAmount(double paidAmount) {
        this.paidAmount = paidAmount;
        this.remainingAmount = totalBillAmount - paidAmount;
    }

    // Print Full Bill Details
    public void printBill() {
        System.out.println("\n--------- Detailed Bill ---------");
        System.out.println("Date:"+ date);
        System.out.println("Customer Name: " + request.getCust_name());
        System.out.println("Vehicle Details: " + request.getVehicle());
        System.out.println("Services Rendered:");

        for (Service service : request.getLinkservice()) {
            if (service instanceof OilService) {
                OilService oilService = (OilService) service;
                System.out.println("- Oil Servicing:");
                System.out.println("  Oil Description: " + oilService.getDescription());
                System.out.println("  Price: " + oilService.price());
            } else if (service instanceof MaintenanceService) {
            	MaintenanceService maintenanceService = (MaintenanceService) service;
                System.out.println("- Maintenance Servicing:");
                System.out.println("  Labor Cost: " + maintenanceService.getLaborcost());
                System.out.println("  Parts Used:");
                for (SparePart part : maintenanceService.getParts()) {
                    System.out.println("    Part Name: " + part.getDescription());
                    System.out.println("    Rate: " + part.getRate());
                }
                System.out.println("  Total Maintenance Cost: " + maintenanceService.price());
            }
        }

        System.out.println("---------------------------------");
        System.out.println("Total Amount (Excluding Tax): " + amount);
        System.out.println("Tax (18%): " + tax);
        System.out.println("Total Amount (Including Tax): " + totalBillAmount);
        System.out.println("Amount Paid by Customer: " + paidAmount);
        System.out.println("Remaining Amount: " + remainingAmount);
        System.out.println("---------------------------------");
    }
}
