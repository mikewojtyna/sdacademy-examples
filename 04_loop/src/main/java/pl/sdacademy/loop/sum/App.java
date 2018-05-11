package pl.sdacademy.loop.sum;

public class App {
	public static void main(String[] args) {
		// let's have some fun using loops
		int[] intArray = new int[]{0, 1, 2};

		// You can use any loop to calculate the sum - try it!
		int sum = forISum(intArray);
		// int sum = forEachSum(intArray);
		// int sum = whileSum(intArray);
		// int sum = doWhileSum(intArray);

		System.out.println(sum);

	}

	private static int doWhileSum(int[] intArray) {
		int sum = 0;
		int currentIndex = 0;
		do {
			sum += intArray[currentIndex];
			currentIndex++;
		}
		while (currentIndex < intArray.length);
		return sum;
	}

	private static int whileSum(int[] intArray) {
		int sum = 0;
		int currentIndex = 0;
		while (currentIndex < intArray.length) {
			sum += intArray[currentIndex];
			currentIndex++;
		}
		return sum;
	}

	private static int forEachSum(int[] intArray) {
		int sum = 0;
		for (int currentInteger : intArray) {
			sum += currentInteger;
		}
		return sum;
	}

	private static int forISum(int[] intArray) {
		int sum = 0;
		for (int i = 0; i < intArray.length; i++) {
			sum = sum + intArray[i];
			// sum += intArray[i];
		}
		return sum;
	}
}
