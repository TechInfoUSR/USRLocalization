package Utils;

import javax.mail.*;
import javax.mail.internet.*;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.util.Properties;

public class EmailUtil {

    public static void sendEmail(String to, String subject, String body, String attachmentPath) {
        final String from = "noreply@okrstars.com";
        final String password = "PHtE6r0OE+/q2TQppkUD4/6/Hs6tZ456+rtlLwMWtopEDfBQGU1Sr9kilWSx/ksuA/VFFP/JzNpqsLuY4uKMI2rtZDxMWWqyqK3sx/VYSPOZsbq6x00bt1gfdkDeUILue9Zq3SfTuN7ZNA==";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.zeptomail.in");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(attachmentPath);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
