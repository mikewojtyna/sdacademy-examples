package pl.sdacademy.swing.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

import static org.assertj.core.api.Assertions.*;

class CopyFileTest {
	private FileCopier fileCopier;

	@BeforeEach
	void setup() {
		fileCopier = new FileCopier();
	}

	@DisplayName("should copy source file to target path")
	@Test
	void copy() throws Exception {
		// given
		String fileContent = "File content";
		Path sourcePath = createTempFileWithContent(fileContent);
		Path targetPath = createEmptyFile();

		// when
		fileCopier.copy(sourcePath, targetPath);

		// then
		String targetContent = fileContent(targetPath);
		assertThat(targetContent).isEqualTo(fileContent);
	}

	@DisplayName("should throw NoSuchFileException when source file doesn't exist")
	@Test
	void copyException() {
		// given
		Path nonExistentSourceFilePath = Paths.get("non", "existent", "file", "path.txt");

		// then
		assertThatExceptionOfType(NoSuchFileException.class).isThrownBy(() -> fileCopier.copy
			(nonExistentSourceFilePath, createEmptyFile()));
	}

	private String fileContent(Path targetPath) {
		return org.assertj.core.util.Files.contentOf(targetPath.toFile(), Charset.forName("UTF-8"));
	}

	private Path createEmptyFile() throws IOException {
		return Files.createTempFile(null, null);
	}

	private Path createTempFileWithContent(String content) throws IOException {
		Path tempFile = Files.createTempFile(null, null);
		Files.copy(new ByteArrayInputStream(content.getBytes(Charset.forName("UTF-8"))), tempFile,
			StandardCopyOption.REPLACE_EXISTING);
		return tempFile;
	}
}
