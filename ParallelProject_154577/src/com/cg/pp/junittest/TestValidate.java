package com.cg.pp.junittest;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

import com.cg.pp.beans.Customer;
import com.cg.pp.beans.Wallet;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class TestValidate {

	WalletService wser = new WalletServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test customer correct");
		Customer c = new Customer("ArnabChakraborty", "1234567890", new Wallet(500.0));
		try {
			assertEquals(true, wser.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongName() {
		System.out.println("From test customer wrong name");
		Customer c = new Customer("ArnabChakraborty123", "1234567890", new Wallet(500.0));
		try {
			assertEquals(new CustomerExceptions(), wser.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongNumber() {
		System.out.println("From test customer wrong number");
		Customer c = new Customer("ArnabChakraborty", "12345", new Wallet(500.0));
		try {
			assertEquals(new CustomerExceptions(), wser.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongBalance() {
		System.out.println("From test customer wrong balance");
		Customer c = new Customer("ArnabChakraborty", "1234567890", new Wallet(-500.0));
		try {
			assertEquals(new CustomerExceptions(), wser.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
