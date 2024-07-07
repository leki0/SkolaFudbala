/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import java.util.List;



/**
 *
 * @author Korisnik
 */
public class ZapamtiTreningGrupu extends ApstraktnaSistemskaOperacija {

    private long id;

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

    public long getId() {
        return id;
    }

}
