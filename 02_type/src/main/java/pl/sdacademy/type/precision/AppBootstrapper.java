package pl.sdacademy.type.precision;

class AppBootstrapper {
	static void start() {
		double division = 1 / 3 * 3.0; // this will return 0.0 - why?
		System.out.println("1 / 3 * 3.0 = " + division);

		double addIntDouble = 1 + 2; // sum of ints can be also used as
		// double
		System.out.println("1 + 2 = " + addIntDouble);

		float addIntFloat = 1 + 2; // the same for float
		System.out.println("1 + 2 = " + addIntFloat);

		// precision and rounding problems
		System.out.println("-----------------");
		System.out.println("Rounding problems");
		double sqrtPower = Math.pow(Math.sqrt(3), 2); // sqrtPower is
		// not 3.0
		System.out.println("Math.pow(Math.sqrt(3), 2) = " + sqrtPower);
		System.out.println(sqrtPower + " != " + 3.0 + " (!)");

		// Therefore - never ever compare doubles using == to perform
		// key decisions - always use > or < operators (greater than
		// or less than) - otherwise strange things can happen
		if (sqrtPower == 3.0) {
			// this will not happen
			System.out.println("Make important decision");
		}
		// You should use greater than and less than with some
		// precision instead
		double epsilon = 0.0000001; // quite big precision
		if (sqrtPower < 3.0 + epsilon && sqrtPower > 3.0 - epsilon) {
			System.out.println("Another important decision");
		}
		// However, it's best not to use double and float for ==
		// comparision at all - use integers or booleans instead.
		// It's much easier.
	}
}
