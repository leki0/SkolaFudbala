/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class UcitajListuTreningUtakmica extends ApstraktnaSistemskaOperacija {

    private List<TreningUtakmica> listaTreningUtakmica;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreningUtakmica = repozitorijum.getAll(new TreningUtakmica());
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    public List<TreningUtakmica> getListaTreningUtakmica() {
        return listaTreningUtakmica;
    }

}
