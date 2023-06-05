package cvMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cunstomerConnection.DBUtil;




public class CustVehicle_Main {
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
//-------------------------------------------------------------
public static void showall(Connection con) {
	String q1="select * from customer_vehicle";
	try {
		PreparedStatement pmt =con.prepareStatement(q1);
		ResultSet rs= pmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("vehicle_number")+" "+rs.getInt("customer_id")+" "+rs.getInt("vehicle_id"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	
//-------------------------------------------------------------------------
public static void soecificVehicle(Connection con) {
	String q2="select * from customer_vehicle where customer_id=?";
	try {
		PreparedStatement pmt =con.prepareStatement(q2);
		System.out.println("enter cust_id:");
		int id=scan.nextInt();
		pmt.setInt(1, id);
		ResultSet rs =pmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("vehicle_number")+" "+id+" "+rs.getInt("vehicle_id"));
		}
			} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}
//--------------------------------------------------------------------------------------------------

public static void removeCustV(Connection con) {
	String q3="delete from customer_vehicle where vehicle_id=?";
	try {
		PreparedStatement pmt= con.prepareStatement(q3);
		int vid=scan.nextInt();
		pmt.setInt(1, vid);
		int nvr=pmt.executeUpdate();
		System.out.println(nvr+" Vehicle removed with id:"+vid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}
//-------------------------------------------------------------------------
public static void changeCVRecord(Connection con) {
	String q4="update customer_vehicle set vehicle_number=? where vehicle_id=?";
	try {
		PreparedStatement pmt= con.prepareStatement(q4);
		System.out.println("Enter vid and vnumber:");
		int vid=scan.nextInt();
		pmt.setInt(2, vid);
		pmt.setString(1, scan.next());
		int nrc=pmt.executeUpdate();
		System.out.println(nrc+" Record Updated with id:"+vid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
	
}
//----------------------------------------------------------------------
public static void addRecord(Connection con) {
	String q5="insert into customer_vehicle values(?,?,?)";
	try {
		PreparedStatement pmt =con.prepareStatement(q5);
		pmt.setString(1, scan.next());
		pmt.setInt(2, scan.nextInt());
		pmt.setInt(3, scan.nextInt());
		int nra =pmt.executeUpdate();
		System.out.println(nra+" Records added!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}


public static int menu() {
	System.out.println("0.Exit");
	System.out.println("1.Fetch All Parts");
	System.out.println("2.Fetch Specific Part");
	System.out.println("3.Delete Part");
	System.out.println("4.Update Part");
	System.out.println("5.Add Part");
	System.out.print("Enter your choice = ");
	System.out.println("");
	return new Scanner(System.in).nextInt();
}		
//-----------------------------------------------------------------------------		
public static void main(String[] args) {
	
	CustVehicle_Main cvm= new CustVehicle_Main();
	int choice;
	
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
			cvm.showall(con);
			break;
			
		case 2:
			cvm.soecificVehicle(con);
			break;
			
		case 3:
			cvm.removeCustV(con);
			break;
			
		case 4:
			cvm.changeCVRecord(con);
			break;
			
		case 5:
			cvm.addRecord(con);
			break;
			
		default:
			System.out.println("Wrong Choice!");
		}
	}
}

}
