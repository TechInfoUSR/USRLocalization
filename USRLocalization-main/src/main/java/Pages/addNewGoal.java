package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utils.ElementUtil;

public class addNewGoal {
	private WebDriver driver;
	private ElementUtil elementUtil;

	
	public addNewGoal(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private WebElement getADDNEWKRA(String ADDNEWKRAvalue) {
		String contactXpathValue = "//span[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isADDNEWKRA(String ADDNEWKRATestValue) {
		driver.findElement(By.xpath("//span[contains(text(),'ADD NEW KRA')]")).click();
		String contact = getADDNEWKRA(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getADDNEWKRA(ADDNEWKRATestValue).isDisplayed();
	}
	private WebElement getPersonalKRA(String ADDNEWKRAvalue) {
		String contactXpathValue = "//a[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isPersonalKRA(String ADDNEWKRATestValue) {
		
		String contact = getPersonalKRA(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getPersonalKRA(ADDNEWKRATestValue).isDisplayed();
	}
	private WebElement getOrgKRA(String ADDNEWKRAvalue) {
	
		String contactXpathValue = "//a[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isOrgKRA(String ADDNEWKRATestValue) {
		String contact = getOrgKRA(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getOrgKRA(ADDNEWKRATestValue).isDisplayed();
	}
	private WebElement getSampleKRA(String ADDNEWKRAvalue) {
		String contactXpathValue = "//a[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isSampleKRA(String ADDNEWKRATestValue) {
		String contact = getSampleKRA(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getSampleKRA(ADDNEWKRATestValue).isDisplayed();
	}
	private WebElement getupload(String ADDNEWKRAvalue) {
		String contactXpathValue = "//a[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isupload(String ADDNEWKRATestValue) {
		String contact = getupload(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getupload(ADDNEWKRATestValue).isDisplayed();
	}
	private WebElement getclone(String ADDNEWKRAvalue) {
		String contactXpathValue = "//a[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isclone(String ADDNEWKRATestValue) {
		String contact = getclone(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getclone(ADDNEWKRATestValue).isDisplayed();
	}
	private WebElement getAI(String ADDNEWKRAvalue) {
		String contactXpathValue = "//a[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isAI(String ADDNEWKRATestValue) {
		String contact = getAI(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getAI(ADDNEWKRATestValue).isDisplayed();
	}
	
	private WebElement getKPI(String ADDNEWKRAvalue) {
		driver.findElement(By.xpath("//span[contains(text(),'ADD NEW KRA')]")).click();
		String contactXpathValue = "//label[contains(text(),'"+ADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isKPI(String ADDNEWKRATestValue) {
		String contact = getKPI(ADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getKPI(ADDNEWKRATestValue).isDisplayed();
	}
	
	
	
	
	
	

	
	
	
}
