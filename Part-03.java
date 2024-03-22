public class NOMATCHEXCP extends Exception {
    private String input;
    private int lineNumber;

    public NOMATCHEXCP(String input, int lineNumber) {
        super();
        this.input = input;
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "NOMATCHEXCP at line " + lineNumber + ": Input does not match 'India': " + input;
    }
}

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            if (!input.equals("India")) {
                throw new NOMATCHEXCP(input, Thread.currentThread().getStackTrace()[1].getLineNumber());
            } else {
                System.out.println("Input matches 'India'");
            }
        } catch (NOMATCHEXCP e) {
            System.out.println(e);
        }
    }
}
