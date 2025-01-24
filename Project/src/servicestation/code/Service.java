package servicestation.code;

import java.util.Scanner;

abstract class Service {
	
	public  String Description;
	

	public Service(){
		super();
	}
	
	public Service(String description) {
		super();
		Description = Description;
	}
	
	

	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = Description;
	}

	
	
	public void display() {
		System.out.println("description: " +getDescription());
	}
	
	
	public abstract void input();
	
	
	public abstract double price();
	
}
