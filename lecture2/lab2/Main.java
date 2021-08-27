
public class Main {
    public static void main(String[] args) {
        System.out.println("\nChinnagrit Butbumrung  61070501016 Sec A\n");
        // Input RectangularFrom
        ComplexNumber c1 = ComplexNumber.CreateRectangularFrom(5, 9);
        System.out.println("value1:" + c1.PrintRectangularFrom());

        // Input PolarFrom
        ComplexNumber c2 = ComplexNumber.CreatePolarFrom(10, 30);
        System.out.println("value2 (convert form PolarFrom):" + c2.PrintRectangularFrom() + "\n");

        // Add between RectangularFrom and PolarFrom
        System.out.println("Add between RectangularFrom and PolarFrom");
        ComplexNumber c3 = c1.Add(c2);
        System.out.println("Result = " + c3.PrintRectangularFrom() + "\nor " + c3.PrintPolar() + "\n");

        // Subtract between RectangularFrom and PolarFrom
        System.out.println("Subtract between RectangularFrom and PolarFrom");
        c3 = c1.Subtract(c2);
        System.out.println("Result = " + c3.PrintRectangularFrom() + "\nor " + c3.PrintPolar() + "\n");

        // Multiply between RectangularFrom and PolarFrom
        System.out.println("Multiply between RectangularFrom and PolarFrom");
        c3 = c1.Multiply(c2);
        System.out.println("Result = " + c3.PrintRectangularFrom() + "\nor " + c3.PrintPolar() + "\n");
        System.out.println("Exit from program");
    }

}

class ComplexNumber {
    private double a, b, x, y;

    private ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static ComplexNumber CreateRectangularFrom(double a, double b) {
        return new ComplexNumber(a, b);
    }

    public static ComplexNumber CreatePolarFrom(double r, double angle) {
        return new ComplexNumber(r * Math.cos(angle), r * Math.sin(angle));
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public ComplexNumber Add(ComplexNumber other) {
        x = a + other.getA();
        y = b + other.getB();
        ComplexNumber newComplex = new ComplexNumber(x, y);
        return newComplex;
    }

    public ComplexNumber Subtract(ComplexNumber other) {
        x = a - other.getA();
        y = b - other.getB();
        ComplexNumber newComplex = new ComplexNumber(x, y);
        return newComplex;
    }

    public ComplexNumber Multiply(ComplexNumber other) {
        x = (a * other.getA()) + ((b * other.getB()) * -1);
        y = (a * other.getB()) + (b * other.getA());
        ComplexNumber newComplex = new ComplexNumber(x, y);
        return newComplex;
    }

    public double getR() {
        return Math.sqrt(a * a + b * b);
    }

    public double getAngle() {
        return Math.atan2(b, a) * 180 / Math.PI;
    }

    public String PrintRectangularFrom() {

        return a + "+ i" + "(" + b + ")";
    }

    public String PrintPolar() {

        return getR() + "(" + "cos" + "(" + getAngle() + ")" + "+" + "isin" + "(" + getAngle() + ")" + ")";
    }
}
