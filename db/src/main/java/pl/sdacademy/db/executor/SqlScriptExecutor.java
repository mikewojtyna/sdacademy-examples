package pl.sdacademy.db.executor;

public interface SqlScriptExecutor {
	/**
	 * Executes the script inside the classpath.
	 *
	 * @param classpath path to the script inside the classpath
	 * @throws SqlScriptExecutorException throws exception if executor fails
	 */
	void execute(String classpath) throws SqlScriptExecutorException;
}
