package copiedfromgithub;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateLeadWithReporter extends Reporter{

	ChromeDriver driver;
	@Test
	public void createLead() throws IOException{

		// start report and testcase


		
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/");
			reportStep("The browser: chrome launched successfully", "pass");
		} catch (Exception e) {
			reportStep("The browser: chrome not launched", "fail");
		}
		// Replace the sysout with reporter
		// System.out.println("The browser: chrome launched successfully");

		driver.findElementById("username").sendKeys("DemoSalesManager");

		// Replace the sysout with reporter
		// System.out.println("The username entered successfully with data - DemoSalesManager");

		driver.findElementById("password").sendKeys("crmsfa");
		// Replace the sysout with reporter
		// System.out.println("The password entered successfully with data - crmsfa");

		driver.findElementByClassName("decorativeSubmit").click();
		System.out.println("The Login button clicked");

		driver.findElementByLinkText("CRM/SFA").click();
		System.out.println("The CRM/SFA link clicked");

		driver.findElementByLinkText("Create Lead").click();		
		// Replace the sysout with reporter
		// System.out.println("The Create Lead link clicked");

		/*File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img.png");
		FileUtils.copyFile(src, desc);*/

		

	}
	private void reportStep(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}