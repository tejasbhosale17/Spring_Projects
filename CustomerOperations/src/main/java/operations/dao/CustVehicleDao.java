package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Customer_vehicles;
import operations.models.Vehicle;

public class CustVehicleDao {

	static Connection con;
	
	public CustVehicleDao() throws SQLException{
		this.con=DBUtil.getConnection();
	}
	
	
	
	public void getAllVehicles(List<Customer_vehicles> CVList) {
		String q1="select * from customer_vehicles";
		try {
			PreparedStatement pmt= con.prepareStatement(q1);
			ResultSet rs= pmt.executeQuery();
			while(rs.next()) {
				Customer_vehicles v =new Customer_vehicles(rs.getString("vehicle_number"), rs.getInt("customer_id"), rs.getInt("vehicle_id"));
				CVList.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//----------------------------------------------------------------------




	public int addThisCVehicle(String vnumber, int customer_id, int vehicle_id) {
		String q5="insert into customer_vehicles values(?,?,?)";
			int ncva=0;
			try {
				PreparedStatement pmt=con.prepareStatement(q5);
				pmt.setString(1, vnumber);
				pmt.setInt(2, customer_id);
				pmt.setInt(3, vehicle_id);
				ncva=pmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ncva;
		
	}

	
	
	
}
