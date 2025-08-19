package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

public class Email_able_report_Sender implements IReporter {

    private String outputDirectory;
    private static String subject;
    static String attachmentPath;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Store the output directory in the instance variable
        this.outputDirectory = outputDirectory;

        System.out.println("Reports are generated in: " + outputDirectory);
        File reportFile = new File(outputDirectory + "/emailable-report.html");
        int attempts = 0;
        while (!reportFile.exists() || reportFile.lastModified() < System.currentTimeMillis() - 5000) {
            try {
                Thread.sleep(1000); 
                attempts++;
                if (attempts > 30) { 
                    System.out.println("Timeout waiting for report to be generated.");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
//         After generating the report, send an email
        try {
            sendEmailWithReport();
        } catch (EmailException e) {
            e.printStackTrace();
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
                    return true;
                }
            }
            attempt++;
        }
        return false;
    }

    public void sendEmailWithReport() throws EmailException {
        if (outputDirectory != null) {
         Date currentDate = new Date();
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String reportPath = outputDirectory + "/emailable-report.html";
         System.out.println("Sending email with report from: " + reportPath);   
         
         StringBuilder reportContent = new StringBuilder();
         try (BufferedReader reader = new BufferedReader(new FileReader(reportPath))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 reportContent.append(line);
             }
         } catch (IOException e) {
             e.printStackTrace();
             System.out.println("Failed to read the report file.");
             return;
         }
         
         if(attachmentPath ==null) {
			 attachmentPath = "screenshots/AllTestCasesPassed.png";
			
		}

            EmailAttachment attachment = new EmailAttachment();
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Test Report");
            attachment.setPath(attachmentPath);
//            attachment.setPath(Logo);
            System.out.println("path to SS: "+attachmentPath);
            attachment.setName(subject+dateFormat.format(currentDate)+".png");

            
            
//            noreply@okrstars.com
            
//		    email.setHostName("smtp.zeptomail.in");
//		    email.setSmtpPort(587);
//		    "noreply@okrstars.com", "PHtE6r0OE+/q2TQppkUD4/6/Hs6tZ456+rtlLwMWtopEDfBQGU1Sr9kilWSx/ksuA/VFFP/JzNpqsLuY4uKMI2rtZDxMWWqyqK3sx/VYSPOZsbq6x00bt1gfdkDeUILue9Zq3SfTuN7ZNA=="         
        
//            skipmanagergobetter@gmail.com
            
//          email.setHostName("smtp.gmail.com");
//          email.setSmtpPort(587);
//          email.setAuthenticator(new DefaultAuthenticator("skipmanagergobetter@gmail.com", "wocx rawr lldu sfws"));

            
            HtmlEmail email = new HtmlEmail();
            email.setHostName("mail.usrinfotech.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("noreply@usrinfotech.com", "]#hoPoQxTqYr")); // ]#hoPoQxTqYr
            email.setSSLOnConnect(true);
            email.setFrom("noreply@usrinfotech.com");
            email.setSubject("Test Instance Test Report");
            email.setHtmlMsg("Test Report: "+reportContent.toString());
                  
            String[] recipients = {"Hanumanth@usrinfotech.com","bharath@usrinfotech.com"};


//    		"ravi@okrstars.co","santhosh@usrinfotech.com","vaidya@usrinfotech.com","subashini@usrinfotech.com" ,"Bharath@usrinfotech.com"

            for (String recipient : recipients) {
                email.addTo(recipient);
            }
         
            email.attach(attachment);
            email.send();
            System.out.println("Email sent successfully!");
        } else {
            System.out.println("Error: Output directory is not set.");
        }
    }
	public static void Screenshortpath(String subject, String body, String attachmentPath) {
		
		Email_able_report_Sender.attachmentPath = attachmentPath;
		Email_able_report_Sender.subject=subject;
	}
}
