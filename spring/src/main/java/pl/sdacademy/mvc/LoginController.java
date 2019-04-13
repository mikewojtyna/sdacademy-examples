package pl.sdacademy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/mvc/my-login")
	public String loginForm() {
		return "my-login";
	}
}