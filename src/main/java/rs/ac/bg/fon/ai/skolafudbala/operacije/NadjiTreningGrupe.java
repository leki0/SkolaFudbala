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
public class NadjiTreningGrupe extends ApstraktnaSistemskaOperacija {

    List<TreningGrupa> listaTreningGrupaPretraga = new ArrayList<>();
    List<Raspored> listaRasporeda = new ArrayList<>();

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        listaTreningGrupaPretraga = repozitorijum.pretraga((TreningGrupa) odo);
        listaRasporeda = repozitorijum.getAll(new Raspored()); 
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof TreningGrupa)) {
            throw new Exception("Objekat trening grupa nije validan za pretragu. VALIDACIJA!");
        }
    }

    public List<TreningGrupa> getListaTreningGrupaPretraga() {
        return listaTreningGrupaPretraga;
    }

    public List<Raspored> getListaRasporeda() {
        return listaRasporeda;
    }

}
