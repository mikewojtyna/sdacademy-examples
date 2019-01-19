package pl.sdacademy.designpatterns.observer;

import java.util.EnumMap;
import java.util.Map;

public class EventManager {

	private Map<EventType, Observer> observers;

	public EventManager() {
		observers = new EnumMap<>(EventType.class);
	}

	public void register(Observer observer, EventType event) {
		observers.put(event, observer);
	}

	public void emitEvents(int n, EventType eventType) {
		for (int i = 0; i < n; i++) {
			Observer observer = observers.get(eventType);
			if (observer != null) {
				observer.eventOccured(eventType);
			}
		}
	}
}
