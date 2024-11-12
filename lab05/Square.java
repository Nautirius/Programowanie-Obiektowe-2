public class Square extends Point {
    protected double _side;

    Square(double side, double x, double y) {
        super(x, y);
        _side = side;
    }

    public String toString() {
        return "Corner = " + super.toString() + "; side = " + String.valueOf(_side);
    }

    public double area() {
        return _side * _side;
    }
}