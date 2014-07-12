package Homework.Homework6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DynamicMassive<T> {
	private T[] mas;
	private int length = 0;

	public DynamicMassive(T[] mas) {
		super();
		this.mas = mas;
		length = mas.length;
	}

	public void add(T object) {
		if (length == mas.length)
			reinitialization(mas.length*2);
		mas[length++] = object;
	}

	public void add(T[] objects) {
		for (T t : objects)
			add(t);
	}

	public int length() {
		return length;
	}

	public T get(int index) {
		if(index >= length)
			throw new ArrayIndexOutOfBoundsException();
		return mas[index];
	}
	
	public void set(int index, T object) {
		if(index >= length)
			throw new ArrayIndexOutOfBoundsException();
		mas[index] = object;
	}
	
	public void remove(int index){
		for (int i = index; i < length-1; i++)
			mas[i] = mas[i+1];
		
		mas[--length]=null;
		
		if( mas.length / length > 1)
			reinitialization(length);
	}
	
	private void reinitialization(int length) {
		@SuppressWarnings("unchecked")
		T[] newMas = (T[]) new Object[length];
		copyCurrentTo(newMas);
		mas = newMas;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[length];
		copyCurrentTo(result);
		return result;
	}

	private void copyCurrentTo(T[] result) {
		for (int i = 0; i < length; i++)
			result[i] = mas[i];
	}
	
	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}

	public void writeToFile(String filePath) throws IOException {
		FileWriter fileWriter = new FileWriter(filePath);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		bw.write(this.toString());
		bw.close();
	} 
}
