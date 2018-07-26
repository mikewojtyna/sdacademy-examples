public class Tires  {

	private byte conditionsOfWheels;
	private final byte thresholdForChangeWheels = 50;
	private byte tiresWearDuringPerLap = 2;

	byte getThresholdForChangeWheels() {
		return thresholdForChangeWheels;
	}

	byte getConditionsOfWheels() {
		return conditionsOfWheels;
	}

	byte setConditionsOfWheels(byte conditionsOfWheels) {
		return this.conditionsOfWheels;

	}

	byte tiresWearDuringRace(Track track){
		while (track.getCurrentRaceLaps() < 100){
			conditionsOfWheels += tiresWearDuringPerLap;
			setConditionsOfWheels(conditionsOfWheels);
		}
		return getConditionsOfWheels();
	}

}
