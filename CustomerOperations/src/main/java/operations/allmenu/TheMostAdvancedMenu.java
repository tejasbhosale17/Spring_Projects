package operations.allmenu;

import java.util.Scanner;




enum EmainMenu{
	EXIT,CUSTOMER,VEHICLE,SERVICE_REQUEST,PART,TODAYSBUSINESS,GIVEN_DATE_BUSINESS,DEFAULT     
}



public class TheMostAdvancedMenu {

	public static EmainMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Vehicle");
		System.out.println("3.Service Request");
		System.out.println("4.Parts");
		System.out.println("5.Today's Business");
		System.out.println("6.Given Date's Business");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>6 ? EmainMenu.values()[7] :EmainMenu.values()[choice]);
	}
	
public static void main(String[] args) {
	System.out.println("Choose The Department");

	EmainMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=EmainMenu.EXIT) {
		switch (choice) {
		case CUSTOMER:
				System.out.println("Customer");
				AllMenuTogether.ChooseCustomerMain();
			break;

		case VEHICLE:
				System.out.println("");
				AllMenuTogether.ChooseVehicleMain();
			break;

		case SERVICE_REQUEST:
				AllMenuTogether.ChooseCustomerVehicleMain();
				System.out.println("");
				AllMenuTogether.ChooseServiceMenu();
				AllMenuTogether.ChoosePaymentMenu();
			break;
			
		case PART:
				AllMenuTogether.ChoosePartMain();
				System.out.println("");
			break;
			
		case TODAYSBUSINESS:
				AllMenuTogether.TodaysBusiness();
				System.out.println("");
			break;
			
		case GIVEN_DATE_BUSINESS:
				AllMenuTogether.givenDateBusiness();
				System.out.println("");
			break;
		
		case DEFAULT:
				System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}


}
