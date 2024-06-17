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
	private WebElement getOrganization(String Organizationvalue) {
		driver.findElement(By.xpath("//a[@data-target='#second']")).click();
		WebElement selectlevel = driver.findElement(By.id("selectlevel"));
		Select level_select=new Select(selectlevel) ;
		 level_select.selectByVisibleText("Organization");
		String contactXpathValue = "//select[@id='selectlevel']";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isOrganization(String OrganizationTestValue) {
		String contact = getOrganization(OrganizationTestValue).getText();
		System.out.println(contact);
		return getOrganization(OrganizationTestValue).isDisplayed();
	}
	private WebElement getManualupdate(String EmpstatusTest) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(text(),'ADD NEW KRA')]")).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"tab_default_11\"]/form/div[4]/div[1]/div[1]/div[1]/a")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(@id,'select2-connectionId-container')]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//li[contains(text(),'"+EmpstatusTest+"')] ")).click();
		String contactXpathValue = "//span[contains(text(),'"+EmpstatusTest+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isManualupdate(String EmpstatusTestValue) {
		String contact = getManualupdate(EmpstatusTestValue).getText();
		System.out.println(contact);
		return getManualupdate(EmpstatusTestValue).isDisplayed();
	}

}
