package pl.sdacademy.designpatterns.adapter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Client {
	private FileOperations fileOperations;

	public Client(FileOperations fileOperations) {
		this.fileOperations = fileOperations;
	}

	void runDemo() throws IOException {
		Path pathToFile = Paths.get("adapter-file-example.txt");
		fileOperations.createFile(pathToFile);
		Files.lines(pathToFile, Charset.forName("UTF-8")).forEach(System.out::println);
		fileOperations.deleteFile(pathToFile);
	}
}
