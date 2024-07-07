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
public class ZapamtiIzmjeneTrenera extends ApstraktnaSistemskaOperacija {

    private int izmjenjenTrener;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        izmjenjenTrener = repozitorijum.addUpdate((Trener) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Trener)) {
            throw new Exception("Objekat trener nije validan za izmjenu. VALIDACIJA!");
        } 
    }

    public int getIzmjenjenTrener() {
        return izmjenjenTrener;
    }


    

}
