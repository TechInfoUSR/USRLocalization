package MnagerPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.ElementUtil;

public class managerHomePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public managerHomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	private WebElement getMgrGoalPlanExist(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),'"+MgrGoalPlan+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrGoalPlanExist(String MgrGoalPlanValue) {
		String header = getMgrGoalPlanExist(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrGoalPlanExist(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrBellcurve(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),'"+MgrGoalPlan+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrOverallPMSReport(String MgrGoalPlanValue) {
		String header = getMgrBellcurve(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrBellcurve(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrTeamIDPs(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),'"+MgrGoalPlan+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrTeamIDPs(String MgrGoalPlanValue) {
		String header = getMgrTeamIDPs(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrTeamIDPs(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrOverallPMSReport(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),'"+MgrGoalPlan+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrBellcurve(String MgrGoalPlanValue) {
		String header = getMgrOverallPMSReport(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrOverallPMSReport(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrGapAnalysis(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),'"+MgrGoalPlan+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrGapAnalysis(String MgrGoalPlanValue) {
		String header = getMgrGapAnalysis(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrGapAnalysis(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrCumulativeReports(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),'"+MgrGoalPlan+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrCumulativeReports(String MgrGoalPlanValue) {
		String header = getMgrCumulativeReports(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrCumulativeReports(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrMyTeamsPMSworkflowcompletedstatus(String MgrGoalPlan) {
		String headerXpathValue = "//p[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrMyTeamsPMSworkflowcompletedstatus(String MgrGoalPlanValue) {
		String header = getMgrMyTeamsPMSworkflowcompletedstatus(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrMyTeamsPMSworkflowcompletedstatus(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrSKIPLEVELREVIEW(String MgrGoalPlan) {
		String headerXpathValue = "//p[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrSKIPLEVELREVIEW(String MgrGoalPlanValue) {
		String header = getMgrSKIPLEVELREVIEW(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrSKIPLEVELREVIEW(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrYETTOSUBMIT(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrYETTOSUBMIT(String MgrGoalPlanValue) {
		String header = getMgrYETTOSUBMIT(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrYETTOSUBMIT(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrSUBMITTEDUNDERAUTHORIZATION(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrSUBMITTEDUNDERAUTHORIZATION(String MgrGoalPlanValue) {
		String header = getMgrSUBMITTEDUNDERAUTHORIZATION(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrSUBMITTEDUNDERAUTHORIZATION(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrAPPROVED(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrAPPROVED(String MgrGoalPlanValue) {
		String header = getMgrAPPROVED(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrAPPROVED(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrREJECTED(String MgrGoalPlan) {
		String headerXpathValue = "//a[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrREJECTED(String MgrGoalPlanValue) {
		String header = getMgrREJECTED(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrREJECTED(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrTotalReviewCycleInitiated(String MgrGoalPlan) {
		String headerXpathValue = "//h3[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrTotalReviewCycleInitiated(String MgrGoalPlanValue) {
		String header = getMgrTotalReviewCycleInitiated(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrTotalReviewCycleInitiated(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrGoalsApproved(String MgrGoalPlan) {
		String headerXpathValue = "//h3[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrGoalsApproved(String MgrGoalPlanValue) {
		String header = getMgrGoalsApproved(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrGoalsApproved(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrEmployeeSelfReview(String MgrGoalPlan) {
		String headerXpathValue = "//h5[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrEmployeeSelfReview(String MgrGoalPlanValue) {
		String header = getMgrEmployeeSelfReview(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrEmployeeSelfReview(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getMgrManagerReview(String MgrGoalPlan) {
		String headerXpathValue = "//h5[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isMgrManagerReview(String MgrGoalPlanValue) {
		String header = getMgrManagerReview(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getMgrManagerReview(MgrGoalPlanValue).isDisplayed();
	}
	private WebElement getSelectEmp(String MgrGoalPlan) {
		String headerXpathValue = "//span[contains(text(),"+MgrGoalPlan+")]";
		
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isSelectEmp(String MgrGoalPlanValue) {
		String header = getSelectEmp(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getSelectEmp(MgrGoalPlanValue).isDisplayed();
		
	}
	private WebElement getOverallPMSReport(String MgrGoalPlan) {
		String headerXpathValue = "//th[contains(text(),"+MgrGoalPlan+")]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	public boolean isOverallPMSReport(String MgrGoalPlanValue) {
		String header = getOverallPMSReport(MgrGoalPlanValue).getText();
		System.out.println(header);
		return getOverallPMSReport(MgrGoalPlanValue).isDisplayed();
	}
}
