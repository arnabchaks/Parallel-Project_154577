package com.cg.pp.junittest;

import static org.testng.AssertJUnit.assertEquals;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class TestTransfer {

	WalletService wser = new WalletServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test transaction correct");
		String mob_from = "9649861046";
		String mob_to = "9650475085";
		double amount = 100;
		try {
			wser.transfer(mob_from, mob_to, amount);
			assertEquals(1100.0, wser.showBalance(mob_to));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAccount() {
		System.out.println("From test transaction wrong account");
		String mob_from = "9649861046";
		String mob_to = "123567890";
		double amount = 100;
		try {
			assertEquals(new CustomerExceptions(), wser.transfer(mob_from, mob_to, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAmount() {
		System.out.println("From test transaction wrong amount");
		String mob_from = "9649861046";
		String mob_to = "9650475085";
		double amount = 1200;
		try {
			assertEquals(new CustomerExceptions(), wser.transfer(mob_from, mob_to, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
