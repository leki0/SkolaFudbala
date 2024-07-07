/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class TreningUtakmica implements GenerickiEntitet {

    private long treningUtakmicaId;
    private int redniBroj;
    private Date datum;
    private int brojGolovaTim1;
    private int brojGolovaTikm2;
    private TreningGrupa tim1 = new TreningGrupa();
    private TreningGrupa tim2 = new TreningGrupa();
    private List<StatistikaFudbalera> listaStatistika;

    public TreningUtakmica() {
    }

    public TreningUtakmica(long treningUtakmicaId, int redniBroj, Date datum, int brojGolovaTim1, int brojGolovaTikm2, TreningGrupa tim1, TreningGrupa tim2, List<StatistikaFudbalera> listaStatistika) {
        this.treningUtakmicaId = treningUtakmicaId;
        this.datum = datum;
        this.brojGolovaTim1 = brojGolovaTim1;
        this.brojGolovaTikm2 = brojGolovaTikm2;
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.listaStatistika = listaStatistika;
        this.redniBroj = redniBroj;
    }

    public TreningUtakmica(long treningUtakmicaId, int redniBroj, Date datum, int brojGolovaTim1, int brojGolovaTikm2, TreningGrupa tim1, TreningGrupa tim2) {
        this.treningUtakmicaId = treningUtakmicaId;
        this.datum = datum;
        this.brojGolovaTim1 = brojGolovaTim1;
        this.brojGolovaTikm2 = brojGolovaTikm2;
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.redniBroj = redniBroj;

    }

    public TreningUtakmica(int redniBroj, Date datum, int brojGolovaTim1, int brojGolovaTikm2, TreningGrupa tim1, TreningGrupa tim2, List<StatistikaFudbalera> listaStatistika) {
        this.datum = datum;
        this.brojGolovaTim1 = brojGolovaTim1;
        this.brojGolovaTikm2 = brojGolovaTikm2;
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.listaStatistika = listaStatistika;
        this.redniBroj = redniBroj;
    }

    public long getTreningUtakmicaId() {
        return treningUtakmicaId;
    }

    public void setTreningUtakmicaId(long treningUtakmicaId) {
        this.treningUtakmicaId = treningUtakmicaId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        if (datum == null) {
            throw new NullPointerException("Datum ne smije da bude null!");
        }
        if (datum.after(new Date())) {
            throw new IllegalArgumentException("Datum mora biti iz prošlosti");
        }
        this.datum = datum;
    }

    public int getBrojGolovaTim1() {
        return brojGolovaTim1;
    }

    public void setBrojGolovaTim1(int brojGolovaTim1) {
        if(brojGolovaTim1<0){
            throw new IllegalArgumentException("Broj golova tim1 ne smije da bude negativan broj!");
        }

        this.brojGolovaTim1 = brojGolovaTim1;
    }

    public int getBrojGolovaTikm2() {
        
        return brojGolovaTikm2;
    }

    public void setBrojGolovaTikm2(int brojGolovaTikm2) {
        if(brojGolovaTikm2<0){
            throw new IllegalArgumentException("Broj golova tim2 ne smije da bude negativan broj!");
        }
        this.brojGolovaTikm2 = brojGolovaTikm2;
    }

    public TreningGrupa getTim1() {
        return tim1;
    }

    public void setTim1(TreningGrupa tim1) {
        this.tim1 = tim1;
    }

    public TreningGrupa getTim2() {
        return tim2;
    }

    public void setTim2(TreningGrupa tim2) {
        this.tim2 = tim2;
    }

    public List<StatistikaFudbalera> getListaStatistika() {
        return listaStatistika;
    }

    public void setListaStatistika(List<StatistikaFudbalera> listaStatistika) {
        this.listaStatistika = listaStatistika;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        if(redniBroj<0){
            throw new IllegalArgumentException("Redni broj utakmice ne moze da bude negativan");
        }
        this.redniBroj = redniBroj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.treningUtakmicaId ^ (this.treningUtakmicaId >>> 32));
        hash = 53 * hash + this.redniBroj;
        hash = 53 * hash + Objects.hashCode(this.datum);
        hash = 53 * hash + this.brojGolovaTim1;
        hash = 53 * hash + this.brojGolovaTikm2;
        hash = 53 * hash + Objects.hashCode(this.tim1);
        hash = 53 * hash + Objects.hashCode(this.tim2);
        hash = 53 * hash + Objects.hashCode(this.listaStatistika);
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
        final TreningUtakmica other = (TreningUtakmica) obj;
        if (this.treningUtakmicaId != other.treningUtakmicaId) {
            return false;
        }
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        if (this.brojGolovaTim1 != other.brojGolovaTim1) {
            return false;
        }
        if (this.brojGolovaTikm2 != other.brojGolovaTikm2) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.tim1, other.tim1)) {
            return false;
        }
        if (!Objects.equals(this.tim2, other.tim2)) {
            return false;
        }
        return Objects.equals(this.listaStatistika, other.listaStatistika);
    }

    @Override
    public String toString() {
        return "TreningUtakmica{" + "treningUtakmicaId=" + treningUtakmicaId + ", redniBroj=" + redniBroj + ", datum=" + datum + ", brojGolovaTim1=" + brojGolovaTim1 + ", brojGolovaTikm2=" + brojGolovaTikm2 + ", tim1=" + tim1 + ", tim2=" + tim2 + ", listaStatistika=" + listaStatistika + '}';
    }

    @Override
    public String getTableName() {
        return "trening_utakmica";
    }

    @Override
    public String getInsertColumns() {
        return "trening_utakmica_id,redni_broj,datum,broj_golova_tim1,broj_golova_tim2,tim1_id,tim2_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + treningUtakmicaId + "','" + redniBroj + "','" + new java.sql.Date(datum.getTime()) + "','" + brojGolovaTim1 + "','" + brojGolovaTikm2 + "','" + tim1.getObjID() + "','" + tim2.getObjID() + "'";
    }

    @Override
    public void setId(long id) {
        this.treningUtakmicaId = id;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinText() {
        return "JOIN trening_grupa tg ON tu.tim1_id=tg.grupa_id JOIN trening_grupa tg2 ON tu.tim2_id=tg2.grupa_id JOIN trener t ON tg.trener_id=t.trener_id JOIN trener t2 ON tg2.trener_id = t2.trener_id";
    }

    @Override
    public String getSelectedText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new TreningUtakmica(rs.getInt(getAlijas() + ".trening_utakmica_id"), rs.getInt(getAlijas() + ".redni_broj"), new java.util.Date(rs.getDate(getAlijas() + ".datum").getTime()), rs.getInt(getAlijas() + ".broj_golova_tim1"), rs.getInt(getAlijas() + ".broj_golova_tim2"), (TreningGrupa) tim1.getEntity(rs), (TreningGrupa) tim2.getJoinEntity(rs));
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long getObjID() {
        return treningUtakmicaId;
    }

    @Override
    public String getWhereDvaParametra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAlijas() {
        return "tu";
    }

    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
