package pl.sdacademy.type.limits;

class AppBootstrapper {
	static void start() {
		// int min value
		System.out.println("int min: " + Integer.MIN_VALUE);
		// int max value
		System.out.println("int max: " + Integer.MAX_VALUE);
		// that's how you create int var
		int intVar = 10;

		// long min value
		System.out.println("long min: " + Long.MIN_VALUE);
		// long max value
		System.out.println("long max: " + Long.MAX_VALUE);
		// that's how you create long var
		long longVar = 10L;

		// double min value
		System.out.println("double min: " + Double.MIN_VALUE);
		// double max value
		System.out.println("double max: " + Double.MAX_VALUE);
		// that's how you create double var
		double doubleVar = 10D;

		// float min value
		System.out.println("float min: " + Float.MIN_VALUE);
		// float max value
		System.out.println("float max: " + Float.MAX_VALUE);
		// that's how you create float var
		double floatVar = 10F;

		// char type - just a single character - note '' instead of ""
		char charVar = '@';
		System.out.println("Char var: " + charVar);
	}
}
