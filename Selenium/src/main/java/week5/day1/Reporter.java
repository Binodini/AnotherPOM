package week5.day1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {
	public ExtentReports extent;
	public ExtentTest suiteTest ,test;
	@BeforeSuite
	public void beingResult() {
	ExtentHtmlReporter html=new ExtentHtmlReporter("./reports/result.html");
	html.setAppendExisting(true);
	ExtentReports extent =new ExtentReports();
	extent.attachReporter(html);
	}
	
	@BeforeClass
	public ExtentTest startTest(String testCaseName, String testDescription) {
		suiteTest=extent.createTest(testCaseName, testDescription);
		return suiteTest;
	}

	// This method create entry for every test case iteration
	@BeforeMethod
	public ExtentTest startTestIteration(String iteration) {	
		 test = suiteTest.createNode("Leads");
		return test;
	}

	// This method create entry for every step
	public void reportStep(String desc,String status) {
		if (status.equalsIgnoreCase("pass")) {
			test.pass(desc);
		} else if (status.equalsIgnoreCase("fail")) {
			test.fail(desc);
		}else if (status.equalsIgnoreCase("warning")) {
			test.warning(desc);
		}
	}

	// This method create the html report finally
	public void endResult() {
		extent.flush();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
