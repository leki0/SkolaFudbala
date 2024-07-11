/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;

/**
 * Klasa ZapamtiIzmjeneFudbalera predstavlja sistemsku operaciju za čuvanje
 * izmena nad postojećim fudbalerom u bazi podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančič
 */
public class ZapamtiIzmjeneFudbalera extends ApstraktnaSistemskaOperacija {

    /**
     * ID izmenjenog fudbalera koji je vraćen nakon čuvanja izmena.
     */
    private int izmjenjenFudbaler;

    /**
     * Izvršava operaciju čuvanja izmena nad fudbalerom u bazi.
     *
     * Rezultat operacije je ID izmenjenog fudbalera, koji se čuva u
     * promenljivoj izmjenjenFudbaler.
     *
     * @param odo objekat koji predstavlja fudbalera sa izmenama
     * @throws Exception ako dođe do greške tokom čuvanja izmena
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        izmjenjenFudbaler = repozitorijum.addUpdate((Fudbaler) odo);
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
            throw new Exception("Objekat fudbaler nije validan za izmjenu. VALIDACIJA!");
        }

    }

    /**
     * Vraća ID izmenjenog fudbalera koji je vraćen nakon čuvanja izmena.
     *
     * @return ID izmenjenog fudbalera
     */
    public int getIzmjenjenFudbaler() {
        return izmjenjenFudbaler;
    }

}
