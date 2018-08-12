package leaf.Lead;

import org.testng.annotations.Test;

import wdMethods.Annotations;

public class EditLead extends Annotations{

	/*@Test(dependsOnMethods= {"leaf.Lead.CreateLead.createLead"})*/
	@Test(groups= {"sanity"})
	public void editLead() throws InterruptedException {
		
		click(locateElement("linkText", "Leads"));
		click(locateElement("linkText", "Find Leads"));
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), "TS");
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		Thread.sleep(3000);
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		verifyTitle("View Lead | opentaps CRM");
		click(locateElement("xpath", "//a[contains(text(),'Edit')]"));
		selectDropDownUsingText(locateElement("id", "updateLeadForm_industryEnumId"), "Computer Software");
		click(locateElement("xpath", "//input[@class='smallSubmit']"));			
	}
}
