package pl.edu.agh.kis.javagradleservicestest.messagesapi;

import javax.mail.Authenticator;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import pl.edu.agh.kis.javagradleservicestest.exceptions.ApplicationException;

public class MailServiceImpl implements MailService {
	
	private String mailServerHostName;
	private short portService;
	private Authenticator auth;
	private String accountName;
	
	
	
	public MailServiceImpl(String mailServerHostName, short portService, String accountName, String user,String password) {
		super();
		this.mailServerHostName = mailServerHostName;
		this.portService = portService;
		this.accountName = accountName;
		auth = new DefaultAuthenticator(user, password);
	}

	@Override
	public void sendMessage(List<String> recipients, String title, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(mailServerHostName);
			System.out.println("port: "+portService);
			email.setSmtpPort(portService);
			email.setSslSmtpPort(""+portService);
			email.setAuthenticator(auth);
			email.setStartTLSEnabled(true);
			email.setFrom(accountName);
			
			email.setSubject(title);
			email.setMsg(message);
			for (String recipient : recipients) {
				email.addTo(recipient);
			}
			email.send();
		} catch (EmailException e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public void sendMessage(String recipient, String title, String message) {
		sendMessage(Arrays.asList(recipient),title,message);
	}

}
