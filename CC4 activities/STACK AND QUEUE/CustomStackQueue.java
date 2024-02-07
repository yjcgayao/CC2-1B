import java.util.Scanner;
import java.util.Stack;

public class CustomStackQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose data structure: \n1. Stack \n2. Queue");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter the number of bounds of the stack:");
            int bounds = scanner.nextInt();

            Stack<Integer> stack = new Stack<>();
            System.out.println("Choose operation: \n1. Push \n2. Pop \n3. End");
            int operation;

            while (true) {
                operation = scanner.nextInt();
                if (operation == 1) {
                    if (stack.size() < bounds) {
                        System.out.println("Enter the value to push:");
                        int value = scanner.nextInt();
                        stack.push(value);
                        System.out.println("Updated stack: " + stack);
                    } else {
                        System.out.println("Stack is full. Pop an element before pushing.");
                    }
                } else if (operation == 2) {
                    if (!stack.isEmpty()) {
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
        } else if (choice == 2) {
            System.out.println("Enter the number of bounds of the queue:");
            int bounds = scanner.nextInt();

            CustomQueue customQueue = new CustomQueue(bounds);

            System.out.println("Choose operation: \n1. Enqueue \n2. Dequeue \n3. End");
            int operation;

            while (true) {
                operation = scanner.nextInt();
                if (operation == 1) {
                    System.out.println("Enter the value to enqueue:");
                    String value = scanner.next();
                    customQueue.enqueue(value);
                    customQueue.printQueue();
                } else if (operation == 2) {
                    customQueue.dequeue();
                    customQueue.printQueue();
                } else if (operation == 3) {
                    System.out.println("Final queue output: ");
                    customQueue.printQueue();
                    break;
                } else {
                    System.out.println("Invalid operation. Please choose again.");
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}

class CustomQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private int count;

    public CustomQueue(int size) {
        this.size = size;
        this.queue = new String[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    public void enqueue(String value) {
        if (count == size) {
            System.out.println("Queue is full. Dequeue an element before enqueuing.");
        } else {
            // Find the first null position
            for (int i = 0; i < size; i++) {
                if (queue[i] == null) {
                    queue[i] = value;
                    count++;
                    break;
                }
            }
        }
    }

    public void dequeue() {
        if (count != 0) {
            queue[front] = null;
            front = (front + 1) % size;
            count--;
        } else {
            System.out.println("Queue is empty. Nothing to dequeue.");
        }
    }

    public void printQueue() {
        System.out.print("Updated queue: ");
        for (String s : queue) {
            if (s != null) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
    }
}
