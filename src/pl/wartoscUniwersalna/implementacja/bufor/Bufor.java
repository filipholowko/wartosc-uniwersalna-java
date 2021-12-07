package pl.wartoscUniwersalna.implementacja.bufor;

import pl.wartoscUniwersalna.implementacja.Obiekt;

import java.util.ArrayList;
import java.util.List;

public final class Bufor {

    private List <Obiekt> listaObiektow = new ArrayList<>();
    private Obiekt obiektGlowny = null;

    public Bufor(final Obiekt obiektGlowny) {
        listaObiektow.add(obiektGlowny);
        this.obiektGlowny = obiektGlowny;
    }

    public Bufor wloz(final String wiadomosc) {
        return wloz(new Obiekt(wiadomosc));
    }

    public Bufor wloz(final Object [] tablicaWiadomosci) {
        final int liczbaWiadomosci = tablicaWiadomosci.length;
        for (int indeksWiadomosci = 0; indeksWiadomosci < liczbaWiadomosci; indeksWiadomosci++) {
            wloz(new Obiekt(tablicaWiadomosci[indeksWiadomosci]));
        }
        return this;
    }

    public Bufor wloz(final Obiekt obiekt) {
        try {
            if (listaObiektow != null) {
                listaObiektow.add(obiekt);
                final Obiekt lokalnyObiektGlowny = obiektGlowny;
                final String poprzedniaWiadomosc = (String) lokalnyObiektGlowny.wartosc();
                final String nowaWiadomosc = (String) obiekt.wartosc();
                final String scalonaWiadomosc = poprzedniaWiadomosc + nowaWiadomosc;
                final Obiekt nowopowstalyObiekt = new Obiekt(scalonaWiadomosc);
                obiektGlowny = nowopowstalyObiekt;
            }
        } catch (final Exception wyjatek) {
            wyjatek.printStackTrace();
        }
        return this;
    }

    public Bufor wloz(final Obiekt ... tablicaObiektowDoDodania) {
        try {
            if (listaObiektow != null) {
                final int liczbaObiektowDoDodania = tablicaObiektowDoDodania.length;
                for (int indeks = 0; indeks < liczbaObiektowDoDodania; indeks++) {
                    final Obiekt obiektDoDodania = tablicaObiektowDoDodania[indeks];
                    wloz(obiektDoDodania);
                }
            }
        } catch (final Exception wyjatek) {
            wyjatek.printStackTrace();
        }
        return this;
    }

    public Obiekt wyciagnij(final Obiekt indeksObiektuDoPobrania) {
        if (listaObiektow != null) {
            Obiekt obiektDoZwrocenia = null;
            try {
                final int indeksJakoTypProsty = (int) indeksObiektuDoPobrania.wartosc();
                obiektDoZwrocenia = listaObiektow.get(indeksJakoTypProsty);
            } catch (final IndexOutOfBoundsException wyjatek) {
                wyjatek.printStackTrace();
            } catch (final Exception wyjatek) {
                wyjatek.printStackTrace();
            } finally {
                return obiektDoZwrocenia;
            }
        } else {
            return new Obiekt(0);
        }
    }

    public Obiekt rozmiar() {
        return new Obiekt(listaObiektow.size());
    }

    public Obiekt wartosc() {
        if (obiektGlowny != null) return obiektGlowny;
        else return new Obiekt("Nie ma takiego obiektu");
    }

    public Bufor scal() {
        if (listaObiektow != null) {
            final StringBuffer scalonaWiadomosc = new StringBuffer();
            final int liczbaObiektow = listaObiektow.size();
            for (int indeks = 0; indeks < liczbaObiektow; indeks++) {
                final String obiektJakoCiagZnakow = listaObiektow.get(indeks).wartosc().toString();
                scalonaWiadomosc.append(obiektJakoCiagZnakow);
            }
            obiektGlowny = new Obiekt(scalonaWiadomosc.toString());
        }
        return this;
    }

}
