package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class will provide implementation to the IRetryAnalyzer interface to TestNG
 * @author loges
 *
 */

public class RetryAnalyzerImplementation implements IRetryAnalyzer {
	
	int count = 0;
	int retrycount =3;

	public boolean retry(ITestResult result) {
		 // 0<3 1<3 3<3 3<3No
		while(count<retrycount)
		{
			count++; // 1  2  3
			return true; // retry retry retry
		}
			
		
		
		
		return false;// stop retrying
	}

}
