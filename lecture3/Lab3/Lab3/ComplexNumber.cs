using System;
namespace Lab3
{
    public class ComplexNumber
    {
        private double a;
        private double b;
        private double x;
        private double y;

        private ComplexNumber(double _a, double _b)
        {
            a = _a;
            b = _b;
        }

        public static ComplexNumber CreateRectangularFrom(double _a, double _b)
        {
            return new ComplexNumber(_a, _b);
        }

        public static ComplexNumber CreatePolarFrom(double r, double angle)
        {
            return new ComplexNumber(r * Math.Cos(angle), r * Math.Sin(angle));
        }

        public double getA()
        {
            return a;
        }

        public double getB()
        {
            return b;
        }

        public ComplexNumber Add(ComplexNumber complex)
        {
            x = a + complex.getA();
            y = b + complex.getB();
            ComplexNumber resultComplex = new ComplexNumber(x, y);
            return resultComplex;
        }

        public ComplexNumber Subtract(ComplexNumber complex)
        {
            x = a - complex.getA();
            y = b - complex.getB();
            ComplexNumber resultComplex = new ComplexNumber(x, y);
            return resultComplex;
        }

        public ComplexNumber Multiply(ComplexNumber complex)
        {
            x = (a * complex.getA()) + ((b * complex.getB()) * -1);
            y = (a * complex.getB()) + (b * complex.getA());
            ComplexNumber resultComplex = new ComplexNumber(x, y);
            return resultComplex;
        }

        public double getR()
        {
            return Math.Sqrt(a * a + b * b);
        }

        public double getAngle()
        {
            return Math.Atan2(b, a) * 180 / Math.PI;
        }

        public String PrintRectangularFrom()
        {

            return a + "+ i" + "(" + b + ")";
        }

        public String PrintPolarFrom()
        {

            return getR() + "(" + "cos" + "(" + getAngle() + ")" + "+" + "isin" + "(" + getAngle() + ")" + ")";
        }
    }
}
