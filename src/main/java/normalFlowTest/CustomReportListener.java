package normalFlowTest;

import java.io.File;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.xml.XmlSuite;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.AddEmployeetoDB;
import NormalFlowForEmployee.addGoalPlan;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomReportListener implements IReporter{

	   private static String attachmentPath,subject;
	   
	
    private WebDriver driver;
    addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    AddEmployeetoDB AddEmployeetoDB;

    @BeforeClass
    public void setUp() {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("EmpUN"), prop.getProperty("Emppass"));
        AddEmployeetoDB = new AddEmployeetoDB(driver, prop);
    }


    // Instance variable to store the output directory
    private String outputDirectory;

    

    void Screenshort() {
    	
    }
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

    public void sendEmailWithReport() throws EmailException {
        if (outputDirectory != null) {
       	 long systemTime = System.currentTimeMillis();
         Time time = new Time(systemTime);
         Date currentDate = new Date();
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         System.out.println(dateFormat.format(currentDate));
         String reportPath = outputDirectory + "/emailable-report.html"; // Path to the TestNG report
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

         String Logo = "screenshots/Logo.png";
            EmailAttachment attachment = new EmailAttachment();
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Test Report");
            attachment.setPath(attachmentPath);
//            attachment.setPath(Logo);
            System.out.println("path to SS: "+attachmentPath);
            attachment.setName(subject+dateFormat.format(currentDate)+".png");
            
            
            

//            MultiPartEmail email = new MultiPartEmail();
//            HtmlEmail email = new HtmlEmail();
//            email.setHostName("smtp.zeptomail.in");
//            email.setSmtpPort(587);
//            email.setAuthenticator(new DefaultAuthenticator("noreply@pms-gobetter.com", "PHtE6r0EEeHogjEt8BUCsaKwHsH2Yd54r+02K1ZAsdxLXqULSk1SqNsrlzTh+hcqAaFCE6bJnItt5OuasO6AIWjuY21LWWqyqK3sx/VYSPOZsbq6x00YuVoTd0PVXYHudtNq3CXVs97YNA=="));
//            email.setSSLOnConnect(true);
//            email.setFrom("noreply@pms-gobetter.com");
//            email.setSubject("Test Instance Test Report");
//            email.setHtmlMsg("Test Report: "+reportContent.toString());
            
            HtmlEmail email = new HtmlEmail();
            email.setHostName("mail.usrinfotech.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("noreply@usrinfotech.com", "]#hoPoQxTqYr"));
            email.setSSLOnConnect(true);
            email.setFrom("noreply@usrinfotech.com");
            email.setSubject("Test Instance Test Report");
            email.setHtmlMsg("Test Report: "+reportContent.toString());
            
//          String[] recipients = {"Hanumanth@usrinfotech.com","partnership@usrinfo.tech","ravi@okrstars.co","santhosh@usrinfo.tech","vaidya@usrinfo.tech","subashini@usrinfo.tech","support@okrstars.co"};       
            String[] recipients = {"Hanumanth@usrinfotech.com","ravi@okrstars.co","support@okrstars.co"};
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
		
		CustomReportListener.attachmentPath = attachmentPath;
		CustomReportListener.subject=subject;
	}

    
//    public static void sendEmail(String to, String subject, String body, String attachmentPath) {
//        
//        Session session = Session.getInstance(properties, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(from, password);
//            }
//        });
//    	
//    	
//    try {
//        Message message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(from));
//        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//        message.setSubject(subject);
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setText(body);
//
//        MimeBodyPart attachmentPart = new MimeBodyPart();
//        attachmentPart.attachFile(attachmentPath);
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//        multipart.addBodyPart(attachmentPart);
//
//        message.setContent(multipart);
//
//        Transport.send(message);
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    
//    }
    
}
