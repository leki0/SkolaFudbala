/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import java.util.List;

/**
 * Klasa UcitajListuTrenera predstavlja sistemsku operaciju koja učitava listu
 * trenera iz baze podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajListuTrenera extends ApstraktnaSistemskaOperacija {

    /**
     * Lista trenera učitana iz baze.
     */
    private List<Trener> listaTrenera;

    /**
     * Izvršava operaciju učitavanja liste trenera.
     *
     * Rezultat učitavanja se čuva u promenljivoj listaTrenera.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTrenera = repozitorijum.getAll(new Trener());
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, može biti null
     * @throws Exception nije potrebno validirati preduslove za ovu operaciju
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    /**
     * Vraća listu trenera učitanu iz baze.
     *
     * @return lista trenera učitana iz baze
     */
    public List<Trener> getListaTrenera() {
        return listaTrenera;
    }

}
