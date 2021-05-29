package Skillrary.genericLibraries;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Excelutilies extends BaseClass{
	@DataProvider
	public Object[][] readData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream f=new FileInputStream(AutoConstant.excelFilepath);
		Workbook wb = WorkbookFactory.create(f);
		Sheet sh = wb.getSheet("Sheet1");
		int rowNum = sh.getLastRowNum();
		System.out.println(rowNum);
		short cellnum = sh.getRow(1).getLastCellNum();
		System.out.println(cellnum);
		
		Object obj[][]=new Object[rowNum][cellnum];
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<cellnum;j++) {
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
			}
		}
		return obj;
		
		
		
	}
}
