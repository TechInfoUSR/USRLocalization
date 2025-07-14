package IPPB_Performence;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manager_Assessment_submission {

	private WebDriver driver;
	private Properties prop;
	String EmpName;

	public Manager_Assessment_submission(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public void DataReader() throws IOException, InterruptedException {

		String excelFilePath = ".\\DataFolder\\IPPB_Manager_Select_EMP.xlsx";

		// Create a FileInputStream to read from the Excel file
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		XSSFWorkbook workbook1 = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook1.getSheetAt(0); // Assuming first sheet, index starts at 0

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		DataFormatter formatter = new DataFormatter();

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			if (row == null) {
				continue; // Skip empty rows
			}

			// Iterate through each cell in the row
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.getCell(c);

				switch (c) {
				case 0:
					String EmpName1 = formatter.formatCellValue(cell);
					EmpName = EmpName1;
					System.out.print(" " + EmpName + "\t");
					break;

				}
			}

			selectGoalCycle(EmpName);

			System.out.println(); // Move to the next line after each row
		}

		// Close the workbook and input stream
		workbook1.close();
		inputStream.close();

	}

	public void selectGoalCycle(String Emp_name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		if (Emp_name != null && !Emp_name.isEmpty()) {
			WebElement empElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Emp_name + "')]")));
			empElement.click();
		} else {
			throw new IllegalArgumentException("Employee name property is not set or empty.");
		}

		Thread.sleep(600);
		WebElement element = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		WebElement listContainer = driver.findElement(By.id("categ1"));

		List<WebElement> noofGoals = listContainer
				.findElements(By.xpath("//ul[@class=\"flex flex-btn py-1 onhover-section ng-scope\"]"));
		int NoofGoal = noofGoals.size();
		System.out.println(NoofGoal);
		for (int i = 1; i <= NoofGoal; i++) {

			Random random = new Random();
			int randomNumber = random.nextInt(100) + 1;

			updateProgressBar(driver, "(//input[@type=\"range\"])[1]", randomNumber);
//			Thread.sleep(1000);

			WebElement element1 = driver
					.findElement(By.xpath("(//a[@class=\"btn checkin-btn block-btn subAssessmentButton\"])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			element1.click();

//			Thread.sleep(1000);
//			for (int im=0;im<=168;im++) {
//				driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys("MGRCMT");
//			}


//			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys("MGRCMT");

//			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys("MGRCMT");
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));
			driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys(prop.getProperty("CMT1000"));

			Thread.sleep(1500);

			driver.findElement(By.xpath("//button[@id=\"submitPerformanceBtn\"]")).click();
			Thread.sleep(1000);

			By OkBtn = (By.xpath("//button[contains(text(),'OK')]"));
			WebElement OKbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(OkBtn));
			OKbtn.click();
//            Thread.sleep(4000); 

			WebElement Click_TEAM_PMS = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//img[@src=\"pmsGE/images/svg/team.svg\"]")));
			Click_TEAM_PMS.click();

		}
	}

	private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) {
		WebElement rangeInput = driver.findElement(By.xpath(cssSelector));
		// Cast WebDriver to JavascriptExecutor
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// Update the value of the range input and trigger the change event
		String script = "arguments[0].value = arguments[1];" + "arguments[0].dispatchEvent(new Event('change'));";
		jsExecutor.executeScript(script, rangeInput, progress);
		// Optionally, update the progress text (if needed)
		WebElement progressText = driver.findElement(By.cssSelector(".risk"));
		jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText,
				String.format("%d%% Complete", progress));

	}

	public String isSelfsub() throws InterruptedException {
//  		  Thread.sleep(5000);
		return driver.findElement(By.xpath("//span[contains(text(),'Manager Review Completed')]")).getText();
	}

}
