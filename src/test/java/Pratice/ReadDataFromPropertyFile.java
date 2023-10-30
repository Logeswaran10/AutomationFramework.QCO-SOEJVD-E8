package Pratice;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//step - 1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step - 2:create obj of properties for java.util package
		Properties p = new Properties();
		
		//step - 3: load the file input stream into properties
		p.load(fis);
		
		//step-4 : provide the key and read the value
		String value=p.getProperty("Url");
		System.out.println(value);
		
		

	}

}
