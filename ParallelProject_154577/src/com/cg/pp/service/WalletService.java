package com.cg.pp.service;

import java.util.HashMap;

import com.cg.pp.beans.Customer;
import com.cg.pp.exceptions.CustomerExceptions;

public interface WalletService {
	Customer createAccount(Customer customer);

	double showBalance(String mobileno) throws CustomerExceptions;

	double deposit(String mobileno, double amount) throws CustomerExceptions;

	double withdraw(String mobileno, double amount) throws CustomerExceptions;

	Customer transfer(String mob_from, String mob_to, double amount) throws CustomerExceptions;
	
	boolean validateCustomer (Customer customer) throws CustomerExceptions;

	HashMap<Integer, String> printTransactions() throws CustomerExceptions;
}
