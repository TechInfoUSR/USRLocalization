package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	private WebElement getHeaderElement(String EmpMyPMS) {
		String headerXpathValue = "//h1[contains(text(),'"+EmpMyPMS+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	//span[contains(text(),'My PMS')]
	public boolean isHeaderExist(String headerValue) {
		String header = getHeaderElement(headerValue).getText();
		System.out.println(header);
		return getHeaderElement(headerValue).isDisplayed();
	}
	
	private WebElement getContactElement(String EmpPolicyDocs) {
		String contactXpathValue = "//span[contains(text(),'"+EmpPolicyDocs+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isContactExist(String contactValue) {
		String contact = getContactElement(contactValue).getText();
		System.out.println(contact);
		return getContactElement(contactValue).isDisplayed();
	}
	private WebElement getEmpstatusTest(String EmpstatusTest) {
		String contactXpathValue = "//span[contains(text(),'"+EmpstatusTest+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpstatusTest(String EmpstatusTestValue) {
		String contact = getEmpstatusTest(EmpstatusTestValue).getText();
		System.out.println(contact);
		return getEmpstatusTest(EmpstatusTestValue).isDisplayed();
	}
	

}