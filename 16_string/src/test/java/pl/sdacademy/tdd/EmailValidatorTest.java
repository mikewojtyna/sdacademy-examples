package pl.sdacademy.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

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