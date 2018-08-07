package org.capg.service;

import org.capg.exception.AccountNotFound;
import org.capg.exception.InSufficientBalance;
import org.capg.exception.InvalidCustomer;
import org.capg.exception.InvalidOpeningBalance;
import org.capg.model.Account;
import org.capg.model.Customer;

public interface IAccountService {

	public Account createAccount(Customer customer,double amount) throws InvalidCustomer,InvalidOpeningBalance;
	public Account findAccountById(int accountNo);
	public Account withdraw(int accountNo,double amount_withdraw) throws AccountNotFound, InSufficientBalance;
	public Account deposit(int accountNo,double amount_withdraw) throws AccountNotFound, InSufficientBalance;
	//public Account updateBalance(int accountNo, double amount);
}
