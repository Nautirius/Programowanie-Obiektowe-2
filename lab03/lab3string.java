import java.lang.StringBuilder;

/**
 * Klasa lab3string
 *
 * Zawiera statyczne metody wykonujace operacje na obiektach klasy String
 *
 * @author Marcin Knapczyk
 * @version 1.0
 */
class lab3string
{
    /**
     * Zwraca dlugosc Stringa
     *
     * @param s String
     * @return dlugosc s
     */
    public static int dlugosc(String s)
    {
        return s.length();
    }

    /**
     * Zwraca liczbe wystapien znaku w Stringu
     *
     * @param s String
     * @param c char
     * @return liczba wystapien count
     */
    public static int ile_razy_literka_wystepuje(String s, char c)
    {
        int count = 0;
        for(char x: s.toCharArray())
        {
            if(x==c) count += 1;
        }
        return count;
    }

    /**
     * Zwraca wynik porownania dwoch Stringow
     *
     * @param s1 String
     * @param s2 String
     * @return wynik porownania Stringow
     */
    public static boolean czy_takie_same(String s1, String s2)
    {
        return s1.equals(s2);
    }

    /**
     * Zwraca odwroconego Stringa
     *
     * @param s String
     * @return odwrocony String
     */
    public static String wspak(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    /**
     * Sprawdza czy podany String jest palindromem
     *
     * @param s String
     * @return wynik testu
     */
    public static boolean czy_plaindrom(String s)
    {
        return s.equals(lab3string.wspak(s));
    }

    /**
     * Sprawdza czy podany String jest 'abecadlowy'
     *
     * @param s String
     * @return wynik testu
     */
    public static boolean czy_abecadlowe(String s)
    {
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i - 1) > s.charAt(i)) return false;
        }
        return true;
    }

    /**
     * Zwraca zaszyfrowany String
     * Szyfr polega na przesunieciu znakow <b>[a-z], [A-Z] o 13</b>, z zawinieciem
     *
     * @param s String
     * @return zaszyfrowany Sting
     */
    public static String rot13(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // przesuniecie o poczatek 'a' (by dzialalo rozwiazanie z modulo);
                // dodanie 13 wg. szyfru; 26 znakow, modulo pozwala na 'zawiniecie';
                // powrot do przedzialu [a-z]
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            }
            else if
            (c >= 'A' && c <= 'Z') {
                // przesuniecie o poczatek 'A' (by dzialalo rozwiazanie z modulo);
                // dodanie 13 wg. szyfru; 26 znakow, modulo pozwala na 'zawiniecie';
                // powrot do przedzialu [A-Z]
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            }
            else { // Znaki specjalne zostaja
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
