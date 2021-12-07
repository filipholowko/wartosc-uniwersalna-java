package pl.wartoscUniwersalna.przyklady;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class P004SzablonHtml {

    public P004SzablonHtml() {
        Obiekt stronaHtml = new Obiekt("");

        stronaHtml.szablon().html().wartosc().ksero().drukuj();
    }

    public static void main(String[] args) {
        new P004SzablonHtml();
    }

}
