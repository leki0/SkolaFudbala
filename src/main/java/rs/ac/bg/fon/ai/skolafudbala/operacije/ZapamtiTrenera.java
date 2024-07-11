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
public class ZapamtiTrenera extends ApstraktnaSistemskaOperacija {

    private long id;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        id = repozitorijum.add((Trener) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Trener)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
        List<Trener> listaTrenera = repozitorijum.getAll(new Trener());
        for (Trener t : listaTrenera) {
            if (((Trener) odo).getJmbg().equals(t.getJmbg())) {
                throw new Exception("Ne možete da unesete dva ista trenera! Dva trenera ne mogu da imaju isti JMBG!");
            }
        }
    }

    public long getId() {
        return id;
    }

}
