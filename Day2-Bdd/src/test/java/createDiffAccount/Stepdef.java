package createDiffAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.capg.model.Account;
import org.capg.model.Address;
import org.capg.model.Customer;
import org.capg.service.DiffAccountServiceImpl;
import org.capg.service.IDiffAccountService;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	
	
	
	private Customer customer;
	private double openingBalance;
	private Account account;
	private IDiffAccountService accountService;
	
	
	@Before
	public void setUp()
	{
		customer=new Customer();
		accountService=new DiffAccountServiceImpl();
	}
	

@Given("^Customer details and opening balance$")
public void customer_details_and_opening_balance() throws Throwable {
    customer.setFirstName("Tom");
    customer.setLastName("modi");
    Address a=new Address();
    a.setCity("chennai");
    a.setDoorNo("15");
    customer.setAddress(a);
    openingBalance=1000;
    
}

@When("^For valid customer with minimum opening balance (\\d+)$")
public void for_valid_customer_with_minimum_opening_balance(int arg1) throws Throwable {
this.openingBalance=arg1;
}

@Then("^create new Savings account$")
public void create_new_Savings_account() throws Throwable {
   account=accountService.createAccount(customer, openingBalance);
   assertNotNull(account);
   assertEquals("savings", account.getAccountType());
}

@Then("^create new Current account$")
public void create_new_Current_account() throws Throwable {
	 account=accountService.createAccount(customer, openingBalance);
	   assertNotNull(account);
	   assertEquals("current", account.getAccountType()); 
}

@Then("^create new RD account$")
public void create_new_RD_account() throws Throwable {
	 account=accountService.createAccount(customer, openingBalance);
	   assertNotNull(account);
	   assertEquals("rd", account.getAccountType());
}

@Then("^create new FD account$")
public void create_new_FD_account() throws Throwable {
	 account=accountService.createAccount(customer, openingBalance);
	   assertNotNull(account);
	   assertEquals("fd", account.getAccountType());
}

}
