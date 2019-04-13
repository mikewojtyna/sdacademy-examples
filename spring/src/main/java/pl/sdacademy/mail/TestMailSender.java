package pl.sdacademy.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class TestMailSender {

	private MailSender mailSender;

	public TestMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendTestMessage(String recipient) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipient);
		message.setSubject("Test message");
		message.setText("Test message content");
		mailSender.send(message);
	}
}
