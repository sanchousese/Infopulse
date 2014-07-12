package Lectures.lecture05072014;

import java.util.Arrays;

public class Main {
	static void reverse(int[] m) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i : m)
			stack.push(i);
		for (int i = 0; i < m.length; i++)
			m[i] = stack.pop();
        System.out.println(Arrays.toString(m));
    }

    private static boolean isValidExp(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (char symb : str.toCharArray())
            if (symb == '(')
                stack.push(symb);
            else if (symb == ')')
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
        return stack.isEmpty();
    }

	public static void main(String[] args) {
		System.out.println();
		System.out.println(isValidExp("()"));
        reverse(new int[]{1,2,3,4,5});

		FBCountry[] countries = {
				new FBCountry(2, "Hungary"),
				new FBCountry(100500, "Ukraine"),
				new FBCountry(4, "Italy")
		};
		Arrays.sort(countries);
		System.out.println(Arrays.toString(countries));
		
	}
}
