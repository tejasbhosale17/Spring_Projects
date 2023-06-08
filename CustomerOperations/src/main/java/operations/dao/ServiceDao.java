package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Service;

public class ServiceDao {

	Connection con;
	
	public ServiceDao(){
		try {
			con=DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getAllVehicles(List<Service> serviceList) {
		String q1="select * from services";
		try {
			PreparedStatement pmt =con.prepareStatement(q1);
			ResultSet rs =pmt.executeQuery();
			Service s= new Service(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("oil_cost"),rs.getDouble("labour_charges"),rs.getDouble("totla_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
