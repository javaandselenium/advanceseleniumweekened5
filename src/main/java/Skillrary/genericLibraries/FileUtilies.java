package Skillrary.genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author QSP
 *
 */
public class FileUtilies  {
	
	
	public static Connection con;
	/**
	 * Read the data from property file
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	
	public String getPropertyData(String key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.propertyfilePath));
		return p.getProperty(key);
	}
	
	
	public String getExceldata(String name,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream f=new FileInputStream(AutoConstant.excelFilepath);
		Workbook wb = WorkbookFactory.create(f);
		String s = wb.getSheet(name).getRow(rownum).getCell(cellnum).getStringCellValue();
		return s;
	}
	
	public static Connection getdatabd() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		return con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skillrary","root","root");
	}
	
	public static String queryExecution(String query,String col,String expdata) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(col).equals(expdata)) {
				break;
			}
			else
			{
				Reporter.log("data is not mataching",true);
			}
		}
		return expdata;
	}
		
	public static void closedab() throws SQLException {
		con.close();
	}
		
		
		
		
	}