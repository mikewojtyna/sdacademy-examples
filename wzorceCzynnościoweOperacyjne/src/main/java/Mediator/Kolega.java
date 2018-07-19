package Mediator;

public class Kolega {

	private Mediator mediator;
	private String id;

	public Kolega(String id) {this.id=id;}
	public void zarejestrujMediatora(Mediator mediator) { this.mediator = mediator;}
	public String getId(){return  id;}

	public void wyslij(String id, String wiadomosc){
		System.out.println("Przesylanie wiadomosci od " + this.id + " do " + id + ": " + wiadomosc);
		mediator.wyslij(id, wiadomosc);
	}
	public void odbierz(String wiadomosc){
		System.out.println("Wiadomosc odebrana przez " + id + ": " + wiadomosc );
	}

}
