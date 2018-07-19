package pl.sdacademy.printer;

import java.util.Stack;

public class Printer {

	private final int documentThreshHold;
	private Stack<Documents> printQueue;

	public Printer(int documentThreshHold) {
		this.printQueue = new Stack<>();
		this.documentThreshHold = documentThreshHold;
	}

	void print(Documents documents) {
		printQueue.push(documents);
		if (printQueue.size() >= documentThreshHold)
		{
			while (!printQueue.isEmpty())printQueue.pop().setPrinted(true);
		}
	}
}

