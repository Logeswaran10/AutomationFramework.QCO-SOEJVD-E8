package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consist of generic method related to excel file
 * @author loges
 *
 */

public class ExcelFileUtility {
	
	/**
	 * this method will read data from excel and return it to caller
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String SheetName, int rowNo ,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
		
		
	}
	/**
	 * this method will read multiple data from excel sheet at time used for dataprovider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int LASTROW = sh.getLastRowNum();
		int LASTCELL = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[LASTROW][LASTCELL];
		
		for(int i=0;i<LASTROW;i++)
		{
			for(int j=0;j<LASTCELL;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
		
		
		
		
		
	}

}
