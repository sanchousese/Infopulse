package Homework.Homework6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		PrinterDischarges.printDischarges(123, 0);

		DynamicMassive<Integer> mas = new DynamicMassive<Integer>(
				new Integer[] { 1, 2, 3 });
		System.out.println(mas);
		System.out.println(mas.length());
		mas.add(4);
		System.out.println(mas);
		mas.remove(2);
		System.out.println(mas);
		System.out.println(mas.length());
		mas.add(new Integer[] { 1, 2, 3, 4 });
		System.out.println(mas);
		System.out.println(mas.get(2));
		System.out.println(mas);

		try {
			mas.writeToFile("C:/test/test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		testHipothesis();
		
	}

	private static void testHipothesis() {
		FileWriter fw;
		try {
			fw = new FileWriter("C:/test/test.java");

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("long[] mas1 = {");
			bw.newLine();
			for (int i = 1; i < 10000; i++) {
				bw.write("1L, ");
				if (i % 10 == 0)
					bw.newLine();
			}
			bw.write("};");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
