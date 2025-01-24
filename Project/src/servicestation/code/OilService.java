package servicestation.code;

import java.util.ArrayList;
import java.util.Scanner;

public  class OilService extends Service {
	
	private double cost;
	
	Scanner sc = new Scanner(System.in);
	
	
	OilService(){
		
	}
	
	public OilService(String Description , double cost) {
		super(Description);
		this.Description = Description;
		this.cost = cost;
	}
	
	
	
    public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void display() {
		super.display();
    	System.out.println("price : " + cost);
    }

	@Override
	public double price() {
		return cost;
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		System.out.println("enter the Description :");
		this.Description = sc.nextLine();
		System.out.println("enter the price :");
		this.cost = sc.nextDouble();
	}
	

    
}
	

