package org.capg.service;

import org.capg.model.Account;
import org.capg.model.Customer;

public class DiffAccountServiceImpl implements IDiffAccountService{

	@Override
	public Account createAccount(Customer customer, double openingBalance) {
		Account account=null;
		if(customer!=null)
		{ account=new Account();
			account.setCustomer(customer);
			if(openingBalance>0)
			{
				if(openingBalance==1000)
				{
					account.setAccountType("savings");
					account.setOpeningBalance(openingBalance);
				}
				else if(openingBalance==10000)
				{
					account.setAccountType("current");
					account.setOpeningBalance(openingBalance);
				}
				
				else if(openingBalance==100)
				{
					account.setAccountType("rd");
					account.setOpeningBalance(openingBalance);
				}
				else if(openingBalance==500)
				{
					account.setAccountType("fd");
					account.setOpeningBalance(openingBalance);
				}
			}
		}
		return account;}
	
}
