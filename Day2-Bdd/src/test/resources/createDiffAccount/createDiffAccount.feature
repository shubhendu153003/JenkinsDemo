@account
Feature: Create Different new Account
 create accounts like savings,current,rd and fd
 
 Scenario Outline: Creating different account
     For valid user and valid amount create a new savings account
     Given Customer details and opening balance
     When For valid customer with minimum opening balance <value> 
     Then create new <accountType> account 
     
 Examples:
    | accountType | value |
    | Savings     | 1000  |
    | Current     | 10000 |
    |RD           | 100   |
    |FD           | 500   |