package _360DFeedback;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.List;
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
	        for (int i=1;i<= noforepons;i++) 
	        {
	        	
	      
	            JavascriptExecutor js = (JavascriptExecutor) driver;

	            String xpath = "(//div[@class='card list-view-card'])[1]"; 

	            boolean elementVisible = false;
	            do {
	                try {
	                
	                    WebElement element = driver.findElement(By.xpath(xpath));
	                    	                
//	                    js.executeScript("arguments[0].scrollIntoView(true);", element);
	                   
	                    elementVisible = true;
	                } catch (NoSuchElementException e) {
	             
	                    js.executeScript("window.scrollBy(0, 100);");
	                }
	            } while (!elementVisible);

	            WebElement element = driver.findElement(By.xpath(xpath));

//	            element.click();
	        	
	        		        
	              JavascriptExecutor executor = (JavascriptExecutor) driver;
	              executor.executeScript("arguments[0].click();", element);
	              Thread.sleep(2000);
	  	        
	              
	              List<WebElement> questions = driver.findElements(By.xpath("//div[@class=\"container-fluid mt-2 collapse in\"]//label[@class=\"control-label col-xs-3 ng-binding\"]"));

	              int numberOfQuestions = questions.size();

	              System.out.println("Number of questions: " + numberOfQuestions);
	              int noofquestions = (numberOfQuestions - 23);

	              for (int i1 = 0; i1 <= noofquestions; i1++) 
	              {                  
	                  Thread.sleep(1000);
	                  

	                  String radioButtonXPath = "(//input[@value=\"1 \"])[" + (i1 + 1) + "]";
	                  driver.findElement(By.xpath(radioButtonXPath)).click();
	                  Thread.sleep(1000);
	                                 
//	                  js.executeScript("window.scrollBy(0, 1000);");
	              }
	        
	              
	              Thread.sleep(2000); 
	              WebElement scrollViewElement = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
	              js.executeScript("arguments[0].scrollIntoView(true);", scrollViewElement);
	              Thread.sleep(2000); 
	              
	              System.out.println(noforepons);
//	   		  driver.findElement(By.xpath("(//button[@type=\"reset\"])[1]")).click();
	              driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();
	              Thread.sleep(2000);
	              Alert alert = driver.switchTo().alert();
	              alert.accept();             
	              Thread.sleep(5000);
	              driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
	              Thread.sleep(2000);
	        
	  	    }
	        
	        }
	       
		}
		

		


