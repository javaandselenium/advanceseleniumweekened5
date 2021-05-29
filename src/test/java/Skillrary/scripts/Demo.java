package Skillrary.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Skillrary.genericLibraries.AutoConstant;
import Skillrary.genericLibraries.BaseClass;
import Skillrray.PomPages.EmpDetailsPage;

public class Demo extends BaseClass{

	@Test
	public void details() throws IOException, InterruptedException {
		EmpDetailsPage e=new EmpDetailsPage(driver);
		e.emploginDetails("jghj","fhsgfgh","fhjf","fbzh","fhg");
	
		Thread.sleep(5000);
		e.upload(utilies.autoIt(utilies.autoIt(AutoConstant.exepath)));
		Thread.sleep(3000);
		

}
}