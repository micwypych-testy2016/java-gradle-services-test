package pl.edu.agh.kis.javagradleservicestest.messagesapi;

import java.util.List;

public interface MailService {
	public void sendMessage(List<String> recipients,String title,String message);
	
	public void sendMessage(String recipient,String title,String message);

}
