/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.StatistikaFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import java.util.List;

/**
 * Klasa ZapamtiTreningUtakmicu predstavlja sistemsku operaciju koja čuva novu
 * trening utakmicu u bazi podataka, zajedno sa statistikama fudbalera koji su
 * učestvovali na utakmici.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @autor Aleksa Stančić
 */
public class ZapamtiTreningUtakmicu extends ApstraktnaSistemskaOperacija {

    /**
     * ID trening utakmice koja je sačuvana u bazi.
     */
    private long id;

    /**
     * Izvršava operaciju čuvanja trening utakmice i statistika fudbalera.
     *
     * Rezultat čuvanja je ID sačuvane trening utakmice, koji se čuva u
     * promenljivoj id.
     *
     * @param odo objekat koji predstavlja trening utakmicu koja se čuva
     * @throws Exception ako dođe do greške tokom čuvanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        id = repozitorijum.add((TreningUtakmica) odo);
        TreningUtakmica tu = (TreningUtakmica) odo;
        List<StatistikaFudbalera> listaStatistika = tu.getListaStatistika();
        for (StatistikaFudbalera sf : listaStatistika) {
            sf.setTreningUtakmica(tu);
            repozitorijum.add(sf);
        }
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase
     * TreningUtakmica
     * @throws Exception ako objekat nije odgovarajućeg tipa, ako je null, ili
     * ako već postoji trening utakmica sa istim rednim brojem i istim timovima
     */
    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof TreningUtakmica)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
        List<TreningUtakmica> listaUtakmica = repozitorijum.getAll((TreningUtakmica) odo);
        for (TreningUtakmica tu : listaUtakmica) {
            if ((((TreningUtakmica) odo).getRedniBroj() == tu.getRedniBroj()) && (((TreningUtakmica) odo).getTim1().equals(tu.getTim1())
                    && ((TreningUtakmica) odo).getTim2().equals(tu.getTim2())
                    || (((TreningUtakmica) odo).getTim1().equals(tu.getTim2()) && ((TreningUtakmica) odo).getTim2().equals(tu.getTim1())))) {
                throw new Exception("Već postoji trening utakmica sa ovim rednim brojem!");
            }
        }
    }

    /**
     * Vraća ID trening utakmice koja je sačuvana u bazi.
     *
     * @return ID sačuvane trening utakmice
     */
    public long getId() {
        return id;
    }

}
