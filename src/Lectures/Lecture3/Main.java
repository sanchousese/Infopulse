package Lectures.Lecture3;
import java.io.File;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

	// малювання зірок
	static void stars(int n) {
		System.out.print("*");
		if (n > 1)
			stars(n - 1);
	}

	// Знаходження факторіалу
	static long fact(long n) {
		if (n == 1)
			return 1;
		return n * fact(n - 1);
	}

	// Чи паліндром
	static boolean isPalindrom(String str, int ind) {
		if (ind == str.length() - ind - 1)
			return true;
		return str.charAt(ind) == str.charAt(str.length() - ind - 1) ? isPalindrom(
				str, ind + 1) : false;
	}

	// Чи просте число
	static boolean isSimple(int x, int i) {
		if (i > x / 2)
			return true;
		return x % i == 0 ? false : isSimple(x, i + 1);
	}

	// сума всіх елементів масиву
	static int sumMas(int[] mas, int ind) {
		if (ind >= mas.length)
			return 0;
		return mas[ind] + sumMas(mas, ind + 1);
	}

	// Сортування вибором
	static void selectionSort(int[] mas, int bound) {
		if (bound >= mas.length)
			return;

		int min = bound;

		for (int i = bound; i < mas.length; i++)
			if (mas[i] < mas[min])
				min = i;

		// swap
		if (bound < min) {
			int temp = mas[min];
			mas[min] = mas[bound];
			mas[bound] = temp;
		}

		selectionSort(mas, bound + 1);
	}

	// Показує всі директорії
	static void showDirs(File dir, int space) {
		for (int i = 0; i < space; i++)
			System.out.print("-");
		System.out.print("|");
		System.out.println(dir.getName());

		if (dir.listFiles() != null)
			for (File f : dir.listFiles())
				if (f.isDirectory())
					showDirs(f, space + 1);
	}

	// Кількість файлів у діректорії
	static int numFiles(File dir) {
		int counter = 0;
		if (dir.listFiles() != null)
			for (File f : dir.listFiles())
				counter += f.isDirectory() ? numFiles(f) : 1;
		return counter;
	}

	static File maxFile(File dir) {
		File temp = null;

		if (dir.listFiles() != null)
			for (File f : dir.listFiles()) {

				if (f.isDirectory()) {
					File mt = maxFile(f);
					if (mt != null)
						temp = (temp == null) ? mt : (temp.length() > mt
								.length()) ? temp : mt;
				}

				if (f.isFile())
					temp = (temp == null) ? f
							: (temp.length() > f.length()) ? temp : f;

			}
		return temp;
	}
	
	public static void main(String[] args) {
		stars(5);

		System.out.println();

		System.out.println(fact(4));

		System.out.println(isPalindrom("radar", 0));
		System.out.println(isPalindrom("asas", 0));

		System.out.println(isSimple(4, 2));

		System.out.println(sumMas(new int[] { 1002, 234, 3 }, 0));

		int[] mas = { 2, 5, 1, 3, 4 };
		selectionSort(mas, 0);
		System.out.println(Arrays.toString(mas));

		File catalog = new File("c:/Intel");
		// showDirs(catalog, 0);
		System.out.println(numFiles(catalog));

		System.out.println(maxFile(catalog).getName());

		// String Format
		String s = String.format("%.15f \t %.4f", Math.PI, Math.PI);
		System.out.println(s);

		System.out.println(String.format("%d \t %o \t %X", 10, 10, 10));

		System.out.println(String.format("%c \t %C \t %d", 97, 97, 97));

		System.out.println(String.format("%s\t%S", "Java", "Java"));

		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(String.format("%tH:%tM:%tS", gc, gc, gc));
		System.out.println(String.format("%tY:%tm:%td", gc, gc, gc));
		System.out.println(String.format(new Locale("uk"),
				"week Day = %tA\tmonth = %tB\tday of the Year = %tj", gc, gc, gc));
		
		
		// Команда форматування
		// %[#параметр$][прапорці][ширина][.точність][тип перетворення]

		System.out.println();
		
		String[] m = { "C#", "Java", "Python" };
		for (String t : m)
			System.out.println(String.format("%10S", t));
		for (String t : m)
			System.out.println(String.format("%-10S", t));

		// прапорець 0 - додає нулі на місце пропусків, ширина 5, ( - від'ємні
		// числа в дужках
		for (int i = -5; i <= 5; i++)
			System.out.println(String.format("%(+05d", i));
		
		for(int i = 1; i <= 10; i++)
			System.out.println(String.format("%2d%10.2f", i, Math.sqrt(i)));
	}
}
