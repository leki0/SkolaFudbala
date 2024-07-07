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
public class ServerskiOdgovor implements Serializable{

    private Object rezultat;
    private Exception exception;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object rezultat, Exception exception) {
        this.rezultat = rezultat;
        this.exception = exception;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
