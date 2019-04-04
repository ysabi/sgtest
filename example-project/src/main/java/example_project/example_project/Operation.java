package example_project.example_project;

import java.util.Date;

public class Operation {
	
	private Date date;
	private Double amount;
	private OperationTypes type;
	private Double balance;
	
	
	public Operation(Date date, Double amount, OperationTypes type, Double balance) {
		super();
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.setBalance(balance);
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public OperationTypes getType() {
		return type;
	}
	public void setType(OperationTypes type) {
		this.type = type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
