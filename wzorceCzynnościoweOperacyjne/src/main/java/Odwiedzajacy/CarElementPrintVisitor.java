package Odwiedzajacy;

class CarElementPrintVisitor implements CarElementVisitor {
	public void visit(final Body body) {
		System.out.println("Visiting body");
	}

	public void visit(final Car car) {
		System.out.println("Visiting car");
	}

	public void visit(final Engine engine) {
		System.out.println("Visiting engine");
	}

	public void visit(final Wheel wheel) {
		System.out.println("Visiting " + wheel.getName() + " wheel");
	}
}
