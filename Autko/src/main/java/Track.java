public class Track {
	private byte currentRaceLaps;

	byte getCurrentRaceLaps() {
		return currentRaceLaps;
	}

	byte setCurrentRaceLap(byte currentRaceLaps) { return this.currentRaceLaps; }

	byte race() {
		while (currentRaceLaps < 100){
			currentRaceLaps++;
			setCurrentRaceLap(currentRaceLaps);
		}
		return getCurrentRaceLaps();
	}

}
