package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.CustVehicleDao;
import operations.dao.VehicleDao;
import operations.models.Customer_vehicles;
import operations.models.Vehicle;

public class CustVService {
	static Scanner scan = new Scanner(System.in);
	static CustVehicleDao custvehicleDao;
	
	
	public static void getAllCustVehicles() {
		List<Customer_vehicles> CVList = new ArrayList<>();
		try {
			custvehicleDao = new CustVehicleDao();
			custvehicleDao.getAllVehicles(CVList);
			for(Customer_vehicles v: CVList) {
				System.out.println(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public static void findThisVehicle() {
		System.out.println("Enter Vehicle Number to check if we have it here:");
		String vnumber=scan.next();
		try {
			custvehicleDao = new CustVehicleDao();
			Customer_vehicles CV= new Customer_vehicles();
			CV=custvehicleDao.searchThisVehicle(vnumber);
			if(CV!=null) {
				System.out.println("Vehicle Details are here...");
				System.out.println(CV);
			}else {
				System.out.println("Vehicle Does not Exists!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

	public static void removeCustVehicle() {
		// TODO Auto-generated method stub
		
	}

	public static void updateCustVehicle() {
		// TODO Auto-generated method stub
		
	}

	public static void addCustVehicle(int customer_id, int vehicle_id) {
			try {
				custvehicleDao = new CustVehicleDao();
				System.out.println("enter vehicle number");
				
				int isAdded=custvehicleDao.addThisCVehicle(scan.next(),customer_id, vehicle_id);
				if(isAdded !=0) {
					System.out.println(isAdded+" Vehicle Inserted Succesfully!");
				}else {
					System.out.println("Vehicle Does not Exists...");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		
	}


}
