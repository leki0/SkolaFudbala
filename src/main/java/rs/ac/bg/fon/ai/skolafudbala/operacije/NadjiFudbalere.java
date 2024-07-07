/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Korisnik
 */
public class NadjiFudbalere extends ApstraktnaSistemskaOperacija {

    List<Fudbaler> listaFudbaleraPretraga = new ArrayList<>();

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaFudbaleraPretraga = repozitorijum.pretraga((Fudbaler) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Fudbaler)) {
            throw new Exception("Objekat fudbaler nije validan za pretragu. VALIDACIJA!");
        }
    }

    public List<Fudbaler> getListaFudbaleraPretraga() {
        return listaFudbaleraPretraga;
    }

}
