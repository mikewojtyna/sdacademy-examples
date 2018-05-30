package pl.bank;

public class Bank {
	public static void main(String[] args) {
		Konto pkoKonto = new Konto(1000);
		//Konto pkoKonto = new KontoPremium(1000, 300);
		pkoKonto.pobierzPieniadze(300);
		pkoKonto.pobierzPieniadze(500);
		pkoKonto.pobierzPieniadze(300);
		pkoKonto.pobierzPieniadze(400);
	}
}
