package Pratice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPratice {
	
	@Test
	public void pratice()
	{
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(false, false); // 1==1 // if it failed the execution will be terminated here after no line will executed
		
		System.out.println("Step 3");
		
		
		
		
		
		
	}

	
	
	@Test
	public void pratice1()
	{
		SoftAssert sa =new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		sa.assertEquals(true, false); // 1==1
		
		System.out.println("Step 3");
		sa.assertAll();
		
		Assert.assertEquals(true, false);// after assert all no line will get executed
		
	}

}
