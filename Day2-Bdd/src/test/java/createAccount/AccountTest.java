package createAccount;

import static org.junit.Assert.*;

import org.capg.exception.InvalidCustomer;
import org.capg.exception.InvalidOpeningBalance;
import org.capg.model.Address;
import org.capg.model.Customer;
import org.capg.service.AccountServiceImpl;
import org.capg.service.IAccountService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class AccountTest {

	private Customer customer;
	private IAccountService accountService;
	private double openingBalance;
	
	@Before
	public void setUp() {
		customer = new Customer();
		customer.setFirstName("tom");
		customer.setLastName("jerry");
		Address address=new Address();
		address.setDoorNo("12");
		address.setCity("Chennai");
		customer.setAddress(address);
		
	// accountService = new AccountServiceImpl();	
	}
	
	@Rule
	public ExpectedException exception=ExpectedException.none();
	
	
	
	
	
	@Test //(expected=NullPointerException.class)
	public void test_customer_with_null() throws InvalidCustomer, InvalidOpeningBalance{
		customer = null;
		
	//	exception.expect(InvalidCustomer.class);
		//exception.expectMessage("sorry! Customer refers null.");
		
	//	accountService.createAccount(customer, 1000);
	}
	
	
	
	@Test //(expected=NullPointerException.class)
	public void test_customer_with_insufficientBalance() throws InvalidCustomer, InvalidOpeningBalance{
		openingBalance = 100;
		
		//exception.expect(InvalidOpeningBalance.class);
	//	exception.expectMessage("so");
		
	//	accountService.createAccount(customer, openingBalance);
	}
	
	
	
}
