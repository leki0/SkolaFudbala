/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;



/**
 * Klasa ObrisiFudbalera predstavlja sistemsku operaciju koja briše fudbalera 
 * iz baze podataka.
 * 
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira
 * metode za izvršenje operacije i validaciju preduslova.
 * 
 * @author Aleksa Stančić
 */
public class ObrisiFudbalera extends ApstraktnaSistemskaOperacija {

    /**
     * ID fudbalera koji je izbrisan iz baze.
     */
    private int obrisanFudbaler;

    /**
     * Izvršava operaciju brisanja fudbalera.
     * 
     * ID obrisanog fudbalera se čuva u promenljivoj obrisanFudbaler.
     * 
     * @param odo objekat koji predstavlja fudbalera za brisanje, očekuje se instanca klase Fudbaler
     * @throws Exception ako dođe do greške tokom brisanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        obrisanFudbaler = repozitorijum.delete((Fudbaler) odo);
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
            throw new Exception("Objekat fudbaler nije validan za brisanje. VALIDACIJA!");
        }
    }

    /**
     * Vraća ID obrisanog fudbalera.
     * 
     * @return ID obrisanog fudbalera
     */
    public int getObrisanFudbaler() {
        return obrisanFudbaler;
    }

}
