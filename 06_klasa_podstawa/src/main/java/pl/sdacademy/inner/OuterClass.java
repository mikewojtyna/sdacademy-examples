package pl.sdacademy.inner;

public class OuterClass {

	private static void privateOuterMethod() {
		System.out.println("private outer method");
	}

	void outerMethod2() {
		new InnerHelperClass().method2();
	}

	void outerMethod() {
		InnerHelperClass innerHelperClass = new InnerHelperClass();
		innerHelperClass.method();
	}

	public static class InnerPublicClass {
		void method() {
			new InnerHelperClass().method();
		}
	}

	private static class InnerHelperClass {
		private void method() {
			System.out.println("inner method");
		}

		private void method2() {
			privateOuterMethod();
		}
	}
}
