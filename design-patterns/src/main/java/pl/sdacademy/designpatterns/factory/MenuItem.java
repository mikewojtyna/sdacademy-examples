package pl.sdacademy.designpatterns.factory;

enum MenuItem {
	BEER(3.5), WINE(13.5), MILK(0), TEA(0), COFFEE(0);

	private final double alcohol;

	MenuItem(double alcohol) {
		this.alcohol = alcohol;
	}

	public double getAlcohol() {
		return alcohol;
	}
}
