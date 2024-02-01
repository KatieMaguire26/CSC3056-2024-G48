package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void main(String[] args) {
		testUserConstructor();
		//User testUser = new User("mike", "my_password", "Mike", "Smith", "07771234567");
		
		//System.out.println(testUser);

	}
	
	public static void testUserConstructor() {
		String test_username = "mike";
		String test_password = "my_password";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";
		
		User testUser = new User(test_username,test_password,test_first_name,test_last_name,test_mobile_number);
		
		if(testUser.getUsername()== test_username)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC1 failed: username did not match" + TestUtils.TEXT_COLOR_RESET);
	
			if(testUser.getPassword()== test_password)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
		
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC2 failed: password did not match" + TestUtils.TEXT_COLOR_RESET);
			
			if(testUser.getFirst_name()== test_first_name)
				System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
			
			else
				System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC3 failed: first name did not match" + TestUtils.TEXT_COLOR_RESET);
			
			if(testUser.getLast_name()== test_last_name)
				System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
			
			else
				System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC4 failed: last name did not match" + TestUtils.TEXT_COLOR_RESET);
			
			if(testUser.getMobile_number()== test_mobile_number)
				System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC5 passed" + TestUtils.TEXT_COLOR_RESET);
			
			else
				System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC5 failed: mobile number did not match" + TestUtils.TEXT_COLOR_RESET);
	}

}
