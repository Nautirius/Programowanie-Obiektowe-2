public class Cube extends Square {

    Cube(double side, double x, double y) {
        super(side, x, y);
    }

    public String toString() {
        return super.toString() + "; depth = " + String.valueOf(_side);
    }

    public double area() {
        return 6 * super.area();
    }

    public double volume()
    {
        return _side * _side * _side;
    }
}