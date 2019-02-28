package pl.sdacademy.inner;

public class Example {
	public static void main(String[] args) {
		OuterClass outerObj = new OuterClass();
		outerObj.outerMethod();
		outerObj.outerMethod2();

		OuterClass.InnerPublicClass innerPublicObj = new OuterClass.InnerPublicClass();
		innerPublicObj.method();
	}
}
