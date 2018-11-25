package pl.sdacademy.point;

/**
 * A 2D point.
 */
class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Calculates the distance to another point.
	 *
	 * @param otherPoint
	 * @return
	 */
	double dist(Point otherPoint) {
		// TODO: calculate the distance
		return 0.0;
	}
}
