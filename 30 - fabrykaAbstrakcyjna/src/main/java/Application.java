public class Application {
	public static void main(String[] args) {
		GUIFactory factory = GUIFactory.getFactory();
		Button button = factory.createButton();
		button.paint();
	}
}