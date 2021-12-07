package pl.wartoscUniwersalna.implementacja.szablon;

import pl.wartoscUniwersalna.implementacja.Obiekt;

public final class Html {

    private final Obiekt obiektGlowny;

    private final Obiekt oznaczenieNowejLinii = new Obiekt("\n");

    private final Obiekt typDokumentu = new Obiekt("<!DOCTYPE html>");

    private final Obiekt otworzenieDokumentuHtml = new Obiekt("<html lang=\"pl\">\n");
    private final Obiekt zamkniecieDokumentuHtml = new Obiekt("</html>");

    private final Obiekt otworzenieSekcjiNaglowka = new Obiekt("<head>\n");
    private final Obiekt zamkniecieSekcjiNaglowka = new Obiekt("</head>\n");
    private final Obiekt znacznikMetaKodowaniaZnakow = new Obiekt(" <meta charset=\"UTF-8\">\n");
    private final Obiekt znacznikMetaEkwiwalentuHttp = new Obiekt(" <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
    private final Obiekt znacznikMetaPortuWidoku = new Obiekt(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
    private final Obiekt importStyluCss = new Obiekt("  <link rel=\"stylesheet\" type=\"text/css\" href=\"arkusz-css.css\" media=\"screen\" />");
    private Obiekt sekcjaNaglowka = new Obiekt("");

    private final Obiekt otwierajacyZnacznikTytulu = new Obiekt("<title>");
    private final Obiekt tytulDokumentu = new Obiekt("Tytul dokumentu");
    private final Obiekt zamykajacyZnacznikTytulu = new Obiekt("</title>\n");
    private Obiekt tytulDokumentuZeZnacznikami = new Obiekt("");

    private final Obiekt otwierajacyZnacznikCiala = new Obiekt("<body>\n");
    private final Obiekt zamykajacyZnacznikCiala = new Obiekt("</body>\n");
    private Obiekt sekcjaCiala = new Obiekt("");

    private Obiekt szablonHtml = new Obiekt("");

    public Html(final Obiekt obiektGlowny) {
        this.obiektGlowny = obiektGlowny;

        zdefiniujSekcjeNaglowka("Nowy dokument");

        zdefiniujSekcjeCiala();

        zdefiniujSzablonHtml();

        zdefiniujSekcjeNaglowka("Pierwsza strona");

        zdefiniujSzablonHtml();
    }

    public Html zdefiniujTytulDokumentu(final String tytulDokumentu) {

        tytulDokumentuZeZnacznikami = new Obiekt("")
                .bufor()
                .wloz(otwierajacyZnacznikTytulu)
                .wloz(new Obiekt(tytulDokumentu))
                .wloz(zamykajacyZnacznikTytulu).wartosc();
        return this;
    }

    private Html zbudujSekcjeNaglowka() {

        sekcjaNaglowka = otworzenieSekcjiNaglowka.bufor()
                .wloz(znacznikMetaKodowaniaZnakow)
                .wloz(znacznikMetaEkwiwalentuHttp)
                .wloz(znacznikMetaPortuWidoku)
                .wloz(importStyluCss)
                .wloz(tytulDokumentuZeZnacznikami)
                .wloz(zamkniecieSekcjiNaglowka).wartosc();

        return this;
    }

    private Html zdefiniujSekcjeNaglowka(final String tytulDokumentu) {
        zdefiniujTytulDokumentu(tytulDokumentu);

        zbudujSekcjeNaglowka();
        return this;
    }


    private Html zdefiniujSekcjeCiala() {

        final Obiekt menuPoziome = zbudujMenuPoziome("Element 1", "Element 2", "Element 3");

        sekcjaCiala = otwierajacyZnacznikCiala.bufor()
                .wloz(zamykajacyZnacznikCiala).wartosc();
        return this;
    }

    private Obiekt zbudujMenuPoziome(final String ... etykietyElementowMenuPoziomego) {
        final Obiekt znacznikOtwierajacyMenu = new Obiekt("<nav class=\"menu-poziome\">\n");
        final Obiekt znacznikZamykajacyMenu = new Obiekt("</nav>\n");
        final Obiekt listaPunktowana = zbudujListePunktowana(etykietyElementowMenuPoziomego);

        final Obiekt menuPoziome = new Obiekt("")
                .bufor()
                .wloz(znacznikOtwierajacyMenu)
                .wloz(listaPunktowana)
                .wloz(znacznikZamykajacyMenu)
                .wartosc();

        return menuPoziome;
    }

    private Obiekt zbudujListePunktowana(final String ... etykietyElementowListy) {
        final Obiekt znacznikOtwierajacyListePunktowana = new Obiekt("<ol>\n");
        final Obiekt znacznikZamykajacyListePunktowana = new Obiekt("</ol>\n");
        final int liczbaElementowListy = etykietyElementowListy.length;
        final Obiekt [] tablicaEtykietListy = new Obiekt[liczbaElementowListy];
        for (int indeksElementowListy = 0; indeksElementowListy < liczbaElementowListy; indeksElementowListy++) {
            final String etykietaElementuListy = etykietyElementowListy[indeksElementowListy];
            final Obiekt elementListy = zbudujLinkZElementemListy(etykietaElementuListy);
            tablicaEtykietListy[indeksElementowListy] = elementListy;
        }
        final Obiekt listaPunktowana = new Obiekt("")
                .bufor()
                .wloz(znacznikOtwierajacyListePunktowana)
                .wloz(tablicaEtykietListy)
                .wloz(znacznikZamykajacyListePunktowana)
                .wartosc();
        return listaPunktowana;
    }

    private Obiekt zbudujLinkZElementemListy(final String etykieta) {
        final Obiekt znacznikOtwierajacyHiperlacze = new Obiekt("<a href=\"#\">");
        final Obiekt znacznikZamykajacyHiperlacze = new Obiekt("</a>\n");

        final Obiekt listaPunktowana = new Obiekt("")
                .bufor()
                .wloz(znacznikOtwierajacyHiperlacze)
                .wloz(zbudujElementListy(etykieta))
                .wloz(znacznikZamykajacyHiperlacze)
                .wartosc();

        return listaPunktowana;
    }

    private Obiekt zbudujElementListy(final String etykieta) {
        final Obiekt znacznikOtwierajacyElementListy = new Obiekt("<li>");
        final Obiekt znacznikZamykajacyElementListy = new Obiekt("</li>");
        final Obiekt etykietaJakoObiekt = new Obiekt(etykieta);
        final Obiekt elementListy = new Obiekt("")
                .bufor()
                .wloz(znacznikOtwierajacyElementListy)
                .wloz(etykietaJakoObiekt)
                .wloz(znacznikZamykajacyElementListy)
                .wartosc();
        return elementListy;
    }

    private Html zdefiniujSzablonHtml() {
        szablonHtml = new Obiekt("")
                .bufor()
                .wloz(typDokumentu)
                .wloz(otworzenieDokumentuHtml)
                .wloz(sekcjaNaglowka)
                .wloz(sekcjaCiala)
                .wloz(zamkniecieDokumentuHtml)
                .wartosc();
        return this;
    }

    public Obiekt wartosc() {
        return szablonHtml;
    }


}
