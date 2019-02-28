package pl.sdacademy.equals;

import java.util.HashSet;
import java.util.Objects;

public class HashCodeAndHashSetExample {
	public static void main(String[] args) {
		User george = new User();
		george.setName("George");
		george.setHeight(170);

		HashSet<User> allUsers = new HashSet<>();
		allUsers.add(george);

		// shows true
		System.out.println(allUsers.contains(george));
		// george grows...
		george.setHeight(180);
		// shows false
		System.out.println(allUsers.contains(george));
	}

	private static class User {
		private String name;
		private int height;

		public void setName(String name) {
			this.name = name;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			User user = (User) o;
			return height == user.height && Objects.equals(name, user.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, height);
		}
	}
}
