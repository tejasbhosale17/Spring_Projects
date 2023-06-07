package com.sunbeam.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import operations.dao.CustomerDao;
import operations.models.Customer;

class CustomerDaoTest {

	 static Scanner scan = new Scanner(System.in);
	
	@Test
	void testAllCustomers() {
		List<Customer> customerList= new ArrayList<>(); 
		try {
			CustomerDao customerDao = new CustomerDao();
			customerDao.getAllCustomers(customerList);
			assertEquals(customerList.isEmpty(), false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Test
	void testSpecificCustomer() {
		System.out.println("Enter mobile no to search the customer:");
		long mobile=scan.nextLong();
		try {
			CustomerDao customerDao = new CustomerDao();
			Customer customer =new Customer();
			customer=customerDao.getThatCustomer(mobile);
			if(customer!=null) {
				System.out.println(customer);
			}else {
				System.out.println("Customer Does not exists!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//
//	@Test
//	void testRemoveThatCustomer() {
//		fail("Not yet implemented");
//	}

}
