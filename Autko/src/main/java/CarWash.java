class CarWash {
	byte wash(Car car) {
		if ( car.getCurrentDegreeOfClean() >= car.getThresholdForCarWashing()){
			car.setCurrentDegreeOfClean((byte)0);
		return car.getCurrentDegreeOfClean();}
		else return car.getCurrentDegreeOfClean();
	}
}
