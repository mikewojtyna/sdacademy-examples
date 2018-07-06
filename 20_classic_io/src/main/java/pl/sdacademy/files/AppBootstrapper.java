package pl.sdacademy.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class AppBootstrapper {
	static void run() {
		try

		{
			List<String> lines = Files.readAllLines(Paths.get("files", "three-lines.txt"));
			Files.write(Paths.get("files", "three-lines-copy.txt"), lines);

			for (String line : lines) {
				System.out.println(line);
			}

		}
		catch (IOException e)

		{
			System.err.println("Failed to read file");
		}
	}
}
