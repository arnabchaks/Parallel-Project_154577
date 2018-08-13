package com.cg.pp.beans;

public class Wallet {
	private double balance;

	public Wallet() {
	};

	public Wallet(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "" + balance;
	}

}
