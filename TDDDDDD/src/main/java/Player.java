import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

class Player {

	@Getter
	@NonNull
	String playerName;

	@Getter
	int health;
}