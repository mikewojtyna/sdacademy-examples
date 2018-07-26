
public class GasStation {
	private short fueled;
	private short price = 503;
	private short toPay;

	short paidForFuel(short ammount) {
		return toPay = (short) (ammount * price);
	}

	short fueled(Tank tank) {
		return fueled = (short) (tank.volumeMax - tank.getCurrentVolume());
	}


	public short getPrice() {
		return price;
	}
	short fillTankToFull(Tank tank) {
		short fuelAmount = (short)0;
		if (tank.getCurrentVolume() < tank.getVolumeMax()) {
			fuelAmount = (short)(tank.getVolumeMax() - tank.getCurrentVolume());
			tank.setCurrentVolume(tank.getVolumeMax());
		}
		return fuelAmount;
	}

}
