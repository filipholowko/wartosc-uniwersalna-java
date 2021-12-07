package pl.wartoscUniwersalna.przyklady;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class P001TworzenieObiektow {

    public P001TworzenieObiektow() {
        Obiekt obiekt1 = new Obiekt("Witaj, świecie");
    }

    public static void main(String[] args) {
        new P001TworzenieObiektow();
    }

}
