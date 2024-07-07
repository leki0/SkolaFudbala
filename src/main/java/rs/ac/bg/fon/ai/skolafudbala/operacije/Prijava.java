/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;
import java.util.List;



/**
 * //
 *
 *
 * @author Korisnik
 */
public class Prijava extends ApstraktnaSistemskaOperacija {

    private List<Korisnik> korisnici;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        korisnici = repozitorijum.getAll(new Korisnik());
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

}
