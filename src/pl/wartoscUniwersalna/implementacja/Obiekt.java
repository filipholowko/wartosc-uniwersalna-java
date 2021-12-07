package pl.wartoscUniwersalna.implementacja;

import pl.wartoscUniwersalna.implementacja.bufor.Bufor;
import pl.wartoscUniwersalna.implementacja.kalkulator.Kalkulator;
import pl.wartoscUniwersalna.implementacja.ksero.Ksero;
import pl.wartoscUniwersalna.implementacja.parser.Parser;
import pl.wartoscUniwersalna.implementacja.porownywacz.Porownanie;
import pl.wartoscUniwersalna.implementacja.szablon.Szablon;

import java.io.*;

/**
 * "Obiekt" jest to klasa,
 * definiujaca typ, posiadajacy wiele metod i funkcjonalnosci
 * znanych z innych bibliotek, jak np. serializacja, zapisywanie do pliku, itp.
 * Jest to typ, mozna powiedziec, uniwersalny.
 * W programowaniu wykonujemy wiele roznych zadan, jak np.
 * zapisywanie i odczytywanie danych do i z pliku, serializacja i deserializacja,
 * szyfrowanie, funkcje matematyczne, itd.
 * Ponizszy typ gromadzi wiele przydatnych funkcjonalnosci
 * w jednym miejscu, dzieki czemu pod reka mamy metody, ktore sa
 * czesto bardzo przydatne. Opiera sie o nowoczesny, funkcyjny paradygmat,
 * a jego uzycie jest proste i intuicyjne.
 *
 * Ponizsza klasa stanowi fasade, ktora rozdziela odpowiedzialnosci
 * wykonywania kodu na osobne klasy. Metody klas, wychodzacych
 * z klasy glownej, pozwalaja na powrot do klasy glownej,
 * dzieki czemu mozna wywolac metody innych klas
 * bez koniecznosci ich ponownego wypisywania.
 *
 * Projekt zaklada, ze jego funkcjonalnosc jest stala, tzn.
 * sposob dzialania metod krytycznych nie powinien sie zmieniac
 * w poszczegolnych wersjach programu.
 *
 * Caly projekt wyroznia elastycznosc, czyli mozliwosc
 * dodawania nowych funkcjonalnosci oraz edytowania juz istniejacych
 * bez zmiany ich dzialania.
 *
 * W niektorych klasach zastosowano typy proste, jednak zalozeniem
 * calego projektu jest stworzenie jednego, zlozonego typu danych,
 * ktory przez swoja jednolitosc pomaga zachowac spojnosc danych
 * oraz ulatwia operowanie na nich.
 *
 * Projekt zostal podzielony na czesc implementacyjna oraz przykladow.
 * W czesci implementacyjnej znajduja sie implementacje poszczegolnych klas,
 * natomiast w czesci przykladow mozna zobaczyc, w jaki sposob uzywac
 * poszczegolnych funkcjonalnosci.
 *
 * Kod kompilowany jest w systemie operacyjnym Linux Mint 20.1 Cinnamon.
 * Wersja Java: JDK 16.
 *
 * Projekt jest udostepniany na licencji Apache 2.0. Tekst licencji
 * w wersji polskiej i angielskiej zostal dolaczony do projektu.
 *
 * Jakie funkcjonalnosci przydadza sie na przyszlosc:
 * - obsluga tablic
 * - obsluga watkow
 * - obsluga wyrazen lambda
 * - refleksja
 * - implementacja algorytmow, np. przeszukiwania, sortowania, itd.
 * - implementacja mechanizmow komunikacji: lokalnej (konkretna maszyna), globalnej (Intranet, Internet),
 * tak więc komunikacja lokalna oznacza w tym ujęciu zakres maszyny, a globalna, poza maszyną
 *
 * Wady:
 * - aby poprawnie stworzyc instancje klasy Obiekt,
 * nalezy zainicjowac ja w konstruktorze.
 * Jezeli obiekt powstaje z wielu malych obiektow,
 * nalezy najpierw utworzyc te obiekty lokalnie,
 * a nastepnie zainicjowac obiekt glowny
 * poprzez wskazanie na ten konkretny obiekt
 * metoda wskaznika "this"
 *
 */
public final class Obiekt {

    private byte [] tablicaBajtow;
    private Class klasa;

    public Obiekt(final Object object) {
        tablicaBajtow = serializuj(object);
        klasa(object.getClass());
    }

    public Obiekt(final Obiekt obiekt) {
        tablicaBajtow = serializuj(obiekt);
        klasa(obiekt.getClass());
    }

    public byte[] serializuj(final Object obiekt) {
        byte [] tablicaBajtowDoZwrocenia = null;
        try(final ByteArrayOutputStream strumienDanych = new ByteArrayOutputStream()){
            try(final ObjectOutputStream strumienDanychObiektu = new ObjectOutputStream(strumienDanych)){
                strumienDanychObiektu.writeObject(obiekt);
            }
            tablicaBajtowDoZwrocenia = strumienDanych.toByteArray();
        } catch (final IOException wyjatekWejsciaWyjscia) {
            wyjatekWejsciaWyjscia.printStackTrace();
        } catch (final Exception wyjatek) {
            wyjatek.printStackTrace();
        }
        return tablicaBajtowDoZwrocenia;
    }

    public Object deserializuj (final Obiekt obiektDoDeserializacji) {
        obiektDoDeserializacji.deserializuj(tablicaBajtow);
        return obiektDoDeserializacji;
    }

    public Object deserializuj(final byte[] lokalnaTablicaBajtow){
        Object obiektDoZwrocenia = null;
        try {
            final ByteArrayInputStream b = new ByteArrayInputStream(lokalnaTablicaBajtow);
            final ObjectInputStream o = new ObjectInputStream(b);
            obiektDoZwrocenia = o.readObject();
        } catch (final Exception ex) {
            ex.printStackTrace();
        }

        return obiektDoZwrocenia;
    }

    public Obiekt obiekt() {
        final Object object = deserializuj(tablicaBajtow);
        final Obiekt obiekt = new Obiekt(object);
        return obiekt;
    }

    public Obiekt obiekt(final Obiekt obiekt) {
        tablicaBajtow = serializuj(obiekt);
        return this;
    }

    public Obiekt wartosc(final Object object) {
        tablicaBajtow = serializuj(object);
        klasa(object.getClass());
        return this;
    }

    public Object wartosc() {
        return deserializuj(tablicaBajtow);
    }

    public Class klasa() {
        return klasa;
    }

    public Obiekt klasa(final Class klasa) {
        this.klasa = klasa;
        return this;
    }

    public Ksero ksero() {
        return new Ksero(this);
    }

    public Bufor bufor() { return new Bufor(this); }

    public Szablon szablon() { return new Szablon(this); }

    public Porownanie porownanie() { return new Porownanie(this); }

    public Kalkulator kalkulator() { return new Kalkulator(this); }

    public Parser parser() { return new Parser(this); }

    @Override
    public String toString() {
        return wartosc().toString();
    }
}
