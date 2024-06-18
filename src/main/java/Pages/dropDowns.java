package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utils.ElementUtil;

public class dropDowns {
	private WebDriver driver;
	private ElementUtil elementUtil;

	
	public dropDowns(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	private WebElement getEmpOrganization(String Organizationvalue) {

		String contactXpathValue = "//select[@id='selectlevel']/option[text()='"+Organizationvalue+"']";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isEmpOrganization(String OrganizationTestValue) {
		String contact = getEmpOrganization(OrganizationTestValue).getText();
		System.out.println(contact);
		return getEmpOrganization(OrganizationTestValue).isDisplayed();
	}
	private WebElement getEmpPersonalgoal(String Personalgoalvalue) {

		String contactXpathValue = "//select[@id='selectlevel']/option[text()='"+Personalgoalvalue+"']";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isEmpPersonalgoal(String PersonalgoalTestValue) {
		String contact = getEmpPersonalgoal(PersonalgoalTestValue).getText();
		System.out.println(contact);
		return getEmpPersonalgoal(PersonalgoalTestValue).isDisplayed();
	}
	private WebElement getEmpDepartment(String EmpDepartmentvalue) {

		String contactXpathValue = "//select[@id='selectlevel']/option[normalize-space()='"+EmpDepartmentvalue +"']";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isEmpDepartment(String EmpDepartmentTestValue) {
		String contact = getEmpDepartment(EmpDepartmentTestValue).getText();
		System.out.println(contact);
		return getEmpDepartment(EmpDepartmentTestValue).isDisplayed();
	}

	
	private WebElement getManualupdate(String ManualupdateTest) {
	String contactXpathValue = "//span[contains(text(),"+ManualupdateTest+")]";
	return elementUtil.getElement("xpath", contactXpathValue);
}

public boolean isManualupdate(String ManualupdateTestValue) {
	String contact = getManualupdate(ManualupdateTestValue).getText();
	System.out.println(contact);
	return getManualupdate(ManualupdateTestValue).isDisplayed();
}
private WebElement getManualandaverage(String ManualupdateTest) {
String contactXpathValue = "//span[contains(text(),"+ManualupdateTest+")]";
return elementUtil.getElement("xpath", contactXpathValue);
}

public boolean isManualandaverage(String ManualupdateTestValue) {
String contact = getManualandaverage(ManualupdateTestValue).getText();
System.out.println(contact);
return getManualandaverage(ManualupdateTestValue).isDisplayed();
}
private WebElement getManualandweightedaveragefromkeyresults(String ManualupdateTest) {
String contactXpathValue = "//span[contains(text(),"+ManualupdateTest+")]";
return elementUtil.getElement("xpath", contactXpathValue);
}

public boolean isManualandweightedaveragefromkeyresults(String ManualupdateTestValue) {
String contact = getManualandweightedaveragefromkeyresults(ManualupdateTestValue).getText();
System.out.println(contact);
return getManualandweightedaveragefromkeyresults(ManualupdateTestValue).isDisplayed();
}
private WebElement getManualandsummationfromkeyresults(String ManualupdateTest) {
String contactXpathValue = "//span[contains(text(),"+ManualupdateTest+")]";
return elementUtil.getElement("xpath", contactXpathValue);
}

public boolean isManualandsummationfromkeyresults(String ManualupdateTestValue) {
String contact = getManualandsummationfromkeyresults(ManualupdateTestValue).getText();
System.out.println(contact);
return getManualandsummationfromkeyresults(ManualupdateTestValue).isDisplayed();
}

}







