package Homework.Homework7;

import Lectures.lecture05072014.Stack;

public class Main {

    private static boolean isValidExp(String str, String brackets) {
        Stack<Character> stack = new Stack<Character>();
        for (char symb : str.toCharArray())
            if (symb == brackets.charAt(0))
                stack.push(symb);
            else if (symb == brackets.charAt(1))
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
        return stack.isEmpty();
    }

    private static boolean isValidExpression(String str) {
        return isValidExp(str, "()") && isValidExp(str, "[]") && isValidExp(str, "<>");
    }

    private static <T> void reverse(Stack<T> stack) {
        if (!stack.isEmpty()) {
            T temp = stack.pop();
            reverse(stack);
            appendToStack(stack, temp);
        }
    }

    private static <T> void appendToStack(Stack<T> stack, T a) {
        if (stack.isEmpty()) {
            stack.push(a);
            return;
        } else {
            T temp = stack.pop();
            appendToStack(stack, a);
            stack.push(temp);
        }
    }

    private static int parseExp(String string) {
        string = string.replaceAll("\\s", "");
        System.out.println(string);
        Stack<Integer> integerStack = new Stack<Integer>();
        Stack<Character> operationStack = new Stack<Character>();

        for (int i = 0; i < string.length(); i++) {
            char currentSymbol = string.charAt(i);
            if (currentSymbol == '(') ;
            else if (Character.isDigit(currentSymbol)) {
                integerStack.push(Integer.parseInt(String.valueOf(currentSymbol)));
            } else if (isDefinedOperation(currentSymbol))
                operationStack.push(currentSymbol);

            else if (currentSymbol == ')') {
                int temp = performOperation(integerStack.pop(), integerStack.pop(), operationStack.pop());
                integerStack.push(temp);
                continue;
            }
        }

        return integerStack.pop();
    }

    private static boolean isDefinedOperation(char currentSymbol) {
        return currentSymbol == '+' || currentSymbol == '*' || currentSymbol == '-' || currentSymbol == '/';
    }

    private static int performOperation(int first, int second, char operation) {
        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return second - first;
            case '*':
                return first * second;
            case '/':
                return second / first;
            default:
                throw new ArithmeticException("Symbol is not defined" + operation);
        }
    }

    public static void main(String[] args) {
        System.out.println("Result cheking out a expression (35*23) + <[3+2]+1):\t"
                + isValidExpression("(35*23) + <[3+2]+1)"));
        System.out.println("Result cheking out a expression (35*23) + <[3+2]+1>:\t"
                + isValidExpression("(35*23) + <[3+2]+1>:"));

        Stack stack = new Stack();
        stack.push(13);
        stack.push(23);
        stack.push(123);
        reverse(stack);
        System.out.println(stack);

        System.out.println(parseExp("(((5* 3)-3)+(3+2))"));
    }

}
