package Homework.Homework4;
import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	// Перший спосіб ( мінус параметр, але ускладнений виведенням)
	private static void subsets(int[] mas, int n) {
		String str = "";
		str += combination(mas, 0, n);

		String[] masive = str.split("\t");

		System.out.println(Arrays.toString(masive));

		String temp = "";
		for (int i = 0; i < masive.length; i++) {
			if (masive[i].length() == n) {
				temp = masive[i];
				continue;
			}
			if (masive[i].length() > 1) {
				String tmp = temp;
				temp = "";
				for (int j = 0, counter = 0; j < n; j++)
					if (j < n - masive[i].length())
						temp += tmp.charAt(j);
					else
						temp += masive[i].charAt(counter++);
				masive[i] = temp;
			} else {
				String tmp = masive[i];
				masive[i] = "";
				for (int j = 0, counter = 0; j < n; j++)
					if (j < n - tmp.length())
						masive[i] += temp.charAt(j);
					else
						masive[i] += tmp.charAt(counter++);
			}
		}
		System.out.println(Arrays.toString(masive));
	}

	private static String combination(int[] mas, int index, int n) {
		String str = "";
		for (int i = index; i < mas.length - n + 1; i++)
			if (n > 1 && i <= mas.length)
				str += Integer.toString(mas[i])
						+ combination(mas, i + 1, n - 1);
			else
				str += Integer.toString(mas[i]) + "\t";

		return str;
	}

	// Другий спосіб, із ще одним додатковим параметром
	public static void subsets1(int[] mas, int n) {
		comb(mas, 0, n, "");
	}

	private static void comb(int[] mas, int index, int n, String base) {
		for (int i = index; i < mas.length - n + 1; i++)
			if (n > 1 && i <= mas.length)
				comb(mas, i + 1, n - 1, base + mas[i]);
			else
				System.out.println(base + mas[i]);
	}

	private static int binarySearch(int[] mas, int n) {
		int lb = 0;
		int hb = mas.length - 1;
		while (lb <= hb) {
			int index = (lb + hb) / 2;
			if (n < mas[index])
				hb = index - 1;
			if (n > mas[index])
				lb = index + 1;
			else
				return index + 1;
		}
		return -1;
	}

	private static int binarySearchRecur(int[] mas, int n, int lb, int hb) {
		int index = (lb + hb) / 2;
		if (lb > hb)
			return -1;
		if (n < mas[index])
			return binarySearchRecur(mas, n, lb, index - 1);
		if (n > mas[index])
			return binarySearchRecur(mas, n, index + 1, hb);
		else
			return index + 1;
	}

	private static void bubleSortRecur(int[] mas, int index, boolean isOver) {

		if (index == mas.length) {
			index = 1;
			if (isOver)
				return;
			else
				isOver = true;
		}
		if (mas[index] < mas[index - 1]) {
			int temp = mas[index];
			mas[index] = mas[index - 1];
			mas[index - 1] = temp;
			isOver = false;
		}
		bubleSortRecur(mas, index + 1, isOver);
	}

	static void showDirs(File dir) {
		if (dir.listFiles() != null)
			for (File f : dir.listFiles())
				if (f.isDirectory())
					showDirs(f);
				else {
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTimeInMillis(f.lastModified());
					if (gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
							&& gc.get(Calendar.DAY_OF_MONTH) == 21)
						System.out.println(f.getName());
				}
	}

	public static void main(String[] args) {
		int[] mas = { 1, 2, 3, 4 };
		subsets(mas, 3);
		subsets1(mas, 3);

		int[] mas1 = { 1, 4, 6, 8, 9, 12, 13 };
		System.out.println(binarySearch(mas1, 13));
		System.out.println(binarySearchRecur(mas1, 13, 0, mas1.length - 1));
		
		int[] mas2 = { 3, 2, 4, 6, 7, 1, 9, 3, 5, 2 };
		bubleSortRecur(mas2, 1, true);
		System.out.println(Arrays.toString(mas2));
		
		showDirs(new File("C:/test"));
	}
}
