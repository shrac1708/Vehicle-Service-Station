public class Service {
    // Field
    private String desc;

    // Constructor
    public Service(String desc) {
        this.desc = desc;
    }

    // Default Constructor
    public Service() {
        this.desc = "";
    }

    // Getter for description
    public String getDesc() {
        return desc;
    }

    // Setter for description
    public void setDesc(String desc) {
        this.desc = desc;
    }

    // Get cost of the service (Assume a base implementation, can be overridden)
    public double getCost() {
        // Default cost implementation (could be replaced by a subclass override)
        return 100.0; // Example default cost
    }

    // Print details of the service
    public void printDetails() {
        System.out.println("Service Description: " + desc);
        System.out.println("Service Cost: " + getCost());
    }

    // Input method (can be used to set details of the service interactively)
    public void input() {
        // Placeholder for input logic, e.g., via Scanner
        // Example: Use Scanner to set the description
        System.out.println("Enter service description:");
        // Scanner sc = new Scanner(System.in);
        // this.desc = sc.nextLine();
    }

    // Display method (similar to printDetails, but as per naming convention)
    public void display() {
        printDetails();
    }
}
