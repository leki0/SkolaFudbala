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
public class ZapamtiIzmjeneFudbalera extends ApstraktnaSistemskaOperacija {

    private int izmjenjenFudbaler;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        izmjenjenFudbaler = repozitorijum.addUpdate((Fudbaler) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Fudbaler)) {
            throw new Exception("Objekat fudbaler nije validan za izmjenu. VALIDACIJA!");
        }
       
    }

    public int getIzmjenjenFudbaler() {
        return izmjenjenFudbaler;
    }

}
