/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;

/**
 * Klasa ZapamtiIzmjeneTrenera predstavlja sistemsku operaciju za čuvanje izmena
 * nad postojećim trenerom u bazi podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class ZapamtiIzmjeneTrenera extends ApstraktnaSistemskaOperacija {

    /**
     * ID izmenjenog trenera koji je vraćen nakon čuvanja izmena.
     */
    private int izmjenjenTrener;

    /**
     * Izvršava operaciju čuvanja izmena nad trenerom u bazi.
     *
     * Rezultat operacije je ID izmenjenog trenera, koji se čuva u promenljivoj
     * izmjenjenTrener.
     *
     * @param odo objekat koji predstavlja trenera sa izmenama
     * @throws Exception ako dođe do greške tokom čuvanja izmena
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        izmjenjenTrener = repozitorijum.addUpdate((Trener) odo);
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
            throw new Exception("Objekat trener nije validan za izmjenu. VALIDACIJA!");
        }
    }

    /**
     * Vraća ID izmenjenog trenera koji je vraćen nakon čuvanja izmena.
     *
     * @return ID izmenjenog trenera
     */
    public int getIzmjenjenTrener() {
        return izmjenjenTrener;
    }

}
