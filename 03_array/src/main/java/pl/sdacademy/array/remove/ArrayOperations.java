package pl.sdacademy.array.remove;

class ArrayOperations {
	static int[] removeElementFromArray(int[] array, int indexToRemove) {
		int[] resultArray = new int[array.length - 1];
		int nextNullElementIndexOfResultArray = 0;
		for (int i = 0; i < array.length; i++) {
			if (elementIsGood(i, indexToRemove)) {
				resultArray[nextNullElementIndexOfResultArray] = array[i];
				nextNullElementIndexOfResultArray++;
			}
		}
		return resultArray;
	}

	private static boolean elementIsGood(int i, int indexToRemove) {
		return i != indexToRemove;
	}
}
