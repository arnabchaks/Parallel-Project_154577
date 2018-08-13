package com.cg.pp.beans;



public class Customer {
	private String name;
	private String mobileno;
	private Wallet wallet;

	public Customer(String name, String mobileno, Wallet wallet) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nMobile no.: " + mobileno + "\nBalance: " + wallet;
	}

}
