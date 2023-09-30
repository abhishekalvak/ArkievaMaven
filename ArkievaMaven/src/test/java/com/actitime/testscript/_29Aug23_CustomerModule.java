package com.actitime.testscript;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class _29Aug23_CustomerModule {

	@Test(priority=3,invocationCount=2)
	public static void createCustomer()
	{
		Reporter.log("create customer",true);
	}
	
	@Test(priority=7,invocationCount=3,dependsOnMethods="createCustomer")
	public void modifyCustomer()
	{
		Reporter.log("modify customer",true);
	}
	
	@Test(priority=10,dependsOnMethods= {"createCustomer","modifyCustomer"})
	public static void deleteCustomer()
	{
		Reporter.log("delete customer",true);
	}
}

