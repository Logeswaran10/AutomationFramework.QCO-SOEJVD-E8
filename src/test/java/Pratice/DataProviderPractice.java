package Pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void addProductToCart(String Name , int Price , int Quantity , String ModelName)
	
	
	{
		System.out.println("Phone Name "+Name + " Price " +Price + " Quantity "+Quantity +" Model "+ModelName);
	}
	
	@DataProvider
	public Object[][] getData()
	{							// row col
		Object[][] data = new Object[3][4]; // 3 set of data with 4 details in each set
		
		data[0][0]= "Iphone";
		data[0][1]= 10000;
		data[0][2]= 20;
		data[0][3] = "XR";
		
		data[1][0]= "Nokia";
		data[1][1]= 15000;
		data[1][2]= 10;
		data[1][3] = "C1";
		
		
		data[2][0]= "Realme";
		data[2][1]= 20000;
		data[2][2]= 25;
		data[2][3] = "X7";
		
		return data;
		
	}

}
