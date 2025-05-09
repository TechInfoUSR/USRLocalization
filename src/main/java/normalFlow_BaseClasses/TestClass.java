package normalFlow_BaseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {


	    public static void main(String[] args) throws InterruptedException {
	        // Set the path to the WebDriver executable
	        System.setProperty("webdriver.chrome.driver", "./Soft/chromedriver.exe");

	        // Create a new instance of the Chrome driver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the webpage with the dropdown
	        driver.get("https://test.okrstars.com/solutions/login?invalid=1");
	        Thread.sleep(2000);
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys("ranganath@okrstars.com");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys("talent");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();
	        Thread.sleep(2000);
//	        driver.findElement( By.xpath("//a[@class='dropdown-toggle']")).click();
//	        Thread.sleep(1000);
//          driver.findElement(By.xpath("//a[contains(text(),'Testing 1706 Normalization ')]")).click();
//          Thread.sleep(1000);
//          driver.findElement(By.xpath("(//span[@class=\"ml-4\"])[1]")).click();
            
            
            
            
            WebElement element = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]"));
            // Use JavaScriptExecutor to click on the element
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            Thread.sleep(1000);
            
            
            
            
            
//            WebElement rangeInput = driver.findElement(By.cssSelector("input[type='range']")); 
//            int progress = 50; // Example: setting progress to 50%
//
//            // Cast WebDriver to JavascriptExecutor
//            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//
//            // Update the value of the range input and trigger the change event
//            String script = "arguments[0].value = arguments[1];" +
//                            "arguments[0].dispatchEvent(new Event('change'));";
//            jsExecutor.executeScript(script, rangeInput, progress);
//
//            // Optionally, update the progress text (if needed)
//            WebElement progressText = driver.findElement(By.cssSelector(".risk"));
//            jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));
//
//            // Close the browser (optional)
            // driver.quit();
            
            
            
            updateProgressBar(driver, "(//input[@type=\"range\"])[1]", 50);
            Thread.sleep(1000);
            // Update progress for the second progress bar
            updateProgressBar(driver, "(//input[@type=\"range\"])[2]", 75);

            Thread.sleep(1000);
            // Perform actions after the progress bar is complete
            System.out.println("Progress bar is complete!");
	        driver.quit();
	    }    
	    
	    
	    
	    private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) {
	    	
	    	  WebElement rangeInput = driver.findElement(By.xpath(cssSelector)); 
//            int progress = 50; // Example: setting progress to 50%

            // Cast WebDriver to JavascriptExecutor
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

            // Update the value of the range input and trigger the change event
            String script = "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('change'));";
            jsExecutor.executeScript(script, rangeInput, progress);

            // Optionally, update the progress text (if needed)
            WebElement progressText = driver.findElement(By.cssSelector(".risk"));
            jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));

            // Close the browser (optional)
            // driver.quit();
	    
	    }
	    
	    
	    
	    
	    
	    
            // Method to update progress bar based on CSS selector and progress value
//            private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) {
//                // Locate the range input element
//                WebElement rangeInput = driver.findElement(By.xpath(cssSelector));
//
//                // Cast WebDriver to JavascriptExecutor
//                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//
//                // Update the value of the range input and trigger the change event
//                String script = "arguments[0].value = arguments[1];" +
//                                "arguments[0].dispatchEvent(new Event('change'));";
//                jsExecutor.executeScript(script, rangeInput, progress);
//
//                // Optionally, update the progress text (if needed)
//                WebElement progressText = rangeInput.findElement(By.xpath("./following-sibling::div[@class='risk']"));
//                jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));
//            }
//            
            
            
            
            

     

	 
	}
