package pl.edu.agh.kis.javagradleservicestest.messagesapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MailListTest {

	@Test
	public void addRecipientToMailingList() {
	  //setup:
		List<MailList.User> users = new ArrayList<>();
		MailService srv = new MailService() {
			
			@Override
			public void sendMessage(String recipient, String title, String message) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendMessage(List<String> recipients, String title, String message) {
				// TODO Auto-generated method stub
				
			}
		};
		MailList list = new MailList(srv,users,null);
	  //when:
		list.addNewRecipient("test@mail.ru");
	  //then:
		assertThat(users).containsOnly(new MailList.User("test@mail.ru","needs-confirmation"));
		//assertArrayEquals(new Object[] {new MailList.User("test@mail.ru","needs-confirmation")},users.toArray());
	}

	@Test
	public void addRecipientToMailingListAndRecieveSingleEmail() {
	  //setup:
		List<MailList.User> users = new ArrayList<>();
		int []numberOfExecution = new int[]{0};
		String []srvRecipient = new String[]{"NOTHING"};
		MailService srv = new MailService() {
			
			@Override
			public void sendMessage(String recipient, String title, String message) {
				numberOfExecution[0]++;
				srvRecipient[0] = recipient;
			}
			
			@Override
			public void sendMessage(List<String> recipients, String title, String message) {
				// TODO Auto-generated method stub
				
			}
		};
		MailList list = new MailList(srv,users,null);
	  //when:
		list.addNewRecipient("test@mail.ru");
	  //then:
		assertThat(numberOfExecution).containsOnly(1);
		assertThat(srvRecipient).containsOnly("test@mail.ru");
	}
}
