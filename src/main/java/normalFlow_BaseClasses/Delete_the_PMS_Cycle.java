package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Delete_the_PMS_Cycle {
    WebDriver driver;
    Properties prop;

    public Delete_the_PMS_Cycle(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }

    public void Deletion() throws InterruptedException {
        String goal = prop.getProperty("GoalPalnName");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");
        driver.findElement(By.xpath("//h3[contains(text(),'PMS Program Management')][1]")).click();

        Select cycleDropdown = new Select(driver.findElement(By.xpath("//select[@ng-model='encReviewCycleId']")));
        cycleDropdown.selectByVisibleText(goal);

        By tableRowsLocator = By.xpath("//table[@class='table table-striped']//tr[@ng-repeat='pp in allProgressData | filter:{employeeName: searchEmployeeName}']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ReviewCycleIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(tableRowsLocator));

        List<WebElement> tableRows = driver.findElements(tableRowsLocator);
        System.out.println("Number of rows: " + tableRows.size());

        for (int i = 1; i <= tableRows.size(); i++) {
            WebElement actionIcon = driver.findElement(By.xpath("//div[@style='text-align:left;position:absolute;']//img[contains(@src,'serial-tasks.png')]"));
            actionIcon.click();

            String actualText = getTextSafe(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr[1]/td[1]/div/ul[2]/li/a/b"));
            String actualText1 = getTextSafe(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[2]/a/b"));
            String resetEmpAssessmentText = getTextSafe(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div[2]/table/tbody/tr[1]/td[1]/div/ul[2]/li/a"));

            if ("Remove Employee from this PMS Cycle".equals(actualText)) {
                removeEmployee();
            } else if ("Reset Manager's Assessment (without deleting contents filled already by emp. and manager)".equals(actualText1)) {
                resetManagerAssessment();
            } else if ("Reset Employee's Assessment ".equals(resetEmpAssessmentText)) {
                resetEmployeeAssessment();
            }
        }
    }

    private String getTextSafe(By locator) {
        try {
            return driver.findElement(locator).getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private void removeEmployee() {
        By removeBtn = By.xpath("(//b[contains(text(),'Remove Employee from this PMS Cycle')])[2]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtn));
        scrollIntoView(btn);
        btn.click();

        confirmPopup();
    }

    private void resetEmployeeAssessment() throws InterruptedException {
        By resetBtn = By.xpath("//b[contains(normalize-space(text()),\"Reset Employee's Assessment\")]");

        List<WebElement> buttons = driver.findElements(resetBtn);
        if (buttons.isEmpty()) {
            System.out.println("Reset button not found.");
            return;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(resetBtn));
        scrollIntoView(btn);

        if (btn.isDisplayed() && btn.isEnabled()) {
            System.out.println("Clicking Reset Employee's Assessment...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        } else {
            System.out.println("Button is not clickable.");
            return;
        }
        Thread.sleep(2000);

        confirmPopup();
        Thread.sleep(2000);
        By icon = By.xpath("//div[@style='text-align:left;position:absolute;']//img[contains(@src,'serial-tasks.png')]");
        WebElement ReviewCycleIcon1 = wait.until(ExpectedConditions.visibilityOfElementLocated(icon));
        ReviewCycleIcon1.click();

        removeEmployee();
    }


    private void resetManagerAssessment() {
        By resetManagerBtn = By.xpath("//a[@ng-click='resetAppraisal(pp.reviewCycleId,pp.employeeId,true,2)']//b");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ReviewCycleIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(resetManagerBtn));
        ReviewCycleIcon.click();

        confirmPopup();

        By icon = By.xpath("//div[@style='text-align:left;position:absolute;']//img[contains(@src,'serial-tasks.png')]");
        WebElement ReviewCycleIcon1 = wait.until(ExpectedConditions.visibilityOfElementLocated(icon));
        ReviewCycleIcon1.click();

        By finalRemoveBtn = By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[1]/a[2]");
        WebElement ReviewCycleIcon2 = wait.until(ExpectedConditions.visibilityOfElementLocated(finalRemoveBtn));
        ReviewCycleIcon2.click();

        confirmPopup();


        ReviewCycleIcon1.click();

        removeEmployee();
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void confirmPopup() {
        By confirmBtn = By.xpath("//button[@data-bb-handler='confirm']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ReviewCycleIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBtn));
        ReviewCycleIcon.click();
    }

    public boolean isDeleted() {
        By zeroText = By.xpath("//span[contains(text(),'0-1000 of 0')]");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(zeroText));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
