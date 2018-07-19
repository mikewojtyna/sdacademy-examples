package Interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class Parser {
	private List<Expression> parseTree = new ArrayList<Expression>(); // only one NonTerminal Expression here

	public Parser(String s) {
		for (String token : s.split(" ")) {
			if (token.equals("+")) {
				parseTree.add(new TerminalExpression_Plus());
			}
			else if (token.equals("-")) {
				parseTree.add(new TerminalExpression_Minus());
			}
			// ...
			else {
				parseTree.add(new TerminalExpression_Number(Integer.parseInt(token)));
			}
		}
	}

	public int evaluate() {
		Stack<Integer> context = new Stack<Integer>();
		Iterator<Expression> parseTreeIterator = parseTree.iterator();
		while (parseTreeIterator.hasNext()) {
			parseTreeIterator.next().interpret(context);
		}
		return context.pop();
	}
}