/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;

/**
 * Klasa UcitajFudbalera predstavlja sistemsku operaciju koja učitava fudbalera
 * iz baze podataka na osnovu određenih kriterijuma.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajFudbalera extends ApstraktnaSistemskaOperacija {

    /**
     * Fudbaler učitan iz baze.
     */
    private Fudbaler fudbalerBaza;

    /**
     * Izvršava operaciju učitavanja fudbalera.
     *
     * Rezultat učitavanja se čuva u promenljivoj fudbalerBaza.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje, očekuje se
     * instanca klase Fudbaler
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        fudbalerBaza = (Fudbaler) repozitorijum.getWhere((Fudbaler) odo);

    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase Fudbaler
     * @throws Exception ako objekat nije odgovarajućeg tipa ili ako je null
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Fudbaler)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    /**
     * Vraća fudbalera učitanog iz baze.
     *
     * @return fudbaler učitan iz baze
     */
    public Fudbaler getFudbalerBaza() {
        return fudbalerBaza;
    }

}
