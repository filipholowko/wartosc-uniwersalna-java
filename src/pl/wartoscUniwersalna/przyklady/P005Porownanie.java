package pl.wartoscUniwersalna.przyklady;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class P005Porownanie {

    public P005Porownanie() {
        final Obiekt obiekt1 = new Obiekt("Witaj, świecie!");
        final Obiekt obiekt2 = new Obiekt("Witaj świecie");

        obiekt1.porownanie().jestRowny(obiekt2).ksero().drukuj();

        final Obiekt obiekt3 = new Obiekt("Witaj, świecie!");
        obiekt1.porownanie().jestRowny(obiekt3).ksero().drukuj();

        final Obiekt obiekt4 = new Obiekt(3);
        final Obiekt obiekt5 = new Obiekt(4);
        obiekt4.porownanie().jestRowny(obiekt5).ksero().drukuj();

        final Obiekt obiekt6 = new Obiekt(3);
        obiekt4.porownanie().jestRowny(obiekt6).ksero().drukuj();
    }

    public static void main(String[] args) {
        new P005Porownanie();
    }

}
