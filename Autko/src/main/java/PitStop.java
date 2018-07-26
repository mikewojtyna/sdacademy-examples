public class PitStop {

	byte changeWheels(Tires tires){
		if (tires.getConditionsOfWheels() >= tires.getThresholdForChangeWheels()){
			tires.setConditionsOfWheels((byte)0);
		return tires.getConditionsOfWheels();}
			else return tires.getConditionsOfWheels();
		}
	}

