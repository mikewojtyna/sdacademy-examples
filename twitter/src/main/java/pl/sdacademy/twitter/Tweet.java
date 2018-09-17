package pl.sdacademy.twitter;

public class Tweet {
	private String message;
	private String author;

	public Tweet(String message) {
		this.message = message;
	}

	public Tweet(String message, String author) {
		this.author = author;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Tweet{" + "message='" + message + '\'' + ", author='" + author + '\'' + '}';
	}

	public String getMessage() {
		return message;
	}

	public String getAuthor() {
		return author;
	}
}
