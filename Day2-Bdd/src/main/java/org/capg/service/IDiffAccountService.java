package org.capg.service;

import org.capg.model.Account;
import org.capg.model.Customer;

public interface IDiffAccountService {
 public Account createAccount(Customer customer,double openingBalance);
}
