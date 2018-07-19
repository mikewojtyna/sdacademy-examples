package Programik;

import Programik.AddusersAndAcces.DodawanieUzytkownika;
import Programik.AddusersAndAcces.Uzytkownik;
import Programik.Szyfrowanie.BuildKeyPair;
import Programik.Szyfrowanie.Decrypt;
import Programik.Szyfrowanie.Encrypt;

import java.security.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		DodawanieUzytkownika dU = new DodawanieUzytkownika();
		Uzytkownik kasia = new Uzytkownik("Kasia");
		Uzytkownik tomek = new Uzytkownik("Tomek");
		dU.dodajUzytkownika(kasia);
		dU.dodajUzytkownika(tomek);
		System.out.println(dU);

		// generate public and private keys
		BuildKeyPair buildKeyPair = new BuildKeyPair();
		KeyPair keyPair = buildKeyPair.buildKeyPair();
		PublicKey pubKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		// encrypt the message
		Scanner scanner = new Scanner(System.in);
		String wiadomosc;
		System.out.println("Podaj tresc wiadomosci. ");
		wiadomosc = scanner.nextLine();

		Encrypt encrypt = new Encrypt();
		byte[] encrypted = encrypt.encrypt(privateKey, wiadomosc);
		System.out.println("Zaszyfrowano.");
		//System.out.println(new String(encrypted));  // <<encrypted message>>

		// decrypt the message
		Decrypt decrypt = new Decrypt();
		byte[] secret = decrypt.decrypt(pubKey, encrypted);
		//System.out.print("Po odszyfrowaniu: ");
		//System.out.println(new String(secret));     // This is a secret message

		System.out.println("Do kogo wysylamy wiadomosc? ");
		Scanner wyborOsoby = new Scanner(System.in);
		int wybor;
		wybor = wyborOsoby.nextInt();

		if (wybor == 1){
			System.out.println(new String(secret));
		}
		else if (wybor == 0){
			System.out.print("Brak uprawnien! ");
			System.out.println(new String(encrypted));
		}
	}

}
