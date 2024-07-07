/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class LekarskiPregled implements GenerickiEntitet {

    private long pregledId;
    private Fudbaler fudbaler = new Fudbaler();
    private double visina;
    private double tezina;
    private String stanje;
    private Date datum;

    public LekarskiPregled() {
    }

    public LekarskiPregled(long pregledId, Fudbaler fudbaler, Date datum, double visina, double tezina, String stanje) {
        this.pregledId = pregledId;
        this.fudbaler = fudbaler;
        this.visina = visina;
        this.tezina = tezina;
        this.stanje = stanje;
        this.datum = datum;
    }

    public LekarskiPregled(double visina, Fudbaler fudbaler, double tezina, String stanje, Date datum) {
        this.fudbaler = fudbaler;
        this.visina = visina;
        this.tezina = tezina;
        this.stanje = stanje;
        this.datum = datum;
    }

    public long getPregledId() {
        return pregledId;
    }

    public void setPregledId(long pregledId) {
        this.pregledId = pregledId;
    }

    public Fudbaler getFudbaler() {
        return fudbaler;
    }

    public void setFudbaler(Fudbaler fudbaler) {
        this.fudbaler = fudbaler;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.pregledId ^ (this.pregledId >>> 32));
        hash = 67 * hash + Objects.hashCode(this.fudbaler);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.visina) ^ (Double.doubleToLongBits(this.visina) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.tezina) ^ (Double.doubleToLongBits(this.tezina) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.stanje);
        hash = 67 * hash + Objects.hashCode(this.datum);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LekarskiPregled other = (LekarskiPregled) obj;
        if (this.pregledId != other.pregledId) {
            return false;
        }
        if (Double.doubleToLongBits(this.visina) != Double.doubleToLongBits(other.visina)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tezina) != Double.doubleToLongBits(other.tezina)) {
            return false;
        }
        if (!Objects.equals(this.stanje, other.stanje)) {
            return false;
        }
        if (!Objects.equals(this.fudbaler, other.fudbaler)) {
            return false;
        }
        return Objects.equals(this.datum, other.datum);
    }

    @Override
    public String toString() {
        return "LekarskiPregled{" + "pregledId=" + pregledId + ", fudbaler=" + fudbaler + ", visina=" + visina + ", tezina=" + tezina + ", stanje=" + stanje + ", datum=" + datum + '}';
    }

    @Override
    public String getTableName() {
        return "lekarski_pregled";
    }

    @Override
    public String getInsertColumns() {
        return "pregled_id,fudbaler_id,datum,visina,tezina,stanje";
    }

    @Override
    public String getInsertValues() {
        return "'" + pregledId + "','" + fudbaler.getFudbalerId() + "','" + new java.sql.Date(datum.getTime()) + "','" + visina + "','" + tezina + "','" + stanje + "'";
    }

    @Override
    public void setId(long id) {
        this.pregledId = id;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getSelectedText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        return "pregled_id";
    }

    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getObjID() {
        return pregledId;
    }

    @Override
    public String getWhereDvaParametra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAlijas() {
        return "lp";
    }

    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
