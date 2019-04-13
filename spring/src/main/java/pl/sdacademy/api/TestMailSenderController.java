package pl.sdacademy.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.mail.TestMailSender;

@RestController
@RequestMapping("/api/mail")
public class TestMailSenderController {

	private TestMailSender mailSender;

	public TestMailSenderController(TestMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@GetMapping
	public void sendTestMessage(@RequestParam String recipient) {
		mailSender.sendTestMessage(recipient);
	}
}
