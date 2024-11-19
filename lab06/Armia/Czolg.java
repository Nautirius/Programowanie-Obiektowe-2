package Armia;

public class Czolg implements Pojazd {
    private StringBuilder historiaRozkazow = new StringBuilder();

    @Override
    public void przyjmijRozkaz(Rozkaz rozkaz) {
        historiaRozkazow.append(rozkaz.toString()).append("\n");
    }

    @Override
    public String ostatniRozkaz() {
        String[] rozkazy = historiaRozkazow.toString().split("\n");
        return rozkazy.length > 0 ? "Ostatni rozkaz do mnie: " + rozkazy[rozkazy.length - 1] : "Brak rozkazów";
    }

    @Override
    public String toString() {
        return historiaRozkazow.toString();
    }
}