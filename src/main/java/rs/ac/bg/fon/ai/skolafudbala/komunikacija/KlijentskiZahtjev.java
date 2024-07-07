/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.komunikacija;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class KlijentskiZahtjev implements Serializable{

    private Operacija operacija;
    private Object objekat;

    public KlijentskiZahtjev(Operacija operacija, Object objekat) {
        this.operacija = operacija;
        this.objekat = objekat;
    }

    public KlijentskiZahtjev() {
    }
    
    

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    public Object getObjekat() {
        return objekat;
    }

    public void setObjekat(Object objekat) {
        this.objekat = objekat;
    }

}
