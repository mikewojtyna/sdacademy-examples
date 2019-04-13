package pl.sdacademy.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

	EmailValidator emailValidator = new EmailValidator();

	@Test
	public void isValidEmail() throws Exception {
		assertTrue(emailValidator.isValid("adam@example.com"));
		assertTrue(emailValidator.isValid("agnieszka.kowalska@gmail.com"));
		assertFalse(emailValidator.isValid("bad.email.com"));
		assertFalse(emailValidator.isValid("bad@@email.com"));
	}

}