package customerMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cunstomerConnection.DBUtil;


public class customerCURD {
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
//--------------------------------------------------------------------
	public static void showAllCustomer(Connection con) {
		System.out.println("List of All Products");
		try {
			String sql="select * from customer";
			PreparedStatement ptmt = con.prepareStatement(sql);

			try(ResultSet rs= ptmt.executeQuery()){
				while(rs.next()) {
					System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getLong("mobile")+" "+rs.getString("email")+" "+rs.getString("address"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("");
	}

//-----------------------------------------------------------------------

	public static void specificCustomer(Connection con) {
		System.out.println("Specific Customer");
		String q2 ="select * from customer where id= ? ;";
		try {
			PreparedStatement ptmt = con.prepareStatement(q2);
			System.out.println("enter id of the customer:");
			int num=scan.nextInt();
			ptmt.setInt(1, num);
			try{
				ResultSet rs =ptmt.executeQuery();
					while(rs.next()) {
						System.out.println(num+" "+rs.getString("name")+" "+rs.getLong("mobile")+" "+rs.getString("email")+" "+rs.getString("address"));
					}			
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("");
	}
//---------------------------------------------------------------------
	public static void removeCustomer(Connection con) {
		System.out.println("Deleted Customer!");
		String q3 ="delete from customer where id= ?";
		try {
			PreparedStatement pmt= con.prepareStatement(q3);
			int deln =scan.nextInt();
			pmt.setInt(1, deln);
			int row =pmt.executeUpdate();
			System.out.println("rows affected "+row);
			System.out.println("Delected Succesfully!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("");
	}
//--------------------------------------------------------------------
	public static void changeCustomer(Connection con) {
		try {
			PreparedStatement updateProduct = con.prepareStatement("UPDATE products SET price = ? WHERE id = ?");
			System.out.print("Enter the product id to update = ");
			int id = scan.nextInt();
			System.out.print("Enter the product price = ");
			double price = scan.nextDouble();
			updateProduct.setDouble(1, price);
			updateProduct.setInt(2, id);
			updateProduct.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("");
	}
//---------------------------------------------------------------------
	public static void addCustomer(Connection con) {
		System.out.println("Added Customer!");
		String q5="insert into customer values( ? , ? , ? , ? , ? )";
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			System.out.println("Enter id, name, mno,wmail,addr");
			pmt.setInt(1,scan.nextInt() );
			pmt.setString(2, scan.next());
			pmt.setLong(3, scan.nextLong());
			pmt.setString(4, scan.next());
			pmt.setString(5, scan.next());
			int insnum =pmt.executeUpdate();
			System.out.println("rows affected "+insnum);
			System.out.println("Insertion Succesful!");
		} catch (SQLException e) {
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
	
public static void main(String[] args) {
	customerCURD cust = new customerCURD();
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				cust.showAllCustomer(con);
			break;

		case 2:
				cust.specificCustomer(con);
			break;

		case 3:
				cust.removeCustomer(con);
			break;

		case 4:
				cust.changeCustomer(con);
			break;

		case 5:
				cust.addCustomer(con);
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}

}