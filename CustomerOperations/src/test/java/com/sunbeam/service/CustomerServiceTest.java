package com.sunbeam.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.CustomerService;

class CustomerServiceTest {

	@Test
	void testGetAllCustomers() {
		CustomerService.getAllCustomers();
	}
	
	@Test
	void testGetThatCustomer() {
		CustomerService.getSpecificCustomer();
	}
	
	@Test
	void testremoveThatCustomer() {
		CustomerService.removeCustomer();;
	}
	
	@Test
	void testUpdateThatCustomer() {
		CustomerService.updateCustomer();;
	}
	
	@Test
	void testAddThisCustomer() {
		CustomerService.addCustomer();;
	}
}
