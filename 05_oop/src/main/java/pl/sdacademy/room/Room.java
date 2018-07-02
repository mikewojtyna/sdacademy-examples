package pl.sdacademy.room;

class Room {
	private final int width;
	private final int height;
	private Table[] tables;

	Room(int width, int height) {
		this.width = width;
		this.height = height;
		tables = new Table[0];
	}

	/**
	 * Remove table from this room. If table doesn't exist, an exception is thrown.
	 *
	 * @param table a table to remove
	 */
	void removeTable(Table table) {
		int matchingTableIndex = findIndex(table);
		removeTableWithIndex(matchingTableIndex);
	}

	private void removeTableWithIndex(int matchingTableIndex) {
		Table[] oldTables = tables;
		tables = new Table[oldTables.length - 1];
		copyFromTo(oldTables, tables, matchingTableIndex);
	}

	private void copyFromTo(Table[] oldTables, Table[] tables, int withoutIndex) {
		// copy all old elements except of element with "withoutIndex"
		int tablesNextNullIndex = 0;
		for (int i = 0; i < oldTables.length; i++) {
			if (i != withoutIndex) {
				tables[tablesNextNullIndex] = oldTables[i];
				tablesNextNullIndex++;
			}
		}
	}

	private int findIndex(Table table) {
		for (int i = 0; i < tables.length; i++) {
			if (tables[i].equals(table)) {
				return i;
			}
		}
		return -1;
	}

	private static void copyFromTo(Table[] oldTables, Table[] tables) {
		// copy all old elements
		for (int i = 0; i < oldTables.length; i++) {
			tables[i] = oldTables[i];
		}
	}

	/**
	 * Adds a new table to this room.
	 *
	 * @param table a new table
	 */
	void addTable(Table table) {
		// create variable containing old tables
		Table[] oldTables = tables;
		// increase size of target array by 1, because we add a new table
		tables = new Table[oldTables.length + 1];
		// copy old tables to tables
		copyFromTo(oldTables, tables);
		// add a new table to the end of the target array
		int indexOfLastElement = tables.length - 1;
		tables[indexOfLastElement] = table;
	}


	/**
	 * Calculates the total area of all tables in this room.
	 *
	 * @return the total area of all tables
	 */
	int tablesArea() {
		int tablesArea = 0;
		for (Table table : tables) {
			tablesArea += table.area();
		}
		return tablesArea;
	}

	/**
	 * Calculates how much space is left after adding a number of tables to this room.
	 *
	 * @return the space left after subtracting space occupied by tables
	 */
	int spaceLeft() {
		return width * height - tablesArea();
	}

}
