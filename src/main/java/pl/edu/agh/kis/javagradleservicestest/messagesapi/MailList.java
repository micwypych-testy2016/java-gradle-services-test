package pl.edu.agh.kis.javagradleservicestest.messagesapi;

import java.util.ArrayList;
import java.util.List;

public class MailList {
	
	private MailService mailSrv;
	private List<User> users;
	private String admin;
	
	public MailList(MailService mailSrv, List<User> users, String admin) {
		super();
		this.mailSrv = mailSrv;
		this.users = users;
		this.admin = admin;
	}

    static class User {
		public final String mail;
		public String status;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((mail == null) ? 0 : mail.hashCode());
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (mail == null) {
				if (other.mail != null)
					return false;
			} else if (!mail.equals(other.mail))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}

		public User(String mail,String status) {
			this.mail = mail;
			this.status = status;
		}
		
		public void changeStatus(String to) {
			this.status = to;
		}
	}
	
	public void sendMessage(String status,String title, String message) {
		List<String> recipients = new ArrayList<>();
		for (User u : users) {
			if (u.status.equals(status)) {
				recipients.add(u.mail);
			}
		}
		mailSrv.sendMessage(recipients, title, message);		
	}
	
	public void addNewRecipient(String mail) {
		User u = new User(mail,"needs-confirmation");
		users.add(u);
		mailSrv.sendMessage(u.mail, "Please Confirm", "Thank you for joining our mailing list. Please follow this link http://myweb.com/confirm to confirm your status");
	}
	
	public void changeStatusOfRecipient(String mail,String status) {
		boolean success = false;
		for(User u : users) {
			if (u.mail.equals(mail)) {
				if (u.status.equals("needs-confirmation") && status.equals("confirmed")) {	
					mailSrv.sendMessage(u.mail, "Thank you", "Your mail was confirmed successfully!");
				} else if (status.equals("confirmed") && status.equals("delete")) {	
					mailSrv.sendMessage(u.mail, "Removed", "You were removed from our mailing list. You will no longer recieve messages from us.");
				}
				success = true;
				u.changeStatus(status);
			}
		}
		if (!success) {
			mailSrv.sendMessage(admin, "ERROR", "One cannot find user: "+mail);
		}
	}

}
