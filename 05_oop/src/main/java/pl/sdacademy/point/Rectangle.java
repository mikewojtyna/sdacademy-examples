package pl.sdacademy.point;

class Rectangle {

	private Point leftTopCorner;
	private Point rightTopCorner;
	private Point leftBottomCorner;
	private Point rightBottomCorner;

	// @formatter:off
	Rectangle(Point leftTopCorner,
			 Point rightTopCorner,
			 Point leftBottomCorner,
			 Point rightBottomCorner)
		throws IllegalArgumentException {
		if(!isRectangle(leftTopCorner,
			rightTopCorner,
			leftBottomCorner,
			rightBottomCorner)){
			throw new IllegalArgumentException
				("At least one point is bad");
		}
		this.leftTopCorner = leftTopCorner;
		this.rightTopCorner = rightTopCorner;
		this.leftBottomCorner = leftBottomCorner;
		this.rightBottomCorner = rightBottomCorner;
	}
	// @formatter:on

	private boolean isRectangle(Point leftTopCorner, Point rightTopCorner, Point leftBottomCorner, Point
		rightBottomCorner) {
		if (leftBottomCorner.getX() != leftTopCorner.getX()) {
			return false;
		}
		if (leftBottomCorner.getY() != rightBottomCorner.getY()) {
			return false;
		}
		if (rightBottomCorner.getX() != rightTopCorner.getX()) {
			return false;
		}
		return rightTopCorner.getY() == leftTopCorner.getY();
	}

}
