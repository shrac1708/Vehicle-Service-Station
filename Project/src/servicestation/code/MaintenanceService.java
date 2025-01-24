package servicestation.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MaintenanceService extends Service  {

	
	private double laborcost;
	ArrayList<SparePart> parts = new ArrayList<>();
	
	Scanner sc = new Scanner (System.in);
	
	public MaintenanceService(){
		
	}
	
	public MaintenanceService( String Description , double laborcost) {
		super(Description);
		this.Description = Description;
		this.laborcost = laborcost;
		this.parts = parts;
	}
	
	public double getLaborcost() {
		return laborcost;
	}

	public void setLaborcost(double laborcost) {
		this.laborcost = laborcost;
	}

	public ArrayList<SparePart> getParts() {
		return parts;
	}

	public void setParts(ArrayList<SparePart> parts) {
		this.parts = parts;
	}
	
	public void add_part(SparePart newPart) {
		parts.add(newPart);
	}

	public void display() {
        System.out.println("Maintenance Service Description: " + Description );
        System.out.println("Labor Charges: " + laborcost);
        System.out.println("Parts Used:");
        for (SparePart part : parts) {
            part.display();
        }
    }
	
	
	public void input() {
		

		System.out.println("Enter maintainance Name: ");
		this.Description = sc.nextLine();
		sc.nextLine();
		
		System.out.println("enter the labor cost: ");
		this.laborcost=sc.nextDouble();
		
		SparePart part = new SparePart();
        part.input();
        parts.add(part);
	
	}
	
	
	@Override
	public double price() {
	    double totalPartsCost = 0.0;
	    for (SparePart part : parts) {
	        totalPartsCost += part.getRate();
	    }
	    return laborcost + totalPartsCost; // Add labor cost and parts cost
	}

	
	public void addpart() {
		SparePart part = new SparePart();
        part.input();
        parts.add(part);
	}
	
	

}
