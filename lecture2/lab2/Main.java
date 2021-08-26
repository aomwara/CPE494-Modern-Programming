import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ComplexNumber complex1;
        ComplexNumber complex2;
        ComplexNumber complex3;
        float a;
        float b;
        int choice = 0;
        // Main menu
        System.out.println("\n===COMPLEX CALCULATOR===");
        while (choice != 5) {
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1: Add");
            System.out.println("2: Subtract");
            System.out.println("3: Multiply");
            System.out.println("4: Divide");
            System.out.println("5: Quit\n");
            choice = input.nextInt();
            // Addition
            if (choice == 1) {
                System.out.println("\nWhere i = (-1)^1/2,\n");
                System.out.println("(a + bi) + (c + di)\n");
                System.out.println("Input a:");
                a = input.nextFloat();
                System.out.println("Input b:");
                b = input.nextFloat();
                complex1 = new ComplexNumber(a, b);
                System.out.println("Input c:");
                a = input.nextFloat();
                System.out.println("Input d:");
                b = input.nextFloat();
                complex2 = new ComplexNumber(a, b);
                complex3 = complex1.add(complex2);
                System.out.println("The result is: " + complex3.toString());
            }
            // Subtraction
            if (choice == 2) {
                System.out.println("\nWhere i = (-1)^1/2,\n");
                System.out.println("(a + bi) - (c + di)\n");
                System.out.println("Input a:");
                a = input.nextFloat();
                System.out.println("Input b:");
                b = input.nextFloat();
                complex1 = new ComplexNumber(a, b);
                System.out.println("Input c:");
                a = input.nextFloat();
                System.out.println("Input d:");
                b = input.nextFloat();
                complex2 = new ComplexNumber(a, b);
                complex3 = complex1.subtract(complex2);
                System.out.println("The result is: " + complex3.toString());
            }
            // Multiplication
            if (choice == 3) {
                System.out.println("\nWhere i = (-1)^1/2,\n");
                System.out.println("(a + bi)(c + di)\n");
                System.out.println("Input a:");
                a = input.nextFloat();
                System.out.println("Input b:");
                b = input.nextFloat();
                complex1 = new ComplexNumber(a, b);
                System.out.println("Input c:");
                a = input.nextFloat();
                System.out.println("Input d:");
                b = input.nextFloat();
                complex2 = new ComplexNumber(a, b);
                complex3 = complex1.multiply(complex2);
                System.out.println("The result is: " + complex3.toString());
            }
            // Division
            if (choice == 4) {
                System.out.println("\nWhere i = (-1)^1/2,\n");
                System.out.println("(a + bi)/(c + di)\n");
                System.out.println("Input a:");
                a = input.nextFloat();
                System.out.println("Input b:");
                b = input.nextFloat();
                complex1 = new ComplexNumber(a, b);
                System.out.println("Input c:");
                a = input.nextFloat();
                System.out.println("Input d:");
                b = input.nextFloat();
                complex2 = new ComplexNumber(a, b);
                complex3 = complex1.divide(complex2);
                System.out.println("The result is: " + complex3.toString());
            }
        }
        input.close();
        System.out.println("\nHave a nice day!\n");
    }
}

class ComplexNumber {
    private float a;
    private float b;
    private float newA;
    private float newB;
    ComplexNumber newComplex;

    public ComplexNumber(float _a, float _b) {
        a = _a;
        b = _b;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    // Addition
    public ComplexNumber add(ComplexNumber otherNumber) {
        newA = a + otherNumber.getA();
        newB = b + otherNumber.getB();
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    // Subtraction
    public ComplexNumber subtract(ComplexNumber otherNumber) {
        newA = a - otherNumber.getA();
        newB = b - otherNumber.getB();
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    // Multiplication
    public ComplexNumber multiply(ComplexNumber otherNumber) {
        newA = (a * otherNumber.getA()) - (b * otherNumber.getB());
        newB = (b * otherNumber.getA()) + (a * otherNumber.getB());
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    // Division
    public ComplexNumber divide(ComplexNumber otherNumber) {
        newA = ((a * otherNumber.getA()) + (b * otherNumber.getB()))
                / ((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
        newB = ((b * otherNumber.getA()) - (a * otherNumber.getB()))
                / ((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    public String toString() {
        return "(" + a + ") + (" + b + ")i";
    }
}