package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {

	//TODO5
    public static void testConstructor() {
        String test_account_number = "45";
        String test_username_of_account_holder = "mike";
        String test_account_type = "Standard";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date test_account_opening_date = null; // Declare the variable outside the try block

        try {
            test_account_opening_date = dateFormat.parse("01-02-2024");
        } catch (ParseException e) {
            e.printStackTrace();
        }

      
        Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type, test_account_opening_date);
        
        if(testAccount.getAccount_number()== test_account_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC1 failed: test account number did not match" + TestUtils.TEXT_COLOR_RESET);
	
			if(testAccount.getUsername_of_account_holder()== test_username_of_account_holder)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
		
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC2 failed: username of account holder did not match" + TestUtils.TEXT_COLOR_RESET);
			
			if(testAccount.getAccount_type()== test_account_type)
				System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
			
			else
				System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC3 failed: test account type did not match" + TestUtils.TEXT_COLOR_RESET);
			
			if(testAccount.getAccount_opening_date()== test_account_opening_date)
				System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
			
			else
				System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC4 failed: account opening date did not match" + TestUtils.TEXT_COLOR_RESET);
			
			}
  //TODO5
    public static void testSetters() {
    	String test_account_number = "45";
        String test_username_of_account_holder = "mike";
        String test_account_type = "Standard";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date test_account_opening_date = null;

        try {
            test_account_opening_date = dateFormat.parse("01-02-2024");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type, test_account_opening_date);
        
     // Test setters
        String new_account_number = "46";
        testAccount.setAccount_number(new_account_number);
        if (testAccount.getAccount_number().equals(new_account_number))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetter-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetter-TC1 failed: account number did not match" + TestUtils.TEXT_COLOR_RESET);

        String new_username = "john";
        testAccount.setUsername_of_account_holder(new_username);
        if (testAccount.getUsername_of_account_holder().equals(new_username))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetter-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetter-TC2 failed: username of account holder did not match" + TestUtils.TEXT_COLOR_RESET);

        String new_account_type = "Saving";
        testAccount.setAccount_type(new_account_type);
        if (testAccount.getAccount_type().equals(new_account_type))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetter-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetter-TC3 failed: test account type did not match" + TestUtils.TEXT_COLOR_RESET);

        Date new_account_opening_date = new Date();
        testAccount.setAccount_opening_date(new_account_opening_date);
        if (testAccount.getAccount_opening_date().equals(new_account_opening_date))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestSetter-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TestSetter-TC4 failed: account opening date did not match" + TestUtils.TEXT_COLOR_RESET);
    }
    
    public static void main(String[] args) throws ParseException {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Date date = dateFormat.parse("01-02-2024");

        //Account testAccount = new Account("45", "mike", "Standard", date);

        //System.out.println(testAccount);
    	
    	//TODO5
    	testConstructor();
    	testSetters();
    }
}
