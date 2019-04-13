package pl.sdacademy.mvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Msg {
	@Id
	@GeneratedValue
	private Long id;
	private String content;
	private int number;

	public Msg(String hello, int number) {
		this.content = hello;
		this.number = number;
	}

	public Msg() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Msg msg = (Msg) o;
		return number == msg.number && Objects.equals(id, msg.id) && Objects.equals(content, msg.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, content, number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
