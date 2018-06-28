package pl.sdacademy.room;

public class Room {
	private final int width;
	private final int height;
	private Table[] tables;

	public Room(int width, int height) {
		this.width = width;
		this.height = height;
		tables = new Table[0];
	}

	/**
	 * Adds a new table to this room.
	 *
	 * @param table a new table
	 */
	public void addTable(Table table) {
		// create variable containing old tables
		Table[] oldTables = tables;
		// increase size of target array by 1, because we add a new table
		tables = new Table[oldTables.length + 1];

		// copy all old elements
		for (int i = 0; i < oldTables.length; i++) {
			tables[i] = oldTables[i];
		}
		// add a new table to the end of the target array
		int indexOfLastElement = tables.length - 1;
		tables[indexOfLastElement] = table;
	}

	/**
	 * Calculates the total area of all tables in this room.
	 *
	 * @return the total area of all tables
	 */
	public int tablesArea() {
		// TODO: implement
		return -1;
	}

	/**
	 * Calculates how much space is left after adding a number of tables to this room.
	 *
	 * @return the space left after subtracting space occupied by tables
	 */
	public int spaceLeft() {
		// TODO: return space left in this room
		return -1;
	}

}
