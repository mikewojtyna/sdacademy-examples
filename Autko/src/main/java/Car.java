public class Car {
	private TypesOfFuel carFuelType;
	private byte currentDegreeOfClean;
	private final byte thresholdForCarWashing = 70;

	Car(TypesOfFuel carFuelType) {
		this.carFuelType = carFuelType;
	}

	byte getThresholdForCarWashing() {
		return thresholdForCarWashing;
	}
	byte getCurrentDegreeOfClean() {
		return currentDegreeOfClean;
	}

	byte setCurrentDegreeOfClean(byte currentDegreeOfClean) {
		this.currentDegreeOfClean = currentDegreeOfClean;
		return currentDegreeOfClean;
	}

}
