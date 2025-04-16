package NormalFlowForEmployee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class PMSCyclePage 
{
	    private WebDriver driver;
	    private Properties prop;

	    private By performanceReviewCycleLink = By.xpath("//a[contains(text(),\"Performance Review cycle\")]");
	    private By addButton = By.xpath("//img[@alt=\"Add\"]");
	    private By goalPlanDropdown = By.id("goalplan");
	    private By ratingScaleField = By.xpath("//input[@placeholder=\"Select Rating Scale\"]");
	    private By fromDatePicker = By.xpath("//input[@class=\"form-control dpd1\"]");
	    private By toDatePicker = By.xpath("//input[@class=\"form-control dpd2\"]");
	    private By saveButton = By.xpath("//button[@id=\"saveReviewCycleDetails\"]");

	    public PMSCyclePage(WebDriver driver, Properties prop) 
	    {
	        this.driver = driver;
	        this.prop = prop;
	    }

	    public void addPMSCycle(String GoalPalnName) throws InterruptedException 
	    {
	        driver.findElement(performanceReviewCycleLink).click();
	        driver.findElement(addButton).click();
//	        Thread.sleep(2000);
	        driver.findElement(goalPlanDropdown).click();
	        WebElement selectGoalPlan = driver.findElement(goalPlanDropdown);
	        Select select_goalplan = new Select(selectGoalPlan);
	        select_goalplan.selectByVisibleText(prop.getProperty("GoalPalnName"));
//	        Thread.sleep(2000);

	        driver.findElement(ratingScaleField).click();
	        driver.findElement(ratingScaleField).sendKeys(prop.getProperty("RatingScale"));
	        driver.findElement(By.xpath("//div[@class=\"selectize-dropdown-content\"]")).click();

	        driver.findElement(fromDatePicker).click();
	        
	        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
	        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");

	        // Print the current month
	        LocalDate currentDate = LocalDate.now();
	        String formattedDate1 = currentDate.format(monthYearFormatter);
	        String formattedDay = currentDate.format(dayFormatter);
//	        driver.findElement(By.xpath("//td[@class='day' and text()='"+formattedDate1+"']")).click();

	        LocalDate thirdMonth = currentDate.plusMonths(3);
	        String Third_Month_Year = thirdMonth.format(monthYearFormatter);
	        String Third_Month_DATE = thirdMonth.format(dayFormatter);
	        
	        
	        driver.findElement(By.xpath("//td[@class='day' and text()='"+Third_Month_DATE+"']")).click();
//	        Thread.sleep(2000);

	        driver.findElement(toDatePicker).click();
//	        Thread.sleep(500);

//	        while (!driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText().equals("June 2025"))
	        while (!driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText().equals(Third_Month_Year)) 
	        {
	            driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
//	            Thread.sleep(100);
	        }                           
//	        driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[1]")).click();
	        driver.findElement(By.xpath("//td [contains(text(),'"+Third_Month_DATE+"') and @class=\"day\"]")).click();
//	        Thread.sleep(1000);
	    	driver.findElement(By.xpath("//div[@class=\"modal-footer\"]")).click();
	        driver.findElement(saveButton).click();
//	        Thread.sleep(1000);
	    }

	    public String isPMSCycleDisplayed() 
	    {
	        return driver.findElement(By.xpath("//span[contains(text(),'" + prop.getProperty("GoalPalnName") + "')]")).getText();
	    }
}


