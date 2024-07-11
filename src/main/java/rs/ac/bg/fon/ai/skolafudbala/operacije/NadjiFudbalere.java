/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa NadjiFudbalere predstavlja sistemsku operaciju koja pretražuje
 * fudbalere na osnovu određenih kriterijuma.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvrsavanje funkcije pronalazenja Fudbalera i testiranje preduslova.
 *
 * @author Aleksa Stančić
 */
public class NadjiFudbalere extends ApstraktnaSistemskaOperacija {

    /**
     * Lista rezultata pretrage fudbalera.
     */
    List<Fudbaler> listaFudbaleraPretraga = new ArrayList<>();

    /**
     * Izvršava operaciju pretrage fudbalera.
     *
     * Rezultat pretrage se čuva u listi listaFudbaleraPretraga.
     *
     * @param odo objekat koji predstavlja kriterijum pretrage, očekuje se
     * instanca klase Fudbaler
     * @throws Exception ako dođe do greške tokom pretrage
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaFudbaleraPretraga = repozitorijum.pretraga((Fudbaler) odo);
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
            throw new Exception("Objekat fudbaler nije validan za pretragu. VALIDACIJA!");
        }
    }

    /**
     * Vraća listu fudbalera koji su rezultat pretrage.
     *
     * @return lista fudbalera kao rezultat pretrage
     */
    public List<Fudbaler> getListaFudbaleraPretraga() {
        return listaFudbaleraPretraga;
    }

}
