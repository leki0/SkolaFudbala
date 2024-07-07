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
 *
 * @author Korisnik
 */
public class ZapamtiIzmjeneTreningGrupe extends ApstraktnaSistemskaOperacija {

    private int izmjenjenaTG;

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

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof TreningGrupa)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    public int getIzmjenjenaTG() {
        return izmjenjenaTG;
    }

}
