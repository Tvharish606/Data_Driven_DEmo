package Test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_package.Base_class;
import Util.DataUtil;
import Util.My_Xls_reader;

public class Login extends Base_class
{
	WebDriver driver;
	My_Xls_reader excel_reader;
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(dataProvider = "datasupplier")
	public void Test_login(HashMap<String,String>hmap) throws InterruptedException
	{
		if(!DataUtil.isRunnable(excel_reader,"Login_funcationality","Testcases")||hmap.get("Runmode").equals("N"))
		{
			throw new SkipException("Runnable method is set to N,hence not excuted");
		}
		driver=open_browser(hmap.get("Browser"));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(hmap.get("Username"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(hmap.get("Password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String Excepted_res=hmap.get("Excepted_results");
		Boolean Excepted_converted_result=null;
		
		if(Excepted_res.equalsIgnoreCase("success"))
		{
			Excepted_converted_result=true;
		}
		else if(Excepted_res.equalsIgnoreCase("failure"))
		{
			Excepted_converted_result=false;
		}
		boolean Actual_result=false;
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		WebElement Logout_element = driver.findElement(By.xpath("(//a[text()='Logout'])[1]"));
		try {
		 Actual_result = Logout_element.isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Assert.assertEquals(Excepted_converted_result,Actual_result);
		
	
	}  
	@DataProvider
	public Object[][] datasupplier() 
	{
		Object[][]data = null;
		try
		{
			excel_reader=new My_Xls_reader("src//test/resources//Ninjatutorial.xlsx");
		
		data=DataUtil.getTestData(excel_reader,"Login_funcationality","Data");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
