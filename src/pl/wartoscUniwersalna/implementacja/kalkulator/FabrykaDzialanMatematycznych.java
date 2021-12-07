package pl.wartoscUniwersalna.implementacja.kalkulator;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class FabrykaDzialanMatematycznych {

    public Obiekt dodawanie() {
        return new Obiekt("dodawanie");
    }

    public Obiekt odejmowanie() {
        return new Obiekt("odejmowanie");
    }

    public Obiekt mnozenie() {
        return new Obiekt("mnozenie");
    }

    public Obiekt dzielenie() {
        return new Obiekt("dzielenie");
    }

    public Obiekt modulo() {
        return new Obiekt("modulo");
    }

}
