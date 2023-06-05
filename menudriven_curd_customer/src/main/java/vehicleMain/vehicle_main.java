package vehicleMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cunstomerConnection.DBUtil;




public class vehicle_main {

		private static Connection con;
		static Scanner scan = new Scanner(System.in);
		static {
			try {
				con = DBUtil.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//----------------------------------------------------------
public static void showallVehicles(Connection con) {
	String q1="select * from vehicle";
	try {
		PreparedStatement pmt =con.prepareStatement(q1);
		ResultSet rs = pmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("vid")+" "+rs.getString("company")+" "+rs.getString("model"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}
//-------------------------------------------------------

public static void specificVehicle(Connection con) {
	String q2= "Select * from vehicle where vid=?";
	try {
		PreparedStatement pmt= con.prepareStatement(q2);
		System.out.println("Enter vehicle id:");
		int vid=scan.nextInt();
		pmt.setInt(1, vid);
		ResultSet rs= pmt.executeQuery();
		while(rs.next()) {
			System.out.println(vid+" "+rs.getString("company") +" "+rs.getString("model"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	System.out.println("");
}
//-----------------------------------------------------------

public static void addVehicle(Connection con) {
	String q3 ="insert into vehicle values(?,?,?)";
	try {
		PreparedStatement pmt =con.prepareStatement(q3);
		System.out.println("Enter vehicle id, company, model respectively");
		pmt.setInt(1, scan.nextInt());
		pmt.setString(2, scan.next());
		pmt.setString(3, scan.next());
		int nva = pmt.executeUpdate();
		System.out.println(nva+" Vehicle added!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	System.out.println("");
}
//-------------------------------------------------------------
public static void removeVehicle(Connection con) {
	String q4= "delete from vehicle where vid=?";
	try {
		PreparedStatement pmt= con.prepareStatement(q4);
		System.out.println("Enter vid to remove vehicle");
		int id= scan.nextInt();
		pmt.setInt(1, id);
		int nvr=pmt.executeUpdate();
		System.out.println(nvr+" Vehicle Removed!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	System.out.println("");
}
//---------------------------------------------------------------

public static void chageVehicle(Connection con) {
	String q5="update vehicle set model=? where vid=?";
	try {
		PreparedStatement pmt =con.prepareStatement(q5);
		System.out.println("Enter vid of vehicle to change and model:");
		int id=scan.nextInt();
		pmt.setInt(2, id);
		pmt.setString(1, scan.next());
		int nvc =pmt.executeUpdate();
		System.out.println(nvc+" Vehicle Updated with id:"+id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}
		
public static int menu() {
	System.out.println("0.Exit");
	System.out.println("1.Fetch All Products");
	System.out.println("2.Fetch Specific Product");
	System.out.println("3.Delete Product");
	System.out.println("4.Update Product");
	System.out.println("5.Add product");
	System.out.print("Enter your choice = ");
	System.out.println("");
	return new Scanner(System.in).nextInt();
}		
//-----------------------------------------------------------------------------		
public static void main(String[] args) {
	
	vehicle_main vm= new vehicle_main();
	int choice;
	
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
			vm.showallVehicles(con);
			break;
			
		case 2:
			vm.specificVehicle(con);
			break;
			
		case 3:
			vm.removeVehicle(con);
			break;
			
		case 4:
			vm.chageVehicle(con);
			break;
			
		case 5:
			vm.addVehicle(con);
			break;
			
		default:
			System.out.println("Wrong Choice!");
		}
	}
}
		
}
