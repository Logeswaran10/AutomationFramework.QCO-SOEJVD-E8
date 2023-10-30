package Pratice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPratice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PropertyFileUtility putil = new PropertyFileUtility();
		String URL = putil.readDataFromPropertyFile("Url");
		System.out.println(URL);

		String Browser = putil.readDataFromPropertyFile("Browser");
		System.out.println(Browser);

		ExcelFileUtility eutil = new ExcelFileUtility();
		String data = eutil.readDataFromExcel("Contacts", 1, 2);
		System.out.println(data);

		JavaUtility jutil = new JavaUtility();
		int r = jutil.getRandomNumber();
		System.out.println(r);

		String date = jutil.getSystemDate();
		System.out.println(date);

	}

}
