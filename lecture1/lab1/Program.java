package lecture1.lab1;

import java.util.Scanner;

public class Program {

    public void run(int shapeType) {

        if (shapeType == 1) {
            rectangle();
        } else if (shapeType == 2) {
            square();
        } else if (shapeType == 3) {
            trinagle();
        } else if (shapeType == 4) {
            circle();
        } else {
            noShape();
        }
    }

    private void rectangle() {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("\nRectangle");
        System.out.println("----------------------");
        System.out.println(" | Please enter width and height of Rectangle");

        System.out.print(" | Width: > ");
        double width = Scanner.nextDouble();
        System.out.print(" | Height: > ");
        double height = Scanner.nextDouble();
        System.out.println(" | ");

        Shape rectangle = new Rectangle(width, height);
        System.out.println(" | > Area = " + rectangle.getArea());
        System.out.println(" | > Perimeter = " + rectangle.getPerimeter());
        System.out.println(" | ");

        Scanner.close();
    }

    private void square() {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("\nSquare");
        System.out.println("----------------------");
        System.out.println(" | Please enter side width of Square");

        System.out.print(" | Width: > ");
        double width = Scanner.nextDouble();
        System.out.println(" | ");

        Shape square = new Square(width);
        System.out.println(" | > Area = " + square.getArea());
        System.out.println(" | > Perimeter = " + square.getPerimeter());
        System.out.println(" | ");

        Scanner.close();
    }

    private void trinagle() {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("\n(Right) Triangle");
        System.out.println("----------------------");
        System.out.println(" | Please enter base and height of (Right) Triangle");

        System.out.print(" | Base: > ");
        double base = Scanner.nextDouble();
        System.out.print(" | Height: > ");
        double height = Scanner.nextDouble();
        System.out.println(" | ");

        Shape triangle = new Triangle(base, height);
        System.out.println(" | > Area = " + triangle.getArea());
        System.out.println(" | > Perimeter = " + triangle.getPerimeter());
        System.out.println(" | ");

        Scanner.close();
    }

    private void circle() {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("\nCircle");
        System.out.println("----------------------");
        System.out.println(" | Please enter radius of circle");

        System.out.print(" | Radius: > ");
        double radius = Scanner.nextDouble();
        System.out.println(" | ");

        Shape circle = new Circle(radius);
        System.out.println(" | > Area = " + circle.getArea());
        System.out.println(" | > Perimeter = " + circle.getPerimeter());
        System.out.println(" | ");

        Scanner.close();
    }

    private void noShape() {

    }
}
