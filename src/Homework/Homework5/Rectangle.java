package Homework.Homework5;
public class Rectangle implements Comparable {

	private int width, height;

	Rectangle(int width, int height) {
		if (width <= 0 || height <= 0)
			throw new RuntimeException("Your measures are wrong!");
		this.width = width;
		this.height = height;
	}

	Rectangle(int size) {
		this(size, size);
	}

	public int getArea() {
		return width * height;
	}

	public void draw(boolean hollow) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if (hollow && i != 1 && j != 1 && i != height && j != width){
					System.out.print(" ");
					continue;
				}
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	public String toString(){
		return "Rect:\t" + "w: " + width + "\th: " + height;
	}

	@Override
	public int compareTo(Object arg) {
		Rectangle rect = (Rectangle) arg;
		
		if(rect.getArea() > getArea())
			return -1;
		if(rect.getArea() < getArea())
			return 1;
		return 0;
	}
}
