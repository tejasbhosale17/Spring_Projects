package opeartions.Menu;

import java.util.Scanner;



public class MainMenu {
	private static CMenu cmain;
	private static PMenu pmain;
	private static VMenu vmain;
	private static CVMenu cvmain;
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Part");
		System.out.println("3.Vehicle");
		System.out.println("4.Customer Vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void TheMainMenu() {
	System.out.println("Choose The Department");
	MainMenu m =new MainMenu();
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				m.cmain.CustomerMain();
				System.out.println("");
			break;

		case 2:
				m.pmain.PartMain();
				System.out.println("");
			break;

		case 3:
				m.vmain.VehicleMain();
				System.out.println("");
			break;
			
		case 4:
			m.cvmain.CustVehicleMain();
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
