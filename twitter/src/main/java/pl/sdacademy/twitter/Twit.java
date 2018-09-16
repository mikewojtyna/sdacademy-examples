package pl.sdacademy.twitter;

public class Twit {
	private String message;
	private String author;

	public Twit(String message) {
		this.message = message;
	}

	public Twit(String message, String author) {
		this.author = author;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Twit{" + "message='" + message + '\'' + ", author='" + author + '\'' + '}';
	}

	public String getMessage() {
		return message;
	}

	public String getAuthor() {
		return author;
	}
}
