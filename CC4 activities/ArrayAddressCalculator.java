import java.util.Scanner;

public class ArrayAddressCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting point (b): ");
        int b = scanner.nextInt();

        System.out.print("Enter weight (w): ");
        int w = scanner.nextInt();

        System.out.print("Enter number of dimensions: ");
        int numDimensions = scanner.nextInt();

        int[] upperBounds = new int[numDimensions];
        int[] elements = new int[numDimensions];

        // Get upper bounds
        for (int i = 0; i < numDimensions; i++) {
            System.out.print("Enter upper bound for  " + (i + 1) + ": ");
            upperBounds[i] = scanner.nextInt();
        }

        // Get elements
        for (int i = 0; i < numDimensions; i++) {
            System.out.print("Enter element for " + (i + 1) + ": ");
            elements[i] = scanner.nextInt();
        }

        int result = calculateArrayAddress(b, w, upperBounds, elements);
        System.out.println("Array address: " + result);
    }

    private static int calculateArrayAddress(int b, int w, int[] upperBounds, int[] elements) {
        int address = b;

        for (int i = 0; i < upperBounds.length; i++) {
            int product = elements[i];
            for (int j = i + 1; j < upperBounds.length; j++) {
                product *= upperBounds[j];
            }
            address += w * product;
        }

        return address;
    }
}
