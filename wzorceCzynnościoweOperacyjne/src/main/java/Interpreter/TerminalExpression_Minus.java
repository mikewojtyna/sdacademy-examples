package Interpreter;

import java.util.Stack;

class TerminalExpression_Minus implements Expression {
	public void interpret(Stack<Integer> s)  { s.push(  -s.pop() + s.pop() ); }
}