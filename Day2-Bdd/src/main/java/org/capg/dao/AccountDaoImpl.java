package org.capg.dao;
import java.sql.*;

import org.capg.exception.AccountNotFound;
import org.capg.exception.InSufficientBalance;
import org.capg.model.Account;
import org.capg.util.AccountUtil;

public class AccountDaoImpl implements IAccountDao{

	@Override
	public boolean addAccount(Account account) {
		
		
		String sql="insert into account values(?,?,?)";
		try
		{
			PreparedStatement pst=getMySQLConnection().prepareStatement(sql);
			//System.out.println("Account No is:"+ account.getOpeningBalance());
			//System.out.println("Account No is:"+ account.getAccountNo());
			pst.setInt(1, account.getAccountNo());
			//System.out.println("Account No is:"+ account.getOpeningBalance());
			pst.setDouble(2, account.getOpeningBalance());
			pst.setString(3, account.getCustomer().getFirstName());
			
			int count=pst.executeUpdate();
			if(count>0)
				return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	private Connection getMySQLConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","India123");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public Account findAccountById(int accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdraw(int accountNo, double amount_withdraw) throws AccountNotFound, InSufficientBalance {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(int accountNo, double amount_withdraw) throws AccountNotFound, InSufficientBalance {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Account updateBalance(int accountNo, double amount) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
