package pl.wartoscUniwersalna.przyklady;

import pl.wartoscUniwersalna.implementacja.Obiekt;
import pl.wartoscUniwersalna.implementacja.kalkulator.FabrykaDzialanMatematycznych;

public final class P006Kalkulator {

    public P006Kalkulator() {
        final Obiekt obiekt1 = new Obiekt(10);
        final Obiekt obiekt2 = new Obiekt(20.2);
        obiekt1.kalkulator().dzialanie(obiekt2, new FabrykaDzialanMatematycznych().dodawanie()).wartosc().ksero().drukuj();

        final Obiekt obiekt3 = new Obiekt(300.4);
        final Obiekt obiekt4 = new Obiekt(100.2);
        obiekt1.kalkulator()
                .dzialanie(obiekt3, new FabrykaDzialanMatematycznych().dodawanie())
                .dzialanie(obiekt4, new FabrykaDzialanMatematycznych().dodawanie())
                .wartosc()
                .parser().typCalkowity()
                .ksero().drukuj();

    }

    public static void main(String[] args) {
        new P006Kalkulator();
    }

}
