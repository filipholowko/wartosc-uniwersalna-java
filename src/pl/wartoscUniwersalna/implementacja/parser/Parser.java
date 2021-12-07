package pl.wartoscUniwersalna.implementacja.parser;

import pl.wartoscUniwersalna.implementacja.Obiekt;

import java.math.BigInteger;

public final class Parser {

    private Obiekt obiektGlowny;

    public Parser(final Obiekt obiektGlowny) {
        this.obiektGlowny = obiektGlowny;
    }

    public Obiekt typCalkowity() {
        final Float wartoscZmiennoprzecinkowa = (Float) obiektGlowny.parser().typZmPoj().wartosc();
        final Integer wartoscCalkowita = wartoscZmiennoprzecinkowa.intValue();
        obiektGlowny = new Obiekt(wartoscCalkowita);
        return obiektGlowny;
    }

    public Obiekt typZmPoj() {
        final float wartoscZmiennoprzecinkowa = Float.valueOf(obiektGlowny.wartosc().toString());
        obiektGlowny = new Obiekt(wartoscZmiennoprzecinkowa);
        return obiektGlowny;
    }

}
