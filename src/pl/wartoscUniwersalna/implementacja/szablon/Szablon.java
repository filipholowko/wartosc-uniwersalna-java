package pl.wartoscUniwersalna.implementacja.szablon;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class Szablon {

    private final Obiekt obiektGlowny;

    public Szablon(final Obiekt obiektGlowny) {
        this.obiektGlowny = obiektGlowny;
    }

    public Html html() {
        return new Html(obiektGlowny);
    }

}
