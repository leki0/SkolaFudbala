/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import java.util.List;

/**
 * Klasa ZapamtiFudbalera predstavlja sistemsku operaciju koja čuva novog
 * fudbalera u bazi podataka.
 *
 * Nasleđuje apstraktnu klasu ApstraktnaSistemskaOperacija i implementira metode
 * za izvršenje operacije i validaciju preduslova.
 *
 * @author Aleksa Stančić
 */
public class ZapamtiFudbalera extends ApstraktnaSistemskaOperacija {

    /**
     * ID fudbalera koji je sačuvan u bazi.
     */
    private long id;

    /**
     * Izvršava operaciju čuvanja fudbalera.
     *
     * Rezultat čuvanja je ID sačuvanog fudbalera, koji se čuva u promenljivoj
     * id.
     *
     * @param odo objekat koji predstavlja fudbalera koji se čuva
     * @throws Exception ako dođe do greške tokom čuvanja
     */
    @Override
    protected void izvrsiOperaciju(Object odo) throws Exception {
        id = repozitorijum.add((Fudbaler) odo);
    }

    /**
     * Validira preduslove za izvršenje operacije.
     *
     * @param odo objekat koji se validira, očekuje se instanca klase Fudbaler
     * @throws Exception ako objekat nije odgovarajućeg tipa, ako je null, ili
     * ako već postoji fudbaler sa istim JMBG-om u bazi
     */
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

    /**
     * Vraća ID fudbalera koji je sačuvan u bazi.
     *
     * @return ID sačuvanog fudbalera
     */
    public long getId() {
        return id;
    }

}
