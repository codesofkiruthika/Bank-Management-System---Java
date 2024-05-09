package com.Bank;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class BankManagement {
	static Scanner bankObj = new Scanner(System.in);

	protected static Map<Long, Long> amountDetailsMap = new HashMap<Long, Long>();
	public static void deposit(long accountNumber){
		System.out.println("Enter the amount to deposit : ");
		long deposit = bankObj.nextLong();
		if(deposit>0) {
			Long depositedAmount = amountDetailsMap.get(accountNumber);
			Long totalAmount = deposit+depositedAmount;
			amountDetailsMap.put(accountNumber,totalAmount);
			System.out.println("Amount deposited successfully!...");
			System.out.println();
			Main.postLoginOptions(accountNumber);
		}
		else {
			System.out.println("Please enter valid amount...");
			deposit(accountNumber);
		}
	}
	public static void withdraw(long accountNumber) {
		System.out.println("Enter the amount to withdraw : ");
		long withdraw = bankObj.nextLong();
		if(withdraw>0) {
			Long depositedAmount = amountDetailsMap.get(accountNumber);
			if(withdraw<=depositedAmount) {
				Long balance = depositedAmount-withdraw;
				amountDetailsMap.put(accountNumber,balance);
				System.out.println("Amount withdrawn successfully!...");
				System.out.println();
				Main.postLoginOptions(accountNumber);
			}
			else {
				System.out.println("Insufficient balance...");
				System.out.println();
				Main.postLoginOptions(accountNumber);
			}
		}
		else {
			System.out.println("Please enter valid amount...");
			withdraw(accountNumber);
		}
	}
	public static void balanceEnquiry(long accountNumber) {
		System.out.println("Your current balance is Rs."+ amountDetailsMap.get(accountNumber));
		System.out.println();
		Main.postLoginOptions(accountNumber);
	}
	
}
