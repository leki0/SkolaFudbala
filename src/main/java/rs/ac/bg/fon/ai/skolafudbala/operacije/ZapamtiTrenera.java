/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import java.util.List;

/**
 * Klasa ZapamtiTrenera predstavlja sistemsku operaciju koja čuva novog trenera
 * u bazi podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @autor Aleksa Stančić
 */
public class ZapamtiTrenera extends ApstraktnaSistemskaOperacija {

    /**
     * ID trenera koji je sačuvan u bazi.
     */
    private long id;

    /**
     * Izvršava operaciju čuvanja trenera.
     *
     * Rezultat čuvanja je ID sačuvanog trenera, koji se čuva u promenljivoj id.
     *
     * @param odo objekat koji predstavlja trenera koji se čuva
     * @throws Exception ako dođe do greške tokom čuvanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        id = repozitorijum.add((Trener) odo);
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase Trener
     * @throws Exception ako objekat nije odgovarajućeg tipa, ako je null, ili
     * ako već postoji trener sa istim JMBG-om u bazi
     */
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

    /**
     * Vraća ID trenera koji je sačuvan u bazi.
     *
     * @return ID sačuvanog trenera
     */
    public long getId() {
        return id;
    }

}
