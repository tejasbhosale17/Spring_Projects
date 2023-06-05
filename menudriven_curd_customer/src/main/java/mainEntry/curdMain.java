package mainEntry;

import java.util.Scanner;

import customerMain.customerCURD;
import cvMain.CustVehicle_Main;
import partMain.part_main;
import vehicleMain.vehicle_main;

public class curdMain {

	private static customerCURD ccurd;
	private static CustVehicle_Main cvcurd;
	private static part_main pcurd;
	private static vehicle_main vcurd;
	static Scanner scan =new Scanner(System.in);
public static int menu() {
	System.out.println("0.Exit");
	System.out.println("1.Customer CURD");
	System.out.println("2.Customer Vehicle CURD");
	System.out.println("3.Part CURD");
	System.out.println("4.Vehicle CURD");
	System.out.print("Enter your choice = ");
	//return new Scanner(System.in).nextInt();
	int n=scan.nextInt();
	System.out.println("");
	return n;
}
public static void main(String[] args) {
	curdMain cmain =new curdMain();
	int choice;
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
			System.out.println("Its Customer Table");
			cmain.ccurd.main(args);;
			break;
			
		case 2:
			System.out.println("Its Customer Vehicle Table");
			cmain.cvcurd.main(args);
			break;
			
		case 3:
			System.out.println("Its Part Table");
			cmain.pcurd.main(args);
			break;
			
		case 4:
			System.out.println("Its Vehicle Table");
			cmain.vcurd.main(args);
			break;
			
		default:
			System.out.println("Wrong Choice!");
		}
	}

}

}
