package Programik.AddusersAndAcces;

public class Uzytkownik {

	private String id;
	private Mediator mediator;
	
	public Uzytkownik(String id) {this.id=id;}
	void zarejestrujMediatora(Mediator mediator){this.mediator=mediator;}
	String getId(){return id;}

}
