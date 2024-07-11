/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import java.util.List;

/**
 * Klasa ZapamtiTreningGrupu predstavlja sistemsku operaciju koja čuva novu
 * trening grupu u bazi podataka, zajedno sa njenim rasporedom.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @autor Aleksa Stančić
 */
public class ZapamtiTreningGrupu extends ApstraktnaSistemskaOperacija {

    /**
     * ID trening grupe koja je sačuvana u bazi.
     */
    private long id;

    /**
     * Izvršava operaciju čuvanja trening grupe i njenih rasporeda.
     *
     * Rezultat čuvanja je ID sačuvane trening grupe, koji se čuva u
     * promenljivoj id.
     *
     * @param odo objekat koji predstavlja trening grupu koja se čuva
     * @throws Exception ako dođe do greške tokom čuvanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        id = repozitorijum.add((TreningGrupa) odo);
        TreningGrupa tg = (TreningGrupa) odo;
        List<Raspored> listaRasporeda = tg.getListaRasporeda();
        for (Raspored r : listaRasporeda) {
            r.setGrupa(tg);
            repozitorijum.add(r);
        }
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase
     * TreningGrupa
     * @throws Exception ako objekat nije odgovarajućeg tipa, ako je null, ili
     * ako već postoji trening grupa sa istim imenom u bazi
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof TreningGrupa)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
        List<TreningGrupa> listaTG = repozitorijum.getAll(new TreningGrupa());
        for (TreningGrupa tg : listaTG) {
            if (tg.getNazivGrupe().equals(((TreningGrupa) odo).getNazivGrupe())) {
                throw new Exception("Trening grupa sa ovim imenom već postoji!");
            }
        }
    }

    /**
     * Vraća ID trening grupe koja je sačuvana u bazi.
     *
     * @return ID sačuvane trening grupe
     */
    public long getId() {
        return id;
    }

}
