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
 * Klasa ZapamtiIzmjeneTreningGrupe predstavlja sistemsku operaciju za čuvanje
 * izmena nad trening grupom u bazi podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class ZapamtiIzmjeneTreningGrupe extends ApstraktnaSistemskaOperacija {

    /**
     * Broj izmena nad trening grupom koji je vraćen nakon čuvanja izmena.
     */
    private int izmjenjenaTG;

    /**
     * Izvršava operaciju čuvanja izmena nad trening grupom u bazi, kao i izmenu
     * liste rasporeda u okviru trening grupe na toj utakmici(dodavanje ili
     * brisanje) u zavisnosti od akcije u formi.
     *
     * @param odo objekat koji predstavlja trening grupu sa izmenama
     * @throws Exception ako dođe do greške tokom čuvanja izmena
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        izmjenjenaTG = 0;
        List<Raspored> listaRasporeda = ((TreningGrupa) odo).getListaRasporeda();
        List<Raspored> listaRasporedaBaza = repozitorijum.getAll(new Raspored());
        List<Raspored> listaRasporedaBazaTG = new ArrayList<>();
        for (Raspored r : listaRasporedaBaza) {
            if (((TreningGrupa) odo).getObjID() == r.getGrupa().getObjID()) {
                listaRasporedaBazaTG.add(r);
            }
        }

        for (Raspored rtg : listaRasporeda) {
            int brojac = 0;
            rtg.setGrupa(((TreningGrupa) odo));
            for (Raspored rb : listaRasporedaBazaTG) {
                if (rtg.equals(rb)) {
                    brojac++;
                }
            }
            if (brojac == 0) {
                izmjenjenaTG += repozitorijum.add(rtg);
            }
        }
        for (Raspored rb : listaRasporedaBazaTG) {
            int brojac = 0;
            for (Raspored rtg : listaRasporeda) {
                rtg.setGrupa(((TreningGrupa) odo));
                if (rb.equals(rtg)) {
                    brojac++;
                }
            }
            if (brojac == 0) {
                izmjenjenaTG += repozitorijum.delete(rb);
            }

        }
        izmjenjenaTG += repozitorijum.addUpdate((TreningGrupa) odo);

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
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    /**
     * Vraća broj izmena nad trening grupom koji je vraćen nakon čuvanja izmena.
     *
     * @return broj izmena nad trening grupom
     */
    public int getIzmjenjenaTG() {
        return izmjenjenaTG;
    }

}
