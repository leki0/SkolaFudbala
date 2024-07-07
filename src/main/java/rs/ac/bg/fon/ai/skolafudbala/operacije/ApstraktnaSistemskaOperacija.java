/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.operacije;

import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db.RepozitorijumDb;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db.impl.RepozitorijumImpl;


/**
 *
 * @author Korisnik
 */
public abstract class ApstraktnaSistemskaOperacija {

    protected Repozitorijum repozitorijum;

    public ApstraktnaSistemskaOperacija() {
        this.repozitorijum = new RepozitorijumImpl();
    }

    public final void izvrsi(Object odo) throws Exception {
        try {
            preduslovi(odo);
            startTransakcija();
            izvrsiOperaciju(odo);
            commit();
        } catch (Exception ex) {
            //ex.printStackTrace();
            rollback();
            throw ex;
        } finally {
            disconnect();
        }
    }

    protected abstract void izvrsiOperaciju(Object odo) throws Exception;

    protected abstract void preduslovi(Object odo) throws Exception;

    private void startTransakcija() throws Exception {
        ((RepozitorijumDb) repozitorijum).connect();
    }

    private void commit() throws Exception {
        ((RepozitorijumDb) repozitorijum).commit();

    }

    private void rollback() throws Exception {
        ((RepozitorijumDb) repozitorijum).rollback();
    }

    private void disconnect() throws Exception {
        ((RepozitorijumDb) repozitorijum).disconnect();
    }

}
