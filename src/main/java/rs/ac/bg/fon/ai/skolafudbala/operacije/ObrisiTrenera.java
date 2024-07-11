/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;



/**
 * Klasa ObrisiTrenera predstavlja sistemsku operaciju koja briše trenera 
 * iz baze podataka.
 * 
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira
 * metode za izvršenje operacije i validaciju preduslova.
 * 
 * @author Aleksa Stančić
 */
public class ObrisiTrenera extends ApstraktnaSistemskaOperacija {

    /**
     * ID obrisanog trenera.
     */
    private int obrisanTrener;

    /**
     * Izvršava operaciju brisanja trenera.
     * 
     * ID obrisanog trenera se čuva u promenljivoj obrisanTrener.
     * 
     * @param odo objekat koji predstavlja trenera za brisanje, očekuje se instanca klase Trener
     * @throws Exception ako dođe do greške tokom brisanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        obrisanTrener = repozitorijum.delete((Trener) odo);
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
            throw new Exception("Objekat trener nije validan za brisanje. VALIDACIJA!");
        }
    }

    /**
     * Vraća ID obrisanog trenera.
     * 
     * @return ID obrisanog trenera
     */
    public int getObrisanTrener() {
        return obrisanTrener;
    }

}
