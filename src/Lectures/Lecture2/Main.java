package Lectures.Lecture2;

import java.io.File;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Main {
	
	//�������� ��������� �� ��������
	static void incInt(int x){
		x++;
	}
	
	//�������� �� ��������� (4 �����, ��� ������ ������ �� ���)
	static void incArr(int [] mas){
		for (int i = 0; i < mas.length; i++) {
			mas[i]++;
		}
		
		//��������, �� �������� ��� ����� ������������ ��
		//for(int i = 0; i < mas.length; i++)		
		//		int t = mas[i];
		//		t++;	
		//Read-only
		for(int t : mas)
			t++;
	}
	
	//ͳ���� �� ��������, �� �� �� ������ �������� String
	//������� ����� String	
	static void incStr(String s){
		s += 'a';
	}
	 
	//��� ����� ������, ��� ��� ��
	static void incStrBuf(StringBuffer sb){
		sb.append("a");
	}
	
	static void incGregorian(GregorianCalendar gc){
		gc.set(GregorianCalendar.DAY_OF_MONTH, 13);
	}
	
	static void fill(int [] mas, int a){
		for (int i = 0; i < mas.length; i++) {
			mas[i]=a;
		}
	}
	
	//��� ����� ������ s = incStr1(s);
	static String incStr1(String s){
		return s+="a";
	}
	
	
	//���� ��������� ���������, ���� ����� �� ������
	//���� ��������� ���� ����, �� ������ ��������� �� ���� � ����������� ����� ��������
	static void change(int [] z){
		z = new int[]{1,2,3};
	}
	
	static int[] copyOf(int [] mas, int n){
		
		int [] m = new int[n];
		
		for (int i = 0; i < n; i++)
			m[i] = mas[i];
		
		return m;
	}
	
	static double [] stat(int a, int b){
		return new double[]{a+b, a*b, (a+b)/2.0};
	}
	
	//��������� �������
	static double [] squareSolve(double a, double b, double c){
		return new double[]{ ( -b + Math.sqrt(b*b - 4*a*c) ) / (2*a), ( -b - Math.sqrt(b*b - 4*a*c) ) / (2*a)};
	}
	
	
	
	//�������������� ������
	static int max(int a, int b){
		return a>b ? a : b;
	}	
	
	static int mas(int a, int b, int c){
		return max(a,b) > c ? max(a,b) : c;
	}
	
	static String max(String a, String b){
		return a.compareTo(b) < 0 ? b : a;	
	}
	
	static GregorianCalendar max(GregorianCalendar a, GregorianCalendar b){
		return a.after(b) ? a : b; 
	}
	
	static StringBuffer max(StringBuffer a, StringBuffer b){
		
		return a.toString().replaceAll("a", "").length() < b.toString().replaceAll("a", "").length() ? a : b;
	}
	
	static File max(File a, File b){
		return (long) a.lastModified() >  (long) b.lastModified() ? a : b;
	}
	
	
	//====================================================================
	
	//arity (���) methods (����-��� ������� ���������) 
	//��� ������ ������� � �����
	static int sum(int ... args){
		int s = 0;
		for (int i : args) {
			s+=i;
		}
		return s;
	}
	
	//��� ������� ����� 
	static int calcInt(double ... args){
		int counter = 0;
		for (double d : args) {
			if(d - (int) d == 0)
				counter ++;
		}
		return counter;
	}
	
	//���������
	static boolean isPalindrom(String str){
		return str.equals(new StringBuffer(str).reverse().toString());
	}
	
	static int pal(String ... args){
		int counter = 0;
		for (String string : args)
			if(isPalindrom(string.toLowerCase().replaceAll(" ", "")))
				counter++;
		return counter;
	}
	
	//���������� ��� ������
	static void sortMas(int[] ... args){
		for (int[] is : args) {
			Arrays.sort(is);
			System.out.println(Arrays.toString(is));
		}
	}
	
	//�� �����
	static String weekDay(int d){
		String [] days = {"Sunday", "Monday", "Tuesday", "Wednesday"};
		return days[d-1];
	}
	
	enum Langs {EN, UKR};
	
	static String weekDay(int d, Langs lang){
		String [] en = {"Sunday", "Monday", "Tuesday", "Wednesday"};
		String [] uk = {"��������", "³������", "������", "������"};
		
		switch (lang){
		case UKR:
			return uk[d-1];
		default:
			return en[d-1];
		
		}
	}
	
	
	enum Rank {CAPTAIN, MAJOR, COLONEL};
	
	static String milRank (Rank r){
		switch (r){
		case CAPTAIN:
			return "****";
		case MAJOR:
			return "O";
		case COLONEL:
			return "OOO";
		default:
			return "Nothing";
		}
	}
	
	
	///////////////////////////////////////////////////////
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Java");
		incStrBuf(sb);
		System.out.println(sb);
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.get(GregorianCalendar.DAY_OF_MONTH));
		incGregorian(gc);
		System.out.println(gc.get(GregorianCalendar.DAY_OF_MONTH));
		
		int [] mas = new int[10];
		fill(mas, 10);
		System.out.println(Arrays.toString(mas));
		
		int [] n = {10, 20, 30, 40};
		change(n);
		System.out.println(Arrays.toString(n));

		int [] n1 = copyOf(n, 1);
		System.out.println(Arrays.toString(n1));

		System.out.println( Arrays.toString(stat(2,3)) );
		System.out.println(stat(2,3)[1]);
		
		System.out.println(squareSolve(2, 5, 2)[0] + "\t" + squareSolve(2, 5, 2)[1]);
		
		
		
		
		//�������� �� ����� ��� ��������� ������, ���� ������ �������� b - ����� � ��� �� ��������
		int [] a = {1,2,3};
		int [] b = a.clone();
		System.out.println(Arrays.toString(a) + "\t" + Arrays.toString(b));
		
		
		
		
		int [][] x = { 
				{1,2},
				{3,4}
		};
		//��������� ����� ����� ������, ����� ������� �� �������� ������ ������ (������� ���������)
		int [][] y = x.clone();
		y[0][0] = 7;
		System.out.println(Arrays.deepToString(x));
		
		
		//���� ��������� �������� ������������� �����
		int [][] y1 = x.clone(); 
		for(int i = 0; i < x.length; i++)
			y1[i] = x[i].clone();
		
		y1[0][0] = 12;
		System.out.println(Arrays.deepToString(x));
		
		
		//String - ���� ������ ����������, ������� ���������� ����� ����� �����, �� �������� �������� ��������� ����
		
		System.out.println(max(new StringBuffer("Java"), new StringBuffer("Javaa")));
		
		
		System.out.println(sum(1,2,3,4,5,6));
		
		
		System.out.println(calcInt(1.2, 1.0, 1.3, 2.0));
		
		
		System.out.println(pal("sys", "oso", "soso", "� �� ���� �����"));
		
		
		sortMas(new int[]{1,3,5,4,2}, new int[]{1,5,4,3});
		
		
		System.out.println(weekDay(3, Langs.UKR));
		
		
		System.out.println(milRank(Rank.COLONEL));
		
		

		//���������� Java
		//File.mkdir
		//��� � Java
		
		//��� ������ ���������
		File f = new File("C:/a/b/c");
		System.out.println(f.exists());
		
		try{
			
			System.out.println(f.mkdirs());
			
		}catch(Exception e){}
		
//		�� ������ ���� ���������� ("C:/2000*b")
//		File f1 = new File("C:/2000*b");
//		System.out.println(f1.exists());
//		
//		try{
//			
//			System.out.println(f1.mkdirs());
//			
//		}catch(Exception e){}		
		
		}
		
	}


