package pl.sdacademy.test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	public static void main(String[] args) {
		List<User> lista = new ArrayList<>();
		User user = new User("adam");
		lista.add(user);
		lista.add(user);
		lista.remove(user);

		System.out.println(lista);
	}
}
