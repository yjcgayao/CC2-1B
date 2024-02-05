import java.util.Scanner;

public class ArrayAddressCalculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting point (b): ");
        int b = scanner.nextInt();

        System.out.print("Enter weight (w): ");
        int w = scanner.nextInt();

        System.out.print("Enter number of Upper bounds: ");
        int numDimensions = scanner.nextInt();

        int[] upperBounds = new int[numDimensions];
        int[] elements = new int[numDimensions];

        // Get upper bounds
        for (int i = 0; i < numDimensions; i++) {
            System.out.print("Enter upper bound for  " + (char) ('a' + i) + ": ");
            upperBounds[i] = scanner.nextInt();
        }

        // Ask the user for the number of elements they want to provide
        System.out.print("Enter the number of elements  (up to " + numDimensions + "): ");
        int numElements = scanner.nextInt();

        // Get elements
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter element for " + (char) ('a' + i) + ": ");
            elements[i] = scanner.nextInt();
        }

        int result = calculateArrayAddress(b, w, upperBounds, elements);
        System.out.println("Array address: " + result);
    }

    private static int calculateArrayAddress(int b, int w, int[] upperBounds, int[] elements) {
        int address = b;

        for (int i = 0; i < elements.length; i++) {
            int product = elements[i];
            for (int j = i + 1; j < upperBounds.length; j++) {
                product *= upperBounds[j];
            }
            address += w * product;
        }

        return address;
    }
}
