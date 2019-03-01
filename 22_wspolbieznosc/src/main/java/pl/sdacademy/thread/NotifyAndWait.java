package pl.sdacademy.thread;

public class NotifyAndWait {
	public static void main(String[] args) throws InterruptedException {
		WaitAndNotify notifyClass = new WaitAndNotify();

		Thread thread0 = new Thread(notifyClass);
		thread0.start();

		Thread.sleep(1000);

		notifyClass.notifySingleThread();
	}

	private static class WaitAndNotify implements Runnable {

		synchronized void notifySingleThread() {
			notify();
		}

		@Override
		synchronized public void run() {
			System.out.printf("Thread %d waits inside runnable.\n", Thread.currentThread().getId());
			try {
				wait();
				System.out.printf("Thread %d stopped waiting.\n", Thread.currentThread().getId());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
