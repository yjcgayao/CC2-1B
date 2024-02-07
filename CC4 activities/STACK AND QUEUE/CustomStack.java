import java.util.Scanner;
import java.util.Stack;

public class CustomStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of bounds of the array:");
        int bounds = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        System.out.println("Choose operation: \n1. Push \n2. Pop \n3. End");
        int operation;

        while (true) {
            operation = scanner.nextInt();
            if (operation == 1) {
                if(stack.size() < bounds) {
                    System.out.println("Enter the value to push:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    System.out.println("Updated stack: " + stack);
                } else {
                    System.out.println("Stack is full. Pop an element before pushing.");
                }
            } else if (operation == 2) {
                if(!stack.isEmpty()) {
                    int poppedValue = stack.pop();
                    System.out.println("Popped value: " + poppedValue);
                    System.out.println("Updated stack: " + stack);
                } else {
                    System.out.println("Stack is empty. Nothing to pop.");
                }
            } else if (operation == 3) {
                System.out.println("Final stack output: " + stack);
                break;
            } else {
                System.out.println("Invalid operation. Please choose again.");
            }
        }

        scanner.close();
    }
}
