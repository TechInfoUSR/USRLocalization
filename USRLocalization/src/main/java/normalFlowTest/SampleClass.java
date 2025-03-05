package normalFlowTest;

import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
public class SampleClass implements IReporter, IExecutionListener {
	  
	  private String testOutDir;

	  @Override
	  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
	      String outputDirectory) {
	    this.testOutDir = outputDirectory;
	  }

	  @Override
	  public void onExecutionFinish(){
	    //Include code here to send an email. The reports will be available in the path that is stored
		  EmailAttachment attachment = new EmailAttachment();
	    	
	    	attachment.setDisposition(EmailAttachment.ATTACHMENT);
	    	attachment.setDescription("in this page bug is there");
//	    	attachment.setName("Bug pic"+ SS);
	    	
	    	
	    	attachment.setPath(".//test-output/emailable-report.html");
	    	attachment.setName("Bug Report");
	    	
	    	
	    	System.out.println("Mail trigger");  	
	    	MultiPartEmail email = new MultiPartEmail();
		    email.setHostName("smtp.zeptomail.in");
		    email.setSmtpPort(587);
		    email.setAuthenticator(new DefaultAuthenticator("noreply@okrstars.com", "PHtE6r0OE+/q2TQppkUD4/6/Hs6tZ456+rtlLwMWtopEDfBQGU1Sr9kilWSx/ksuA/VFFP/JzNpqsLuY4uKMI2rtZDxMWWqyqK3sx/VYSPOZsbq6x00bt1gfdkDeUILue9Zq3SfTuN7ZNA=="));
		    email.setSSLOnConnect(true);
		    try {
				email.setFrom("noreply@okrstars.com");
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    email.setSubject("Bug is threr in Production Dev Team Please fix it");
		    try {
				email.setMsg("Dev team Fix this issue");
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				email.addTo("Hanumanth@usrinfotech.com");
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    
	        try {
				email.attach(attachment);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				email.send();
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  // in "this.testOutDir"
	  }

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		
	}
	}