/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;

/**
 * Klasa ObrisiTreningGrupu predstavlja sistemsku operaciju koja briše trening
 * grupu i sve njene rasporede iz baze podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class ObrisiTreningGrupu extends ApstraktnaSistemskaOperacija {

    /**
     * ID obrisane trening grupe.
     */
    private int obrisanaTreningGrupa;

    private int broj;

    /**
     * Izvršava operaciju brisanja trening grupe i njenih rasporeda.
     *
     * Ako trening grupa ima rasporede, svi rasporedi će biti obrisani pre
     * brisanja grupe. ID obrisane trening grupe se čuva u promenljivoj
     * obrisanaTreningGrupa.
     *
     * @param odo objekat koji predstavlja trening grupu za brisanje, očekuje se
     * instanca klase TreningGrupa
     * @throws Exception ako dođe do greške tokom brisanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        if (((TreningGrupa) odo).getListaRasporeda() != null) {
            for (Raspored r : ((TreningGrupa) odo).getListaRasporeda()) {
                repozitorijum.delete(r);
            }
        }
        obrisanaTreningGrupa = repozitorijum.delete((TreningGrupa) odo);
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase
     * TreningGrupa
     * @throws Exception ako objekat nije odgovarajućeg tipa ili ako je null
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof TreningGrupa)) {
            throw new Exception("Objekat trening grupa nije validan za brisanje. VALIDACIJA!");
        }
    }

    /**
     * Vraća ID obrisane trening grupe.
     *
     * @return ID obrisane trening grupe
     */
    public int getObrisanaTreningGrupa() {
        return obrisanaTreningGrupa;
    }

}
