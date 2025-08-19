package normalFlow_BaseClasses;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addGoalPlan {
     WebDriver driver;

    public addGoalPlan(WebDriver driver) {
        this.driver = driver;
    }
    private By usernameField = By.xpath("//input[@name=\"username\"]");
    private By passwordField = By.xpath("//input[@name=\"password\"]");
    private By loginButton = By.xpath("//button[@type=\"submit\"]");
    private By goalPlanManagementLink = By.xpath("//h3[contains(text(),'Goal Time Period Plan Management')]");
    private By addGoalPlanButton = By.id("addGoalPlan");
    private By goalPlanNameField = By.xpath("//input[@id='goalPlanName']");
    private By datepickerSwitch = By.xpath("//th[@class=\"datepicker-switch\"]");
    private By nextMonthButton = By.xpath("//th[@class=\"next\"]");
    private By ratingScaleField = By.xpath("//input[@placeholder=\"Select Rating Scale\"]");
    private By ratingScaleDropdown = By.xpath("//div[@class=\"selectize-dropdown-content\"]");
    private By groupRadioButton = By.xpath("//input[@id=\"selectGroupRadio\"]");
    private By empGroupField = By.xpath("//input[@placeholder=\"Select Target Employees Group for this Plan\"]");
    private By isActiveCheckbox = By.id("isActive");
    private By isWeightageBasedCheckbox = By.xpath("//input[@id=\"isWeightageBased\"]");
    private By submitButton = By.xpath("//button[@id=\"submit_btn_action\"]");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }



    public void addGoalPlan1(String goalPlanName, String empGroup,String RatingScale) throws InterruptedException
    {
        JavascriptExecutor Srollup = (JavascriptExecutor) driver;
        Srollup.executeScript("window.scrollBy(0,1600)");
        Thread.sleep(2000);
        driver.findElement(goalPlanManagementLink).click();
        Thread.sleep(2000);
        driver.findElement(addGoalPlanButton).click();
        Thread.sleep(2000);
        driver.findElement(goalPlanNameField).sendKeys(goalPlanName);
        Thread.sleep(500);

        // Select start date
        LocalDate currentDate = LocalDate.now();
        
        // Create a formatter for "MMMM yyyy" (e.g., January 2025)
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");

        // Print the current month
        String formattedDate1 = currentDate.format(monthYearFormatter);
        String formattedDay = currentDate.format(dayFormatter);
 
        driver.findElement(By.xpath("//input[@class=\"form-control dpd1\"]")).click();
        
        selectDate(formattedDate1,formattedDay);
        
        // Select end date
        
        LocalDate thirdMonth = currentDate.plusMonths(3);
        String Third_Month_Year = thirdMonth.format(monthYearFormatter);
        String Third_MonthDATE = thirdMonth.format(dayFormatter);
        
        driver.findElement(By.xpath("//input[@class=\"form-control dpd2\"]")).click();
        selectDate(Third_Month_Year, Third_MonthDATE);
        Srollup.executeScript("window.scrollBy(0,800)");
        // Select rating scale
        driver.findElement(ratingScaleField).sendKeys(RatingScale);
        Thread.sleep(2000);
        driver.findElement(ratingScaleDropdown).click();
        Thread.sleep(1000);
        // Select employee group
        Srollup.executeScript("window.scrollBy(0,1000)");
        driver.findElement(groupRadioButton).click();
        Thread.sleep(2000);
        driver.findElement(empGroupField).sendKeys(empGroup);
        Thread.sleep(3000);



        WebElement element = driver.findElement(By.cssSelector("span.name"));
        if (element.getText().contains(empGroup)) {
        	
            System.out.println(element.getText());
            element.click();
        }
        Thread.sleep(2000);

        
//        String empgruop = driver.findElement(By.xpath("//*[@id=\"selectGroupDropDiv\"]/div/div/div[1]/div/span/span")).getText();
//        if (empgruop != empGroup) 
//        {
//        	driver.findElement(empGroupField).sendKeys(empGroup);	
//        driver.findElement(By.xpath("//span[@class='highlight' and contains(text(), '" + empGroup + "')]")).click();
//        Thread.sleep(2000);
//        }

        Thread.sleep(2000);
        driver.findElement(isWeightageBasedCheckbox).click();
        Thread.sleep(2000);

        Srollup.executeScript("window.scrollBy(0,1500)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement enabled = wait.until(ExpectedConditions.visibilityOfElementLocated(isActiveCheckbox));
        System.out.println(enabled);
//        driver.findElement(isActiveCheckbox).click();
        Thread.sleep(1000);

   
        driver.findElement(submitButton).click();
        Thread.sleep(5000);
    }

    private void selectDate(String month, String day) throws InterruptedException 
    {
        String displayedMonth = driver.findElement(datepickerSwitch).getText();
        while (!displayedMonth.equals(month)) 
        {
            driver.findElement(nextMonthButton).click();
            displayedMonth = driver.findElement(datepickerSwitch).getText();
            Thread.sleep(100);
        }
        driver.findElement(By.xpath("//td[@class='day' and text()='" + day + "']")).click();
        Thread.sleep(100);
    }

    public String isGoalPlanDisplayed(String goalPlanName) 
    {
        return driver.findElement(By.xpath("//td[contains(text(),'" + goalPlanName + "')]")).getText();
    
   
    }  
    
}