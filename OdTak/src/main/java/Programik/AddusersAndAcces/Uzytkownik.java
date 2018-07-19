package Programik.AddusersAndAcces;

import java.util.Scanner;

public class Uzytkownik {

	private String id;
	private Mediator mediator;
	private String imieDodawane;
	Scanner scanner = new Scanner(System.in);

	public String getImieDodawane() {
		System.out.println("Podaj imie uzytkownika. ");
		imieDodawane = scanner.nextLine();
		return imieDodawane;
	}

	public String getId() {
		System.out.println("Podaj id. ");
		id = scanner.nextLine();
		return id;
	}

	public Uzytkownik(String id, String imieDodawane) {
		this.id = id;
		this.imieDodawane = imieDodawane;
	}

	void zarejestrujMediatora(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public String toString() {
		return "Uzytkownik{" + "id='" + id + '}';
	}
}
