public class lab07 {
    public static void main(String[] args) {

        // sprawdzenie poprawnosci dzialania konstruktorow
        Complex c1 = new Complex();
        Complex c2 = new Complex(5);
        Complex c3 = new Complex(3, -4);

        System.out.println(c1.toString()); // oczekiwane: 0.0+0.0i
        System.out.println(c2.toString()); // oczekiwane: 5.0+0.0i
        System.out.println(c3.toString()); // oczekiwane: 3.0-4.0i
    }
}