import java.util.ArrayList;

public class Stos<T> {
    private ArrayList<T> elements;

    // Konstruktor
    public Stos() {
        elements = new ArrayList<>();
    }

    // Dodanie elementu na stos
    public void push(T value) {
        elements.add(value);
    }

    // Usunięcie elementu ze stosu
    public T pop() {
        if (!elements.isEmpty()) {
            return elements.remove(elements.size() - 1);
        } else {
            throw new IllegalStateException("Stos jest pusty");
        }
    }

    // Reprezentacja stosu w postaci tekstowej
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = elements.size() - 1; i >= 0; i--) {
            sb.append("{").append(elements.get(i)).append("} ");
        }
        return sb.toString().trim();
    }
}
