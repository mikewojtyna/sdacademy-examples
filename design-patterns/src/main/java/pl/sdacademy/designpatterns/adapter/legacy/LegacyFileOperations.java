package pl.sdacademy.designpatterns.adapter.legacy;

import java.io.File;

public interface LegacyFileOperations {
	void createMultipleFiles(boolean overwrite, File... files);

	void deleteFileByPath(String file);
}
