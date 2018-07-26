import java.util.HashMap;
import java.util.Map;

class PetrolStation {

	Map<TypesOfFuel, Double> pricesList = new HashMap<>();

	double fillTankToFull(CarsTank carsTank) {
		double fuelAmount = 0;
		if (carsTank.getTankCurrentVolume() < carsTank.getTankVolumeMax()) {
			fuelAmount = (carsTank.getTankVolumeMax() - carsTank.getTankCurrentVolume());
			carsTank.setTankCurrentVolume(carsTank.getTankVolumeMax());
		}
		return fuelAmount;
	}

	double fillSpecifiedAmountOfFuel(CarsTank carsTank, double specifiedAmountOfFuel){
		double volumeBefore = carsTank.getTankCurrentVolume();
		carsTank.setTankCurrentVolume(volumeBefore+specifiedAmountOfFuel);
		return specifiedAmountOfFuel;
	}

	public double payForFuel(double specifiedAmountOfFuel, TypesOfFuel typesOfFuel) {
		double priceForFilledFuel;
		return  priceForFilledFuel = typesOfFuel.getPriceForFuelUnit() * specifiedAmountOfFuel;
	}

	public void setPricesList(Map<TypesOfFuel, Double> pricesList) {
			this.pricesList = pricesList;
	}

	public Map<TypesOfFuel, Double> getPricesList() {
		return pricesList;
	}
}
