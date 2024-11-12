public class Point extends Shape {

    protected double _x;
    protected double _y;

    Point(double x, double y) {
        _x = x;
        _y = y;
    }

    public String toString() {
        return "[" + String.valueOf(_x) + ", " + String.valueOf(_y) + "]";
    }

    public double area()
    {
        return 0.0;
    }

    public double volume()
    {
        return 0.0;
    }
}