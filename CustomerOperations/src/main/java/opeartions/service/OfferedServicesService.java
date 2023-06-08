package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import operations.dao.ServiceDao;
import operations.models.Service;



public class OfferedServicesService {
	static ServiceDao serviceDao;
	
	public static void getAllVehicles(){
		List<Service> serviceList = new ArrayList<>();
		serviceDao = new ServiceDao();
		serviceDao.getAllVehicles(serviceList);
		for(Service s: serviceList) {
			System.out.println(s);
		}		
	}
}
