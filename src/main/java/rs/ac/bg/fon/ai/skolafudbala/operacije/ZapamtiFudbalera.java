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
public class ZapamtiFudbalera extends ApstraktnaSistemskaOperacija {

    private long id;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        id = repozitorijum.add((Fudbaler) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null || !(odo instanceof Fudbaler)) {
            throw new Exception("VALIDACIJA! Nekorektno unijet argument metode!");
        }
        List<Fudbaler> listaFudbalera = repozitorijum.getAll(new Fudbaler());
        for (Fudbaler f : listaFudbalera) {
            if (((Fudbaler) odo).getJmbg().equals(f.getJmbg())) {
                throw new Exception("Ne možete da unesete dva ista fudbalera! Dva fudbalera ne mogu da imaju isti JMBG!");
            }
        }

    }

    public long getId() {
        return id;
    }

}
