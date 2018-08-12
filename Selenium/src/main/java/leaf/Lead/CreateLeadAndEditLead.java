package leaf.Lead;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class CreateLeadAndEditLead extends Annotations{

	private WebElement subBtn;

	@Test
	public void createLead() throws InterruptedException {	

		click(locateElement("linkText", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), "TestLeaf");
		type(locateElement("id", "createLeadForm_firstName"), "Gopinath");
		type(locateElement("id", "createLeadForm_lastName"), "Jayakumar");
		type(locateElement("id", "createLeadForm_primaryEmail"), "gopinath@testleaf.com");
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), "9597704568");
		Thread.sleep(3000);
		click( locateElement("xptah","//input[@value='Create Lead']"));	
		

	}
	
	@Test(enabled=true)
	public void editLead() throws InterruptedException {
		
		click(locateElement("linkText", "Leads"));
		click(locateElement("linkText", "Find Leads"));
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), "Gopinath");
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		Thread.sleep(3000);
		String txt = getText(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		verifyTitle("View Lead | opentaps CRM");
		click(locateElement("linkText", "Delete"));
		
		click(locateElement("linkText", "Find Leads"));
		type(locateElement("xpath", "//label[contains(text(),'Lead ID:')]/following::input"), txt);
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		verifyPartialText(locateElement("xpath", "//div[@class='x-paging-info']"), "No records to display");		
	}

	}


