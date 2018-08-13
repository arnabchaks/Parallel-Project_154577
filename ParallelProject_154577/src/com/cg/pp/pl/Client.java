/*
 * 
 * Author: Arnab Chakraborty (154577)
 * Associate Consultant, Capgemini
 * 
 */
package com.cg.pp.pl;

import java.util.Scanner;

import com.cg.pp.beans.Customer;
import com.cg.pp.beans.Wallet;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class Client {

	public static void main(String[] args) {
		WalletService wser = new WalletServiceImpl();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			String name,mobileno;
			double balance,amount;
			System.out.println(
					"Menu \n1. Create Account \n2. Show balance \n3. Add balance \n4. Withdraw money \n5. Send money \n6. Transaction history \n7. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter name (Name space surname) :");
				String firstName = sc.next();
				String lastName = sc.next();
				name = firstName + " " + lastName ;
				System.out.println("Enter phone number");
				mobileno = sc.next();
				System.out.println("Enter initial balance to be filled");
				balance = sc.nextDouble();
				Customer cust = new Customer(name, mobileno, new Wallet(balance));
				try {
					if (wser.validateCustomer(cust)) {
					System.out.println("Account created. Details: \n" + wser.createAccount(cust));
					}
					else
					break;
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
					break;
				}
				break;
			case 2:
				System.out.println("Enter phone number: ");
				mobileno = sc.next();
				try {
					System.out.println("Your balance is " + wser.showBalance(mobileno));
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter phone number: ");
				mobileno = sc.next();
				System.out.println("Enter amount to be added: ");
				amount = sc.nextDouble();
				try {
					wser.deposit(mobileno, amount);
					System.out.println("Rs. " + amount + " successfully deposited");
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter phone number: ");
				mobileno = sc.next();
				System.out.println("Enter amount to be withdrawn: ");
				amount = sc.nextDouble();
				try {
					wser.withdraw(mobileno, amount);
					System.out.println("Rs. " + amount + " successfully withdrawn");
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter phone number: ");
				String mob_from = sc.next();
				System.out.println("Enter number to which you want to send money: ");
				String mob_to = sc.next();
				System.out.println("Enter amount to be sent: ");
				amount = sc.nextDouble();
				try {
					wser.transfer(mob_from, mob_to, amount);
					System.out.println("Rs. " + amount + " successfully transferred to "+ mob_to );
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			case 6:
				try {
					System.out.println(wser.printTransactions());
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}
			default:
				break;
			}
		} while (choice != 7);
		sc.close();
	}
}