package admin;

import java.util.Scanner;

import opeartions.service.CustomerService;
import opeartions.service.VehicleService;

public class adminsWork {
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Customers");
		System.out.println("2.Fetch Specific Customer");
		System.out.println("3.Delete Customer");
		System.out.println("4.Update Customer");
		System.out.println("5.Add Customer & vehicle Details:");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void CustomerMain() {
	System.out.println("Choose Customer Operations");
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				CustomerService.getAllCustomers();
				System.out.println("");
			break;

		case 2:
				CustomerService.getSpecificCustomer();
				System.out.println("");
			break;

		case 3:
				CustomerService.removeCustomer();
				System.out.println("");
			break;

		case 4:
				CustomerService.updateCustomer();
				System.out.println("");
			break;

		case 5:
				System.out.println("Add Customer Details:");
				CustomerService.addCustomer();
				System.out.println("Add vehicle Details:");
//				VehicleService.addVehicle();
//				System.out.println("Enter Vehicle Number:");
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
