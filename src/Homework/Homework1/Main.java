package Homework.Homework1;

import java.util.Arrays;

public class Main {
	
	
	//��� �������� �� �������� �����
	static void drawCross(int l){
		char [][] mas = new char[l][l];
		for (int i = 0; i < l; i++) 
			Arrays.fill(mas[i], 'X');
		
		//������ ���� ����
		for(int i = 0; i < l/3; i++)
			for (int j = 0; j < l/3; j++)
				mas[i][j] = ' ';
		
		//������ ������ ����
		for(int i = 0; i < l/3; i++)
			for (int j = l - l/3; j < l; j++)
				mas[i][j] = ' ';
		
		//����� ���� ����
		for(int i = l - l/3; i < l; i++)
			for (int j = 0; j < l/3; j++)
				mas[i][j] = ' ';
		
		//����� ������ ����
		for(int i = l - l/3; i < l; i++)
			for (int j = l - l/3; j < l; j++)
				mas[i][j] = ' ';
		
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				System.out.print(mas[i][j]);
			}
			System.out.println();
		}
	}
	
	
	static void insertionSort( int [] mas){
		for (int i = 0; i < mas.length; i++) {

			int temp = mas[i];
			
			int ind = i - 1;
			while(ind >= 0 && mas[ind] > temp){
				mas[ind+1] = mas[ind];
				mas[ind]=temp;
					
				ind--;
			}
		}
	}
	
	
	static void bucketSort(int [] mas){
		
		System.out.println(Arrays.toString(mas));
		
		//���� �� �� ����� ������������� ��������, ��������� ������������
		int max = mas[0];
		for (int i = 1; i < mas.length; i++)
			if (mas[i] > max)
				max = mas[i];
		
		//�������� ���'��� �� ������������ ����� (������ ���, �� �����
		//												����� ������ ������ ������)
		int [] resMas = new int[ max + 1 ]; 
		Arrays.fill(resMas, 0);

		//���������� ������
		for (int i = 0; i < mas.length; i++)
			resMas[ mas[i] ] ++ ;
		
		for( int i = 0; i < resMas.length; i++)
			for (int j = 0; j < resMas[i]; j++)
				System.out.print(" " + i + " ");
		
		System.out.println();
	}
	

	//����� ������ �� ��������� ��������
	static int evklid(int a, int b){
		if(a <= 0)
			return b;
		else 
			return evklid(Integer.max(a, b) - Integer.min(a, b), Integer.min(a, b));			
	}
	
	//����� ������ �� ��������� ����� �� ������
	static int evklid1(int a, int b){
		if(b==0)
			return a;
		else 
			return evklid1(b, a%b);
	}
	
	public static void main(String[] args) {
		//��������� ����� � �������� �������� 3-�� (�� ������)
		drawCross(12);
		
		int [] mas = {1, 6, 5, 3, 2, 7, 9};
		
		insertionSort(mas);
		
		System.out.println(Arrays.toString(mas));
		
		bucketSort(new int[]{4, 5, 6, 7, 1, 2, 3, 4, 3});
		
		System.out.println( "���(840, 396): " + evklid(840, 396) );
		System.out.println( "���1(840, 396): " + evklid1(840, 396) );
	}
}
