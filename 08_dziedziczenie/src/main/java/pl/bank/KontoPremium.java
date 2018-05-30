package pl.bank;

public class KontoPremium extends Konto {

	private int debet;

	public KontoPremium(int stanKonta, int debet) {
		super(stanKonta);
		this.debet = debet;
	}

	@Override
	public void pobierzPieniadze(int ilePobrac) {
		if((this.getStanKonta() + debet) - ilePobrac > 0) {
			this.setStanKonta(this.getStanKonta() - ilePobrac);
			System.out.println("Pobrano " + ilePobrac + ", stan konta: " + getStanKonta());
		} else {
			System.out.println("Przekroczono limit (i to z debetem!!!)");
		}
	}

	public int getDebet() {
		return debet;
	}
}
