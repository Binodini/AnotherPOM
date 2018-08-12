package wdMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Annotations extends SeMethods{
	private WebElement mousehoveronicon;
	private WebElement loginbtn;
	private WebElement username;
	private WebElement password;
	private WebElement loginBtn;
	
	
	private WebElement userName;
	private WebElement passWd;
	private WebElement submit;
	private WebElement clickcrmSfa;

	@Parameters({"url","uName","pword"})
	@BeforeMethod() //groups={"sanity"}
		public void login(String url,String uName, String pword){
		startApp("chrome", url);
		 userName = locateElement("id","username");
		 userName.sendKeys(uName);
		 passWd = locateElement("id","password");
		 passWd.sendKeys(pword);
		 submit = locateElement("class","decorativeSubmit");
		 click(submit);
		 clickcrmSfa = locateElement("linkText","CRM/SFA");
		 clickcrmSfa.click();
		 
		 
//		startApp("chrome", "https://www.myntra.com/");
//		mousehoveronicon = locateElement("xpath","//span[@class='myntraweb-sprite desktop-iconUser sprites-user']");
//		Actions builder=new Actions(driver);
//		builder.moveToElement(mousehoveronicon).click().perform();
//		//		signinbtn = locateElement("xpath","//a[@class='desktop-linkButton']");
//		//		click(signinbtn);
//		loginbtn = locateElement("xpath","(//a[@class='desktop-linkButton'])[2]");
//		click(loginbtn);
//		username = locateElement("xpath","//input[@name='email']");
//		username.sendKeys("binodini.sahoo@gmail.com");
//		password = locateElement("xpath","//input[@name='password']");
//		password.sendKeys("luckyb241");
//
//		loginBtn = locateElement("xpath","//button[text()='Log in']");
//		click(loginBtn);
	}
	@AfterMethod() //groups={"smoke"}
	public void closeApp(){
		 closeBrowser();
		
		
	}
	
	

}
