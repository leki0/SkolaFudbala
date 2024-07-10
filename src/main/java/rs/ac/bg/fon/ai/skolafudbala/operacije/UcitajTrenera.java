/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;



/**
 *
 * @author Korisnik
 */
public class UcitajTrenera extends ApstraktnaSistemskaOperacija {

    private Trener trenerBaza;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        trenerBaza = (Trener) repozitorijum.getWhere((Trener) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Trener)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    public Trener getTrenerBaza() {
        return trenerBaza;
    }

}
