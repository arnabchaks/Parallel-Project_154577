package com.cg.pp.junittest;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class TestDeposit {

	WalletService wser = new WalletServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test deposit correct");
		String mobileno = "9649861046";
		double amount = 500.0;
		try {
			assertEquals(1000.0, wser.deposit(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrong() {
		System.out.println("From test deposit wrong number");
		String mobileno = "9649861045";
		double amount = 500;
		try {
			assertEquals(new CustomerExceptions(), wser.deposit(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAmount() {
		System.out.println("From test deposit wrong balance");
		String mobileno = "9649861046";
		double amount = -500;
		try {
			assertEquals(new CustomerExceptions(), wser.deposit(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}
}
