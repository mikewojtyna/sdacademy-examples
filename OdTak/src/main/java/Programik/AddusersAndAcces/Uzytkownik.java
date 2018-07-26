package Programik.AddusersAndAcces;

import java.util.Scanner;

public class Uzytkownik {

	private int id;
	private int pozycja;
	private Mediator mediator;
	private String imieUzytkownika;
	private String nazwiskoUzytkownika;
	Scanner scanner = new Scanner(System.in);

	public Uzytkownik(int id, int pozycja, String imieUzytkownika, String nazwiskoUzytkownika) {
		this.id = id;
		this.imieUzytkownika = imieUzytkownika;
		this.pozycja = pozycja;
		this.nazwiskoUzytkownika=nazwiskoUzytkownika;
	}

	public String getImieUzytkownika() {
		System.out.println("Podaj imie uzytkownika. ");
		imieUzytkownika = scanner.nextLine();
		return imieUzytkownika;
	}

	public String getNazwiskoUzytkownika(){
		System.out.println("Podaj nazwisko. ");
		nazwiskoUzytkownika = scanner.nextLine();
		return nazwiskoUzytkownika;
	}

	public int getId() {
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
