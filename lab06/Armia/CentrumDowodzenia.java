package Armia;

import java.util.HashMap;

public class CentrumDowodzenia implements Jednostka {
    private HashMap<String, Pojazd> pojazdy = new HashMap<>();
    private int licznikPojazdow = 0;

    @Override
    public void zarejestrujCzolg(Czolg czolg) {
        licznikPojazdow++;
        pojazdy.put(String.valueOf(licznikPojazdow), czolg);
    }

    @Override
    public void wydajRozkaz(String numerPojazdu, Rozkaz rozkaz) {
        Pojazd pojazd = pojazdy.get(numerPojazdu);
        if (pojazd != null) {
            pojazd.przyjmijRozkaz(rozkaz);
        } else {
            System.out.println("Brak pojazdu o danym numerze");
        }
    }

    @Override
    public String toString() {
        StringBuilder raport = new StringBuilder("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n");
        for (HashMap.Entry<String, Pojazd> entry : pojazdy.entrySet()) {
            raport.append("Czolg nr ").append(entry.getKey()).append(" otrzymal rozkazy:\n");
            raport.append(entry.getValue().toString()).append("\n");
        }
        return raport.toString();
    }
}