/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;

/**
 * Klasa UcitajTreningGrupu predstavlja sistemsku operaciju koja učitava trening
 * grupu iz baze podataka na osnovu određenih kriterijuma.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajTreningGrupu extends ApstraktnaSistemskaOperacija {

    /**
     * Trening grupa učitana iz baze.
     */
    private TreningGrupa treningGrupaBaza;

    /**
     * Izvršava operaciju učitavanja trening grupe.
     *
     * Rezultat učitavanja se čuva u promenljivoj treningGrupaBaza.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje, očekuje se
     * instanca klase TreningGrupa
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        treningGrupaBaza = (TreningGrupa) repozitorijum.getWhere((TreningGrupa) odo);
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
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    /**
     * Vraća trening grupu učitanu iz baze.
     *
     * @return trening grupa učitana iz baze
     */
    public TreningGrupa getTreningGrupaBaza() {
        return treningGrupaBaza;
    }

}
