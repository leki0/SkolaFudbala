/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import java.util.ArrayList;
import java.util.List;


/**
 * Klasa NadjiTrenere predstavlja sistemsku operaciju koja pretražuje trenere 
 * na osnovu određenih kriterijuma.
 * 
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira
 * metode za izvršenje operacije pronalazenja Trenera i validaciju preduslova.
 * 
 * @author Aleksa Stančić
 */
public class NadjiTrenere extends ApstraktnaSistemskaOperacija {

    /**
     * Lista rezultata pretrage trenera.
     */
    List<Trener> listaTreneraPretraga = new ArrayList<>();

    /**
     * Izvršava operaciju pretrage trenera.
     * 
     * Rezultat pretrage se čuva u listi listaTreneraPretraga.
     * 
     * @param odo objekat koji predstavlja kriterijum pretrage, očekuje se instanca klase Trener
     * @throws Exception ako dođe do greške tokom pretrage
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreneraPretraga = repozitorijum.pretraga((Trener) odo);
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
            throw new Exception("Objekat trener nije validan za pretragu. VALIDACIJA!");
        }
    }

    /**
     * Vraća listu trenera koji su rezultat pretrage.
     * 
     * @return lista trenera kao rezultat pretrage
     */
    public List<Trener> getListaTreneraPretraga() {
        return listaTreneraPretraga;
    }

}
