package Programik.AddusersAndAcces;

import java.util.Scanner;

public class Uzytkownik {

	private Integer id;
	private int pozycja;
	private Mediator mediator;
	private String imieDodawane;
	Scanner scanner = new Scanner(System.in);

	public Uzytkownik(Integer id, String imieDodawane) {
		this.id = id;
		this.imieDodawane = imieDodawane;
		this.pozycja = pozycja;
	}

	public String getImieDodawane() {
		System.out.println("Podaj imie uzytkownika. ");
		imieDodawane = scanner.nextLine();
		return imieDodawane;
	}
	public Integer getId() {
		System.out.println("Podaj id. ");
		id = scanner.nextInt();
		return id;
	}

	public int getPozycja() {
		return pozycja;
	}

	void zarejestrujMediatora(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public String toString() {
		return "Uzytkownik{" + "id='" + id + '}';
	}
}
