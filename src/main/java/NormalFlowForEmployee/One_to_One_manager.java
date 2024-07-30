package NormalFlowForEmployee;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class One_to_One_manager 
{
    private WebDriver driver;
    private Properties prop;
    
    private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
    private By avatarIcon = By.xpath("//a[@class='avatar-sec header-icon']");
    private By employeeName = By.xpath("//span[contains(text(),'Ranganath ')]");
    private By goalCycleLink(String cycleName) 
    {
        return By.xpath("//a[contains(text(),'" + cycleName + "')]");
    }
    public One_to_One_manager(WebDriver driver, Properties prop) 
    {
        this.driver = driver;
        this.prop = prop;
    }

    
    
    
    public void selectGoalCycle(String cycleName) throws InterruptedException 
    {
        driver.findElement(dropdownToggle).click();
        Thread.sleep(2000);
        driver.findElement(goalCycleLink(cycleName)).click();
        Thread.sleep(1000);
    }
    
    public void navigateToEmployeeSelf() throws InterruptedException 
    {
//        driver.findElement(avatarIcon).click();
        driver.findElement(employeeName).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[6]/textarea")).sendKeys("1:1 meeting comment");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class=\"btn checkin-btn block-btn\"])[1]")).click();
        Thread.sleep(2000);
    
    }
    
}
