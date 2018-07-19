package com.capg.project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.capg.project.bean.AccountDetails;
import com.capg.project.bean.CustomerDetails;
import com.capg.project.service.AccountService;
import com.capg.project.service.AccountValidation;
import com.capg.project.service.CustomerService;

public class Client {
	static boolean k;
	static boolean b;
	static boolean login;
	static int value;

	static String transaction;

	public static void main(String[] args) {
		AccountValidation valid = new AccountValidation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AccountService acservice = new AccountService();
		CustomerService cuservice = new CustomerService();

		while (true) {

			AccountDetails account = new AccountDetails();
			CustomerDetails customer = new CustomerDetails();

			System.out.println("Payment Wallet Application");
			System.out.println("1. Create account");
			System.out.println("2. Login");
			System.out.println("3. Exit");

			Scanner sc = new Scanner(System.in);

			int i = sc.nextInt();
			try {
				switch (i) {
				case 1:
					System.out.println("Enter your name");

					String customerName = br.readLine();
					customer.setCustomerName(customerName);
					boolean iscustomerName = valid.validatecustomerName(customerName);
					if (!iscustomerName) {
						System.out.println("Invalid input");
						continue;
					}
					customer.setCustomerName(customerName);

					System.out.println("Enter age");
					int age = sc.nextInt();

					System.out.println("Mobile Number");
					String phoneNumber = br.readLine();
					boolean isphoneNumber = valid.validatephoneNumber(phoneNumber);
					if (!isphoneNumber) {
						System.out.println("Invalid input");
						continue;
					}

					System.out.println("Enter Gender : Male/Female/M/F/Others");
					String gender = br.readLine();
					boolean isgender = valid.validategender(gender);
					if (!isgender) {
						System.out.println("Invalid input");
						continue;
					}

					long accountNumber = (long) (Math.random() * 100000 + 99999);

					System.out.println("Enter your email id");
					String customerEmail = br.readLine();
					customer.setCustomerEmail(customerEmail);
					boolean iscustomerEmail = valid.validatecustomerEmail(customerEmail);
					if (!iscustomerEmail) {
						System.out.println("Invalid input");
						continue;
					}

					System.out.println(
							"Enter username : use aplabets and characters from a-z, 0-9, underscore _, hyphen-");
					String username = br.readLine();
					account.setUsername(username);
					boolean isusername = valid.validateusername(username);
					if (!isusername) {
						System.out.println("Invalid input");
						continue;
					}

					System.out.println(
							"Enter password : use aplabets and characters from a-z, 0-9. \n It should have atleast 1 Upper case character, 1 Lower case character, 1 special character and 1 digit. MIN LENGTH IS 6 MAX LENGTH IS 20 ");
					String password = br.readLine();
					account.setPassword(password);
					boolean ispassword = valid.validatepassword(password);
					if (!ispassword) {
						System.out.println("Invalid. Try again");
						continue;
					}

					System.out.println("Deposit Rs : 500 or above as account minimum limit is Rs500");

					while (true) {
						int bal = sc.nextInt();
						if (bal < 500)
							System.out.println("Minimum bal. should be 500");

						else {
							account.setBalance(bal);
							break;
						}
					}
					customer.setAge(age);
					customer.setGender(gender);
					customer.setPhoneNumber(phoneNumber);
					account.setAccountNumber(accountNumber);
					account.setCustomerDetails(customer);

					if (isphoneNumber && iscustomerEmail && ispassword && isusername) {
						{
							b = acservice.createAccount(account);
							b = cuservice.createAccount(account);
							System.out.println("Account Created Successfully");

							System.out.println("Your account number is " + accountNumber);
						}
					} else {
						System.out.println("Invalid");
					}
					break;
				case 2:
					System.out.println("Enter username1");
					String username1 = br.readLine();
					System.out.println("Enter password1");
					String password1 = br.readLine();

					login = acservice.login(username1, password1);
					while (login != false) {
						System.out.println("*****WELCOME*****");
						// System.out.println("Name: " +
						// account.getCustomerDetails().getCustomerName());
						// System.out.println("Account Number: ");
						System.out.println("1.Show Balance");
						System.out.println("2.Deposit");
						System.out.println("3.Withdraw");
						System.out.println("4. Fund Transfer");
						System.out.println("5.Print Transaction");
						System.out.println("6. Logout");

						int options = sc.nextInt();
						switch (options) {

						case 1:

							System.out.println("Balance: " + acservice.showBalance());
							break;
						case 2:
							System.out.println("Enter amount to deposit");
							int deposit = sc.nextInt();
							if (deposit < 0)
								System.out.println("Invalid Input");

							else {
								value = acservice.depositBalance(deposit);
								if (value != 0)
									System.out.println("Deposited");

								else
									System.out.println("Something went wrong. Please try again");
							}
							transaction = deposit + " credited";
							// transactionService.addTransactions(trans);
							break;

						case 3:
							System.out.println("Enter amount to withdraw");
							int withdraw = sc.nextInt();
							if (withdraw < 0)
								System.out.println("Invalid Input");

							else {
								value = acservice.withdrawBalance(withdraw);
								if (value != 0)
									System.out.println("Amount Successfuly Withdrawn");

								else
									System.out.println("Insufficient Funds!");
							}

							break;

						case 4:
							System.out.println("Enter the account number to which you want to Trasnfer money");
							accountNumber = sc.nextLong();
							System.out.println("Enter amount you want to transfer");
							int transferAmount = sc.nextInt();
							value = acservice.FundTransfer(accountNumber, transferAmount);
							// service.FundTransfer(accountNumber, account);
							if (value != 0)
								System.out.println("Successful");
							else
								System.out.println("failed");
							break;
						case 5:

							// service.PrintTransaction(account);
							break;

						case 6:
							login = false;
						}
					}
					break;
				case 3:
					System.exit(0);

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
