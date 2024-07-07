/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import java.util.List;



/**
 *
 * @author Korisnik
 */
public class UcitajListuTrenera extends ApstraktnaSistemskaOperacija {

    private List<Trener> listaTrenera;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTrenera = repozitorijum.getAll(new Trener());
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    public List<Trener> getListaTrenera() {
        return listaTrenera;
    }

}
