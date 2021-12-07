package pl.wartoscUniwersalna.przyklady;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class P002WyswietlanieDanych {

    public P002WyswietlanieDanych() {
        final Obiekt wartosc1 = new Obiekt(1);
        wartosc1.ksero().drukuj();

        final Obiekt wartosc2 = new Obiekt(1.4f);
        wartosc2.ksero().drukuj();

        final Obiekt wartosc3 = new Obiekt("Witaj, świecie.");
        wartosc3.ksero().drukuj();

        final Obiekt wartosc4 = new Obiekt(4.2d);
        wartosc4.ksero().drukuj();

        final Obiekt wartosc5 = new Obiekt(true);
        wartosc5.ksero().drukuj();
    }

    public static void main(String[] args) {
        new P002WyswietlanieDanych();
    }

}
