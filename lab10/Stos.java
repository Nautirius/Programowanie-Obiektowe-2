public class Stos<T> {
    private Node<T> top;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public Stos() {
        top = null;
    }

    public void push(T value) {
        top = new Node<>(value, top);
    }

    public T pop() {
        if (top == null) {
            throw new IllegalStateException("Stos jest pusty");
        }
        T value = top.value;
        top = top.next;
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            sb.append("{").append(current.value).append("} ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}
