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
public class Raspored implements GenerickiEntitet {

    private long rasporedId;
    private TreningGrupa grupa = new TreningGrupa();
    private Date datumOd;
    private Date datumDo;
    private String tipTreninga;

    public Raspored() {
    }

    public Raspored(int rasporedId, TreningGrupa grupa, Date datumOd, Date datumDo, String tipTreninga) {
        this.rasporedId = rasporedId;
        this.grupa = grupa;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.tipTreninga = tipTreninga;
    }

    public Raspored(TreningGrupa grupa, Date datumOd, Date datumDo, String tipTreninga) {
        this.rasporedId = rasporedId;
        this.grupa = grupa;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.tipTreninga = tipTreninga;
    }

    public long getRasporedId() {
        return rasporedId;
    }

    public void setRasporedId(int rasporedId) {
        this.rasporedId = rasporedId;
    }

    public TreningGrupa getGrupa() {
        return grupa;
    }

    public void setGrupa(TreningGrupa grupa) {
        this.grupa = grupa;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.rasporedId ^ (this.rasporedId >>> 32));
        hash = 67 * hash + Objects.hashCode(this.grupa);
        hash = 67 * hash + Objects.hashCode(this.datumOd);
        hash = 67 * hash + Objects.hashCode(this.datumDo);
        hash = 67 * hash + Objects.hashCode(this.tipTreninga);
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
        final Raspored other = (Raspored) obj;
        if (this.rasporedId != other.rasporedId) {
            return false;
        }
        if (!Objects.equals(this.tipTreninga, other.tipTreninga)) {
            return false;
        }
        if (!Objects.equals(this.datumOd, other.datumOd)) {
            return false;
        }
        return Objects.equals(this.datumDo, other.datumDo);
    }

    @Override
    public String toString() {
        return "Raspored{" + "rasporedId=" + rasporedId + ", grupa=" + grupa + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", tipTreninga=" + tipTreninga + '}';
    }

    @Override
    public String getTableName() {
        return "raspored";
    }

    @Override
    public String getInsertColumns() {
        return "raspored_id,grupa_id,trening_tip,datum_od,datum_do";
    }

    @Override
    public String getInsertValues() {
        return "'" + rasporedId + "','" + grupa.getObjID() + "','" + tipTreninga + "','" + new java.sql.Date(datumOd.getTime()) + "','" + new java.sql.Date(datumDo.getTime()) + "'";
    }

    @Override
    public void setId(long id) {
        this.rasporedId = id;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinText() {
        return "JOIN trening_grupa tg ON r.grupa_id=tg.grupa_id JOIN trener t ON tg.trener_id=t.trener_id";
    }

    @Override
    public String getSelectedText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        return "raspored_id";
    }

    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new Raspored(Integer.parseInt(rs.getString("r.raspored_id")), (TreningGrupa) grupa.getEntity(rs), new java.util.Date(rs.getDate("r.datum_od").getTime()), new java.util.Date(rs.getDate("r.datum_do").getTime()), rs.getString("r.trening_tip"));
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new Raspored(Integer.parseInt(rs.getString("r.raspored_id")), (TreningGrupa) grupa.getEntity(rs), new java.util.Date(rs.getDate("r.datum_od").getTime()), new java.util.Date(rs.getDate("r.datum_do").getTime()), rs.getString("r.trening_tip"));
    }

    @Override
    public long getObjID() {
        return rasporedId;
    }

    @Override
    public String getWhereDvaParametra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAlijas() {
        return "r";
    }

    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
