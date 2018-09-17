package pl.sdacademy.thread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ThreadTest {
	private boolean threadExecuted;
	private int number;

	@BeforeEach
	void beforeEach() {
		threadExecuted = false;
		number = 0;
	}

	@DisplayName("show how to start a new thread")
	@Test
	void test0() throws Exception {
		Thread fred = new Thread(() -> {
			threadExecuted = true;
		});

		fred.start();
		// this line is needed to make the test pass - why?
		fred.join();

		assertThat(threadExecuted).isTrue();
	}

	@DisplayName("show run condition")
	@Test
	void test1() throws Exception {
		Thread fred0 = new Thread(this::incrementIfLessThanOne);
		Thread fred1 = new Thread(this::incrementIfLessThanOne);

		// everything seems to be ok...
		// <START>
		fred0.start();
		fred0.join();
		fred1.start();
		fred1.join();
		// <END>
		// now, comment the lines between <START> and <END> comments
		// and uncomment the following lines
		//		fred0.start();
		//		fred1.start();
		//		fred0.join();
		//		fred1.join();
		// if the test still passes - run it a few more times

		assertThat(number).isEqualTo(1);
	}

	private void incrementIfLessThanOne() throws RuntimeException {
		if (number < 1) {
			try {
				Thread.sleep(500);
				number++;
			}
			catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
