package pl.sdacademy;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.*;

class InputStreamTest {
	@DisplayName("show how to read input stream using buffered reader")
	@Test
	void test0() throws Exception {
		InputStream inputStream = createHelloInputStream();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
			String readStr = reader.readLine();
			assertThat(readStr).isEqualTo("Hello!");
		}
	}

	@DisplayName("show how to read input stream using apache commons")
	@Test
	void test1() throws Exception {
		try (InputStream inputStream = createHelloInputStream()) {
			String readStr = IOUtils.toString(inputStream, "UTF-8");
			assertThat(readStr).isEqualTo("Hello!");
		}
	}

	private InputStream createHelloInputStream() {
		// uncomment this line to take input stream from a file
		// return new FileInputStream("/tmp/test.txt");
		return new ByteArrayInputStream("Hello!".getBytes());
	}
}
