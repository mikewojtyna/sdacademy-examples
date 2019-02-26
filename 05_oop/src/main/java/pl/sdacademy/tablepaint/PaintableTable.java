package pl.sdacademy.tablepaint;

/**
 * This is a class modeling the table used in painting company.
 *
 * @author goobar
 */
class PaintableTable {
	private final int height;
	protected int width;

	/**
	 * Creates a default table with size 100x100.
	 */
	PaintableTable() {
		width = 100;
		height = 100;
	}

	/**
	 * Creates a new table with given width and height.
	 *
	 * @param width  width of the table
	 * @param height height of the table
	 */
	PaintableTable(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Calculates how much paint should be used to cover the table.
	 *
	 * @param paint a paint to be used
	 * @return the number of gallons needed to cover the table
	 */
	int howMuchPaint(Paint paint) {
		return calculateArea() / paint.getEfficiency();
	}

	private int calculateArea() {
		return width * height;
	}
}
