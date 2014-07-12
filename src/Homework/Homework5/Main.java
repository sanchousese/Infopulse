package Homework.Homework5;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

//Позитивне число
class PosInt {
	private int x;

	PosInt(int x) {
		if (x <= 0)
			throw new RuntimeException("This is`nt positive value!");
		this.x = x;
	}

	// Парні числа
	public boolean isEven() {
		return x % 2 == 0;
	}

	// Непарні числа
	public boolean isOdd() {
		return !isEven();
	}

	// Чи є число квадратом
	public boolean isSquare() {
		return Math.round(Math.sqrt(x)) - Math.sqrt(x) == 0;
	}

	// Всі дільники
	public int[] allDivisors() {
		int[] res = new int[numDivisors()];

		for (int i = 1, j = 0; i <= x / 2; i++)
			if (x % i == 0)
				res[j++] = i;

		res[res.length - 1] = x;

		return res;
	}

	// Кількість дільників
	public int numDivisors() {
		int counter = 0;

		for (int i = 1; i <= x / 2; i++)
			if (x % i == 0)
				counter++;
		return counter + 1;
	}

	public String toString() {
		return "Value:\t" + x;
	}

	public boolean isCube() {
		return Math.round(Math.cbrt(x)) - Math.cbrt(x) == 0;
	}

	public boolean is5thPower() {
		int neighbor = (int) Math.round(Math.pow(x, 1.0 / 5.0));
		return Math.pow(neighbor, 5) - x == 0;
	}

	//Ніхто не може звернутися до закритого поля класа, крім того ж класу
	public boolean before(PosInt a){
		return x < a.x;
	}
			
	public boolean after(PosInt a){
		return x > a.x;
	}
	
	public int [] getPythagorasTriple(){
		if(isSquare()){
			for(int i = 1; i < x - 1; i++)
				for(int j = i+1; j < x; j++)
					if(Math.pow(i,2) + Math.pow(j,2) == x){
						int [] result = new int [3];
						result[0] = i;
						result[1] = j;
						result[2] = (int) Math.sqrt(x);
						return result;
					}
		}
		return null;
	}
}

public class Main {
	public static void main(String[] args) {
		PosInt[] m = { new PosInt(25), new PosInt(8), new PosInt(1) };
		for (PosInt t : m)
			System.out.println(t);

		System.out.println("Is cube:\t" + m[1].isCube());

		// Math.cbrt - для вирішення задачі з кубом
		for (int i = 1; i <= 50; i++) {
			PosInt temp = new PosInt((int) Math.pow(i, 5));
			System.out.print(temp.is5thPower() + " ");
		}

		System.out.println();

		PosInt a = new PosInt(100);
		System.out.println(Arrays.toString(a.getPythagorasTriple()));
		
		Rectangle rect = new Rectangle(3);
		rect.draw(true);
		System.out.println(rect);
		
		System.out.println(new Test());
		
		try{
			String path = "C:/test/test.txt";
			//Не має переходу на новий рядок
			FileWriter writer = new FileWriter(path);
			
//			Щоб дописати у файл використовуємо 
//			FileWriter writer = new FileWriter("C:/test/test.txt", true);
			
			//Тому використовуємо це
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("Hello!");
			bw.newLine();
			bw.write("Second line");
			//Обов'язково закривати, інакше програма не запише в файл
			bw.close();
			System.out.println("File writed!");
		
			
			//Відкрити файл через другу програму
			Runtime.getRuntime().exec(new String[]{"Notepad", path});

			Runtime.getRuntime().exec(new String[]{"C:/ADT/eclipse/eclipse.exe"});

		}catch(Exception e){
			System.out.println("Error!" + e);
		}
		
		Rectangle[] mas = {
				new Rectangle(10, 20),
				new Rectangle(10, 2),
				new Rectangle(10, 15),
		};
		Arrays.sort(mas);
		System.out.println(Arrays.toString(mas));
	}
}
