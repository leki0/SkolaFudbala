/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;



/**
 *
 * @author Korisnik
 */
public class UcitajFudbalera extends ApstraktnaSistemskaOperacija {

    private Fudbaler fudbalerBaza;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        fudbalerBaza = (Fudbaler) repozitorijum.getWhere((Fudbaler) odo);

    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null && !(odo instanceof Fudbaler)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    public Fudbaler getFudbalerBaza() {
        return fudbalerBaza;
    }

}
