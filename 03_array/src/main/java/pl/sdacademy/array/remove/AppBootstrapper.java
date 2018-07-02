package pl.sdacademy.array.remove;

class AppBootstrapper {
	public static void run() {
		int[] inputArray = {5, 3, 4};
		int[] arrayWithoutIndex1 = ArrayOperations.removeElementFromArray(inputArray, 1);
		for (int element : arrayWithoutIndex1) {
			System.out.println(element);
		}
	}
}
