package servicestation.code;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceStation serstation = new ServiceStation();
         
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add Customer");
            System.out.println("2. New Service Request");
            System.out.println("3. Display todays Business");
            System.out.println("4.Display give Dtae Business");
            System.out.println("5. Exit");
            
           
           
           int choice = sc.nextInt();
           
           sc.nextLine();  

            switch (choice) {
                case 1:
                	serstation.newCustomer();
                    break;

                case 2:
                	serstation.handleServiceRequest();
                    break;

                case 3:
                	serstation.DisplayTodaysBusiness();
                    break;
                    
                case 4:
                	
                	System.out.print("Enter Date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    serstation.displaytodaysbusiness(date);
                    break;
                case 5: 
                	System.out.print("Exiting the program.");
                	break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    
                    
            }
        }
    }

}
