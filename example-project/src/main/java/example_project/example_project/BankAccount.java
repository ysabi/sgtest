package example_project.example_project;

import java.util.ArrayList;
import java.util.Date;

public class BankAccount {

	private String accountNumber;
	private Double balance;
	private ArrayList<Operation> operations = new ArrayList<Operation>();

	public BankAccount(String accountNumber, Double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
		this.balance = 0d;
	}

	/*
	 * In order to check my operations As a bank client I want to see the history
	 * (operation, date, amount, balance) of my operations
	 */
	public ArrayList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/*
	 * In order to save money As a bank client I want to make a deposit in my
	 * account
	 */
	public void deposit(double d, Date date) {
		this.balance += d;
		ArrayList<Operation> newOperationList = this.getOperations();
		newOperationList.add(new Operation(date, d, OperationTypes.DEPOSIT, balance));
		this.setOperations(newOperationList);
	}

	public AccountState getState() {
		return balance >= 0d ? AccountState.POSITIVE_BALANCE : AccountState.NEGATIVE_BALANCE;
	}

	/*
	 * In order to retrieve some or all of my savings As a bank client I want to
	 * make a withdrawal from my account
	 */
	public void withdraw(double d, Date date) {
		this.balance -= d;
		ArrayList<Operation> newOperationList = this.getOperations();
		newOperationList.add(new Operation(date, d, OperationTypes.WITHDRAW, balance));
		this.setOperations(newOperationList);
	}

}
