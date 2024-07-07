/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.StatistikaFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import java.util.List;


/**
 *
 * @author Korisnik
 */
public class ZapamtiTreningUtakmicu extends ApstraktnaSistemskaOperacija {

    private long id;

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

    public long getId() {
        return id;
    }

}
