import lombok.Builder;
import lombok.ToString;

@Builder(builderMethodName = "robPizze")
@ToString
class PizzaLombok {
	private String dough = "";
	private String sauce = "";
	private String topping = "";
}

