package pl.sdacademy.thread;

public class CounterExample {

	public static void main(String[] args) {

		MyCounter myCounter = new MyCounter(5);

		runInNThreads(() -> {
			for (int i = 0; i < 10; i++) {
				myCounter.decrement();
				System.out.println(myCounter.getCount());
			}
		}, 1_000);
	}

	private static void runInNThreads(Runnable runnable, int numberOfThreads) {
		for (int i = 0; i < numberOfThreads; i++) {
			new Thread(runnable).start();
		}
	}

	private static class MyCounter {
		private int count;

		public MyCounter(int count) {
			this.count = count;
		}

		public int getCount() {
			return count;
		}

		void decrement() {
			if (count > 0) {
				// w tym miejscu mija troche czasu, zanim przejdziemy do count--
				try {
					Thread.sleep(100);
					count--;
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
