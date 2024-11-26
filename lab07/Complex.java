public class Complex {
    private double re;
    private double im;

    public Complex() {
        this.re = 0;
        this.im = 0;
    }

    public Complex(double a) {
        this.re = a;
        this.im = 0;
    }

    public Complex(double a, double b) {
        this.re = a;
        this.im = b;
    }

    public void set(double a, double b) {
        this.re = a;
        this.im = b;
    }

    public void setRe(double a) {
        this.re = a;
    }

    public void setIm(double a) {
        this.im = a;
    }

    public double getRe() {
//        return 0;
        return re;
    }

    public double getIm() {
//        return 0;
        return im;
    }

    public static Complex add(Complex c1, Complex c2) {
//        return new Complex();
        return new Complex(c1.getRe() + c2.getRe(), c1.getIm() + c2.getIm());
    }

    public static Complex add(Complex c, double d) {
//        return new Complex();
        return new Complex(c.getRe() + d, c.getIm());
    }

    public static Complex add(double d, Complex c) {
//        return new Complex();
        return add(c, d);
    }

    public static Complex subtract(Complex c1, Complex c2) {
//        return new Complex();
        return new Complex(c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm());
    }

    public static Complex subtract(Complex c, double d) {
//        return new Complex();
        return new Complex(c.getRe() - d, c.getIm());
    }

    public static Complex subtract(double d, Complex c) {
//        return new Complex();
        return new Complex(d - c.getRe(), -c.getIm());
    }

    public static Complex multiply(Complex c1, Complex c2) {
//        return new Complex();
        double re = c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm();
        double im = c1.getRe() * c2.getIm() + c1.getIm() * c2.getRe();
        return new Complex(re, im);
    }

    public static Complex multiply(Complex c, double d) {
//        return new Complex();
        return new Complex(c.getRe() * d, c.getIm() * d);
    }

    public static Complex multiply(double d, Complex c) {
//        return new Complex();
        return multiply(c, d);
    }

    public static Complex divide(Complex c1, Complex c2) {
//        return new Complex();
        double denominator = c2.getRe() * c2.getRe() + c2.getIm() * c2.getIm();
        double re = (c1.getRe() * c2.getRe() + c1.getIm() * c2.getIm()) / denominator;
        double im = (c1.getIm() * c2.getRe() - c1.getRe() * c2.getIm()) / denominator;
        return new Complex(re, im);
    }

    public static Complex divide(Complex c, double d) {
//        return new Complex();
        return new Complex(c.getRe() / d, c.getIm() / d);
    }

    public static Complex divide(double d, Complex c) {
//        return new Complex();
        double denominator = c.getRe() * c.getRe() + c.getIm() * c.getIm();
        double re = d * c.getRe() / denominator;
        double im = -d * c.getIm() / denominator;
        return new Complex(re, im);
    }

    @Override
    public String toString() {
        return re + (im >= 0 ? "+" : "") + im + "i";
    }
}