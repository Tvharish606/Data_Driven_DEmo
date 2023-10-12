package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_report
{
	public static ExtentReports getExtentReport()
	{
		String ExtentReport_path=System.getProperty("user.dir")+"\\Reports\\Extent_report.html";
		ExtentSparkReporter Spark_reporter=new ExtentSparkReporter(ExtentReport_path);
		Spark_reporter.config().setReportName("Tutorialninja automation results");
		Spark_reporter.config().setDocumentTitle("Tutorialninja Test automation results");
		
		ExtentReports Extentrep=new ExtentReports();
		Extentrep.attachReporter(Spark_reporter);
		Extentrep.setSystemInfo("Selenium_version","4.27.0");
		Extentrep.setSystemInfo("operating system","windows 11");
		Extentrep.setSystemInfo("Excuted By","Haris.v");
		return Extentrep;
		
	}         
}

