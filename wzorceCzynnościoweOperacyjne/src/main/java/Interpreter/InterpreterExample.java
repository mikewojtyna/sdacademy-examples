package Interpreter;

class InterpreterExample {
	public static void main(String[] args) {
		String expression = "42 4 2 + -";
		Parser p = new Parser(expression);
		System.out.println("'" + expression +"' equals " + p.evaluate());
	}
}