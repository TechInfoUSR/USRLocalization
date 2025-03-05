package NormalFlowForEmployee;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SuitClass_for_Test 
{

	 WebDriver driver;
	 Properties prop;

	    public SuitClass_for_Test(WebDriver driver,Properties prop) {
	        this.driver = driver;
	        this.prop = prop;
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

	    public void addGoalPlan1() throws InterruptedException 
	    {
	    	login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
	    	
	    	
	    	String goalPlanName = prop.getProperty("GoalPalnName");
	      	String empGroup = prop.getProperty("EmpGroup");
	      	String RatingScale = prop.getProperty("RatingScale");
	    	
	    	
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
	        selectDate("August 2024", "11");

	        // Select end date
	        driver.findElement(By.xpath("//input[@class=\"form-control dpd2\"]")).click();
	        selectDate("June 2025", "20");
	        JavascriptExecutor Srollup1 = (JavascriptExecutor) driver;
	        Srollup1.executeScript("window.scrollBy(0,800)");
	        // Select rating scale
	        driver.findElement(ratingScaleField).sendKeys(RatingScale);
	        Thread.sleep(2000);
	        driver.findElement(ratingScaleDropdown).click();
	        Thread.sleep(1000);
	        // Select employee group
	        JavascriptExecutor Srollup2 = (JavascriptExecutor) driver;
	        Srollup2.executeScript("window.scrollBy(0,1000)");
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
	        
//	        String empgruop = driver.findElement(By.xpath("//*[@id=\"selectGroupDropDiv\"]/div/div/div[1]/div/span/span")).getText();
//	        if (empgruop != empGroup) 
//	        {
//	        	driver.findElement(empGroupField).sendKeys(empGroup);	
//	        driver.findElement(By.xpath("//span[@class='highlight' and contains(text(), '" + empGroup + "')]")).click();
//	        Thread.sleep(2000);
//	        }

	        driver.findElement(isActiveCheckbox).click();
	        Thread.sleep(1000);

	        Thread.sleep(2000);
	        driver.findElement(isWeightageBasedCheckbox).click();
	        Thread.sleep(2000);
	   
	        driver.findElement(submitButton).click();
//	        driver.findElement(By.xpath("//*[@id=\"goalplanmodal\"]/div/div/div[2]/div/div/div[3]/span/span[2]/span[2]/div/button[3]")).click();
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
	    
//	    
//	    <!--> Add New PMS Cycle  <-->
//	    
	    
	    
	    
	    
	    private By performanceReviewCycleLink = By.xpath("//a[contains(text(),\"Performance Review cycle\")]");
	    private By addButton = By.xpath("//img[@alt=\"Add\"]");
	    private By goalPlanDropdown = By.id("goalplan");
	    private By ratingScaleField1 = By.xpath("//input[@placeholder=\"Select Rating Scale\"]");
	    private By fromDatePicker = By.xpath("//input[@class=\"form-control dpd1\"]");
	    private By toDatePicker = By.xpath("//input[@class=\"form-control dpd2\"]");
	    private By saveButton = By.xpath("//button[@id=\"saveReviewCycleDetails\"]");


	    public void addPMSCycle(String GoalPalnName) throws InterruptedException 
	    {
	        driver.findElement(performanceReviewCycleLink).click();
	        driver.findElement(addButton).click();
	        Thread.sleep(2000);
	        driver.findElement(goalPlanDropdown).click();
	        WebElement selectGoalPlan = driver.findElement(goalPlanDropdown);
	        Select select_goalplan = new Select(selectGoalPlan);
	        select_goalplan.selectByVisibleText(prop.getProperty("GoalPalnName"));
	        Thread.sleep(2000);

	        driver.findElement(ratingScaleField1).click();
	        driver.findElement(ratingScaleField1).sendKeys(prop.getProperty("RatingScale"));
	        driver.findElement(By.xpath("//div[@class=\"selectize-dropdown-content\"]")).click();

	        driver.findElement(fromDatePicker).click();
	        driver.findElement(By.xpath("//td[@class='day' and text()='11']")).click();
	        Thread.sleep(2000);

	        driver.findElement(toDatePicker).click();
	        while (!driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText().equals("June 2025")) 
	        {
	            driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
	            Thread.sleep(10);
	        }
	        driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[3]")).click();
	        Thread.sleep(1000);
	    	driver.findElement(By.xpath("//div[@class=\"modal-footer\"]")).click();
	        driver.findElement(saveButton).click();
	        Thread.sleep(1000);
	    }

	    public boolean isPMSCycleDisplayed() 
	    {
	        return driver.findElement(By.xpath("//span[contains(text(),'" + prop.getProperty("GoalPalnName") + "')]")).isDisplayed();
	    }
	    
	    
	    
	    
	    
//	    
//	    <!--> Initiate PMS cycle   <-->
//	 
	    
	    
	
	    
	    
	    
	    
	    private By tabWeightTab = By.xpath("//a[@data-toggle='tab' and @href='#sectionWeightTab']");
	    private By addNewRowLink = By.xpath("//a[@ng-click=\"addNewRow = true\"]");
	    private By selectGroupDropdown = By.xpath("//span[@id=\"select2-chosen-2\"]");
	    private By groupSearchField = By.xpath("//input[@id=\"s2id_autogen2_search\"]");
//	    private By groupOption = By.xpath("//div[contains(text(),'{{group}}')]");
	    private By objectiveWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.objectiveWeightage\"]");
	    private By coreValueWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.coreValueWeightage\"]");
	    private By jobCompetencyWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.jobCompetencyWeightage\"]");
	    private By behaviorWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.behaviorWeightage\"]");
	    private By leadershipWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.leadershipWeightage\"]");
	    private By insertButton = By.xpath("//a[contains(text(),'Insert')]");
	    private By initiateReviewCycleButton = By.xpath("//*[@class='btn btn-default btn-xs' and @ng-click='initiateReviewCycleForGroup(eg.weightageGroupId)']");
	    private By okButton = By.xpath("//button[contains(text(),'OK')]");



	    
	    public void goToWeightTab(String group, String AddPMSCyle) throws InterruptedException 
	    {
	    	driver.findElement(By.xpath("//span[contains(text(),'"+AddPMSCyle+"')]")).click();
			Thread.sleep(1000);
	        driver.findElement(tabWeightTab).click();
	        Thread.sleep(500);
	        driver.findElement(addNewRowLink).click();
	        Thread.sleep(500);
	        driver.findElement(selectGroupDropdown).click();
	        driver.findElement(groupSearchField).sendKeys(group);
	        Thread.sleep(500);
	        driver.findElement(By.xpath("//div[contains(text(),'"+group+"')]")).click();
	        Thread.sleep(2000);

	    }

	    public void enterWeightages(String objective, String coreValue, String jobCompetency, String behavior, String leadership) throws InterruptedException 
	    {
	        driver.findElement(objectiveWeightageField).sendKeys(objective);
	        driver.findElement(coreValueWeightageField).sendKeys(coreValue);
	        driver.findElement(jobCompetencyWeightageField).sendKeys(jobCompetency);
	        driver.findElement(behaviorWeightageField).sendKeys(behavior);
	        driver.findElement(leadershipWeightageField).sendKeys(leadership);

	        driver.findElement(insertButton).click();
	    	Thread.sleep(5000);
	        driver.findElement(initiateReviewCycleButton).click();
	        Thread.sleep(2000);
	        driver.findElement(okButton).click();
	        Thread.sleep(6000);
	        
	    }
	    //Not working due to a minor bug
	    public boolean isCycleInitiated(String GoalPalnName) throws InterruptedException 
	    {
	    	return driver.findElement(By.xpath("//td[contains(text(),'"+GoalPalnName+"')and @class=\"ng-binding\"]")).isDisplayed();
	    }
	    
	    
	    
	    
	    
