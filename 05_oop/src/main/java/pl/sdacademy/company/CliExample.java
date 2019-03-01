package pl.sdacademy.company;

public class CliExample {
	public static void main(String[] args) {
		try (CommandLineInterface userInterface = new CommandLineInterface(chooseCompanyImpl())) {
			userInterface.initInterface();
		}
	}

	private static Company chooseCompanyImpl() {
		return new InMemoryCompany();
	}
}
