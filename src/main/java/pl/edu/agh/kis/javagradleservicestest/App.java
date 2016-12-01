package pl.edu.agh.kis.javagradleservicestest;

import java.util.HashMap;

import pl.edu.agh.kis.javagradleservicestest.messagesapi.MailService;
import pl.edu.agh.kis.javagradleservicestest.messagesapi.MailServiceImpl;

public class App {

	public static void main(String[] args) {
		//jatesty.testy@interia.pl
		//testytesty_1
		new HashMap<String,String>().equals(null);
		MailService mailService = new MailServiceImpl("smtp.gmail.com", (short) 465, "username", "password");
		mailService.sendMessage("test@mail.com","Hello JAVA","Hello, how are you Pete!");
		
	}

}
