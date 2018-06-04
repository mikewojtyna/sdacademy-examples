package pl.sdacademy.swing.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ClasspathResourceReaderTest {
	private ClasspathResourceReader reader;

	@BeforeEach
	void setup() {
		reader = new ClasspathResourceReader();
	}

	@DisplayName("should read all lines of a text file inside the classpath")
	@Test
	void readLines() throws Exception {
		// given
		// test file containing 3 lines - "line0", "line1" and "line2"
		// this file exists in src/test/resources directory - go ahead and see it
		Path pathToTestFile = Paths.get("file.txt");

		// when
		Stream<String> allLines = reader.readAllLines(pathToTestFile);

		// then
		assertThat(allLines).containsOnly("line0", "line1", "line2");
	}

	@DisplayName("should throw exception when read all lines of non-existent file")
	@Test
	void readLinesException() {
		// given
		Path pathToNonExistentFile = Paths.get("path", "to", "non-existent", "file.txt");

		// then
		assertThatExceptionOfType(NoSuchFileException.class).isThrownBy(() -> reader.readAllLines
			(pathToNonExistentFile));
	}
}