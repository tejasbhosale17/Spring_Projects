package opeartions.main;

import java.util.Scanner;


public class Main {
	private static CMain cmain;
	private static PMain pmain;
	private static VMain vmain;
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Part");
		System.out.println("3.Vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void main(String[] args) {
	Main m =new Main();
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				m.cmain.main(args);
			break;

		case 2:
				m.pmain.main(args);
			break;

		case 3:
				m.vmain.main(args);
			break;
			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
