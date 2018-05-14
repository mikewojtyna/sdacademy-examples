package pl.sdacademy.regular_expression.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IpFinderTest {

	//w obu metodach będziemy używać tych samych danych testowych, dlatego warto je zapisać w jednym miejscu, np. jako stałe klasy IpFinderTest

	private static final String TEST_IP1 = "10.234.20.90";
	private static final String TEST_TEXT1 =  "Serwer gry dostępny jest pod adresem " + TEST_IP1 + " - miłej zabawy!"; //żeby uniknąć powtórzeń, umieszczamy zmienną TEST_IP1 w środku naszego testowego napisu
	private static final String TEST_IP2 = "23.340.45.900";
	private static final String TEST_TEXT2 = "Adres domeny mojafirma.com to" + TEST_IP2;
	private static final String TEST_BAD_TEXT1  = "Współrzędne to 90.3454 stopnie na północ";
	private static final String TEST_BAD_TEXT2  = "Tu nie ma nawet żadnych cyfr!";

	private IpFinder ipFinder;

	@Before
	//metoda oznaczona adnotacją @Before będzie wywoływana przed każdą metodą oznaczoną adnotacją @Test - każda metoda test otrzyma świeżą wersję obiektu IpFinder. Jest to istotne kiedy testowany obiekt w trakcie testu zmienia swój stan, np. wartości pól
	public void setUp() throws Exception {
		ipFinder = new IpFinder();
	}

	@Test //metody testowe oznaczone są adnotacją @Test. Jeżeli jakakolwiek asercja nie zostanie spełniona, dana metoda będzie oznaczona jako czerwona (=test nie przechodzi)
	public void hasIp() throws Exception {
		assertTrue(ipFinder.hasIp(TEST_TEXT1)); //asercja jest spełniona jeśli metoda hasIp zwróci prawdę dla argumentu TEST_TEXT1
		assertTrue(ipFinder.hasIp(TEST_TEXT2)); //j.w.
		assertFalse(ipFinder.hasIp(TEST_BAD_TEXT1));//asercja jest spełniona jeśli metoda hasIp zwróci fałsz dla argumentu TEST_BAD_TEXT1
		assertFalse(ipFinder.hasIp(TEST_BAD_TEXT2)); //j.w.
		assertFalse(true);

	}

	@Test
	public void getIp() throws Exception {
		assertEquals(ipFinder.getIp(TEST_TEXT1), TEST_IP1); //asercja jest spełniona, jeśli jeśli to co zwróci metoda getIp dla napisu TEST_TEXT1 jest takie samo jak TEST_IP1
		assertEquals(ipFinder.getIp(TEST_TEXT2), TEST_IP2); //j. w.
		assertNull(ipFinder.getIp(TEST_BAD_TEXT1)); //asercja jest spełniona, jeśli to co zwróci metoda getIp dla napisu TEST_BAD_TEXT1 jest nullem
		assertNull(ipFinder.getIp(TEST_BAD_TEXT2)); //j. w.

	}

	@Test
	public void getIpAndHasIp() throws Exception {
		assertTrue(ipFinder.getIp(TEST_TEXT1) != null && ipFinder.hasIp(TEST_TEXT1));
	}
}