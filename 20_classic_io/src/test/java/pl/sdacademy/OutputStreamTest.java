package pl.sdacademy;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class OutputStreamTest {
	@DisplayName("show how to write string to output stream using buffered writer")
	@Test
	void test0() throws Exception {
		// given
		String str = "Hello!";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// when
		writeMsgToStreamUsingBufferedWriter(str, outputStream);

		// then
		assertThat(outputStream.toString("UTF-8")).isEqualTo(str);
	}

	@DisplayName("show how to write string to output stream using apache commons")
	@Test
	void test1() throws Exception {
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			// given
			String str = "Hello!";

			// when
			IOUtils.write(str, outputStream, "UTF-8");

			// then
			assertThat(outputStream.toString("UTF-8")).isEqualTo(str);
		}
	}

	private void writeMsgToStreamUsingBufferedWriter(String msg, OutputStream outputStream) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"))) {
			writer.append(msg);
			writer.flush();
		}
	}
}
