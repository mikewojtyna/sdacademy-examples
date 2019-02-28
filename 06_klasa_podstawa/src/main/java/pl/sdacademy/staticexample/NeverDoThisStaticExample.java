package pl.sdacademy.staticexample;

public class NeverDoThisStaticExample {
	public static void main(String[] args) {
		User user0 = new User();
		User.setName("goobar");

		User user1 = new User();
		User.setName("foobar");

		User user2 = new User();
		User.setName("hoobar");

		System.out.println(User.getName());
		System.out.println(User.getName());
		System.out.println(User.getName());
	}
}
