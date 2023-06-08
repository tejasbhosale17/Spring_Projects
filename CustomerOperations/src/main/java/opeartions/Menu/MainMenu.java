package opeartions.Menu;

import java.util.Scanner;

enum EmainMenu{
	EXIT,CUSTOMER,PART,VEHICLE
}


public class MainMenu {
	private static CMenu cmain;
	private static PMenu pmain;
	private static VMenu vmain;
	private static CVMenu cvmain;
	public static EmainMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Part");
		System.out.println("3.Vehicle");
		System.out.println("4.Customer Vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return EmainMenu.values()[choice];
	}

	
public static void TheMainMenu() {

	System.out.println("Choose The Department");
	MainMenu m =new MainMenu();
	EmainMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=EmainMenu.EXIT) {
		switch (choice) {
		
		case CUSTOMER:
				m.cmain.CustomerMain();
				System.out.println("");
			break;

		case PART:
				m.pmain.PartMain();
				System.out.println("");
			break;

		case VEHICLE:
				m.vmain.VehicleMain();
				System.out.println("");
			break;

		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
public static void main(String[] args) {
	TheMainMenu();
}



}
