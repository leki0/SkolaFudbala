/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.util.List;
import rs.ac.bg.fon.ai.skolafudbala.model.TipTreninga;

/**
 * Klasa UcitajListuTipovaTreninga predstavlja sistemsku operaciju koja učitava
 * listu tipova treninga iz baze podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class UcitajListuTipovaTreninga extends ApstraktnaSistemskaOperacija {

    /**
     * Lista tipova treninga učitana iz baze.
     */
    private List<TipTreninga> listaTipova;

    /**
     * Izvršava operaciju učitavanja liste tipova treninga.
     *
     * Rezultat učitavanja se čuva u promenljivoj listaTipova.
     *
     * @param odo objekat koji predstavlja kriterijum za učitavanje
     * null
     * @throws Exception ako dođe do greške tokom učitavanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTipova = repozitorijum.getAll(new TipTreninga());
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
     * Vraća listu tipova treninga učitanu iz baze.
     *
     * @return lista tipova treninga učitana iz baze
     */
    public List<TipTreninga> getListaTipova() {
        return listaTipova;
    }
}
