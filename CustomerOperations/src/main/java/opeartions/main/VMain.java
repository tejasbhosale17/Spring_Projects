package opeartions.main;

import java.util.Scanner;

import opeartions.service.VehicleService;

public class VMain {

		public static int menu() {
			System.out.println("0.Exit");
			System.out.println("1.Fetch All vehicles");
			System.out.println("2.Fetch Specific vehicle");
			System.out.println("3.Delete vehicle");
			System.out.println("4.Update vehicle");
			System.out.println("5.Add vehicle");
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
					VehicleService.getAllVehicles();
				break;

			case 2:
				VehicleService.getSpecificVehicle();
				break;

			case 3:
				VehicleService.removeVehicle();
				break;

			case 4:
				VehicleService.updateVehicle();
				break;

			case 5:
				VehicleService.addVehicle();
				break;

				
			default:
				System.out.println("Wrong choice entered..:(");
				break;
			}
		}
	
	}

}