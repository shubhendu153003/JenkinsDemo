package org.capg.service;

import org.capg.dao.AccountDaoImpl;
import org.capg.dao.IAccountDao;
import org.capg.exception.AccountNotFound;
import org.capg.exception.InSufficientBalance;
import org.capg.exception.InvalidCustomer;
import org.capg.exception.InvalidOpeningBalance;
import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.util.AccountUtil;

public class AccountServiceImpl  implements IAccountService{
   private IAccountDao accountDao/*=new AccountDaoImpl()*/;
  public AccountServiceImpl(IAccountDao accountDao2) {
		accountDao=accountDao2;
	// TODO Auto-generated constructor stub
}
   
	public AccountServiceImpl() {
	super();
	// TODO Auto-generated constructor stub
}

	@Override
	public Account createAccount(Customer customer, double amount) throws InvalidCustomer, InvalidOpeningBalance {
		if(customer!=null) {
			if(amount>=500) {
				Account account = new Account();
				account.setCustomer(customer);
				account.setOpeningBalance(amount);
				account.setAccountNo(AccountUtil.generateAccountNo());
				//System.out.println("Account No is:"+AccountUtil.generateAccountNo());
				boolean flag=accountDao.addAccount(account);
				if(flag)
				return account;
				else
					return null;
			}
			else
			{
				throw new InvalidOpeningBalance("sorry! Customer refers1 null.");
			}
			
			
		}
		
		else
		{
			throw new InvalidCustomer("sorry! Customer refers null.");
		}
	}

	@Override
	public Account findAccountById(int accountNo) {
		// TODO Auto-generated method stub
		return accountDao.findAccountById(accountNo);
	}

	@Override
	public Account withdraw(int accountNo, double amount_withdraw) throws AccountNotFound, InSufficientBalance {
		Account account=accountDao.findAccountById(accountNo);
		if(account!=null)
		{
			if(amount_withdraw<=account.getOpeningBalance())
			{
				account.setOpeningBalance(account.getOpeningBalance()-amount_withdraw);
			}
			else
				throw new InSufficientBalance("Insufficient balance ");
		}
		else
	     throw new AccountNotFound("Sorry!account id does not exist");
		
		//updateBalance(accountNo,account.getOpeningBalance());
		 account= accountDao.withdraw(accountNo, amount_withdraw);
		return account;
	}

	@Override
	public Account deposit(int accountNo, double amount_deposit) throws AccountNotFound, InSufficientBalance {
		Account account=accountDao.findAccountById(accountNo);
		if(account!=null)
		{
		
				account.setOpeningBalance(account.getOpeningBalance()+amount_deposit);
			
		}
		else
	     throw new AccountNotFound("Sorry!account id does not exist");
		
		
		 account= accountDao.deposit(accountNo, amount_deposit);
		return account;
	}

	/*@Override
	public Account updateBalance(int accountNo, double amount) {
		
			
			return accountDao.updateBalance(accountNo, amount);
		
	}*/

}

