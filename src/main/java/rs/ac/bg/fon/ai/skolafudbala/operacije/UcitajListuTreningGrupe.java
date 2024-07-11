/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa UcitajListuTreningGrupe predstavlja sistemsku operaciju koja učitava
 * listu trening grupa i listu rasporeda iz baze podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajListuTreningGrupe extends ApstraktnaSistemskaOperacija {

    /**
     * Lista trening grupa učitana iz baze.
     */
    List<TreningGrupa> listaTreningGrupa = new ArrayList<>();

    /**
     * Lista rasporeda učitana iz baze.
     */
    List<Raspored> listaRasporeda = new ArrayList<>();

    /**
     * Izvršava operaciju učitavanja liste trening grupa i liste rasporeda.
     *
     * Rezultat učitavanja se čuva u promenljivim listaTreningGrupa i
     * listaRasporeda.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreningGrupa = repozitorijum.getAll(new TreningGrupa());
        listaRasporeda = repozitorijum.getAll(new Raspored());

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
     * Vraća listu trening grupa učitanu iz baze.
     *
     * @return lista trening grupa učitana iz baze
     */
    public List<TreningGrupa> getListaTreningGrupa() {
        return listaTreningGrupa;
    }

    /**
     * Vraća listu rasporeda učitanu iz baze.
     *
     * @return lista rasporeda učitana iz baze
     */
    public List<Raspored> getListaRasporeda() {
        return listaRasporeda;
    }

}
