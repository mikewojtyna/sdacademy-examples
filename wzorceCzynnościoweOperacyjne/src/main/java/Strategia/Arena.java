package Strategia;

import java.util.ArrayList;
import java.util.List;

class Arena{

	private List<Knight> knights;
	private KnightValidator validator;

	public Arena(KnightValidator validator){

		this.validator = validator;

		knights =  new ArrayList<Knight>();

	}

	public void addKnight(Knight knight){

		if(validator.validate(knight))
			knights.add(knight);

	}

	public String toString(){
		String out ="";
		for(Knight knight : knights)
			out += "Rycerz " +  knight.getName() + "\n";

		return out;

	}
}