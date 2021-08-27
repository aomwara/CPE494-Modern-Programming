
public class Main {
    public static void main(String[] args) {
        // Input RectangularFrom
        ComplexNumber complexNumber1 = ComplexNumber.CreateRectangularFrom(5, 9);
        System.out.println("ComplexNumber 1:" + complexNumber1.PrintRectangularFrom());

        // Input PolarFrom
        ComplexNumber complexNumber2 = ComplexNumber.CreatePolarFrom(10, 30);
        System.out.println("ComplexNumber 2:" + complexNumber2.PrintRectangularFrom() + "(convert form PolarFrom)\n");

        // Add RectangularFrom and PolarFrom
        System.out.println("Add: RectangularFrom & PolarFrom");
        ComplexNumber complexNumber3 = complexNumber1.Add(complexNumber2);
        System.out.println(" | Result: " + complexNumber3.PrintRectangularFrom() + "\n | = "
                + complexNumber3.PrintPolarFrom() + "\n");

        // Subtract RectangularFrom and PolarFrom
        System.out.println("Subtract: RectangularFrom & PolarFrom");
        complexNumber3 = complexNumber1.Subtract(complexNumber2);
        System.out.println(" | Result: " + complexNumber3.PrintRectangularFrom() + "\n | = "
                + complexNumber3.PrintPolarFrom() + "\n");

        // Multiply RectangularFrom and PolarFrom
        System.out.println("Multiply: RectangularFrom & PolarFrom");
        complexNumber3 = complexNumber1.Multiply(complexNumber2);
        System.out.println(" | Result: " + complexNumber3.PrintRectangularFrom() + "\n | = "
                + complexNumber3.PrintPolarFrom() + "\n");
        System.out.println("_______End_______");
    }

}

class ComplexNumber {
    private double a;
    private double b;
    private double x;
    private double y;

    private ComplexNumber(double _a, double _b) {
        this.a = _a;
        this.b = _b;
    }

    public static ComplexNumber CreateRectangularFrom(double _a, double _b) {
        return new ComplexNumber(_a, _b);
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

    public ComplexNumber Add(ComplexNumber complex) {
        x = a + complex.getA();
        y = b + complex.getB();
        ComplexNumber resultComplex = new ComplexNumber(x, y);
        return resultComplex;
    }

    public ComplexNumber Subtract(ComplexNumber complex) {
        x = a - complex.getA();
        y = b - complex.getB();
        ComplexNumber resultComplex = new ComplexNumber(x, y);
        return resultComplex;
    }

    public ComplexNumber Multiply(ComplexNumber complex) {
        x = (a * complex.getA()) + ((b * complex.getB()) * -1);
        y = (a * complex.getB()) + (b * complex.getA());
        ComplexNumber resultComplex = new ComplexNumber(x, y);
        return resultComplex;
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

    public String PrintPolarFrom() {

        return getR() + "(" + "cos" + "(" + getAngle() + ")" + "+" + "isin" + "(" + getAngle() + ")" + ")";
    }
}
