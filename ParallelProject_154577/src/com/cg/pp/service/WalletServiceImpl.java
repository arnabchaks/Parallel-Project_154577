package com.cg.pp.service;

import java.util.HashMap;

import com.cg.pp.beans.Customer;
import com.cg.pp.dao.WalletDao;
import com.cg.pp.dao.WalletDaoImpl;
import com.cg.pp.exceptions.CustomerExceptions;

public class WalletServiceImpl implements WalletService {

	public WalletServiceImpl() {

	}

	WalletDao wdao = new WalletDaoImpl();

	@Override
	public Customer createAccount(Customer customer) {
		return wdao.createAccount(customer);
	}

	@Override
	public double showBalance(String mobileno) throws CustomerExceptions {
		return wdao.showBalance(mobileno);
	}

	@Override
	public double deposit(String mobileno, double amount) throws CustomerExceptions {
		return wdao.deposit(mobileno, amount);
	}

	@Override
	public double withdraw(String mobileno, double amount) throws CustomerExceptions {
		return wdao.withdraw(mobileno, amount);
	}

	@Override
	public Customer transfer(String mob_from, String mob_to, double amount) throws CustomerExceptions {
		return wdao.transfer(mob_from, mob_to, amount);

	}

	@Override
	public HashMap<Integer, String> printTransactions() throws CustomerExceptions {
		return wdao.printTransactions();
	}

	@Override
	public boolean validateCustomer(Customer customer) throws CustomerExceptions {
		if (!customer.getName().matches("[A-Za-z ]{1,50}")) {
			throw new CustomerExceptions("ERROR: Your name should be alphabetical in nature and less than 50 characters long.");
		}
		if (!customer.getMobileno().matches("[0-9]{10}")) {
			throw new CustomerExceptions("ERROR: Your mobile number must be numerical and 10 digits long.");
		}
		if (customer.getWallet().getBalance()<0) {
			throw new CustomerExceptions("ERROR: Please enter a non-negative initial balance.");
		} else {
			return true;
		}
	}

}
