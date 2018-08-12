package copiedfromgithub;



import org.testng.annotations.Test;
import wdMethods.Annotations;

public class CreateLead extends Annotations{

	@Test(invocationCount=2)
	public void createLead() {			
		click(locateElement("linkText", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), "TL");
		type(locateElement("id", "createLeadForm_firstName"), "Babu");
		type(locateElement("id", "createLeadForm_lastName"), "M");
		type(locateElement("id", "createLeadForm_primaryEmail"), "babu@testleaf.com");
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), "9843824324");
		click(locateElement("xpath", "//input[@value='Create Lead']"));			
	}
	

	
	
	
	
}