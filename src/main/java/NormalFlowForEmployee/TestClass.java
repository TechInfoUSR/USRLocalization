package NormalFlowForEmployee;

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
	        driver.get("https://greythrpms.co/solutions/login?invalid=1");
	        Thread.sleep(2000);
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys("manjunath@gmail.com");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys("talent");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();
	        Thread.sleep(2000);
	        driver.findElement( By.xpath("//a[@class='dropdown-toggle']")).click();
	        Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Testing 1706 Normalization ')]")).click();
            Thread.sleep(5000);
//            driver.findElement(By.xpath("(//span[@class=\"ml-4\"])[1]")).click();
            
            
//            WebElement listViewCard = driver.findElement(By.cssSelector(".list-view-card"));
//
//            // Perform actions on the element
//            listViewCard.click();
//            Thread.sleep(2000);
            WebElement listViewCard = driver.findElement(By.xpath("//*[contains(@class, 'list-view-card')]"));

            // Perform actions on the element
            listViewCard.click();
            
            
	        // Locate the dropdown element
//	        WebElement dropdownContainer = driver.findElement(By.cssSelector(".dropdown-container"));
//
//	        // Use JavaScript to get the computed style of the ::after pseudo-element
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        String pseudoElementContent = (String) js.executeScript(
//	            "return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');",
//	            dropdownContainer
//	        );
//
//	        // Print the content of the pseudo-element
//	        System.out.println("Pseudo-element content: " + pseudoElementContent);
//
//	        // Interact with the dropdown (e.g., clicking to open it)
//	        dropdownContainer.click();

	        // Close the browser
	        driver.quit();
	    }
	}
