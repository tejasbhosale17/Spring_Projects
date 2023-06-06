package opeartions.main;

import java.util.Scanner;

import opeartions.service.CustomerService;

public class CMain {
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Customers");
		System.out.println("2.Fetch Specific Customer");
		System.out.println("3.Delete Customer");
		System.out.println("4.Update Customer");
		System.out.println("5.Add Customer");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void main(String[] args) {
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				CustomerService.getAllCustomers();
			break;

		case 2:
			CustomerService.getSpecificCustomer();
			break;

		case 3:
			CustomerService.removeCustomer();
			break;

		case 4:
			CustomerService.updateCustomer();
			break;

		case 5:
			CustomerService.addCustomer();
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
