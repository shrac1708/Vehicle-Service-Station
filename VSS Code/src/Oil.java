

import java.util.ArrayList;
import java.util.Scanner;

public class Oil {

	private String name;
	private String cost;
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Oil> oil = new ArrayList<>();
	
	Oil(){
		
	}
	
	
	Oil(String name, String cost){
		this.name = name;
		this.cost = cost;
	}
	
	public void oilService() {
		      
		 int ch;
		do {
		 ch = sc.nextInt();
		
		    
		    	 sc.nextLine();
		    	System.out.println("Enter Oil/Additive Name : ");
				String Name = sc.nextLine();
						
				
				System.out.println("Enter Oil/Additive Cost : ");
				String Cost =sc.nextLine();
				
				System.out.println("Enter 0 FOR eXIT ");
				oil.add(new Oil(Name , Cost));
		     
		     }while(ch!=0);
		
			
			
			
			
		}
				
	}
	

