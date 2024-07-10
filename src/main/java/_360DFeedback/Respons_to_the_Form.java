package _360DFeedback;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Respons_to_the_Form {
	 private WebDriver driver;
     private Properties prop;
     
     public Respons_to_the_Form(WebDriver driver, Properties prop) 
     {
         this.driver = driver;
         this.prop = prop;
     }
     private By usernameField = By.xpath("//*[@id=\"hello\"]/div[2]/input");
     private By passwordField = By.xpath("//*[@id=\"hello\"]/div[3]/input");
     private By loginButton = By.xpath("//*[@id=\"hello\"]/div[4]/button");
	
	public void login(String username, String password) throws InterruptedException {
		driver.findElement(usernameField).sendKeys("balaram@okrstar.com");
        driver.findElement(passwordField).sendKeys("talent");
        driver.findElement(loginButton).click();	
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'360° feedback')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'OKR for Testing')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
       
        Thread.sleep(2000);
        String noforeponsText = driver.findElement(By.xpath("(//h3[@class=\"ng-binding\"]) [5]")).getText();
        int noforepons = Integer.parseInt(noforeponsText);
        for (int i=4;i<= noforepons;i++) 
        {
//        	  JavascriptExecutor scrollup = (JavascriptExecutor) driver;
//        	  scrollup.executeScript("window.scrollBy(0,50)");
//        	  WebElement element = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[" + (i) + "]"));

        	
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Define the XPath for the element to be found
            String xpath = "(//div[@class='card list-view-card'])[" + (i) + "]";  // Adjust the index as necessary

            // Scroll until the element is visible
            boolean elementVisible = false;
            do {
                try {
                    // Try to find the element
                    WebElement element = driver.findElement(By.xpath(xpath));
                    
                    // Scroll to the element
                    js.executeScript("arguments[0].scrollIntoView(true);", element);
                    
                    // If no exception is thrown, element is found and visible
                    elementVisible = true;
                } catch (NoSuchElementException e) {
                    // Scroll down by 50 pixels
                    js.executeScript("window.scrollBy(0, 50);");
                }
            } while (!elementVisible);

            // Perform actions on the element
            WebElement element = driver.findElement(By.xpath(xpath));
            // Example: click the element
            element.click();
        	
        	
        	
              // Use JavaScriptExecutor to click on the element
              JavascriptExecutor executor = (JavascriptExecutor) driver;
              executor.executeScript("arguments[0].click();", element);
              Thread.sleep(5000);
  	        

          
              List<WebElement> questions = driver.findElements(By.xpath("//div[@id='myokrCollapse439']//div[@class=\"form-group\"]"));

              // Get the number of questions
              int numberOfQuestions = questions.size();

              // Print the number of questions
              System.out.println("Number of questions: " + numberOfQuestions);
              int noofquestions = numberOfQuestions - 23;

              // Correct the loop condition
              for (int i1 = 0; i1 < noofquestions; i1++) 
              {                  
                  Thread.sleep(1000);
                  
                  // Construct the XPath dynamically with the current index (i1 + 1)
                  String radioButtonXPath = "(//input[@value=\"1 \"])[" + (i1 + 1) + "]";
                  driver.findElement(By.xpath(radioButtonXPath)).click();
                  Thread.sleep(1000);
                                 
                  js.executeScript("window.scrollBy(0, 50);");
              }
        
        
              System.out.println(noforepons);
//   		  driver.findElement(By.xpath("(//button[@type=\"reset\"])[1]")).click();
              driver.findElement(By.xpath("(//button[@type=\"submit\"])[" + (noofquestions) + "]")).click();
              Thread.sleep(2000);
              Alert alert = driver.switchTo().alert();
              alert.accept();             
              Thread.sleep(5000);
              driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
              Thread.sleep(2000);
        
  	    }
        
        }
       
	}
	

	


