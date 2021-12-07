package pl.wartoscUniwersalna.przyklady;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class P003Bufor {

    public P003Bufor() {
        final Obiekt obiekt1 = new Obiekt("Witaj, świecie");
        obiekt1.bufor().wloz(new Obiekt("Przykladowy tekst")).wloz(new Obiekt("Kolejny tekst")).wartosc().ksero().drukuj();

        new Obiekt("").ksero().drukuj();
        new Obiekt("**********************").ksero().drukuj();
        new Obiekt("").ksero().drukuj();

        final Obiekt obiekt2 = new Obiekt("To jest drugi obiekt");
        obiekt2.bufor().wloz("tekst1").wloz("tekst2").wloz("tekst3").wartosc().ksero().drukuj();

    }

    public static void main(String[] args) {
        new P003Bufor();
    }

}
