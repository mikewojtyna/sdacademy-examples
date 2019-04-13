package pl.sdacademy.testhomework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VovelsCounterTest {

	private static final String text1 = "TEXT_1";
	private static final int text1Vovels = 1;
	private static final String text2 = "TEEXT_2";
	private static final int text2Vovels = 2;
	private static final String text3 = "TEAXT_2";
	private static final int text3Vovels = 2;
	private VovelsCounter vovelsCounter;

	@BeforeEach
	public void setUp() {
		vovelsCounter = new VovelsCounter();
	}

	@Test
	@Disabled("Remove @Disabled to test your implementation")
	public void count() {
		assertEquals(text1Vovels, vovelsCounter.count(text1));
		assertEquals(text2Vovels, vovelsCounter.count(text2));
		assertEquals(text3Vovels, vovelsCounter.count(text3));
	}
}