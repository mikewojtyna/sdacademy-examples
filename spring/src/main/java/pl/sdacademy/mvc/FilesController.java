package pl.sdacademy.mvc;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mvc/files")
public class FilesController {

	private Path uploadedFilesPath;

	public FilesController() throws IOException {
		uploadedFilesPath = createTempDir();
	}

	@PostMapping
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		saveFile(file);
		return "redirect:/mvc/files";
	}

	@GetMapping
	@RequestMapping("/{file}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("file") String file) {
		return responseEntity(file);
	}

	@GetMapping
	public String loadView(Model model) {
		model.addAttribute("files", findAllFiles());
		return "upload-file";
	}

	private Path createTempDir() throws IOException {
		return Files.createTempDirectory("spring-uploaded-files");
	}

	private ResponseEntity<Resource> responseEntity(String file) {
		try {
			Path path = resolveFilePath(file);
			MediaType contentType =
				Optional.ofNullable(Files.probeContentType(path)).map(MediaType::valueOf).orElse(MediaType.APPLICATION_OCTET_STREAM);
			return ResponseEntity.ok().contentType(contentType).body(new FileSystemResource(path));
		}
		catch (IOException e) {
			throw wrapEx(e);
		}
	}

	private RuntimeException wrapEx(Exception e) {
		return new RuntimeException(e);
	}


	private Collection<String> findAllFiles() {
		try {
			return Files.list(uploadedFilesPath).map(p -> p.getFileName().toString()).collect(Collectors.toList());
		}
		catch (IOException e) {
			throw wrapEx(e);
		}
	}

	private void saveFile(MultipartFile file) {
		try {
			Path path = resolveFilePath(file.getOriginalFilename());
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e) {
			throw wrapEx(e);
		}
	}

	private Path resolveFilePath(String fileName) {
		return uploadedFilesPath.resolve(uploadedFilesPath.resolve(Paths.get(fileName)));
	}
}
