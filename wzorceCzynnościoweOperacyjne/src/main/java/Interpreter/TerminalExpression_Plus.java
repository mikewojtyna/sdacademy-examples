package Interpreter;

import java.util.Stack;

class TerminalExpression_Plus implements Expression {
	public void interpret(Stack<Integer> s)  { s.push( s.pop() + s.pop() ); }
}