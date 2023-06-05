package customerMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cunstomerConnection.DBUtil;


public class customerCURD {
	private static Connection connection;
	static {
		try {
			connection = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				System.out.println("List of All Products");
				try {
					String sql="select * from customer";
					PreparedStatement ptmt = connection.prepareStatement(sql);
	
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
			break;

		case 2:
			System.out.println("Specific Customer");
			String q2 ="select * from customer where id= ? ;";
			try {
				PreparedStatement ptmt = connection.prepareStatement(q2);
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
			break;

		case 3:
			System.out.println("Deleted Customer!");
			String q3 ="delete from customer where id= ?";
			try {
				PreparedStatement pmt= connection.prepareStatement(q3);
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
			break;

		case 4:
				try {
					PreparedStatement updateProduct = connection.prepareStatement("UPDATE products SET price = ? WHERE id = ?");
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
			break;

		case 5:
			System.out.println("Added Customer!");
			String q5="insert into customer values( ? , ? , ? , ? , ? )";
			try {
				PreparedStatement pmt =connection.prepareStatement(q5);
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
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}

}