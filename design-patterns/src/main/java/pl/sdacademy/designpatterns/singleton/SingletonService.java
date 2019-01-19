package pl.sdacademy.designpatterns.singleton;

public class SingletonService {
	private static SingletonService instance;

	private SingletonService() {

	}

	public static synchronized SingletonService getInstance() {
		if (instance == null) {
			instance = new SingletonService();
		}
		return instance;
	}

	public void makeSomethingImportant() {

	}
}
