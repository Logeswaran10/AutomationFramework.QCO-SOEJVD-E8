package Pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPratice {

	
	
		@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
		public void analyzerPratcie()
		{
			Assert.fail();
			System.out.println("Hi");
		}

	}

	

