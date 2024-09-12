package normalFlowTest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.List;

public class Email_able_report_Sender implements IReporter {

    private String outputDirectory;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        this.outputDirectory = outputDirectory;

        System.out.println("Reports are generated in: " + outputDirectory);

        // Wait for the report to be fully generated
        if (waitForFileUpdate(outputDirectory + "/emailable-report.html")) {
            try {
                sendEmailWithReport();
            } catch (EmailException e) {
                System.err.println("Error sending email: " + e.getMessage());
            }
        } else {
            System.err.println("The report file is not updated or could not be found.");
        }
    }

    public boolean waitForFileUpdate(String filePath) {
        File file = new File(filePath);
        long lastModified = 0;
        int maxAttempts = 10;
        int attempt = 0;

        while (attempt < maxAttempts) {
            if (file.exists()) {
                long currentModified = file.lastModified();
                if (currentModified > lastModified) {
                    lastModified = currentModified;
                    try {
                        Thread.sleep(2000); // Wait for 2 seconds
                    } catch (InterruptedException e) {
                        System.err.println("Error during wait: " + e.getMessage());
                        Thread.currentThread().interrupt(); // Restore interrupted status
                    }
                } else {
                    return true; // File has not been updated, assume it's ready
                }
            }
            attempt++;
        }
        return false;
    }

    public void sendEmailWithReport() throws EmailException {
        if (outputDirectory != null) {
            String reportPath = outputDirectory + "/emailable-report.html";
            File reportFile = new File(reportPath);

            if (reportFile.exists()) {
                System.out.println("(This is from email able class)Sending email with report from: " + reportPath);

                HtmlEmail email = new HtmlEmail();
                email.setHostName("smtp.zeptomail.in");
                email.setSmtpPort(587);
                email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator("noreply@okrstars.com", "PHtE6r0OE+/q2TQppkUD4/6/Hs6tZ456+rtlLwMWtopEDfBQGU1Sr9kilWSx/ksuA/VFFP/JzNpqsLuY4uKMI2rtZDxMWWqyqK3sx/VYSPOZsbq6x00bt1gfdkDeUILue9Zq3SfTuN7ZNA=="));
                email.setSSLOnConnect(true);
                email.setFrom("noreply@okrstars.com", "Report Sender");
                email.setSubject("Test Report");
                email.setMsg("Please find the attached test report.");

                email.addTo("Hanumanth@usrinfotech.com");
                email.attach(reportFile);

                email.send();
                System.out.println("Email sent successfully!");
            } else {
                System.err.println("Report file does not exist: " + reportPath);
            }
        } else {
            System.err.println("Output directory is null. Cannot send email.");
        }
    }
}
