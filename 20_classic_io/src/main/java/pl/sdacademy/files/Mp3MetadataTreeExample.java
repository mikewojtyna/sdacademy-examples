package pl.sdacademy.files;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Duration;

public class Mp3MetadataTreeExample {
	public static void main(String[] args) throws IOException {
		Files.walkFileTree(Paths.get("files"), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (file.getFileName().toString().endsWith(".mp3")) {
					System.out.println("Visiting file " + file);
					try {
						Mp3File mp3File = new Mp3File(file);
						System.out.println("Duration in seconds: " + Duration.ofMillis(mp3File.getLengthInMilliseconds()).getSeconds());
						System.out.println("Bitrate: " + mp3File.getBitrate());
					}
					catch (UnsupportedTagException | InvalidDataException e) {
						throw new RuntimeException(String.format("Failed to read mp3 metadata "
							+ "for file %s", file), e);
					}

				}
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
