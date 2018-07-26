public class CarsTank {

	private TypesOfFuel carFuelType;
	private double tankCurrentVolume;
	private final double tankVolumeMax = 54;

	public CarsTank(TypesOfFuel carFuelType) {
		this.carFuelType = carFuelType;
	}

	double getTankVolumeMax() {
		return tankVolumeMax;
	}
	double getTankCurrentVolume() {
		return tankCurrentVolume;
	}

	void setTankCurrentVolume(double currentVolume) {
		this.tankCurrentVolume = currentVolume;
	}

	boolean checkIfTankIsFull() {
		if (tankCurrentVolume == tankVolumeMax) {
			return true;
		}
		else {
			return false;
		}
	}
}
