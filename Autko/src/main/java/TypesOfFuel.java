public enum TypesOfFuel {
	ON(5.03), PB(5.30), ELECTRIC(2.67);

	private final double priceForFuelUnit;

	 TypesOfFuel(double priceForFuelUnit) {
		this.priceForFuelUnit = priceForFuelUnit;
	}

	public double getPriceForFuelUnit() {
		return priceForFuelUnit;
	}
}

