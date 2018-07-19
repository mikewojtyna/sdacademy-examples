package pl.sdacademy.printer;

public class Documents {
	private boolean printed;

	public Documents(boolean b) {
		this.printed = b;
	}

	public boolean isPrinted() {
		return printed;
	}

	public void setPrinted(boolean b) {
		printed = b;
	}
}
