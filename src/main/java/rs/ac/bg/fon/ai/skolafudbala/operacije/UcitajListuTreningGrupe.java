/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Korisnik
 */
public class UcitajListuTreningGrupe extends ApstraktnaSistemskaOperacija {

    List<TreningGrupa> listaTreningGrupa = new ArrayList<>();
    List<Raspored> listaRasporeda = new ArrayList<>();

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreningGrupa = repozitorijum.getAll(new TreningGrupa());
        listaRasporeda = repozitorijum.getAll(new Raspored());
        
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    public List<TreningGrupa> getListaTreningGrupa() {
        return listaTreningGrupa;
    }
    public List<Raspored> getListaRasporeda() {
        return listaRasporeda;
    }

}
