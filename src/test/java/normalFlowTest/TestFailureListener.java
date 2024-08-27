package normalFlowTest;

import org.apache.commons.mail.EmailException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestFailureListener implements ITestListener {

	 private static final String REPORT_DIR = "D:\\USRInfotech\\10-07-2024_Automation\\USRLocalization\\test-output"; // Update this path as needed

    @Override
    public void onFinish(ITestContext context) {
        // This method will be called after all tests have run
        Email_able_report_Sender reportSender = new Email_able_report_Sender();
        try {
            // Wait for the report to be fully generated (optional, depends on your setup)
            if (reportSender.waitForFileUpdate(REPORT_DIR + "/emailable-report.html")) {
                reportSender.sendEmailWithReport();
            } else {
                System.err.println("The report file is not updated or could not be found.");
            }
        } catch (EmailException e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestFailure(ITestResult result) {}

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}
}
