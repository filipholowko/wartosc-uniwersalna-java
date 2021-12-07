package pl.wartoscUniwersalna.implementacja.kalkulator;

import pl.wartoscUniwersalna.implementacja.Obiekt;
import pl.wartoscUniwersalna.implementacja.bufor.Bufor;

public final class Kalkulator {

    private Obiekt obiektGlowny;
    private Bufor buforZadan;

    public Kalkulator(final Obiekt obiektGlowny) {
        this.obiektGlowny = obiektGlowny;
        buforZadan = new Bufor(obiektGlowny);
    }

    public Kalkulator dzialanie(final Obiekt obiektDoWykonaniaDzialania, final Obiekt dzialanie) {
        final float wartoscZmiObiGlownego = (float) obiektGlowny.parser().typZmPoj().wartosc();
        final float wartoscZmiObiDoWykDzialania = (float) obiektDoWykonaniaDzialania.parser().typZmPoj().wartosc();
        float wynikDzialania = (float) obiektGlowny.parser().typZmPoj().wartosc();

        if ((boolean)dzialanie.porownanie().jestRowny(new FabrykaDzialanMatematycznych().dodawanie()).wartosc()) {
            wynikDzialania = wartoscZmiObiGlownego + wartoscZmiObiDoWykDzialania;
        } else if ((boolean)dzialanie.porownanie().jestRowny(new FabrykaDzialanMatematycznych().odejmowanie()).wartosc()) {
            wynikDzialania = wartoscZmiObiGlownego - wartoscZmiObiDoWykDzialania;
        } else if ((boolean)dzialanie.porownanie().jestRowny(new FabrykaDzialanMatematycznych().mnozenie()).wartosc()) {
            wynikDzialania = wartoscZmiObiGlownego * wartoscZmiObiDoWykDzialania;
        } else if ((boolean)dzialanie.porownanie().jestRowny(new FabrykaDzialanMatematycznych().dzielenie()).wartosc()) {
            wynikDzialania = wartoscZmiObiGlownego / wartoscZmiObiDoWykDzialania;
        } else if ((boolean)dzialanie.porownanie().jestRowny(new FabrykaDzialanMatematycznych().modulo()).wartosc()) {
            wynikDzialania = wartoscZmiObiGlownego % wartoscZmiObiDoWykDzialania;
        }

        obiektGlowny = new Obiekt(wynikDzialania);
        return this;
    }

    public Obiekt wartosc() {
        return obiektGlowny;
    }

}
