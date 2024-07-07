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
public class ObrisiFudbalera extends ApstraktnaSistemskaOperacija {

    private int obrisanFudbaler;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        obrisanFudbaler = repozitorijum.delete((Fudbaler) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Fudbaler)) {
            throw new Exception("Objekat fudbaler nije validan za brisanje. VALIDACIJA!");
        }
    }

    public int getObrisanFudbaler() {
        return obrisanFudbaler;
    }

}
