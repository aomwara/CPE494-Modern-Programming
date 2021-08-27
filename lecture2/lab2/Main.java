public class Main {
    public static void main(String[] args) {
        System.out.println("Create an imaginary number in rectangular form with real = 1 and imaginary = 2\n");
        ComplexNumber complexNum1 = new ComplexNumber.Builder().a(1).b(2).build();
        ComplexNumber.printAsRectangularForm(complexNum1);
        System.out.println("Now print the same imaginary number in polar form\n");
        ComplexNumber.printAsPolarForm(complexNum1);
        System.out.println("Create an imaginary number in polar form with r = 3 and theta = PI Rad.\n");
        ComplexNumber complexNum2 = new ComplexNumber.Builder().r(3).thetaAsRadians(Math.PI).build();
        ComplexNumber.printAsPolarForm(complexNum2);
        System.out.println("Now print the same imaginary number in rectangular form\n");
        ComplexNumber.printAsRectangularForm(complexNum2);
        System.out.println("Now sum these two imaginary numbers\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.add(complexNum1, complexNum2));
        ComplexNumber.printAsPolarForm(ComplexNumber.add(complexNum1, complexNum2));
        System.out.println("Now subtract these two imaginary numbers\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.subtract(complexNum1, complexNum2));
        ComplexNumber.printAsPolarForm(ComplexNumber.subtract(complexNum1, complexNum2));
        System.out.println("Now multiply these two imaginary numbers\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.multiply(complexNum1, complexNum2));
        ComplexNumber.printAsPolarForm(ComplexNumber.multiply(complexNum1, complexNum2));
        System.out.println("Now try: (1 + 2i) + (3 + 4i)\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.add(1, 2, 3, 4, 1));
        ComplexNumber.printAsPolarForm(ComplexNumber.add(1, 2, 3, 4, 1));
        System.out.println("Now try: 3(cos(PI) + isin(PI)) + 5(cos(PI/2) + (sin(PI/2)))i\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.add(3, Math.PI, 5, Math.PI / 2, 2));
        ComplexNumber.printAsPolarForm(ComplexNumber.add(3, Math.PI, 5, Math.PI / 2, 2));
        System.out.println("Now try: (1 + 2i) - (3 + 4i)\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.subtract(1, 2, 3, 4, 1));
        ComplexNumber.printAsPolarForm(ComplexNumber.subtract(1, 2, 3, 4, 1));
        System.out.println("Now try: 3(cos(PI) + isin(PI)) - 5(cos(PI/2) + (sin(PI/2)))i\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.subtract(3, Math.PI, 5, Math.PI / 2, 2));
        ComplexNumber.printAsPolarForm(ComplexNumber.subtract(3, Math.PI, 5, Math.PI / 2, 2));
        System.out.println("Now try: (1 + 2i) * (3 + 4i)\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.multiply(1, 2, 3, 4, 1));
        ComplexNumber.printAsPolarForm(ComplexNumber.multiply(1, 2, 3, 4, 1));
        System.out.println("Now try: 3(cos(PI) + isin(PI)) * 5(cos(PI/2) + (sin(PI/2)))i\n");
        ComplexNumber.printAsRectangularForm(ComplexNumber.multiply(3, Math.PI, 5, Math.PI / 2, 2));
        ComplexNumber.printAsPolarForm(ComplexNumber.multiply(3, Math.PI, 5, Math.PI / 2, 2));
    }
}

class ComplexNumber {
    private double a, b, r, theta;

    private ComplexNumber(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.r = builder.r;
        this.theta = builder.theta;
    }

    public static class Builder {
        private double a = 0, b = 0, r = 0, theta = 0;

        public Builder() {
        }

        public Builder a(double a) {
            this.a = a;
            return this;
        }

        public Builder b(double b) {
            this.b = b;
            return this;
        }

        public Builder r(double r) {
            this.r = r;
            return this;
        }

        public Builder thetaAsRadians(double theta) {
            this.theta = theta;
            return this;
        }

        public Builder thetaAsDegrees(double theta) {
            this.theta = Math.toRadians(theta);
            return this;
        }

        public ComplexNumber build() {
            if (this.r == 0) {
                this.r = Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
            }
            if (this.theta == 0) {
                if (this.a > 0) {
                    this.theta = Math.atan(this.b / this.a);
                } else if (this.a < 0) {
                    this.theta = Math.atan(this.b / this.a) + Math.PI;
                }
            }
            if (this.a == 0) {
                this.a = this.r * Math.cos(this.theta);
            }
            if (this.b == 0) {
                this.b = this.r * Math.sin(this.theta);
            }
            return new ComplexNumber(this);
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public static ComplexNumber add(ComplexNumber complexNum1, ComplexNumber complexNum2) {
        return new ComplexNumber.Builder().a(complexNum1.getA() + complexNum2.getA())
                .b(complexNum1.getB() + complexNum2.getB()).build();
    }

    public static ComplexNumber add(double complex1Field1, double complex1Field2, double complex2Field1,
            double complex2Field2, int type) {
        ComplexNumber result = new ComplexNumber.Builder().build();
        if (type == 1) {
            // both complex numbers are in rectangular form
            ComplexNumber complexNumber1 = new ComplexNumber.Builder().a(complex1Field1).b(complex1Field2).build();
            ComplexNumber complexNumber2 = new ComplexNumber.Builder().a(complex2Field1).b(complex2Field2).build();
            result = add(complexNumber1, complexNumber2);
        } else if (type == 2) {
            // both complex numbers are in polar form
            ComplexNumber complexNumber1 = new ComplexNumber.Builder().r(complex1Field1).thetaAsRadians(complex1Field2)
                    .build();
            ComplexNumber complexNumber2 = new ComplexNumber.Builder().r(complex2Field1).thetaAsRadians(complex2Field2)
                    .build();
            result = add(complexNumber1, complexNumber2);
        }
        return result;
    }

    public static ComplexNumber subtract(ComplexNumber complexNum1, ComplexNumber complexNum2) {
        return new ComplexNumber.Builder().a(complexNum1.getA() - complexNum2.getA())
                .b(complexNum1.getB() - complexNum2.getB()).build();
    }

    public static ComplexNumber subtract(double complex1Field1, double complex1Field2, double complex2Field1,
            double complex2Field2, int type) {
        ComplexNumber result = new ComplexNumber.Builder().build();
        if (type == 1) {
            // both complex numbers are in rectangular form
            ComplexNumber complexNumber1 = new ComplexNumber.Builder().a(complex1Field1).b(complex1Field2).build();
            ComplexNumber complexNumber2 = new ComplexNumber.Builder().a(complex2Field1).b(complex2Field2).build();
            result = subtract(complexNumber1, complexNumber2);
        } else if (type == 2) {
            // both complex numbers are in polar form
            ComplexNumber complexNumber1 = new ComplexNumber.Builder().r(complex1Field1).thetaAsRadians(complex1Field2)
                    .build();
            ComplexNumber complexNumber2 = new ComplexNumber.Builder().r(complex2Field1).thetaAsRadians(complex2Field2)
                    .build();
            result = subtract(complexNumber1, complexNumber2);
        }
        return result;
    }

    public static ComplexNumber multiply(ComplexNumber complexNum1, ComplexNumber complexNum2) {
        return new ComplexNumber.Builder()
                .a(complexNum1.getA() * complexNum2.getA() - complexNum1.getB() * complexNum2.getB())
                .b(complexNum1.getA() * complexNum2.getB() + complexNum1.getB() * complexNum2.getA()).build();
    }

    public static ComplexNumber multiply(double complex1Field1, double complex1Field2, double complex2Field1,
            double complex2Field2, int type) {
        ComplexNumber result = new ComplexNumber.Builder().build();
        if (type == 1) {
            // both complex numbers are in rectangular form
            ComplexNumber complexNumber1 = new ComplexNumber.Builder().a(complex1Field1).b(complex1Field2).build();
            ComplexNumber complexNumber2 = new ComplexNumber.Builder().a(complex2Field1).b(complex2Field2).build();
            result = multiply(complexNumber1, complexNumber2);
        } else if (type == 2) {
            // both complex numbers are in polar form
            ComplexNumber complexNumber1 = new ComplexNumber.Builder().r(complex1Field1).thetaAsRadians(complex1Field2)
                    .build();
            ComplexNumber complexNumber2 = new ComplexNumber.Builder().r(complex2Field1).thetaAsRadians(complex2Field2)
                    .build();
            result = multiply(complexNumber1, complexNumber2);
        }
        return result;
    }

    public static void printAsRectangularForm(ComplexNumber complexNum) {
        System.out.println(complexNum.getA() + " + " + complexNum.getB() + "i\n");
    }

    public static void printAsPolarForm(ComplexNumber complexNum) {
        System.out.println(
                complexNum.getR() + "(cos(" + complexNum.getTheta() + ") + (sin(" + complexNum.getTheta() + "))i)\n");
    }
}