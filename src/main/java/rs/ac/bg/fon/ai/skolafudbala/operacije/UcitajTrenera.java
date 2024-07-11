/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;

/**
 * Klasa UcitajTrenera predstavlja sistemsku operaciju koja učitava trenera iz
 * baze podataka na osnovu određenih kriterijuma.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajTrenera extends ApstraktnaSistemskaOperacija {

    /**
     * Trener učitan iz baze.
     */
    private Trener trenerBaza;

    /**
     * Izvršava operaciju učitavanja trenera.
     *
     * Rezultat učitavanja se čuva u promenljivoj trenerBaza.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje, očekuje se
     * instanca klase Trener
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        trenerBaza = (Trener) repozitorijum.getWhere((Trener) odo);
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase Trener
     * @throws Exception ako objekat nije odgovarajućeg tipa ili ako je null
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Trener)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    /**
     * Vraća trenera učitanog iz baze.
     *
     * @return trener učitan iz baze
     */
    public Trener getTrenerBaza() {
        return trenerBaza;
    }

}
