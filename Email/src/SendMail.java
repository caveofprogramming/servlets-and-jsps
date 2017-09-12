import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class SendMail {

	public static void main(String[] args) {
		Properties props = new Properties();
		
		props.setProperty("mail.host", "mail.caveofprogramming.com");
		props.setProperty("mail.smtp.port", "26");
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("test2+caveofprogramming.com", "hello");
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		
		Message msg = new MimeMessage(session);
		
		try {
			msg.setSubject("Cave of Programming - Validate Your Account");
			msg.setText("Please click this link: http://www.caveofprogramming.com/verify?user=someone");
			msg.setFrom(new InternetAddress("test2@caveofprogramming.com", "John"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("webmaster@caveofprogramming.com"));
			
			Transport.send(msg);
		} catch (MessagingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished.");
	}

}
