package servicestation.code;

import java.util.Scanner;

public class SparePart {

	private String Description;
	private double rate;
	
	public  SparePart() {
		
	}
	
	public SparePart(String description, double rate) {
		super();
		this.Description = description;
		this.rate = rate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public void input() {
		    Scanner sc = new Scanner(System.in);
	        System.out.print("Enter part description: ");
	        this.Description = sc.nextLine();
	        System.out.print("Enter part rate: ");
	        this.rate = sc.nextDouble();
	}
	
	 public void display() {
	        System.out.println("Part Description: " + Description );
	        System.out.println("Part Rate: " + rate);
	    }

	
	
	
	
	
	
}
