class Tank {
	private short currentVolume;
	final short volumeMax = 54;

	public Tank() {

	}

	boolean isFull() {
		if (currentVolume == volumeMax) {
			return true;
		}
		else {
			return false;
		}
	}



	public void setCurrentVolume(short currentVolume) {
		this.currentVolume = currentVolume;
	}

	public short getCurrentVolume() {
		return currentVolume;
	}

	public short getVolumeMax() {
		return volumeMax;
	}
}
