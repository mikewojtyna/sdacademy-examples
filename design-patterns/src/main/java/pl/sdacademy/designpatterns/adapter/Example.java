package pl.sdacademy.designpatterns.adapter;

import pl.sdacademy.designpatterns.adapter.legacy.VeryUglyLegacyFileOperations;

import java.io.IOException;

public class Example {
	public static void main(String[] args) throws IOException {
		FileOperations fileOperationsUsingUglyAdaptee =
			new FileOperationsAdapter(new VeryUglyLegacyFileOperations());
		Client client = new Client(fileOperationsUsingUglyAdaptee);
		client.runDemo();
	}
}
