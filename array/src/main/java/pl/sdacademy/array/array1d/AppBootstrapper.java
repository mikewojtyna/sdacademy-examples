package pl.sdacademy.array.array1d;

class AppBootstrapper {
	static void start() {
		// You can initialize 1D arrays like this
		int[] array0 = new int[]{0, 1, 2};
		print(array0);

		// Or like this
		int[] array1 = {0, 1, 2};
		print(array1);

		// Or even like that
		int[] array2 = new int[3];
		array2[0] = 0;
		array2[1] = 1;
		array2[2] = 2;
		print(array2);
	}

	private static void print(int[] array) {
		System.out.print("{ ");
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println("}");
	}
}
