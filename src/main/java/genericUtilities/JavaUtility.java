package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class consist of generic method related to java
 * @author Loges
 *
 */

public class JavaUtility {
	
	/**
	 * this method will generate random no for every run and return it to caller
	 * @return
	 */
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int R1 = r.nextInt(1000);
		return R1;
		
	}
	
	/**
	 * this method is used the capture the current system date & time in required format 
	 * @return
	 */
	
	public String getSystemDate()
	
	
	{
		Date d = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formater.format(d);
		return date;
	}

}
