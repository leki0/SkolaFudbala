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
 * Klasa NadjiTreningGrupe predstavlja sistemsku operaciju koja pretražuje
 * trening grupe i učitava sve rasporede iz baze podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class NadjiTreningGrupe extends ApstraktnaSistemskaOperacija {

    /**
     * Lista rezultata pretrage trening grupa.
     */
    List<TreningGrupa> listaTreningGrupaPretraga = new ArrayList<>();

    /**
     * Lista svih rasporeda.
     */
    List<Raspored> listaRasporeda = new ArrayList<>();

    /**
     * Izvršava operaciju pretrage trening grupa i vraća sve rasporede iz baze
     * podataka.
     *
     * Rezultat pretrage trening grupa se čuva u listi
     * listaTreningGrupaPretraga. Svi rasporedi se čuvaju u listi
     * listaRasporeda.
     *
     * @param odo objekat koji predstavlja kriterijum pretrage, očekuje se
     * instanca klase TreningGrupa
     * @throws Exception ako dođe do greške tokom pretrage ili preuzimanja
     * podataka o rasporedima
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreningGrupaPretraga = repozitorijum.pretraga((TreningGrupa) odo);
        listaRasporeda = repozitorijum.getAll(new Raspored());
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase
     * TreningGrupa
     * @throws Exception ako objekat nije odgovarajućeg tipa ili ako je null
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof TreningGrupa)) {
            throw new Exception("Objekat trening grupa nije validan za pretragu. VALIDACIJA!");
        }
    }

    /**
     * Vraća listu trening grupa koje su rezultat pretrage.
     *
     * @return lista trening grupa kao rezultat pretrage
     */
    public List<TreningGrupa> getListaTreningGrupaPretraga() {
        return listaTreningGrupaPretraga;
    }

    /**
     * Vraća listu svih rasporeda.
     *
     * @return lista svih rasporeda
     */
    public List<Raspored> getListaRasporeda() {
        return listaRasporeda;
    }

}
