import java.util.Scanner;

public class CustomQueue {
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
        if(count != 0) {
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of bounds of the array:");
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
        scanner.close();
    }
}
