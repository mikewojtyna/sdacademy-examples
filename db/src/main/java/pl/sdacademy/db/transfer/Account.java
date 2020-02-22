package pl.sdacademy.db.transfer;

import lombok.Value;

@Value
public class Account {
	private String accountNumber;
	private double amount;
}
