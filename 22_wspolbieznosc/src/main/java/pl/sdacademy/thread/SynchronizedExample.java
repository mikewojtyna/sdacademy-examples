package pl.sdacademy.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {
	private static Object obj = new Object();

	public static void main(String[] args) {
		TestClass testObj = new TestClass();

		int numberOfThreadsInPool = 2;
		// uncomment this to see what happens
		// numberOfThreadsInPool = 3;
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreadsInPool);
		executorService.submit(testObj::method0);
		executorService.submit(testObj::method1);
		executorService.submit(testObj::method2);
	}

	private static class TestClass {
		void method0() {
			// something
			synchronized (obj) {
				try {
					System.out.println("Executing method 0 from thread " + Thread.currentThread().getId());
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		void method2() {
			try {
				System.out.println("Executing method 2 from thread " + Thread.currentThread().getId());
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		void method1() {
			synchronized (obj) {
				try {
					System.out.println("Executing method 1 from thread " + Thread.currentThread().getId());
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
