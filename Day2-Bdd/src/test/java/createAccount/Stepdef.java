package createAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.capg.dao.IAccountDao;
import org.capg.exception.InvalidCustomer;
import org.capg.exception.InvalidOpeningBalance;
import org.capg.model.Account;
import org.capg.model.Address;
import org.capg.model.Customer;
import org.capg.service.AccountServiceImpl;
import org.capg.service.IAccountService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	Customer customer;
	private double openingBalance;
	private IAccountService accountService;
	private int accountNo;
	private double amount_withdraw;
	private double amount_deposit;
	private Account account;
	@Mock
	private IAccountDao accountDao;
	
	@Before
	public void setup() {
		customer=new Customer();
		openingBalance=500;
		account=new Account();
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImpl(accountDao);
	}
	
	@Given("^customer details$")
	public void customer_details() throws Throwable {
		 customer.setFirstName("Sanu");
		  customer.setLastName("Nama");
		  Address address=new Address();
		  address.setDoorNo("12");
		  address.setCity("chennai");
		  customer.setAddress(address);
	}

	@When("^Valid Customer$")
	public void valid_Customer() throws Throwable {
	
		assertNotNull(customer);
	}

	@When("^valid opening balance$")
	public void valid_opening_balance() throws Throwable {
		assertTrue(openingBalance>=500);
	}

	@Then("^craete new Account$")
	public void craete_new_Account() throws Throwable {
		
		Account account=new Account();
		account.setAccountNo(1);
		account.setOpeningBalance(500);
		account.setCustomer(customer);
		
		Mockito.when(accountDao.addAccount(account)).thenReturn(true);
		
		
		   Account account2 = accountService.createAccount(customer, openingBalance);
		   Mockito.verify(accountDao).addAccount(account);
		   
		 assertNotNull(account);
		   assertEquals(openingBalance, account.getOpeningBalance(),0.0);;
		   assertEquals(account.getAccountNo(), 1);
		   
		   assertEquals(account.getOpeningBalance(), account2.getOpeningBalance(),0.0);
		   
	}
	
	
	@Given("^Customer details$")
	public void customer_details1() throws Throwable {
	  customer=null;
	}

	@When("^Invalid Customer$")
	public void invalid_Customer() throws Throwable {
	 assertNull(customer);
	}

	@Then("^throw 'Invalid Customer' error message$")
	public void throw_Invalid_Customer_error_message() throws Throwable {
	try
	{
		accountService.createAccount(customer, 3000);
	}
	catch(InvalidCustomer e)
	{
		
	}
	}
	
	
	
	
	@Given("^Customer details and openingbalance$")
	public void customer_details_and_openingbalance() throws Throwable {
	   openingBalance=100;
	}

	@When("^Invalid opening balance$")
	public void invalid_opening_balance() throws Throwable {
	    assertTrue(openingBalance<=1000);
	}

	@Then("^throw 'insufficient Balance' error message$")
	public void throw_insufficient_Balance_error_message() throws Throwable {
	   try
	   {
		   accountService.createAccount(customer, openingBalance);
	   }
	   catch(InvalidOpeningBalance e)
	   {
		   
	   }
	}

	@Given("^Account number$")
	public void account_number() throws Throwable {
	   accountNo=1001;
	}

	@When("^valid Account number$")
	public void valid_Account_number() throws Throwable {
	   assertTrue(accountNo>0);
	}

	@Then("^find account details$")
	public void find_account_details() throws Throwable {
		
		Account account=new Account();
		account.setAccountNo(1001);
		account.setOpeningBalance(10000);
		account.setCustomer(customer);
		
		Mockito.when(accountDao.findAccountById(accountNo)).thenReturn(account);
		  Account account2 = accountService.findAccountById(accountNo);
		   //Mockito.verify(accountDao).findAccountById(2);
		  assertNotNull(account2);
		 // assertEquals(1, account2.getAccountNo());
	    //Account account=accountService.findAccountById(accountNo);
	}
	
	
	
	@Given("^Account number (\\d+) and amount (\\d+)$")
	public void account_number_and_amount(int accNo, int amount) throws Throwable {
	   this.accountNo=accNo;
	   this.amount_withdraw=amount;
	}

	@When("^Find account and do withdraw$")
	public void find_account_and_do_withdraw() throws Throwable {
		System.out.println("account No is:"+accountNo);
		
		Account account=new Account();
		account.setAccountNo(1001);
		account.setOpeningBalance(10000);
		account.setCustomer(customer);
		
		Mockito.when(accountDao.findAccountById(accountNo)).thenReturn(account);
		Mockito.when(accountDao.withdraw(accountNo,amount_withdraw)).thenReturn(account);
		//Mockito.when(accountDao.updateBalance(accountNo, 9000)).thenReturn(account);
	 Account updatedaccount =accountService.withdraw(accountNo,amount_withdraw);
	 
	 assertEquals(9000, updatedaccount.getOpeningBalance(),0.0);
	Mockito.verify(accountDao).withdraw(accountNo,amount_withdraw);
	}

	@Then("^Update the account details$")
	public void update_the_account_details() throws Throwable {
		
		/*Account account=new Account();
		account.setAccountNo(1001);
		account.setOpeningBalance(10000);
		account.setCustomer(customer);
		
		Mockito.when(accountDao.findAccountById(accountNo)).thenReturn(account);
		Mockito.when(accountDao.withdraw(accountNo, amount_withdraw)).thenReturn(account);
		Account account2=accountService.withdraw(accountNo, amount_withdraw);
		
		assertEquals(9000, account2.getOpeningBalance(),0.0);*/

	//	Account updated_account=accountService.updateBalance(accountNo, 9000);
		
		//	Mockito.verify(accountDao).updateBalance(accountNo, 9000);
		//	assertEquals(9000, updated_account.getOpeningBalance(),0.0);
		
		
	  
	}

	@Given("^Account number is (\\d+) and amount is (\\d+)$")
	public void account_number_is_and_amount_is(int accNo, int amount) throws Throwable {
		  this.accountNo=accNo;
		   this.amount_deposit=amount;
	}

	@When("^Find account and do deposit$")
	public void find_account_and_do_deposit() throws Throwable {

		Account account=new Account();
		account.setAccountNo(1001);
		account.setOpeningBalance(10000);
		account.setCustomer(customer);
		
		Mockito.when(accountDao.findAccountById(accountNo)).thenReturn(account);
		Mockito.when(accountDao.deposit(accountNo,amount_deposit)).thenReturn(account);
	 Account updatedaccount1 =accountService.deposit(accountNo,amount_deposit);
	 
	 assertEquals(13000, updatedaccount1.getOpeningBalance(),0.0);
	Mockito.verify(accountDao).deposit(accountNo,amount_deposit);
	}

	@Then("^Update given account details$")
	public void update_given_account_details() throws Throwable {
	  
	}
	
	
}
