package pl.sdacademy.array.array2d;

class AppBootstrapper {
	static void start() {
		// we can init 2d array1d using {} brackets
		String[][] table = new String[][]{
			// first row
			{"A", "B"},
			// second row
			{"C", "D"}};

		System.out.println("print table cells manually");
		// printCell table cells
		printCell(table, 0, 0); // prints "A" cell
		printCell(table, 0, 1); // prints "B" cell
		printCell(table, 1, 0); // prints "C" cell
		printCell(table, 1, 1); // prints "D" cell

		// we can also init 2d array1d "dynamically" - remember about
		// size
		String[][] table2 = new String[2][2]; // this line only
		// initializes memory for 2x2 array1d - elements are not set
		// yet
		// set cell value at row 0 and column 0
		table2[0][0] = "E";
		// set cell value at row 0 and column 1
		table2[0][1] = "F";
		// set cell value at row 1 and column 0
		table2[1][0] = "G";
		// set cell value at row 1 and column 1
		table2[1][1] = "H";

		System.out.println("print table2 cells manually");
		// printCell table2 cells
		printCell(table2, 0, 0); // prints "E" cell
		printCell(table2, 0, 1); // prints "F" cell
		printCell(table2, 1, 0); // prints "G" cell
		printCell(table2, 1, 1); // prints "H" cell

		System.out.println("---------------");
		System.out.println("print table cells using for loop");
		// for over all table cells - the result will be the same as
		// printing table cells manually using previous code - this
		// way we can print all elements writing printCell just once
		// for any 2d array1d of any length
		printAllCells(table);
		System.out.println("print table2 cells using for loop");
		printAllCells(table2);
	}

	private static void printAllCells(String[][] table) {
		for (int rowIndex = 0; rowIndex < table.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex <
				table[rowIndex].length; columnIndex++) {
				printCell(table, rowIndex, columnIndex);
			}
		}
	}

	private static void printCell(String[][] table, int row, int column) {
		System.out.printf("[%d][%d] => %s\n", row, column,
			table[row][column]);
	}
}
