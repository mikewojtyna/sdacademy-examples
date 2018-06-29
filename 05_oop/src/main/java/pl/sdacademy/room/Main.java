package pl.sdacademy.room;

public class Main {
	public static void main(String[] args) {
		Room room = new Room(1000, 2000);
		room.addTable(new Table(100, 200));
		room.addTable(new Table(50, 100));
		room.addTable(new Table(500, 200));

		int spaceLeft = room.spaceLeft();
		int tablesArea = room.tablesArea();

		System.out.println("Space left: " + spaceLeft);
		System.out.println("Tables area: " + tablesArea);
	}
}
