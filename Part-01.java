import java.util.Scanner;

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
    }

    public RationalNumber add(RationalNumber other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber subtract(RationalNumber other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber multiply(RationalNumber other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber divide(RationalNumber other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public static RationalNumber parseRational(String input) {
        String[] parts = input.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid input format, must be in the form 'a/b'");
        }
        try {
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            return new RationalNumber(numerator, denominator);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input, both numerator and denominator must be integers");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the first rational number (in the form 'a/b'): ");
            String input1 = scanner.nextLine();
            RationalNumber num1 = parseRational(input1);

            System.out.print("Enter the second rational number (in the form 'a/b'): ");
            String input2 = scanner.nextLine();
            RationalNumber num2 = parseRational(input2);

            RationalNumber sum = num1.add(num2);
            System.out.println("Sum: " + sum);
            RationalNumber difference = num1.subtract(num2);
            System.out.println("Difference: " + difference);
            RationalNumber product = num1.multiply(num2);
            System.out.println("Product: " + product);
            RationalNumber quotient = num1.divide(num2);
            System.out.println("Quotient: " + quotient);
            System.out.println("Sum as floating point: " + sum.toDouble());
            System.out.println("Difference as floating point: " + difference.toDouble());
            System.out.println("Product as floating point: " + product.toDouble());
            System.out.println("Quotient as floating point: " + quotient.toDouble());
            // Perform other operations and output results
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
