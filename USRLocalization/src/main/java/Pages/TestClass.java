package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestClass {


		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./Soft/chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://test.okrstars.com/solutions/login?invalid=1");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys("ranganath@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys("talent");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();
			Thread.sleep(1000);
												
			
//			driver.findElement(By.xpath("//span[@class='ml-h align-center']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//a[@data-target='#second']")).click();
//			Thread.sleep(2000);
//			WebElement selectlevel = driver.findElement(By.id("selectlevel"));
//			Select level_select=new Select(selectlevel) ;
//			level_select.selectByVisibleText("Organization");
////			level_select.selectByValue("Organization");
			Thread.sleep(000);
			driver.findElement(By.xpath("//*[@id=\"listView\"]/div/div[2]/a[2]/span")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"tab_default_11\"]/form/div[4]/div[1]/div[1]/div[1]/a/img")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"select2-connectionId-container\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(text(),'Manual update')]")).click();
//			driver.findElement(By.id("select2-connectionId-container")).sendKeys("Manual update");
//			Select select_progress=new Select(Progress) ;
//			select_progress.selectByVisibleText("Manual update");
//			select_progress.selectByIndex(2);
//			level_select.selectByValue("Organization");
			Thread.sleep(2000);
			
			
			
//			WebElement date = driver.findElement(By.id("day"));
//			Select date_select=new Select(date) ;
//			date_select.selectByValue("11");
//			date_select.selectByVisibleText("31");
//			date_select.selectByIndex(11);
//			date_select.deselectByIndex(15);//multi select list box
			Thread.sleep(3000);
			driver.quit();
			
			

		}

	}
