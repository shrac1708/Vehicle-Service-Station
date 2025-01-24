package servicestation.code;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;

public class Vehicle implements Serializable {
   
	private static final long serialVersionUID = 1L;
	private String vehicleId;
    private String vehicleType;
    private String number;
	private String company;
	private String model;
	
	public Vehicle() {
		
	}

    public Vehicle(String vehicleId, String vehicleType,String vehicleNumber, String company , String model) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.number = vehicleNumber;
        this.company = company;
		this.model = model;
    }

    

    public String getVehicleId() {
		return vehicleId;
	}



	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}



	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}

    public void input() {
    	Scanner sc = new Scanner(System.in);
    	 System.out.print("Enter Vehicle ID: ");
         this.vehicleId = sc.nextLine();
         System.out.print("Enter Vehicle Type: ");
          this.vehicleType = sc.nextLine();
         System.out.print("Enter Vehicle Number: ");
          this.number = sc.nextLine();
         System.out.print("Enter Vehicle Company: ");
          this.company = sc.nextLine();
         System.out.print("Enter Vehicle Model: ");
         this.model = sc.nextLine();
    }

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", number=" + number + ", company="
				+ company + ", model=" + model + "]";
	}

	
}

