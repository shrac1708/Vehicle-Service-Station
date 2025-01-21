import java.io.Serializable;

public class Bill implements Serializable{
    // Fields
    private double amount;
    private double paidAmount;
    private ServiceRequest req;

    // Constructor
    public Bill(ServiceRequest req) {
        this.req = req;
        this.amount = computeAmount();
    }

    // Method to compute the amount (base amount from service request)
    public double computeAmount() {
        if (req != null) {
            return req.getServiceCost(); // Assuming ServiceRequest has getServiceCost()
        }
        return 0.0;
    }

    // Method to compute tax (e.g., 10% of amount)
    public double computeTax() {
        return amount * 0.1; // 10% tax
    }

    // Method to compute total bill (amount + tax)
    public double computeTotalBill() {
        return amount + computeTax();
    }

    // Getter for paidAmount
    public double getPaidAmount() {
        return paidAmount;
    }

    // Setter for paidAmount
    public void setPaidAmount(double amount) {
        this.paidAmount = amount;
    }

    // Method to print bill details
    public void print() {
        System.out.println("Service Request Details:");
        if (req != null) {
            req.printDetails(); // Assuming ServiceRequest has a printDetails() method
        }
        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + computeTax());
        System.out.println("Total Bill: " + computeTotalBill());
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Balance Due: " + (computeTotalBill() - paidAmount));
    }
}
