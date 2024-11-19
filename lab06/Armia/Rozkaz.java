package Armia;

public class Rozkaz {
    private String tresc;

    public Rozkaz(String tresc) {
        this.tresc = tresc;
    }

    @Override
    public String toString() {
        return tresc;
    }
}