//	    
//	    <!--> Add New Goals to Reporters  <-->
//	    
	    
	  
	    
	  

	    

        // Locators for elements on the EmployeeSelfPage
        private By avatarIcon = By.xpath("//a[@class='avatar-sec header-icon']");
        private By employeeName = By.xpath("(//h5[@class='ma-0'])[2]");
        private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
        private By goalCycleLink(String cycleName) 
        {
            return By.xpath("//a[contains(text(),'" + cycleName + "')]");
        }
        
        private By goalAction = By.xpath("(//img[@alt=\"Add\" and @width=\"24\"]) [1]");
        private By goalTitle = By.id("obj_title");
        private By goalCategoryField = By.xpath("(//span[contains(text(),'Select Goal Category')])[1]");
        private By descriptionField = By.xpath("//textarea[@placeholder=\"type to add description\"]");
        private By toggleMetric = By.xpath("//a[@data-target=\"#Outcomes\"]");
        private By kpiSuccess = By.id("kpi_success");
        private By currentMetric = By.id("current_metric");
        private By weightField = By.id("Weight");
        private By CreateBTN = By.xpath("(//button[@class=\"btn btn-default btn-cs mt-1 ng-binding\"])[1]");


        public void navigateToEmployeeSelf() throws InterruptedException 
        {
        	
            driver.findElement(avatarIcon).click();
            driver.findElement(employeeName).click();
            Thread.sleep(2000);
        }

        public void selectGoalCycle(String cycleName) throws InterruptedException 
        {
        	
            driver.findElement(dropdownToggle).click();
            Thread.sleep(2000);
            driver.findElement(goalCycleLink(cycleName)).click();
            Thread.sleep(1000);
        }

        public void openEmployeeAssessment() throws InterruptedException 
        {
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	String empname = prop.getProperty("empname");
            driver.findElement(By.xpath("//span[contains(text(),'"+empname+" ')]")).click();
            Thread.sleep(2000);
            driver.findElement(goalAction).click();
            Thread.sleep(2000);
        }

        public void enterGoalDetails() throws InterruptedException 
        {
        	String goalType = prop.getProperty("GoalType");
        	String goalName = prop.getProperty("Title");
        	String goalCategory = prop.getProperty("goalCategory");
        	String description = prop.getProperty("Description");
        	String weight = prop.getProperty("Weight");
        	  
//            	driver.findElement(goalTitle).click();
            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     	
            driver.findElement(goalTitle).sendKeys(goalName);
            Thread.sleep(100);
            driver.findElement(goalCategoryField).click();
            Thread.sleep(500);
            List<WebElement> Catcount = driver.findElements(By.xpath("//li[@aria-selected=\"false\"]"));
     
            int numberOfQuestions = Catcount.size();
  	        System.out.println("Number of questions: " + numberOfQuestions);
               
            System.out.println(Catcount);
                
//             String ActualTest = driver.findElement(goalTitle).getText();
	           for(int i=1;i<=numberOfQuestions;i++) 
	           {
	            	  String ActualTest = driver.findElement(By.xpath("//li[@aria-selected=\"false\"]["+i+"]")).getText();
//	            	  Thread.sleep(10);       	 
//	                  System.out.println(ActualTest);
	                if (ActualTest.equals(goalCategory) ) 
	                {
	                	System.out.println("Act"+ActualTest);
	                	driver.findElement(By.xpath("//li[@aria-selected=\"false\" and contains(text(),'')]["+i+"] ")).click();
	//                  driver.findElement(By.xpath("//li[@class=\"select2-results__option select2-results__option--selectable\" and contains(text(),'"+goalCategory+"')]")).click();
	                	Thread.sleep(500);
	                	break;
	                }
	            }
//              driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(goalCategory);
//              Thread.sleep(500);
//              driver.findElement(By.xpath("//li[contains(text(),'OKRs') and @role=\"option\"] [3]")).click();
//              Thread.sleep(500);
                driver.findElement(By.xpath("//a[@data-target=\"#second\"]")).click();
                Thread.sleep(500);
                driver.findElement(descriptionField).sendKeys(description);
                Thread.sleep(500);
//              JavascriptExecutor Srollup1 = (JavascriptExecutor) driver;
//              Srollup1.executeScript("window.scrollBy(0,1000)");
                driver.findElement(toggleMetric).click();
                Thread.sleep(500);
//              driver.findElement(kpiSuccess).click();
//              driver.findElement(currentMetric).click();              
//              driver.findElement(toggleMetric).click();                  
//              WebElement ele = driver.findElement(weightField);
//              Srollup1.executeScript("arguments[0].srollIntoView();", ele);
                
            	WebElement rangeInput = driver.findElement(toggleMetric); 
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                
                driver.findElement(weightField).sendKeys(weight);
                Thread.sleep(5000);
                driver.findElement(CreateBTN).click();
                Thread.sleep(5000);
                
            }
	    
	    
	    
	    
	    
	    
	    
