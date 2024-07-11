/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import java.util.List;

/**
 * Klasa UcitajListuTreningUtakmica predstavlja sistemsku operaciju koja učitava
 * listu trening utakmica iz baze podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajListuTreningUtakmica extends ApstraktnaSistemskaOperacija {

    /**
     * Lista trening utakmica učitana iz baze.
     */
    private List<TreningUtakmica> listaTreningUtakmica;

    /**
     * Izvršava operaciju učitavanja liste trening utakmica.
     *
     * Rezultat učitavanja se čuva u promenljivoj listaTreningUtakmica.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreningUtakmica = repozitorijum.getAll(new TreningUtakmica());
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira
     * @throws Exception nije potrebno validirati preduslove za ovu operaciju
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    /**
     * Vraća listu trening utakmica učitanu iz baze.
     *
     * @return lista trening utakmica učitana iz baze
     */
    public List<TreningUtakmica> getListaTreningUtakmica() {
        return listaTreningUtakmica;
    }

}
