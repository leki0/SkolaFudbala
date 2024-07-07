/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Korisnik
 */
public class NadjiTrenere extends ApstraktnaSistemskaOperacija {

    List<Trener> listaTreneraPretraga = new ArrayList<>();

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreneraPretraga = repozitorijum.pretraga((Trener) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Trener)) {
            throw new Exception("Objekat trener nije validan za pretragu. VALIDACIJA!");
        }
    }

    public List<Trener> getListaTreneraPretraga() {
        return listaTreneraPretraga;
    }

}
