package com.cg.pp.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.pp.beans.Customer;
import com.cg.pp.beans.Wallet;
import com.cg.pp.exceptions.CustomerExceptions;

public class WalletDaoImpl implements WalletDao {
	Map<String, Customer> database = new HashMap<String, Customer>(); // Database stores customers identified bytheir
																		// mobileno
	HashMap<Integer, String> transactions = new HashMap<Integer, String>();
	static int id = 0;

	public WalletDaoImpl() {
		//creating three base accounts for reference
		Customer arnab = new Customer("Arnab Chakraborty", "9649861046", new Wallet(500.0));
		Customer messi = new Customer("Lionel Messi", "9650475085", new Wallet(1000.0));
		Customer ronaldo = new Customer("Cristiano Ronaldo", "8961231001", new Wallet(250.0));
		database.put(arnab.getMobileno(), arnab);
		database.put(messi.getMobileno(), messi);
		database.put(ronaldo.getMobileno(), ronaldo);
	}

	@Override
	public Customer createAccount(Customer customer) {
		//Adds new customer to database
		database.put(customer.getMobileno(), customer);
		return customer;
	}

	@Override
	public double showBalance(String mobileno) throws CustomerExceptions {
		// Identifies mobileno and prints wallet balance
		if (database.containsKey(mobileno)) {
			return database.get(mobileno).getWallet().getBalance();
		} else {
			throw new CustomerExceptions("ERROR: Account not found.");
		}
	}

	@Override
	public double deposit(String mobileno, double amount) throws CustomerExceptions {
		// Identifies mobileno and adds amount to wallet balance
		if (database.containsKey(mobileno)) {
			if (amount > 0) {
				double bal = database.get(mobileno).getWallet().getBalance();
				bal = bal + amount;
				database.get(mobileno).getWallet().setBalance(bal);
				id++;
				transactions.put(id, " Deposit of Rs. " + amount + " to " + mobileno + ".");
				return database.get(mobileno).getWallet().getBalance();
			} else {
				throw new CustomerExceptions("ERROR: Please enter a positive amount to be added.");
			}
		} else {
			throw new CustomerExceptions("ERROR: Account not found.");
		}
	}

	@Override
	public double withdraw(String mobileno, double amount) throws CustomerExceptions {
		// Identifies mobileno and subtracts amount from wallet balance
		if (database.containsKey(mobileno)) {
			if (amount > 0) {
				double bal = database.get(mobileno).getWallet().getBalance();
				if (amount < bal) {
					bal = bal - amount;
					database.get(mobileno).getWallet().setBalance(bal);
					id++;
					transactions.put(id, " Withdrawal of Rs. " + amount + " to " + mobileno + ".");
					return database.get(mobileno).getWallet().getBalance();
				} else {
					throw new CustomerExceptions("ERROR : Insufficient funds for withdrawal.");
				}
			} else {
				throw new CustomerExceptions("ERROR : Please enter a positive value to be withdrawn.");
			}
		} else {
			throw new CustomerExceptions("ERROR: Account not found.");
		}
	}

	@Override
	public Customer transfer(String mob_from, String mob_to, double amount) throws CustomerExceptions {
		//transfers 'amount' from 'mob_from' to 'mob_to'
		if (database.containsKey(mob_from)) {
			if (database.containsKey(mob_to)) {
				double bal1 = database.get(mob_from).getWallet().getBalance();
				double bal2 = database.get(mob_to).getWallet().getBalance();
				if (amount < bal1) {
					bal1 = bal1 - amount;
					bal2 = bal2 + amount;
					database.get(mob_from).getWallet().setBalance(bal1);
					database.get(mob_to).getWallet().setBalance(bal2);
					id++;
					transactions.put(id, " Transfer of Rs. " + amount + " from " + mob_from + " to " + mob_to + ".");
					return database.get(mob_to);
				} else {
					throw new CustomerExceptions("ERROR: Insufficient funds for transfer.");
				}
			} else {
				throw new CustomerExceptions("ERROR: Reciever account not found");
			}
		} else {
			throw new CustomerExceptions("ERROR: Sender account not found.");
		}
	}

	@Override
	public HashMap<Integer, String> printTransactions() throws CustomerExceptions {
		//prints all transactions of one session
		if (id!=0)
			return transactions;
		else throw new CustomerExceptions("ERROR: No transactions have been performed yet.");
	}

}
