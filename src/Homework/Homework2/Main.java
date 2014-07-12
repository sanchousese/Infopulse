package Homework.Homework2;

public class Main {
	
	
	//��������� ���������
	static String encode(String str, int shift){
		String mas = new String();
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				mas += ' ';
				continue;
			}
			
			mas += str.charAt(i) + shift <= 122 ? 
					(char) (str.charAt(i) + shift) : 
						(char) (str.charAt(i) + shift - 26);
		}
		
		return mas;	
	}
	
	//����������� ���������
	static String decode(String str, int shift){
		String mas = new String();
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				mas += ' ';
				continue;
			}
			
			mas+=(str.charAt(i) - shift >= 97 ? 
					(char) (str.charAt(i) - shift) : 
						(char) (str.charAt(i) - shift + 26));
		}
		
		return mas;
	}
	
	static String toBinary(int n){
		String result = new String();
		
		do{
			result += (char) n%2;
		}while( (n=n/2) > 0 );
		
		//������� ������� ����������� ����� (���� ������) �� ����
		return new StringBuffer(result).reverse().toString();
	}
	
	static int toDex(String str){
		int n = 0;
		for(int i = 0; i < str.length(); i++)
			n += str.charAt(str.length() - i - 1) == '0' ? 0 :  Math.pow(2, i);
		return n;
	}
	
	public static void main(String[] args) {
		
		for(int i = 1; i<26; i++)
			System.out.println( i + "\t" + decode("ardvj sfeu zj rsjvek ze cfeufe efn", i) );
	
		String temp = encode("mr bond in the space" ,10);
		System.out.println(temp);
		System.out.println(decode(temp, 10));
		
		
		System.out.println( toBinary(144) );
		System.out.println( toDex( toBinary(144) ) );
	}
}
