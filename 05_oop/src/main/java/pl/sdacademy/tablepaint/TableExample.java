package pl.sdacademy.tablepaint;

public class TableExample {
	public static void main(String[] args) {
		PaintableTable table = new PaintableTable(5, 10);

		Paint redPaint = new Paint(2);
		int howMuchRedPaint = table.howMuchPaint(redPaint);
		System.out.println(howMuchRedPaint);

		Paint greenPaint = new Paint(5);
		int howMuchGreenPaint = table.howMuchPaint(greenPaint);
		System.out.println(howMuchGreenPaint);
	}
}
