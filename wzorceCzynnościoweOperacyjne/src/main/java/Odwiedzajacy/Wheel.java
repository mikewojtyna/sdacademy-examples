package Odwiedzajacy;

public class Wheel implements CarElement {
	private String name;

	public Wheel(final String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	@Override
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}
}
