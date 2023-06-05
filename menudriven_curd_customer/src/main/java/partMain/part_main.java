package partMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cunstomerConnection.DBUtil;




public class part_main {
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
//----------------------------------------------------------------	
public static void showParts(Connection con) {
	String q1="select * from part";
	try {
		System.out.println("List of All parts");
		PreparedStatement pmt =con.prepareStatement(q1);
		ResultSet rs= pmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("pid")+" "+rs.getString("pname")+" "+rs.getString("description")+" "+rs.getDouble("price"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}
//---------------------------------------------------------------------

public static void specificPart(Connection con) {
	String q2="select * from part where pid=?";
	
	try {
		PreparedStatement pmt =con.prepareStatement(q2);
		System.out.println("Enter id of the part");
		int id=scan.nextInt();
		pmt.setInt(1, id);
		ResultSet rs = pmt.executeQuery();
		while(rs.next()) {
			System.out.println(id+" "+rs.getString("pname")+" "+rs.getString("description")+" "+rs.getDouble("price"));
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
} 
//--------------------------------------------------------------------
public static void removePart(Connection con) {
	String q3="delete from part where pid=?";
	try {
		PreparedStatement pmt =con.prepareStatement(q3);
		System.out.println("enter id of art to remove");
		int id=scan.nextInt();
		pmt.setInt(1, id);
		int npr=pmt.executeUpdate();
		System.out.println(npr+" Part Removed with id:"+id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}
//---------------------------------------------------------------------------
public static void changePart(Connection con) {
	String q4="update part set price=? where pid=?";
	try {
		PreparedStatement pmt = con.prepareStatement(q4);
		System.out.println("Enter pid and price to change");
		int id=scan.nextInt();
		pmt.setInt(2, id);
		pmt.setDouble(1, scan.nextDouble());
		int npu=pmt.executeUpdate();
		System.out.println(npu+" Parts Changed with id:"+id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("");
}
//------------------------------------------------------------------------------

public static void addPart(Connection con) {
	String q5="insert into part (pid,pname,description,price) values(?,?,?,?)";
	try {
		PreparedStatement pmt = con.prepareStatement(q5);
		System.out.println("enter pid,pname,description,price respectively:");
		pmt.setInt(1, scan.nextInt());
		pmt.setString(2, scan.next());
		scan.nextLine();
		pmt.setString(3,scan.nextLine());
		pmt.setDouble(4, scan.nextDouble());
		int npa=pmt.executeUpdate();
		System.out.println(npa+" Part Added!");
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
	
	part_main pm= new part_main();
	int choice;
	
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
			pm.showParts(con);
			break;
			
		case 2:
			pm.specificPart(con);
			break;
			
		case 3:
			pm.removePart(con);
			break;
			
		case 4:
			pm.changePart(con);
			break;
			
		case 5:
			pm.addPart(con);
			break;
			
		default:
			System.out.println("Wrong Choice!");
		}
	}
}
}
