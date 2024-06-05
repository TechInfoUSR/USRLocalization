package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	private WebElement getHeaderElement(String EmpMyPMS) {
		String headerXpathValue = "//h1[contains(text(),'"+EmpMyPMS+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	//span[contains(text(),'My PMS')]
	public boolean isempgreetingsExist(String headerValue) {
		String header = getHeaderElement(headerValue).getText();
		System.out.println(header);
		return getHeaderElement(headerValue).isDisplayed();
	}
	
	private WebElement getContactElement(String EmpPolicyDocs) {
		String contactXpathValue = "//span[contains(text(),'"+EmpPolicyDocs+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpTotalExist(String contactValue) {
		String contact = getContactElement(contactValue).getText();
		System.out.println(contact);
		return getContactElement(contactValue).isDisplayed();
	}
	private WebElement getEmpstatusTest(String EmpstatusTest) {
		String contactXpathValue = "//span[contains(text(),'"+EmpstatusTest+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpstatusTest(String EmpstatusTestValue) {
		String contact = getEmpstatusTest(EmpstatusTestValue).getText();
		System.out.println(contact);
		return getEmpstatusTest(EmpstatusTestValue).isDisplayed();
	}
	
	private WebElement getEmp360feedback(String Emp360feedbackTest) {
		String contactXpathValue = "//a[contains(text(),'"+Emp360feedbackTest+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmp360feedback(String Emp360feedbackTestValue) {
		String contact = getEmp360feedback(Emp360feedbackTestValue).getText();
		System.out.println(contact);
		return getEmp360feedback(Emp360feedbackTestValue).isDisplayed();
	}

	private WebElement getEmpCumulativeReports(String EmpCumulativeReports) {
		String contactXpathValue = "//a[contains(text(),'"+EmpCumulativeReports+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpCumulativeReports(String EmpCumulativeReportsTestValue) {
		String contact = getEmpCumulativeReports(EmpCumulativeReportsTestValue).getText();
		System.out.println(contact);
		return getEmpCumulativeReports(EmpCumulativeReportsTestValue).isDisplayed();
	}
	
	private WebElement getEmpMYGoal(String EmpMYGoal) {
		String contactXpathValue = "//p[contains(text(),'"+EmpMYGoal+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpMYGoal(String isEmpMYGoalTestValue) {
		String contact = getEmpMYGoal(isEmpMYGoalTestValue).getText();
		System.out.println(contact);
		return getEmpMYGoal(isEmpMYGoalTestValue).isDisplayed();
	}
	
	private WebElement getEmpOnTrack(String EmpOnTrackvalue) {
		driver.findElement(By.xpath("//*[@id=\"nggDiv\"]/div[2]/div[2]/div/div[3]/ul/li[3]/a")).click();
		String contactXpathValue = "//span[contains(text(),'"+EmpOnTrackvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpOnTrack(String EmpOnTrackTestValue) {
		String contact = getEmpOnTrack(EmpOnTrackTestValue).getText();
		System.out.println(contact);
		return getEmpOnTrack(EmpOnTrackTestValue).isDisplayed();
	}
	
	private WebElement getEmpAtRisk(String EmpAtRiskvalue) {
		String contactXpathValue = "//span[contains(text(),'"+EmpAtRiskvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpAtRisk(String EmpAtRiskTestValue) {
		String contact = getEmpAtRisk(EmpAtRiskTestValue).getText();
		System.out.println(contact);
		return getEmpAtRisk(EmpAtRiskTestValue).isDisplayed();
	}
	private WebElement getEmpBehind(String EmpBehindvalue) {
		String contactXpathValue = "//span[contains(text(),'"+EmpBehindvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpBehind(String EmpBehindTestValue) {
		String contact = getEmpBehind(EmpBehindTestValue).getText();
		System.out.println(contact);
		return getEmpBehind(EmpBehindTestValue).isDisplayed();
	}
	private WebElement getEmpClosed(String EmpClosedvalue) {
		String contactXpathValue = "//span[contains(text(),'"+EmpClosedvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpClosed(String EmpClosedTestValue) {
		String contact = getEmpClosed(EmpClosedTestValue).getText();
		System.out.println(contact);
		return getEmpClosed(EmpClosedTestValue).isDisplayed();
	}
	private WebElement getEmpPostponed(String EmpPostponedvalue) {
		String contactXpathValue = "//span[contains(text(),'"+EmpPostponedvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpPostponed(String EmpPostponedTestValue) {
		String contact = getEmpPostponed(EmpPostponedTestValue).getText();
		System.out.println(contact);
		return getEmpPostponed(EmpPostponedTestValue).isDisplayed();
	}
	private WebElement getEmpNotStarted(String EmpNotStartedvalue) {
		String contactXpathValue = "//span[contains(text(),'"+EmpNotStartedvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpNotStarted(String EmpNotStartedTestValue) {
		String contact = getEmpNotStarted(EmpNotStartedTestValue).getText();
		System.out.println(contact);
		return getEmpNotStarted(EmpNotStartedTestValue).isDisplayed();
	}
	private WebElement getEmpNotApproved(String EmpNotApprovedvalue) {
		String contactXpathValue = "//span[contains(text(),'"+EmpNotApprovedvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpNotApproved(String EmpNotApprovedTestValue) {
		String contact = getEmpNotApproved(EmpNotApprovedTestValue).getText();
		System.out.println(contact);
		return getEmpNotApproved(EmpNotApprovedTestValue).isDisplayed();
	}
	private WebElement getEmpASSIGNEDBY(String EmpASSIGNEDBYvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+EmpASSIGNEDBYvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpASSIGNEDBY(String EmpASSIGNEDBYTestValue) {
		String contact = getEmpASSIGNEDBY(EmpASSIGNEDBYTestValue).getText();
		System.out.println(contact);
		return getEmpASSIGNEDBY(EmpASSIGNEDBYTestValue).isDisplayed();
	}
	private WebElement getEmpPROGRESSSCORE(String EmpPROGRESSSCOREvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+EmpPROGRESSSCOREvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpPROGRESSSCORE(String EmpPROGRESSSCORETestValue) {
		String contact = getEmpPROGRESSSCORE(EmpPROGRESSSCORETestValue).getText();
		System.out.println(contact);
		return getEmpPROGRESSSCORE(EmpPROGRESSSCORETestValue).isDisplayed();
	}
	private WebElement getEmpADDNEWKRA(String EmpADDNEWKRAvalue) {
		String contactXpathValue = "//span[contains(text(),'"+EmpADDNEWKRAvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpADDNEWKRA(String EmpADDNEWKRATestValue) {
		String contact = getEmpADDNEWKRA(EmpADDNEWKRATestValue).getText();
		System.out.println(contact);
		return getEmpADDNEWKRA(EmpADDNEWKRATestValue).isDisplayed();
	}
	
	private WebElement getEmpActions(String EmpActionsvalue) {
		String contactXpathValue = "//strong[contains(text(),'"+EmpActionsvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpActions(String EmpActionsTestValue) {
		String contact = getEmpActions(EmpActionsTestValue).getText();
		System.out.println(contact);
		return getEmpActions(EmpActionsTestValue).isDisplayed();
	}
	
	private WebElement getEmpProfileSettings(String EmpProfileSettingsvalue) {
		driver.findElement(By.xpath("//*[@id=\"nggDiv\"]/div[2]/div[2]/div/div[3]/ul/li[3]/a")).click();
		String contactXpathValue = "//h5[contains(text(),'"+EmpProfileSettingsvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpProfileSettings(String EmpProfileSettingsTestValue) {
		String contact = getEmpProfileSettings(EmpProfileSettingsTestValue).getText();
		System.out.println(contact);
		return getEmpProfileSettings(EmpProfileSettingsTestValue).isDisplayed();
	}
	private WebElement getEmpLogOut(String EmpLogOutvalue) {
		driver.findElement(By.xpath("//*[@id=\"nggDiv\"]/div[2]/div[2]/div/div[3]/ul/li[3]/a")).click();
		String contactXpathValue = "//h5[contains(text(),'"+EmpLogOutvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpLogOut(String EmpLogOutTestValue) {
		String contact = getEmpLogOut(EmpLogOutTestValue).getText();
		System.out.println(contact);
		return getEmpLogOut(EmpLogOutTestValue).isDisplayed();
	}
	private WebElement getSubmitSelfAssessment(String SubmitSelfAssessmentvalue) {
		String contactXpathValue = "//a[contains(text(),'"+SubmitSelfAssessmentvalue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isSubmitSelfAssessment(String SubmitSelfAssessmentTestValue) {
		String contact = getSubmitSelfAssessment(SubmitSelfAssessmentTestValue).getText();
		System.out.println(contact);
		return getSubmitSelfAssessment(SubmitSelfAssessmentTestValue).isDisplayed();
	}
	private WebElement getEmpPolicyDocs(String EmpPolicyDocsvalue) {
		driver.findElement(By.xpath("//*[@id=\"nggDiv\"]/div[2]/div[1]/span")).click();
		String contactXpathValue = "//*[@id=\"policyDocumentation\"]/a";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isEmpPolicyDocs(String EmpPolicyDocsTestValue) {
		String contact = getEmpPolicyDocs(EmpPolicyDocsTestValue).getText();
		System.out.println(contact);
		return getEmpPolicyDocs(EmpPolicyDocsTestValue).isDisplayed();
	}
	
}