package week5.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CreateLead  {
	public static WebDriver dr;
	private ExtentTest suiteTest;
	private ExtentTest test;

	@Test
	public void login() throws InterruptedException, IOException {


		//@BeforeSuite
		ExtentHtmlReporter html=new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);

		ExtentReports extent =new ExtentReports();
		extent.attachReporter(html);
		//@BeforeTest->
		String testcaseName="TC001";
		String testcaseDesc="create a new lead in leaftaps";
		//@BeforeClass
		suiteTest = extent.createTest(testcaseName, testcaseDesc);
		//@BeforeMethod
		test = suiteTest.createNode("Leads");


		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		dr= new ChromeDriver(); 
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("http://leaftaps.com/opentaps/");
		test.pass("The browser: chrome launched successfully",
				MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/createlead.png").build());
		dr.findElement(By.id("username")).sendKeys("DemoSalesManager1");
		test.fail("The username entered successfully with data - DemoSalesManager1",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/fail.png").build());
		WebElement password=dr.findElement(By.id("password"));

		password.sendKeys("crmsfa");
		dr.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
		dr.findElement(By.linkText("CRM/SFA")).click();
		dr.findElement(By.xpath("//a[text()='Create Lead']")).click();
		dr.findElement(By.id("createLeadForm_companyName")).sendKeys("Binodini Enterprises");
		dr.findElement(By.id("createLeadForm_firstName")).sendKeys("Binodini");
		dr.findElement(By.id("createLeadForm_lastName")).sendKeys("Sahoo");
		dr.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9877156342");
		dr.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("binukunu@gmail.com");
		dr.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600100");
		dr.findElement(By.name("submitButton")).click();



		File src = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/createlead.png");
		FileUtils.copyFile(src, desc);
		//@AfterSuite
		extent.flush();
	}






}






