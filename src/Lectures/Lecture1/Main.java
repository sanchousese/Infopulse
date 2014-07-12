package Lectures.Lecture1;

public class Main {

	private static void exercise1(){
		int [] mas = new int[10];
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) ( -50 + Math.random()*101 );
			System.out.println(mas[i]);
		}
	}
	
	//���� ���� (������ �� �� ������ ������ ��-������)
	private static void exercise2(){

		double b;
		int x = 15;
		
		long time = System.currentTimeMillis();
		for (long i = 0; i < 1000000000L; i++){ 
			b = x>>1;
		}
		long end = System.currentTimeMillis();
		System.out.println( end - time );
	
	}
	
	private static double avg(int a, int b){
		return (double)(a+b)/2;
		//��� 2.0
	}
	
	private static double power(int a, int b){
		double res = 1;
		for(int i = 0; i < b; i++)
			res *= a;
		return res;
	}
	
	private static int max(int [] mas){
		int max = mas[0];
		for (int i : mas) {
			if( i > max)
				max = i;
		}
		return max;
	}
	
	private static boolean isPerfect(int x){
		int sum = 0;
		for (int i = 1; i <= x/2; i++) {
			if(x%i == 0)
				sum+=i;
		}
		
		return sum == x ? true : false;
	}
	
	private static int [] divisors(int x){
		int sum = 0;
			
		for (int i = 1; i <= x/2; i++)
			if(x%i == 0)
				sum++;
		
		int [] mas = new int[sum];
		
		for (int i = 1, counter = 0; i <= x/2; i++)
			if(x%i == 0)
				mas[ counter++ ] = i;
		
		return mas;
	}	
	
	
	public static void main(String[] args) {
		System.out.println(avg(3,4));
		System.out.println( power(2,4) );
		System.out.println( max( new int[]{1,4,54} ) );
		
		System.out.println();
	
		System.out.println( isPerfect(13) );
		
		for (int i : divisors(6))
			System.out.println(i);	
	}
}
