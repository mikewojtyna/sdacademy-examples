/** "Produkt" */

public class Pizza {
	private String dough = "";
	private String sauce = "";
	private String topping = "";

	@Override
	public String toString() {
		return "Pizza{" + "dough='" + dough + '\'' + ", sauce='" + sauce + '\'' + ", topping='" + topping +
			'\'' + '}';
	}

	private Pizza(Builder builder) {
		setDough(builder.dough);
		setSauce(builder.sauce);
		setTopping(builder.topping);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public void setDough(String dough)     { this.dough = dough; }
	public void setSauce(String sauce)     { this.sauce = sauce; }
	public void setTopping(String topping) { this.topping = topping; }

	public static final class Builder {
		private String dough;
		private String sauce;
		private String topping;

		private Builder() {
		}

		public Builder withDough(String val) {
			dough = val;
			return this;
		}

		public Builder withSauce(String val) {
			sauce = val;
			return this;
		}

		public Builder withTopping(String val) {
			topping = val;
			return this;
		}

		public Pizza build() {
			return new Pizza(this);
		}
	}
}
