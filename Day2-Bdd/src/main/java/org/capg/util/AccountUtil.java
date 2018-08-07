package org.capg.util;

public class AccountUtil {
public static int accountNo=0;
 public static int generateAccountNo()
 {
	 return ++accountNo;
 }
}
