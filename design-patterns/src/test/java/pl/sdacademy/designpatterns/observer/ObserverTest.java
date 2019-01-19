package pl.sdacademy.designpatterns.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ObserverTest {

	private EventManager eventManager;

	@BeforeEach
	void setup() {
		eventManager = new EventManager();
	}

	@DisplayName("should all observers be notified when event occurs")
	@Test
	void test() throws Exception {
		// given
		Observer observer0 = mock(Observer.class);
		Observer observer1 = mock(Observer.class);
		eventManager = new EventManager();
		eventManager.register(observer0, EventType.EVENT0);
		eventManager.register(observer1, EventType.EVENT1);

		// when
		eventManager.emitEvents(1, EventType.EVENT0);
		eventManager.emitEvents(1, EventType.EVENT1);

		// then
		verify(observer0, times(1)).eventOccured(EventType.EVENT0);
		verify(observer1, times(1)).eventOccured(EventType.EVENT1);
	}

	@DisplayName("should observer be notified multiple times each time for the matching event")
	@Test
	void test1() throws Exception {
		// given
		Observer observer = mock(Observer.class);
		eventManager = new EventManager();
		eventManager.register(observer, EventType.EVENT0);

		// when
		eventManager.emitEvents(100, EventType.EVENT0);

		// then
		verify(observer, times(100)).eventOccured(EventType.EVENT0);
	}

}
