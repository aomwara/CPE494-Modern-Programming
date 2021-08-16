package lecture1.lab1;

public class Square {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * width;
    }

    public double getPerimeter() {
        return width * 4;
    }
}
