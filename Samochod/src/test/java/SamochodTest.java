import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SamochodTest {

	@DisplayName("check if tank is full")
	@Test
	void test01() {
		//given
		Tank tank = new Tank();
		tank.setCurrentVolume((short) 54);
		//when
		tank.isFull();
		//then
		assertThat(tank.getCurrentVolume()).isEqualTo(tank.volumeMax);
	}

	@DisplayName("when cars tank is not full should tank fuel")
	@Test
	void test02() {
		//given
		GasStation gasStation = new GasStation();
		Tank tank = new Tank();
		//when
		gasStation.fillTankToFull(tank);
		//then
		assertThat(tank.getCurrentVolume()).isEqualTo(tank.volumeMax);
	}

	@DisplayName("should calculate price for tanked fuel")
	@Test
	void test03(){
		//given
		Tank tank = new Tank();
		tank.setCurrentVolume((short) 20);
		GasStation gasStation = new GasStation();
		//when
		short ammount = gasStation.fueled(tank);
		gasStation.paidForFuel(ammount);

		//then
		assertThat((tank.volumeMax - tank.getCurrentVolume())* gasStation.getPrice())
			.isEqualTo(gasStation.paidForFuel(ammount));
	}

	@DisplayName("should refuel the right amount of fuel")
	@Test
	void test04(){
		//given

		//when

		//then
	}
}
