package com.Bank;
import java.util.Scanner;

public class Main {
	
	public static void showOption() {
		Scanner homeObj = new Scanner(System.in);
		System.out.println();
		System.out.println("1. Create Account \n2. Login \n3. Exit");
		System.out.println("Enter your option : ");
		int option = homeObj.nextInt();
		switch(option) {
		case 1:
			User.createAccount();
			break;
		case 2:
			User.Login();
			break;
		case 3:
			System.out.println("Thank you for visiting our bank !...");
			break;
		default:
			System.out.println("Please enter the valid option...");
			showOption();
		}
	}
	public static void postLoginOptions(long accountNumber) {
		Scanner postLoginObj = new Scanner(System.in);
		System.out.println();
		System.out.println("1. Deposit \n2. Withdraw \n3. Balance enquiry \n4. Back");
		System.out.println("Enter your option : ");
		int option = postLoginObj.nextInt();
		switch(option) {
		case 1:
			BankManagement.deposit(accountNumber);
			break;
		case 2:
			BankManagement.withdraw(accountNumber);
			break;
		case 3:;
			BankManagement.balanceEnquiry(accountNumber);
			break;
		case 4:
			showOption();
			break;
		default:
			System.out.println("Please enter the valid option...");
			postLoginOptions(accountNumber);
		}
	}
	
	public static void main(String [] args) {
		System.out.println("Welcome to TKL BANK !...");
		showOption();
	}
}
