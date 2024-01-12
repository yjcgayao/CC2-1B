import java.util.Scanner;

public class ArtRoutine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yasmien's art routine:");
        System.out.println("1. Start");
        System.out.println("2. Choose art style");
        // Loop until a valid choice (1 or 2) is entered
        int setupChoice;
        while (true) {
            System.out.print("   Enter 1 for traditional or 2 for digital: ");  
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                setupChoice = scanner.nextInt();
                scanner.nextLine();  // Handle the newline character
                // Check the entered choice and break the loop if it's valid (1 or 2)
                if (setupChoice == 1) {
                    System.out.println("   - Prepare canvas and brushes");
                    break;
                } else if (setupChoice == 2) {
                    System.out.println("   - Turn on digital drawing tablet");
                    break;
                } else {
                    System.out.println("   - Invalid number choice, choose a number between 1 and 2.");
                }
            } else {
                System.out.println("  - Invalid input, choose a number between 1 and 2.");
                scanner.nextLine();  //Handle  the invalid input
            }
        }
        System.out.println("3. Set up workspace");
        System.out.println("4. Gather art references");
        System.out.println("5. Sketch initial ideas");
        System.out.println("6. Start creating artwork");
        System.out.println("7. Show artwork to brother or sister or someone nearby for clout, I mean opinions");
        System.out.println("8. Refine details");
        // Loop until a satisfaction choice is entered (1 for satisfied or any other key for unsatisfied)
        int satisfactionChoice;
        while (true) {
            System.out.print("9. Evaluate the artwork (Enter 1 for satisfied or any other key for unsatisfied): ");
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                satisfactionChoice = scanner.nextInt();
                scanner.nextLine();  // Handle  the newline character
                // Check the entered choice and break the loop if it's satisfied (1)
                if (satisfactionChoice == 1) {
                    System.out.println("   - Enjoy the artwork");
                    break;
                }
            }
            // Continue refining details if the satisfaction choice is not 1
            System.out.println("   - Continue refining details");
            scanner.nextLine();  // Handle the input (valid or invalid)
        }
        System.out.println("10. End");
        scanner.close();  // Close the scanner to prevent resource leak
    }
}
