package pl.wartoscUniwersalna.przyklady;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class P007Parser {

    public P007Parser() {
        final Obiekt obiekt1 = new Obiekt(10);
        obiekt1.parser().typCalkowity().ksero().drukuj();
        obiekt1.parser().typZmPoj().ksero().drukuj();

        new Obiekt("***********").ksero().drukuj();

        final Obiekt obiekt2 = new Obiekt(13.3334);
        obiekt2.parser().typCalkowity().ksero().drukuj();
        obiekt2.parser().typZmPoj().ksero().drukuj();

    }

    public static void main(String[] args) {
        new P007Parser();
    }

}
