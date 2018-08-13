package com.cg.pp.dao;

import java.util.HashMap;

import com.cg.pp.beans.Customer;
import com.cg.pp.exceptions.CustomerExceptions;

public interface WalletDao {
	Customer createAccount(Customer customer);

	double showBalance(String mobileno) throws CustomerExceptions;

	double deposit(String mobileno, double amount) throws CustomerExceptions;

	double withdraw(String mobileno, double amount) throws CustomerExceptions;

	Customer transfer(String mob_from, String mob_to, double amount) throws CustomerExceptions;

	HashMap<Integer, String> printTransactions() throws CustomerExceptions;

}
