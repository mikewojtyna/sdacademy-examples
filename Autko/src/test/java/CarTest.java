import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

	Car electricCar = new Car(TypesOfFuel.ELECTRIC);
	CarsTank electricCarsTank = new CarsTank(TypesOfFuel.ELECTRIC);
	Car dieselCar = new Car(TypesOfFuel.ON);
	CarsTank dieselCarsTrack = new CarsTank(TypesOfFuel.ON);
	Car petrolCar = new Car(TypesOfFuel.PB);
	CarsTank carsTank = new CarsTank(TypesOfFuel.PB);
	PetrolStation petrolStation = new PetrolStation();
	CarWash carWash = new CarWash();
	Track track = new Track();
	Tires tires = new Tires();
	PitStop pitStop = new PitStop();
	Map<TypesOfFuel, Double> pricesList = new HashMap<>();

	@BeforeEach
	void setUp() {
		pricesList.put(TypesOfFuel.PB, 5.08);
		pricesList.put(TypesOfFuel.ON, 5.02);
		pricesList.put(TypesOfFuel.ELECTRIC, 2.67);
		petrolStation.setPricesList(pricesList);
	}

	@DisplayName("check if tank is full")
	@Test
	void test01() {
		//given
		carsTank.setTankCurrentVolume(54);
		//when
		carsTank.checkIfTankIsFull();
		//then
		assertThat(carsTank.getTankCurrentVolume()).isEqualTo(carsTank.getTankVolumeMax());
	}

	@DisplayName("when car's tank is not full should tank fuel")
	@Test
	void test02(){
		//given
		//when
		petrolStation.fillTankToFull(carsTank);
		//then
		assertThat(carsTank.getTankCurrentVolume()).isEqualTo(carsTank.getTankVolumeMax());
	}
	@DisplayName("Should fill specified amount of fuel.")
	@Test
	void test03() {
		//given
		double volumeBefore = electricCarsTank.getTankCurrentVolume();
		double specifiedAmountOfFuel = 10;
		//when
		petrolStation.fillSpecifiedAmountOfFuel(carsTank, specifiedAmountOfFuel);
		//then
		assertThat(electricCarsTank.getTankCurrentVolume()).isEqualTo(volumeBefore + specifiedAmountOfFuel);
	}

	@DisplayName("should pay for filled fuel")
	@Test
	void test04(){
		//given
		double specifiedAmountOfFuel = 10;
		//when
		double payment = petrolStation.payForFuel(specifiedAmountOfFuel,TypesOfFuel.ELECTRIC);
		//then
		assertThat(payment).isEqualTo(specifiedAmountOfFuel * petrolStation.getPricesList().get(TypesOfFuel
			.ELECTRIC));
	}

	@DisplayName("should wash car when it's not clean")
	@Test
	void test05(){
		//given
		//when
		carWash.wash(electricCar);
		//then
		assertThat(electricCar.getCurrentDegreeOfClean()).isEqualTo((byte)0);
	}

	@DisplayName("should change wheels when they are used")
	@Test
	void test06(){
		//given
		//when
		pitStop.changeWheels(tires);
		//then
		assertThat(tires.getConditionsOfWheels()).isEqualTo((byte)0);
	}

	@DisplayName("car should drive 100 laps on race")
	@Test
	void test07(){
		//given
		//when
		track.race();
		//then
		assertThat(track.getCurrentRaceLaps()).isEqualTo((byte) 100);
	}

	@DisplayName("when the car is doing laps on the track " +
		     "it should check if the fuel level drops and if the tire wear and dirt increase")
	@Test
	void test08(){
		//given
		track.setCurrentRaceLap((byte) 100);
		//when
		track.race();
		tires.tiresWearDuringRace(track);
		//then
		assertThat(tires.getConditionsOfWheels()).isEqualTo(200);
	}

}