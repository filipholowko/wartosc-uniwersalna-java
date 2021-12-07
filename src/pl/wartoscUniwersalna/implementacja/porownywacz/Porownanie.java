package pl.wartoscUniwersalna.implementacja.porownywacz;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class Porownanie {

    private final Obiekt obiektGlowny;

    public Porownanie(final Obiekt obiektGlowny) {
        this.obiektGlowny = obiektGlowny;
    }

    public Obiekt jestRowny(final Obiekt obiektDoPorownania) {
        final boolean jestRownyBoolean = obiektGlowny.wartosc().equals(obiektDoPorownania.wartosc());
        final Obiekt wartoscPorownania = new Obiekt(jestRownyBoolean);
        return wartoscPorownania;
    }

}
