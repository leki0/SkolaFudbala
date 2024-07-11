/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.util.List;
import rs.ac.bg.fon.ai.skolafudbala.model.LekarskiPregled;

/**
 * Klasa ZapamtiPregled predstavlja sistemsku operaciju koja čuva novi lekarski
 * pregled u bazi podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @autor Aleksa Stančić
 */
public class ZapamtiPregled extends ApstraktnaSistemskaOperacija {

    /**
     * ID lekarskog pregleda koji je sačuvan u bazi.
     */
    private long id;

    /**
     * Izvršava operaciju čuvanja lekarskog pregleda.
     *
     * Rezultat čuvanja je ID sačuvanog lekarskog pregleda, koji se čuva u
     * promenljivoj id.
     *
     * @param odo objekat koji predstavlja lekarski pregled koji se čuva
     * @throws Exception ako dođe do greške tokom čuvanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        id = repozitorijum.add((LekarskiPregled) odo);
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase
     * LekarskiPregled
     * @throws Exception ako objekat nije odgovarajućeg tipa ili ako je null
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof LekarskiPregled)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    /**
     * Vraća ID lekarskog pregleda koji je sačuvan u bazi.
     *
     * @return ID sačuvanog lekarskog pregleda
     */
    public long getId() {
        return id;
    }
}
