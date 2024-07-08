/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class TipTreninga implements GenerickiEntitet {

    private long tipId;
    private String nazivTipa;

    public TipTreninga() {
    }

    public TipTreninga(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }

    public TipTreninga(long tipId, String nazivTipa) {
        this.tipId = tipId;
        this.nazivTipa = nazivTipa;
    }

    public long getTipId() {
        return tipId;
    }

    public void setTipId(long tipId) {
        this.tipId = tipId;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        if (nazivTipa == null) {
            throw new NullPointerException("Naziv tipa ne smije da bude null!");
        }
        this.nazivTipa = nazivTipa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.tipId ^ (this.tipId >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nazivTipa);
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
        final TipTreninga other = (TipTreninga) obj;
        if (this.tipId != other.tipId) {
            return false;
        }
        return Objects.equals(this.nazivTipa, other.nazivTipa);
    }

    @Override
    public String toString() {
        return nazivTipa;
    }

    @Override
    public String getTableName() {
        return "tip_treninga";
    }

    @Override
    public String getInsertColumns() {
        return "tip_id,naziv_tipa";
    }

    @Override
    public String getInsertValues() {
        return "'" + tipId + "','" + nazivTipa + "'";
    }

    @Override
    public void setId(long id) {
        this.tipId = id;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinText() {
        return "";
    }

    @Override
    public String getSelectedText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        return "tip_id";
    }

    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new TipTreninga(Integer.parseInt(rs.getString("tt.tip_id")), rs.getString("tt.naziv_tipa"));
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new TipTreninga(rs.getInt(getAlijas() + ".tip_id"), rs.getString(getAlijas() + ".naziv_tipa"));
    }

    @Override
    public long getObjID() {
        return tipId;
    }

    @Override
    public String getWhereDvaParametra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAlijas() {
        return "tt";
    }

    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
