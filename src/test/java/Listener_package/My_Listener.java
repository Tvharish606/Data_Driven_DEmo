package Listener_package;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Util.Extent_report;

public class My_Listener implements ITestListener
{
	ExtentReports Extentrep=Extent_report.getExtentReport();
	ExtentTest Extenttest;

	@Override
	public void onTestStart(ITestResult result) 
	{
		Extenttest = Extentrep.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		Extenttest.log(Status.PASS,"Testcase is passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		Extenttest.log(Status.FAIL,"testcase is failed");
		Extenttest.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Extentrep.flush();
	}
	
}
