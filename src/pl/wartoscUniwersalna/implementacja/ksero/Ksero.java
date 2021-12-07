package pl.wartoscUniwersalna.implementacja.ksero;

import pl.wartoscUniwersalna.implementacja.Obiekt;

/**
 * Klasa "Ksero" odpowiada za drukowanie, czyli wyswietlanie danych
 * oraz skanowanie, czyli pobieranie danych od uzytkownika
 */
public final class Ksero {

    private Obiekt obiekt;

    public Ksero(final Obiekt obiekt) {
        this.obiekt = obiekt;
    }

    public Obiekt drukuj() {
        System.out.println(obiekt);
        return obiekt;
    }

}
