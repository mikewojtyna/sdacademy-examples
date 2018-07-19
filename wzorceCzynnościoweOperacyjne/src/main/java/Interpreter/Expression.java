package Interpreter;

import java.util.Stack;

interface Expression {
	public void interpret(Stack<Integer> s);
}