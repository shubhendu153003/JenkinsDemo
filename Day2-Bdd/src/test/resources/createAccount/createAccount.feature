@account
Feature: Create New Account
  I want to use this template for my feature file

  Scenario: For valid customer create new Account
    Given customer details
    When Valid Customer
    And valid opening balance
    Then craete new Account
  
   Scenario: For Invalid customer
    For invalid customer details throw error message
    Given Customer details
    When Invalid Customer
    Then throw 'Invalid Customer' error message
    
   Scenario: For Invalid Opening Balance
    For invalid opening balance throw error message
    Given Customer details and openingbalance
    When Invalid opening balance
    Then throw 'insufficient Balance' error message
   
   Scenario: Find Account Details
    Find account details for the given account number
    Given Account number
    When valid Account number
    Then find account details
    
  Scenario: Withdraw Amount from Account
    Find account details and withdraw money
    Given Account number 1001 and amount 1000
    When Find account and do withdraw
    Then Update the account details 
    
  Scenario: Deposit Amount into Account
    Find account details and deposit money
    Given Account number is 1001 and amount is 3000
    When Find account and do deposit
    Then Update given account details 
    
  
    
    
   
     