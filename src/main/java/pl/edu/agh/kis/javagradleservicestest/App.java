package pl.edu.agh.kis.javagradleservicestest;

import java.util.HashMap;

import pl.edu.agh.kis.javagradleservicestest.messagesapi.MailService;
import pl.edu.agh.kis.javagradleservicestest.messagesapi.MailServiceImpl;

public class App {

	public static void main(String[] args) {
		final String USER_NAME =  "jatesty.testy";
		final String PASS = "testytesty_1";
		new HashMap<String,String>().equals(null);
		MailService mailService = new MailServiceImpl("poczta.interia.pl", (short) 587, USER_NAME+"@interia.pl", USER_NAME, PASS);
		mailService.sendMessage("test@mail.com","Hello JAVA","Hello, how are you Pete!");
		
	}

}
