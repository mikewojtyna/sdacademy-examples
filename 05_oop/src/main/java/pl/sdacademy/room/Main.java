package pl.sdacademy.room;

public class Main {
	public static void main(String[] args) {
		Room room = new Room(1000, 2000);
		room.addTable(new Table(100, 200));
		room.addTable(new Table(50, 100));
		Table table = new Table(500, 200);
		room.addTable(table);
		room.addTable(new Table(10, 100));

		System.out.println("Space left: " + room.spaceLeft());
		System.out.println("Tables area: " + room.tablesArea());

		room.removeTable(table);

		System.out.println("Space left: " + room.spaceLeft());
		System.out.println("Tables area: " + room.tablesArea());
	}
}
