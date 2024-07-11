/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import java.util.List;

/**
 * Klasa UcitajListuFudbalera predstavlja sistemsku operaciju koja učitava listu
 * fudbalera iz baze podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajListuFudbalera extends ApstraktnaSistemskaOperacija {

    /**
     * Lista fudbalera učitana iz baze.
     */
    private List<Fudbaler> listaFudbalera;

    /**
     * Izvršava operaciju učitavanja liste fudbalera.
     *
     * Rezultat učitavanja se čuva u promenljivoj listaFudbalera.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaFudbalera = repozitorijum.getAll(new Fudbaler());
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
     * Vraća listu fudbalera učitanu iz baze.
     *
     * @return lista fudbalera učitana iz baze
     */
    public List<Fudbaler> getListaFudbalera() {
        return listaFudbalera;
    }

}
