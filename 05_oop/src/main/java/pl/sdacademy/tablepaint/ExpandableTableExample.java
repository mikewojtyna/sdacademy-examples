package pl.sdacademy.tablepaint;

public class ExpandableTableExample {
	public static void main(String[] args) {
		ExpandableTable table = new ExpandableTable(5, 10);

		Paint redPaint = new Paint(2);
		int howMuchRedPaint = table.howMuchPaint(redPaint);
		System.out.println(howMuchRedPaint);

		Paint greenPaint = new Paint(5);
		int howMuchGreenPaint = table.howMuchPaint(greenPaint);
		System.out.println(howMuchGreenPaint);

		table.expand();

		howMuchGreenPaint = table.howMuchPaint(greenPaint);
		howMuchRedPaint = table.howMuchPaint(redPaint);
		System.out.println(howMuchGreenPaint);
		System.out.println(howMuchRedPaint);
	}
}
