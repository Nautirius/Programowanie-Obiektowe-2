import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    void testComplex() {
        Complex c = new Complex();
        assertEquals(0, c.getRe());
        assertEquals(0, c.getIm());
    }

    @Test
    void testComplex1() {
        Complex c = new Complex(2);
        assertEquals(2, c.getRe());
        assertEquals(0, c.getIm());
    }

    @Test
    void testComplex2() {
        Complex c = new Complex(2, -3);
        assertEquals(2, c.getRe());
        assertEquals(-3, c.getIm());
    }

    @Test
    void testSet() {
        Complex c = new Complex();
        c.set(5, -3);
        assertEquals(5, c.getRe());
        assertEquals(-3, c.getIm());
    }

    @Test
    void testSet1() {
        Complex c = new Complex();
        c.set(2, -1);
        assertEquals(2, c.getRe());
        assertEquals(-1, c.getIm());
    }

    @Test
    void testSetRe() {
        Complex c = new Complex();
        c.setRe(7);
        assertEquals(7, c.getRe());
        assertEquals(0, c.getIm());
    }

    @Test
    void testSetRe1() {
        Complex c = new Complex();
        c.setRe(2);
        assertEquals(2, c.getRe());
        assertEquals(0, c.getIm());
    }

    @Test
    void testSetIm() {
        Complex c = new Complex();
        c.setIm(-4);
        assertEquals(0, c.getRe());
        assertEquals(-4, c.getIm());
    }

    @Test
    void testSetIm1() {
        Complex c = new Complex();
        c.setIm(2);
        assertEquals(0, c.getRe());
        assertEquals(2, c.getIm());
    }

    @Test
    void testGetRe() {
        Complex c = new Complex(4, 5);
        assertEquals(4, c.getRe());
    }

    @Test
    void testGetRe1() {
        Complex c = new Complex(-20, 0);
        assertEquals(-20, c.getRe());
    }

    @Test
    void testGetIm() {
        Complex c = new Complex(4, -5);
        assertEquals(-5, c.getIm());
    }

    @Test
    void testGetIm1() {
        Complex c = new Complex(-2, 3);
        assertEquals(3, c.getIm());
    }

    @Test
    void testAddCC() {
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(1, -1);
        Complex result = Complex.add(c1, c2);
        assertEquals(3, result.getRe());
        assertEquals(2, result.getIm());
    }

    @Test
    void testAddCC1() {
        Complex c1 = new Complex(-2, -2);
        Complex c2 = new Complex(3, -1);
        Complex result = Complex.add(c1, c2);
        assertEquals(1, result.getRe());
        assertEquals(-3, result.getIm());
    }

    @Test
    void testAddCD() {
        Complex c = new Complex(3, 4);
        Complex result = Complex.add(c, 5);
        assertEquals(8, result.getRe());
        assertEquals(4, result.getIm());
    }

    @Test
    void testAddCD1() {
        Complex c = new Complex(3, 4);
        Complex result = Complex.add(c, -5);
        assertEquals(-2, result.getRe());
        assertEquals(4, result.getIm());
    }

    @Test
    void testAddDC() {
        Complex c = new Complex(3, 4);
        Complex result = Complex.add(5, c);
        assertEquals(8, result.getRe());
        assertEquals(4, result.getIm());
    }

    @Test
    void testAddDC1() {
        Complex c = new Complex(3, 4);
        Complex result = Complex.add(-5, c);
        assertEquals(-2, result.getRe());
        assertEquals(4, result.getIm());
    }

    @Test
    void testSubtractCC() {
        Complex c1 = new Complex(5, 7);
        Complex c2 = new Complex(2, 3);
        Complex result = Complex.subtract(c1, c2);
        assertEquals(3, result.getRe());
        assertEquals(4, result.getIm());
    }

    @Test
    void testSubtractCC1() {
        Complex c1 = new Complex(-3, 2);
        Complex c2 = new Complex(-1, 0);
        Complex result = Complex.subtract(c1, c2);
        assertEquals(-2, result.getRe());
        assertEquals(2, result.getIm());
    }

    @Test
    void testSubtractCD() {
        Complex c = new Complex(5, 7);
        Complex result = Complex.subtract(c, 5);
        assertEquals(0, result.getRe());
        assertEquals(7, result.getIm());
    }

    @Test
    void testSubtractCD1() {
        Complex c = new Complex(-2, 7);
        Complex result = Complex.subtract(c, -4);
        assertEquals(2, result.getRe());
        assertEquals(7, result.getIm());
    }

    @Test
    void testSubtractDC() {
        Complex c = new Complex(5, 7);
        Complex result = Complex.subtract(5, c);
        assertEquals(0, result.getRe());
        assertEquals(-7, result.getIm());
    }

    @Test
    void testSubtractDC1() {
        Complex c = new Complex(-2, 7);
        Complex result = Complex.subtract(-4, c);
        assertEquals(-2, result.getRe());
        assertEquals(-7, result.getIm());
    }

    @Test
    void testMultiplyCC() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex result = Complex.multiply(c1, c2);
        assertEquals(-5, result.getRe());
        assertEquals(10, result.getIm());
    }

    @Test
    void testMultiplyCC1() {
        Complex c1 = new Complex(-3, -3);
        Complex c2 = new Complex(2, -1);
        Complex result = Complex.multiply(c1, c2);
        assertEquals(-9, result.getRe());
        assertEquals(-3, result.getIm());
    }

    @Test
    void testMultiplyCD() {
        Complex c = new Complex(1, -2);
        Complex result = Complex.multiply(c, -1);
        assertEquals(-1, result.getRe());
        assertEquals(2, result.getIm());
    }

    @Test
    void testMultiplyCD1() {
        Complex c = new Complex(-2, 2);
        Complex result = Complex.multiply(c, 2);
        assertEquals(-4, result.getRe());
        assertEquals(4, result.getIm());
    }

    @Test
    void testMultiplyDC() {
        Complex c = new Complex(1, -2);
        Complex result = Complex.multiply(-1, c);
        assertEquals(-1, result.getRe());
        assertEquals(2, result.getIm());
    }

    @Test
    void testMultiplyDC1() {
        Complex c = new Complex(-2, 2);
        Complex result = Complex.multiply(2, c);
        assertEquals(-4, result.getRe());
        assertEquals(4, result.getIm());
    }

    @Test
    void testDivideCC() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex result = Complex.divide(c1, c2);
        assertEquals(0.44, result.getRe());
        assertEquals(0.08, result.getIm());
    }

    @Test
    void testDivideCC1() {
        Complex c1 = new Complex(-3, -2);
        Complex c2 = new Complex(4, -3);
        Complex result = Complex.divide(c1, c2);
        assertEquals(-0.24, result.getRe());
        assertEquals(-0.68, result.getIm());
    }

    @Test
    void testDivideCD() {
        Complex c = new Complex(1, 2);
        Complex result = Complex.divide(c, 2);
        assertEquals(0.5, result.getRe());
        assertEquals(1, result.getIm());
    }

    @Test
    void testDivideCD1() {
        Complex c = new Complex(-3, 1);
        Complex result = Complex.divide(c, 4);
        assertEquals(-0.75, result.getRe());
        assertEquals(0.25, result.getIm());
    }

    @Test
    void testDivideDC() {
        Complex c = new Complex(1, 2);
        Complex result = Complex.divide(2, c);
        assertEquals(0.4, result.getRe());
        assertEquals(-0.8, result.getIm());
    }

    @Test
    void testDivideDC1() {
        Complex c = new Complex(-3, 1);
        Complex result = Complex.divide(4, c);
        assertEquals(-1.2, result.getRe());
        assertEquals(-0.4, result.getIm());
    }

    @Test
    void testToString() {
        Complex c1 = new Complex();
        assertEquals("0.0+0.0i", c1.toString());

        Complex c2 = new Complex(5);
        assertEquals("5.0+0.0i", c2.toString());

        Complex c3 = new Complex(3, -4);
        assertEquals("3.0-4.0i", c3.toString());
    }
}