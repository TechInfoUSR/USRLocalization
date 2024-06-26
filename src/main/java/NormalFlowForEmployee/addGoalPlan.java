package NormalFlowForEmployee;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addGoalPlan {
    WebDriver driver;

    public addGoalPlan(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//*[@id=\"hello\"]/div[2]/input");
    private By passwordField = By.xpath("//*[@id=\"hello\"]/div[3]/input");
    private By loginButton = By.xpath("//*[@id=\"hello\"]/div[4]/button");
    private By goalPlanManagementLink = By.xpath("//h3[contains(text(),'Goal Time Period Plan Management')]");
    private By addGoalPlanButton = By.id("addGoalPlan");
    private By goalPlanNameField = By.xpath("//input[@id='goalPlanName']");
    private By datepickerSwitch = By.xpath("//th[@class=\"datepicker-switch\"]");
    private By nextMonthButton = By.xpath("//th[@class=\"next\"]");
    private By ratingScaleField = By.xpath("//input[@placeholder=\"Select Rating Scale\"]");
    private By ratingScaleDropdown = By.xpath("//div[@class=\"selectize-dropdown-content\"]");
    private By groupRadioButton = By.xpath("//input[@id=\"selectGroupRadio\"]");
    private By empGroupField = By.xpath("//input[@placeholder=\"Select Target Employees Group for this Plan\"]");
    private By isActiveCheckbox = By.xpath("//input[@id=\"isActive\"]");
    private By isWeightageBasedCheckbox = By.xpath("//input[@id=\"isWeightageBased\"]");
    private By submitButton = By.xpath("//button[@id=\"submit_btn_action\"]");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void addGoalPlan1(String goalPlanName, String empGroup, boolean isWeighted,String RatingScale) throws InterruptedException 
    {
        JavascriptExecutor Srollup = (JavascriptExecutor) driver;
        Srollup.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(2000);
        driver.findElement(goalPlanManagementLink).click();
        Thread.sleep(2000);
        driver.findElement(addGoalPlanButton).click();
        Thread.sleep(2000);
        driver.findElement(goalPlanNameField).sendKeys(goalPlanName);
        Thread.sleep(500);

        // Select start date
        driver.findElement(By.xpath("//input[@class=\"form-control dpd1\"]")).click();
        selectDate("June 2024", "11");

        // Select end date
        driver.findElement(By.xpath("//input[@class=\"form-control dpd2\"]")).click();
        selectDate("June 2025", "20");
        JavascriptExecutor Srollup1 = (JavascriptExecutor) driver;
        Srollup1.executeScript("window.scrollBy(0,800)");
        // Select rating scale
        driver.findElement(ratingScaleField).sendKeys(RatingScale);
        Thread.sleep(1000);
        driver.findElement(ratingScaleDropdown).click();
        Thread.sleep(1000);
        // Select employee group
        JavascriptExecutor Srollup2 = (JavascriptExecutor) driver;
        Srollup2.executeScript("window.scrollBy(0,1000)");
        driver.findElement(groupRadioButton).click();
        Thread.sleep(2000);
        driver.findElement(empGroupField).sendKeys(empGroup);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='highlight' and contains(text(), '" + empGroup + "')]")).click();
        Thread.sleep(2000);

        // Check active
        driver.findElement(isActiveCheckbox).click();
        Thread.sleep(1000);

        // Check weighted
        if (isWeighted) 
        {
            Thread.sleep(2000);
            driver.findElement(isWeightageBasedCheckbox).click();
            Thread.sleep(2000);
        }

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

    public boolean isGoalPlanDisplayed(String goalPlanName) 
    {
        return driver.findElement(By.xpath("//td[contains(text(),'" + goalPlanName + "')]")).isDisplayed();
    
   
    }  
    
}