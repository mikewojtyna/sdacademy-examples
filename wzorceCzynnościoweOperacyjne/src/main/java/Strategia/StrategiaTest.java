package Strategia;

public class StrategiaTest {


	public static void main(String[] args) {

		Knight anna = new Knight(20, "Anna");
		Knight zbyszko = new Knight(40, "Zbyszko");
		Knight dobromil = new Knight(70, "Dobromil");

		KnightValidator oldValid = new OldKnightsValidator();
		KnightValidator nameValid = new MaleKnightsValidator();

		Arena eldersArena = new Arena(oldValid);
		Arena malesArena = new Arena(nameValid);

		eldersArena.addKnight(anna);
		eldersArena.addKnight(zbyszko);
		eldersArena.addKnight(dobromil);

		malesArena.addKnight(anna);
		malesArena.addKnight(zbyszko);
		malesArena.addKnight(dobromil);

		System.out.println("=== Arena seniorow ===");
		System.out.println(eldersArena);

		System.out.println("=== Arena bez rownoupranienia ===");
		System.out.println(malesArena);


	}

}