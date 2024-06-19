package NormalFlowForEmployee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.ElementUtil;

public class Employeepage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public Employeepage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	 public void addGoalPaln() {
		driver.findElement(By.xpath("//h3[contains(text(),'Goal Time Period Plan Management')]")).click();
		
	}
	
}