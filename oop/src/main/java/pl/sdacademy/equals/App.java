package pl.sdacademy.equals;

public class App {
	public static void main(String[] args) {
		// this will return false because equals method is not
		// implemented
		// equals method (best together with hashCode) should be
		// implemented in StringWrapper class to make this result true
		boolean equalsResult = new StringWrapper("hello").equals(new
			StringWrapper("hello"));
		System.out.println("Equals result: " + equalsResult);

		// this will return false because == operator checks if
		// objects are "the same" (point to exactly the same object)
		// and here we created two different objects
		boolean referenceResult = new StringWrapper("hello") == new
			StringWrapper("hello");
		System.out.println("Reference result: " + referenceResult);

		// this will return true, because we == exactly the same object
		StringWrapper stringWrapper = new StringWrapper("hello");
		boolean referenceResultTheSameObject = stringWrapper ==
			stringWrapper;
		System.out.println("Reference result comparing the same " +
			"object: " + referenceResultTheSameObject);
	}
}
