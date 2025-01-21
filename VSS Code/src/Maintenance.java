import java.util.ArrayList;
import java.util.Scanner;

public class Maintenance  {

	private String name;
	private double laborcost;
	private String part;
	private double partcost;
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Maintenance> maintain = new ArrayList<>();
	
	Maintenance(){
		
	}
	
	Maintenance(String name , double laborcost , String part , double partcost){
		this.name = name;
		this.laborcost=laborcost;
		this.part=part;
		this.partcost=partcost;
	}
	
	
	public void Maintenance() {
		System.out.println("Enter Mintenance Name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Mintenance Labor Charges : ");
		double laborcost = sc.nextDouble();
		
		int ch;
		
		do {
			System.out.println("0. Mintenance Done ");
			System.out.println("1. Add new part ");
			
			 ch = sc.nextInt();
			
			switch(ch) {
			
			case 0:
				return;
			
			case 1:
				addNewPart();
				break;
			}
			
		}while(ch!=0);
		
		
	}

	private void addNewPart() {
		// TODO Auto-generated method stub
		System.out.println("Input part Description");
		String part = sc.nextLine();
		
		System.out.println("Input part Cost");
		double cost = sc.nextDouble();
		
		maintain.add(new Maintenance(name , laborcost , part , cost));
		
	}
}
