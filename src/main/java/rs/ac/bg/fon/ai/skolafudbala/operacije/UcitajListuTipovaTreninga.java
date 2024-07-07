/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.util.List;
import rs.ac.bg.fon.ai.skolafudbala.model.TipTreninga;

/**
 *
 * @author Korisnik
 */
public class UcitajListuTipovaTreninga extends ApstraktnaSistemskaOperacija {

    private List<TipTreninga> listaTipova;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTipova = repozitorijum.getAll(new TipTreninga());
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    public List<TipTreninga> getListaTipova() {
        return listaTipova;
    }
}
