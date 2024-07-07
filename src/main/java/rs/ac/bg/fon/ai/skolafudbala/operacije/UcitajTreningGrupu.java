/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;



/**
 *
 * @author Korisnik
 */
public class UcitajTreningGrupu extends ApstraktnaSistemskaOperacija {

    private TreningGrupa treningGrupaBaza;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        treningGrupaBaza = (TreningGrupa) repozitorijum.getWhere((TreningGrupa) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null && !(odo instanceof TreningGrupa)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    public TreningGrupa getTreningGrupaBaza() {
        return treningGrupaBaza;
    }

}
