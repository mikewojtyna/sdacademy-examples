package pl.sdacademy.db.transfer;

@FunctionalInterface
public interface ThrowingRunnable {
	void run() throws Exception;
}
