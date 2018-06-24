import java.util.stream.Stream;

public class CommandLineRunner {

	public static void load(String[] args, HRManager hrManager) {
		if (containsAllArguments(args))
		{
			createEmployee(args,hrManager);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	private static void createEmployee(String[] args, HRManager hrManager) {
		hrManager.create(
			extractArgument(args[0],"firstName"),
			extractArgument(args[1],"lastName"),
			extractArgument(args[2], "dateOfBirth"));
	}

	private static boolean containsAllArguments(String[] args) {
		return Stream.of(args).allMatch(
			arg -> arg.contains("firstName") ||
				arg.contains("lastName") ||
				arg.contains("dateOfBirth"));

	}

	private static String extractArgument(String argument, String argumentKey){
		return argument.split(argumentKey + "=")[1];
	}
}
