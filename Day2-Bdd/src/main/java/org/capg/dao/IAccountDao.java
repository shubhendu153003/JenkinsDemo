package org.capg.dao;

import org.capg.exception.AccountNotFound;
import org.capg.exception.InSufficientBalance;
import org.capg.model.Account;

public interface IAccountDao {
 public boolean addAccount(Account account);
	public Account findAccountById(int accountNo);
	public Account withdraw(int accountNo,double amount_withdraw) throws AccountNotFound, InSufficientBalance;
	public Account deposit(int accountNo,double amount_withdraw) throws AccountNotFound, InSufficientBalance;
	//public Account updateBalance(int accountNo, double amount);

}
