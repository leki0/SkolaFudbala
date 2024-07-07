/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.util.List;
import rs.ac.bg.fon.ai.skolafudbala.model.LekarskiPregled;

/**
 *
 * @author Korisnik
 */
public class ZapamtiPregled extends ApstraktnaSistemskaOperacija{
    private long id;

    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        repozitorijum.add((LekarskiPregled) odo);
    }

    @Override
    protected void preduslovi(Object odo) throws Exception {
        if (odo == null && !(odo instanceof LekarskiPregled)) {
            throw new Exception("VALIDACIJA! Vrijednost parametra nije validna!");
        }
    }

    public long getId() {
        return id;
    }
}
