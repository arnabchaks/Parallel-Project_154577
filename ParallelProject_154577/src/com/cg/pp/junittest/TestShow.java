package com.cg.pp.junittest;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class TestShow {
	WalletService wser = new WalletServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test show correct");
		String mobileno = "9649861046";
		try {
			assertEquals(500.0, wser.showBalance(mobileno));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrong() {
		System.out.println("From test show correct");
		String mobileno = "9649861045";
		try {
			assertEquals(new CustomerExceptions(), wser.showBalance(mobileno));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}
}
