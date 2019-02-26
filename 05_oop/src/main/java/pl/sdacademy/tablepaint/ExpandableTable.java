package pl.sdacademy.tablepaint;

/**
 * A specialization of {@link PaintableTable} which can be expanded.
 */
class ExpandableTable extends PaintableTable {

	/**
	 * Creates an expandable table with given width and height.
	 *
	 * @param width  a given width
	 * @param height a given height
	 */
	ExpandableTable(int width, int height) {
		super(width, height);
	}

	/**
	 * Expands the width of this table by 20%.
	 */
	void expand() {
		width *= 1.2;
	}

}
