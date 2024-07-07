/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;



/**
 *
 * @author Korisnik
 */
public class ObrisiTreningGrupu extends ApstraktnaSistemskaOperacija {

    private int obrisanaTreningGrupa;
    private int broj;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        if (((TreningGrupa) odo).getListaRasporeda() != null) {
            for (Raspored r : ((TreningGrupa) odo).getListaRasporeda()) {
                repozitorijum.delete(r);
            }
        }
        obrisanaTreningGrupa = repozitorijum.delete((TreningGrupa) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof TreningGrupa)) {
            throw new Exception("Objekat trening grupa nije validan za brisanje. VALIDACIJA!");
        }
    }

    public int getObrisanaTreningGrupa() {
        return obrisanaTreningGrupa;
    }

}
