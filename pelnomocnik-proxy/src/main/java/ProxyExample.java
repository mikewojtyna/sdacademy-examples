class ProxyExample {

	/**
	 * Test method
	 */
	public static void main(final String[] arguments) {
		final Image image1 = new ProxyImage("HiRes_10MB_Photo1");
		final Image image2 = new ProxyImage("HiRes_10MB_Photo2");

		image1.displayImage(); // loading necessary
		image1.displayImage(); // loading unnecessary
		image2.displayImage(); // loading necessary
		image2.displayImage(); // loading unnecessary
		image1.displayImage(); // loading unnecessary
	}
}