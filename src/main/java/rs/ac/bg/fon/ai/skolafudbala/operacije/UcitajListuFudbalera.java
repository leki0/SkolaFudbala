/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import java.util.List;



/**
 *
 * @author Korisnik
 */
public class UcitajListuFudbalera extends ApstraktnaSistemskaOperacija {

    private List<Fudbaler> listaFudbalera;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaFudbalera = repozitorijum.getAll(new Fudbaler());
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    public List<Fudbaler> getListaFudbalera() {
        return listaFudbalera;
    }

}
