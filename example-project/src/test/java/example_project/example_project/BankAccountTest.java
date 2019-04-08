package example_project.example_project;

import java.util.Date;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class BankAccountTest extends TestCase {
	
	BankAccount myAccount = new BankAccount("FR7630001007941234567890185", 500d);
	
	
	public void testDoNothing() {
		
	}
	
	@Test
	public void testInitialBalance() {
		BankAccount myAccount = new BankAccount("FR7630001007941234567890185");
		assertEquals(myAccount.getBalance(), 0d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
	}
	
	@Test
	public void testDeposit100euro() {
		myAccount.deposit(100d, new Date());
		assertEquals(myAccount.getBalance(), 600d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		assertEquals(myAccount.getOperations().size(),1);
	}
	
	@Test
	public void testWithDraw50euro() {
		myAccount.withdraw(50d, new Date());
		assertEquals(myAccount.getBalance(), 450d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		assertEquals(myAccount.getOperations().size(),1);
	}
	
	@Test
	public void testDeposit100euroAndWithDraw50euro() {
		myAccount.deposit(100d, new Date());
		assertEquals(myAccount.getBalance(), 600d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		myAccount.withdraw(50d, new Date());
		assertEquals(myAccount.getBalance(), 550d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
	}
	
	@Test
	public void testCaseofNegativeBalance() {
		myAccount.withdraw(650d, new Date());
		assertEquals(myAccount.getBalance(), -150d);
		assertEquals(myAccount.getState(), AccountState.NEGATIVE_BALANCE);
		
	}
	
	@Test
	public void testGetHistoryofOperations() {
		myAccount.withdraw(650d, new Date());
		assertEquals(myAccount.getBalance(), -150d);
		assertEquals(myAccount.getState(), AccountState.NEGATIVE_BALANCE);
		int sizeListOperations = myAccount.getOperations().size();
		assertEquals(sizeListOperations,1);
		
		// L'historique des opérations.
		assertEquals(myAccount.getOperations().get(0).getAmount(), 650d);
		assertEquals(myAccount.getOperations().get(0).getBalance(), -150d);
		assertEquals(myAccount.getOperations().get(0).getType(), OperationTypes.WITHDRAW);
	}
	
	

	

}
