package Pratice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step - 1 open the doc in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		
		//Step - 2 Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step-3 navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Step-4 navigate to required row
		Row rw = sh.getRow(0);
		
		//Step-5 navigate to required cell
		Cell c = rw.getCell(0);
		
		//Step-6 capture the value and print
		String value = c.getStringCellValue();
		System.out.println(value);
		
		
	}

}
