package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.ElementUtil;

public class degreeFedback360 {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public degreeFedback360(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private WebElement getPending(String Pendingvalue) {
		String contactXpathValue = "//span[contains(text(),'"+Pendingvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isPending(String PendingTestValue) {
		String contact = getPending(PendingTestValue).getText();
		System.out.println(contact);
		return getPending(PendingTestValue).isDisplayed();
	}
	private WebElement getCompleted(String Completedvalue) {
		String contactXpathValue = "//span[contains(text(),'"+Completedvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isCompleted(String CompletedTestValue) {
		String contact = getCompleted(CompletedTestValue).getText();
		System.out.println(contact);
		return getCompleted(CompletedTestValue).isDisplayed();
	}
	private WebElement getKRAPEERREVIEW(String Completedvalue) {
		String contactXpathValue = "//h3[contains(text(),'"+Completedvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isKRAPEERREVIEW(String PendingTestValue) {
		String contact = getKRAPEERREVIEW(PendingTestValue).getText();
		System.out.println(contact);
		return getKRAPEERREVIEW(PendingTestValue).isDisplayed();
	}
	private WebElement getSCOPE(String SCOPEvalue) {
		String contactXpathValue = "//h3[contains(text(),'"+SCOPEvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isSCOPE(String SCOPETestValue) {
		String contact = getSCOPE(SCOPETestValue).getText();
		System.out.println(contact);
		return getSCOPE(SCOPETestValue).isDisplayed();
	}
	private WebElement getEMPLOYEE(String EMPLOYEEvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+EMPLOYEEvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isEMPLOYEE(String EMPLOYEETestValue) {
		String contact = getEMPLOYEE(EMPLOYEETestValue).getText();
		System.out.println(contact);
		return getEMPLOYEE(EMPLOYEETestValue).isDisplayed();
	}
	private WebElement getREQUESTEDBY(String REQUESTEDBYvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+REQUESTEDBYvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isREQUESTEDBY(String REQUESTEDBYTestValue) {
		String contact = getREQUESTEDBY(REQUESTEDBYTestValue).getText();
		System.out.println(contact);
		return getREQUESTEDBY(REQUESTEDBYTestValue).isDisplayed();
	}
	private WebElement getEMPLOYEESELFREVIEW(String EMPLOYEESELFREVIEWvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+EMPLOYEESELFREVIEWvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isEMPLOYEESELFREVIEW(String REQUESTEDBYTestValue) {
		String contact = getEMPLOYEESELFREVIEW(REQUESTEDBYTestValue).getText();
		System.out.println(contact);
		return getEMPLOYEESELFREVIEW(REQUESTEDBYTestValue).isDisplayed();
	}
	private WebElement getMANAGERREVIEW(String MANAGERREVIEWvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+MANAGERREVIEWvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isMANAGERREVIEW(String MANAGERREVIEWTestValue) {
		String contact = getMANAGERREVIEW(MANAGERREVIEWTestValue).getText();
		System.out.println(contact);
		return getMANAGERREVIEW(MANAGERREVIEWTestValue).isDisplayed();
	}
	private WebElement getGOALPEERFEEDBACK(String GOALPEERFEEDBACKvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+GOALPEERFEEDBACKvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isGOALPEERFEEDBACK(String MANAGERREVIEWTestValue) {
		String contact = getGOALPEERFEEDBACK(MANAGERREVIEWTestValue).getText();
		System.out.println(contact);
		return getGOALPEERFEEDBACK(MANAGERREVIEWTestValue).isDisplayed();
	}
	private WebElement getMy360FEEDBACK(String My360FEEDBACKvalue) {
		String contactXpathValue = "//h3[contains(text(),'"+My360FEEDBACKvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isMy360FEEDBACK(String MANAGERREVIEWTestValue) {
		String contact = getMy360FEEDBACK(MANAGERREVIEWTestValue).getText();
		System.out.println(contact);
		return getMy360FEEDBACK(MANAGERREVIEWTestValue).isDisplayed();
	}
	private WebElement getProvide360Feedbackabout(String Provide360Feedbackaboutvalue) {
	    driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
		String contactXpathValue = "//h3[contains(text(),'"+Provide360Feedbackaboutvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isProvide360Feedbackabout(String Provide360FeedbackaboutTestValue) {
		String contact = getProvide360Feedbackabout(Provide360FeedbackaboutTestValue).getText();
		System.out.println(contact);
		return getProvide360Feedbackabout(Provide360FeedbackaboutTestValue).isDisplayed();
	}
	private WebElement get360Feedbackrequestedby(String Feedbackrequestedbyvalue) {
		driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
		String contactXpathValue = "//h3[contains(text(),'"+Feedbackrequestedbyvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean is360Feedbackrequestedby(String MANAGERREVIEWTestValue) {
		String contact = get360Feedbackrequestedby(MANAGERREVIEWTestValue).getText();
		System.out.println(contact);
		return get360Feedbackrequestedby(MANAGERREVIEWTestValue).isDisplayed();
	}
	private WebElement getReportingManager(String ReportingManagervalue) {
//		driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
		String contactXpathValue = "//h3[contains(text(),'"+ReportingManagervalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isReportingManager(String ReportingManagerTestValue) {
		String contact = getReportingManager(ReportingManagerTestValue).getText();
		System.out.println(contact);
		return getReportingManager(ReportingManagerTestValue).isDisplayed();
	}
	private WebElement getRequestcameon(String Requestcameonvalue) {
//		driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
		String contactXpathValue = "//h3[contains(text(),'"+Requestcameonvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isRequestcameon(String RequestcameonTestValue) {
		String contact = getRequestcameon(RequestcameonTestValue).getText();
		System.out.println(contact);
		return getRequestcameon(RequestcameonTestValue).isDisplayed();
	}	
	private WebElement getCOMPETENCIESPEERREVIEW(String COMPETENCIESPEERREVIEWvalue) {
		driver.findElement(By.xpath("//h3[contains(text(),'COMPETENCIES PEER REVIEW')]")).click();
		String contactXpathValue = "//h3[contains(text(),'"+COMPETENCIESPEERREVIEWvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isCOMPETENCIESPEERREVIEW(String COMPETENCIESPEERREVIEWTestValue) {
		String contact = getCOMPETENCIESPEERREVIEW(COMPETENCIESPEERREVIEWTestValue).getText();
		System.out.println(contact);
		return getCOMPETENCIESPEERREVIEW(COMPETENCIESPEERREVIEWTestValue).isDisplayed();
	}
	private WebElement getCumulativePerformanceReport(String COMPETENCIESPEERREVIEWvalue) {
		driver.findElement(By.xpath("//a[contains(text(),'Cumulative Reports')]")).click();
		String contactXpathValue = "//header[contains(text(),'"+COMPETENCIESPEERREVIEWvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isCumulativePerformanceReport(String COMPETENCIESPEERREVIEWTestValue) {
		String contact = getCumulativePerformanceReport(COMPETENCIESPEERREVIEWTestValue).getText();
		System.out.println(contact);
		return getCumulativePerformanceReport(COMPETENCIESPEERREVIEWTestValue).isDisplayed();
	}
	private WebElement getSelectReport(String COMPETENCIESPEERREVIEWvalue) {
		driver.findElement(By.xpath("//a[contains(text(),'Cumulative Reports')]")).click();
		String contactXpathValue = "//label[contains(text(),'"+COMPETENCIESPEERREVIEWvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isSelectReport(String COMPETENCIESPEERREVIEWTestValue) {
		String contact = getSelectReport(COMPETENCIESPEERREVIEWTestValue).getText();
		System.out.println(contact);
		return getSelectReport(COMPETENCIESPEERREVIEWTestValue).isDisplayed();
	}
	private WebElement getExporttoExcel(String COMPETENCIESPEERREVIEWvalue) {	
		String contactXpathValue = "//a[contains(text(),'"+COMPETENCIESPEERREVIEWvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isExporttoExcel(String COMPETENCIESPEERREVIEWTestValue) {
		String contact = getExporttoExcel(COMPETENCIESPEERREVIEWTestValue).getText();
		System.out.println(contact);
		return getExporttoExcel(COMPETENCIESPEERREVIEWTestValue).isDisplayed();
	}
	private WebElement getCreateNewReport(String COMPETENCIESPEERREVIEWvalue) {
		String contactXpathValue = "//a[contains(text(),'"+COMPETENCIESPEERREVIEWvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	public boolean isCreateNewReport(String COMPETENCIESPEERREVIEWTestValue) {
		String contact = getCreateNewReport(COMPETENCIESPEERREVIEWTestValue).getText();
		System.out.println(contact);
		return getCreateNewReport(COMPETENCIESPEERREVIEWTestValue).isDisplayed();
	}
	
}
