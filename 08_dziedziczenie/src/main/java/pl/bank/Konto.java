package pl.bank;

public class Konto {

	private int stanKonta;

	public Konto(int stanKonta) {
		this.stanKonta = stanKonta;
	}

	public int getStanKonta() {
		return stanKonta;
	}

	public void setStanKonta(int stanKonta) {
		this.stanKonta = stanKonta;
	}

	public void pobierzPieniadze(int ilePobrac) {
		if(stanKonta - ilePobrac >= 0) {
			stanKonta -= ilePobrac;
			System.out.println("Pobrano" + ilePobrac + ", zostało " + stanKonta);
		} else {
			System.out.println("Brak środków!!");
		}
	}
}
