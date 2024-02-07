import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GayaoSQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of bounds of the array:");
        int bounds = scanner.nextInt();

        System.out.println("Choose data structure: \n1. Stack \n2. Queue");
        int dataStructure = scanner.nextInt();

        if (dataStructure == 1) {
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
        } else if (dataStructure == 2) {
            Queue<Integer> queue = new LinkedList<>();
            boolean isDequeued = false;
            System.out.println("Choose operation: \n1. Enqueue \n2. Dequeue \n3. End");
            int operation;

            while (true) {
                operation = scanner.nextInt();
                if (operation == 1) {
                    if(queue.size() < bounds) {
                        System.out.println("Enter the value to enqueue:");
                        int value = scanner.nextInt();
                        if (isDequeued) {
                            ((LinkedList<Integer>) queue).addFirst(value);
                        } else {
                            queue.add(value);
                        }
                        System.out.println("Updated queue: " + queue);
                    } else {
                        System.out.println("Queue is full. Dequeue an element before enqueuing.");
                    }
                } else if (operation == 2) {
                    if(!queue.isEmpty()) {
                        int dequeuedValue = queue.poll();
                        isDequeued = true;
                        System.out.println("Dequeued value: " + dequeuedValue);
                        System.out.println("Updated queue: " + queue);
                    } else {
                        System.out.println("Queue is empty. Nothing to dequeue.");
                    }
                } else if (operation == 3) {
                    System.out.println("Final queue output: " + queue);
                    break;
                } else {
                    System.out.println("Invalid operation. Please choose again.");
                }
            }
        } else {
            System.out.println("Invalid data structure. Please choose again.");
        }

        scanner.close();
    }
}
