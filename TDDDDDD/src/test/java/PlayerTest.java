import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

	@DisplayName("Check do player exist.")
	@Test
	void test00() {
		//given

		//when
		Player playerOne = new Player("Tateusz");

		//then
		assertThat(playerOne).isNotNull();
	}

	@DisplayName("check if playern name is Papryk")
	@Test
	void test01() {
		//given
		String playerName = "Papryk";
		//when
		Player playerOne = new Player(playerName);
		//then
		assertThat(playerOne.getPlayerName()).isEqualTo(playerName);

	}

	@DisplayName("check if player name is Tatryk")
	@Test
	void test02() {
		//given
		String playerName = "Tatryk";
		//when
		Player playerOne = new Player(playerName);
		//then
		assertThat(playerOne.getPlayerName()).isEqualTo(playerName);
	}

	@DisplayName("check do player have health")
	@Test
	void test03() {
		//give

		//when
		Player playerOne = new Player("Tymek");
		//then
		assertThat(playerOne.getHealth()).isNotNull();
	}
}