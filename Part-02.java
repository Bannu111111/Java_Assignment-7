public class FactorialException extends Exception {
    private int number;

    public FactorialException(int number) {
        super();
        this.number = number;
    }

    @Override
    public String toString() {
        return "FactorialException: Invalid input for factorial: " + number;
    }
}


import java.util.Scanner;

public class ExceptionDemo {
    public static int factorial(int n) throws FactorialException {
        if (n < 0 || n > 15) {
            throw new FactorialException(n);
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of integers to find factorial for: ");
            int count = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            for (int i = 0; i < count; i++) {
                System.out.print("Enter an integer: ");
                int number = scanner.nextInt();
                int fact = factorial(number);
                System.out.println("Factorial of " + number + ": " + fact);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input, not a number");
        } catch (FactorialException e) {
            System.out.println(e);
        }
    }
}
