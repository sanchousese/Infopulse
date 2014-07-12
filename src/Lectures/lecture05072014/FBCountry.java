package Lectures.lecture05072014;

@SuppressWarnings("rawtypes")
public class FBCountry implements Comparable {
	private int numberVictory;
	private String name;

	public FBCountry(int numberVictory, String name) {
		this.numberVictory = numberVictory;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[numberVictory=" + numberVictory + ", name=" + name
				+ "]";
	}

	@Override
	public int compareTo(Object arg) {
		if(((FBCountry)arg).numberVictory > numberVictory)
			return -1;
		else if(((FBCountry)arg).numberVictory < numberVictory)
			return 1;
		return 0;
	}

}