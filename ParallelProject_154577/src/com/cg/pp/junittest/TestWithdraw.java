package com.cg.pp.junittest;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class TestWithdraw {

	WalletService wser = new WalletServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test withdraw correct");
		String mobileno = "9649861046";
		double amount = 200;
		try {
			assertEquals(300.0, wser.withdraw(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAccount() {
		System.out.println("From test withdraw wrong account");
		String mobileno = "9649861045";
		double amount = 100;
		try {
			assertEquals(new CustomerExceptions(), wser.withdraw(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAmount() {
		System.out.println("From test transaction wrong amount");
		String mobileno = "9649861046";
		double amount = 600;
		try {
			assertEquals(new CustomerExceptions(), wser.withdraw(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
