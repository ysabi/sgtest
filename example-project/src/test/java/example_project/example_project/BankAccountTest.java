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
		assertEquals(myAccount.getBalance(), 500d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
	}
	
	@Test
	public void testScenario1() {
		myAccount.deposit(100d, new Date());
		assertEquals(myAccount.getBalance(), 600d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		assertEquals(myAccount.getOperations().size(),1);
	}
	
	@Test
	public void testScenario2() {
		myAccount.deposit(100d, new Date());
		assertEquals(myAccount.getBalance(), 600d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		myAccount.withdraw(50d, new Date());
		assertEquals(myAccount.getBalance(), 550d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		assertEquals(myAccount.getOperations().size(),2);
	}
	
	@Test
	public void testScenario3() {
		myAccount.deposit(100d, new Date());
		assertEquals(myAccount.getBalance(), 600d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		myAccount.withdraw(50d, new Date());
		assertEquals(myAccount.getBalance(), 550d);
		assertEquals(myAccount.getState(), AccountState.POSITIVE_BALANCE);
		myAccount.withdraw(650d, new Date());
		assertEquals(myAccount.getBalance(), -100d);
		assertEquals(myAccount.getState(), AccountState.NEGATIVE_BALANCE);
		
		int sizeListOperations = myAccount.getOperations().size();
		assertEquals(sizeListOperations,3);
		
		// L'historique des opérations.
		assertEquals(myAccount.getOperations().get(0).getAmount(), 100d);
		assertEquals(myAccount.getOperations().get(0).getBalance(), 600d);
		System.out.println(myAccount.getOperations().get(0).getDate());
		assertEquals(myAccount.getOperations().get(0).getType(), OperationTypes.DEPOSIT);
		
		assertEquals(myAccount.getOperations().get(1).getAmount(), 50d);
		assertEquals(myAccount.getOperations().get(1).getBalance(), 550d);
		System.out.println(myAccount.getOperations().get(1).getDate());
		assertEquals(myAccount.getOperations().get(1).getType(), OperationTypes.WITHDRAW);
		
		assertEquals(myAccount.getOperations().get(2).getAmount(), 650d);
		assertEquals(myAccount.getOperations().get(2).getBalance(), -100d);
		System.out.println(myAccount.getOperations().get(2).getDate());
		assertEquals(myAccount.getOperations().get(2).getType(), OperationTypes.WITHDRAW);
		
		
		assertEquals(myAccount.getOperations().get(sizeListOperations-1).getBalance(), myAccount.getBalance());
		
		for(final Operation operation : myAccount.getOperations()) {
			System.out.println(operation.getDate() + " " + operation.getType().toString() + " " + operation.getAmount().toString());
		}
	}
	
	@Test
	public void testScenario4() {
		
	}
	

}
