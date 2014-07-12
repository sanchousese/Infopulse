package Homework.Homework6;

public class PrinterDischarges{
	public static void printDischarges(int n, int pow) {
		if (n / powerOfTen(pow) != 0) {
			printDischarges(n, pow + 1);
			System.out.println(differenceOfTwoRemainders(n, pow)
					/ powerOfTen(pow));
		}
	}

	private static int differenceOfTwoRemainders(int n, int pow) {
		return n % powerOfTen(pow + 1) - n % powerOfTen(pow);
	}

	private static int powerOfTen(int pow) {
		return (int) Math.pow(10, pow);
	}
}