//	    
//	    <!--> Rate Goals  <-->
//	    
	    
	  
	    
	  

	    


	public void selectGoalCycle1(String cycleName) throws InterruptedException 
      {
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.findElement(dropdownToggle).click();
          driver.findElement(By.xpath("//a[contains(text(),'"+cycleName+"')]")).click();
//          driver.findElement(goalCycleLink(cycleName)).click();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.findElement(By.xpath("//span[@class=\"ml-4\"]")).click();
                     
          
      //  FOR Clicking on Drop down  
          WebElement element = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]")); 
          // Use JavaScriptExecutor to click on the element
          JavascriptExecutor executor = (JavascriptExecutor) driver;
          executor.executeScript("arguments[0].click();", element);
          Thread.sleep(1000);
        
 
          WebElement listContainer  = driver.findElement(By.id("categ105"));

          List<WebElement> noofGoals =listContainer.findElements(By.xpath("//ul[@class=\"flex flex-btn py-1 onhover-section ng-scope\"]"));
          int NoofGoal = noofGoals.size();
          System.out.println(NoofGoal);
          for (int i=1 ;i<=NoofGoal;i++) 
          {
        	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          
        	  Random random = new Random();

          	int randomNumber = random.nextInt(100) + 1;

          	System.out.println("Random number between 1 and 100: " + randomNumber);
          
          	updateProgressBar(driver, "(//input[@type=\"range\"])[1]", randomNumber);
       		Thread.sleep(1000);
       		String Employee_cmt = "EmpCmt";
       		String Employee_comment =Employee_cmt + i;
            EmployeeComment(driver,"(//img[@src=\"pmsGE/images/ellipsis-1.png\"])[("+i+")]",Employee_comment, "(//a[@class=\"view-link mt-h cs-modal-btn ng-binding ng-scope\"]) [("+i+")]");
            Thread.sleep(1000);
          }
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//a[@ng-click=\"submitSelfPerformance(1)\"]")).click();
       Thread.sleep(500); 
       driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
       Thread.sleep(500); 
       
      }
	  private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) 
	  {  
    	  WebElement rangeInput = driver.findElement(By.xpath(cssSelector)); 
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Update the value of the range input and trigger the change event
        String script = "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('change'));";
        jsExecutor.executeScript(script, rangeInput, progress);
        // Optionally, update the progress text (if needed)
        WebElement progressText = driver.findElement(By.cssSelector(".risk"));
        jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));

      }
	  private static void EmployeeComment(WebDriver driver, String cssSelector, String Empcmt, String ReviewBTN) throws InterruptedException 
	  { 
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(cssSelector)).click();
		  Thread.sleep(500);
		  driver.findElement(By.xpath(ReviewBTN)).click();
		  Thread.sleep(500);
		  String goal_comments1 = "goal_comments1";    	
		  driver.findElement(By.id(goal_comments1)).sendKeys(Empcmt);

		  driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[3]")).click();

		  driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
		  Thread.sleep(1000);
	  }    
	    
	
	
}
