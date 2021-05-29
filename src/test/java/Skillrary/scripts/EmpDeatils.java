package Skillrary.scripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Skillrary.genericLibraries.AutoConstant;
import Skillrary.genericLibraries.BaseClass;
import Skillrary.genericLibraries.Excelutilies;
import Skillrary.genericLibraries.FileUtilies;
import Skillrray.PomPages.EmpDetailsPage;

public class EmpDeatils extends Excelutilies{
	
	@Test(dataProvider = "readData")
	public void details(String fname,String lname,String emailid,String pass,String contactnum) throws IOException, InterruptedException {
		EmpDetailsPage e=new EmpDetailsPage(driver);
		e.emploginDetails(fname, lname, emailid, pass, contactnum);
	
	
		
		
	}}