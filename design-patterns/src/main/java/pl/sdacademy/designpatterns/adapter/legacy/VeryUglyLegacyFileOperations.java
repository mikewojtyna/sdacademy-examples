package pl.sdacademy.designpatterns.adapter.legacy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A very ugly class. Unfortunately, we are forced to use it.
 */
public class VeryUglyLegacyFileOperations implements LegacyFileOperations {
	@Override
	public void createMultipleFiles(boolean overwrite, File... files) {
		for (File file : files) {
			if (overwrite) {
				FileWriter fileWriter = null;
				try {
					fileWriter = new FileWriter(file);
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
				try {
					fileWriter.write("New default content");
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			try {
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("A new file content");
				fileWriter.flush();
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void deleteFileByPath(String file) {
		new File(file).delete();
	}
}
