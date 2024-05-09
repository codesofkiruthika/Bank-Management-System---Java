package com.Bank;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class User {
	private static long dynamicAccountNumber = 876543210000L;
	private String name;
	private String dateOfBirth;
	private long mobileNumber;
	private long aadharNumber;
	private String emailId;
	private String password;
	private long accountNumber;
	
	private static Map<String,User> userMap = new HashMap<String, User>();
	
	private User(String userName, String userDateOfBirth, long userMobileNumber, long userAadharNumber, String userPassword, long dynamicAccountNumber){
		this.name = userName;
		this.dateOfBirth = userDateOfBirth;
		this.mobileNumber = userMobileNumber;
		this.aadharNumber = userAadharNumber;
		this.password = userPassword;
		this.accountNumber = dynamicAccountNumber;
	}
	public static void createAccount() {
		Scanner accObj = new Scanner(System.in);
		System.out.println("Enter your name : ");
		String userName = accObj.nextLine();
		System.out.println("Enter your date of birth(Format: DD/MM/YYYY) : ");
		String userDateOfBirth = accObj.nextLine();
		System.out.println("Enter your mobile number : ");
		long userMobileNumber = accObj.nextLong();
		System.out.println("Enter your aadharcard number : ");
		long userAadharNumber = accObj.nextLong();
		accObj.nextLine();
		System.out.println("Enter your email id(This will be your username) : ");
		String userEmailId = accObj.nextLine();
		System.out.println("Enter your password(Must be atleast 8 characters) : ");
		String userPassword = accObj.nextLine();
		System.out.println("Confirm your password : ");
		String reEnterPassword = accObj.nextLine();
		System.out.println("(To create an account please deposit minimum amount of Rs.500) \nEnter the amount : ");
		long userDeposit = accObj.nextLong();
		
		
		if(Long.toString(userMobileNumber).length()==10 && userEmailId.contains("@") && userPassword.equals(reEnterPassword) && userPassword.length()>=8 && userDeposit>=500) {
			dynamicAccountNumber++;
			User userObj = new User(userName, userDateOfBirth, userMobileNumber, userAadharNumber, userPassword, dynamicAccountNumber);
			userMap.put(userEmailId, userObj);
			System.out.println("Account created successfully!... ");
			System.out.println("Your Account Number is : "+dynamicAccountNumber);
			BankManagement.amountDetailsMap.put(dynamicAccountNumber, userDeposit);
			System.out.println("Initial amount Rs."+ userDeposit +" deposited to your account...");
			Main.showOption();

		}
		else {
			System.out.println("Please enter valid details...");
			createAccount();
		}
		

	}
	public static void Login() {
		Scanner loginObj = new Scanner(System.in);
		System.out.println("Enter your Username : ");
		String loginName = loginObj.nextLine();
		System.out.println("Enter your password : ");
		String loginPassword = loginObj.nextLine();
		User userLoginObj = userMap.get(loginName);
		if(userLoginObj==null) {
			System.out.println("Please enter valid username or password...");
			Main.showOption();
		}
		else {
			if(loginPassword.equals(userLoginObj.password)){
				System.out.println("Logged in successfully!...");
				Main.postLoginOptions(userLoginObj.accountNumber);
			}
			else {
				System.out.println("Please enter valid username or password...");
				Main.showOption();
			}
		}

	}

}
