package pl.sdacademy.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {
	@Id
	@GeneratedValue
	private long id;
	private String msg;
	private String author;

	public Greeting() {
	}

	public Greeting(String msg, String author) {
		this.msg = msg;
		this.author = author;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
