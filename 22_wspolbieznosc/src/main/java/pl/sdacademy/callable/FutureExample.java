package pl.sdacademy.callable;

import java.util.concurrent.*;

public class FutureExample {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future<Integer> future0 = executorService.submit(waitForInteger(5));
		Future<Integer> future1 = executorService.submit(waitForInteger(6));
		Future<Integer> future2 = executorService.submit(waitForInteger(7));

		int sum = future0.get() + future1.get() + future2.get();
		System.out.println(sum);
		executorService.shutdown();
	}

	private static Callable<Integer> waitForInteger(int i) {
		return () -> {
			Thread.sleep(2000);
			return i;
		};
	}
}
