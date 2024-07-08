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
public class StatistikaFudbalera implements GenerickiEntitet {

    private Fudbaler fudbaler;
    private TreningUtakmica treningUtakmica;
    private int brojGolova;
    private int brojAsistencija;
    private int brojPromasenihSuteva;
    private int brojProvedenihMinuta;
    private Boolean prvaPostava;
    private int brojOdbrana;
    private int brojPrimljenihGolova;
    private double ocjena;

    public StatistikaFudbalera() {
    }

    public StatistikaFudbalera(Fudbaler fudbaler, TreningUtakmica treningUtakmica, int brojGolova, int brojAsistencija, int brojPromasenihSuteva,
            int brojProvedenihMinuta, Boolean prvaPostava, int brojOdbrana, int brojPrimljenihGolova, double ocjena) {
        this.fudbaler = fudbaler;
        this.treningUtakmica = treningUtakmica;
        this.brojGolova = brojGolova;
        this.brojAsistencija = brojAsistencija;
        this.brojPromasenihSuteva = brojPromasenihSuteva;
        this.brojProvedenihMinuta = brojProvedenihMinuta;
        this.prvaPostava = prvaPostava;
        this.brojOdbrana = brojOdbrana;
        this.brojPrimljenihGolova = brojPrimljenihGolova;
        this.ocjena = ocjena;
    }

    public Fudbaler getFudbaler() {
        return fudbaler;
    }

    public void setFudbaler(Fudbaler fudbaler) {
        if (fudbaler == null) {
            throw new NullPointerException("Fudbaler ne smije da bude null!");
        }
        this.fudbaler = fudbaler;
    }

    public TreningUtakmica getTreningUtakmicaId() {
        return treningUtakmica;
    }

    public void setTreningUtakmicaId(TreningUtakmica treningUtakmica) {
        this.treningUtakmica = treningUtakmica;
    }

    public int getBrojGolova() {
        return brojGolova;
    }

    public void setBrojGolova(int brojGolova) {
        if (brojGolova < 0) {
            throw new IllegalArgumentException("Broj golova ne smije da bude negativan broj!");
        }
        this.brojGolova = brojGolova;
    }

    public int getBrojAsistencija() {
        return brojAsistencija;
    }

    public void setBrojAsistencija(int brojAsistencija) {
        if (brojAsistencija < 0) {
            throw new IllegalArgumentException("Broj asistencija ne smije da bude negativan broj!");
        }
        this.brojAsistencija = brojAsistencija;
    }

    public TreningUtakmica getTreningUtakmica() {
        return treningUtakmica;
    }

    public void setTreningUtakmica(TreningUtakmica treningUtakmica) {
        if (treningUtakmica == null) {
            throw new NullPointerException("Trening utakmica ne smije da bude null!");
        }
        this.treningUtakmica = treningUtakmica;
    }

    public int getBrojPromasenihSuteva() {
        return brojPromasenihSuteva;
    }

    public void setBrojPromasenihSuteva(int brojPromasenihSuteva) {
        if (brojPromasenihSuteva < 0) {
            throw new IllegalArgumentException("Broj promasenih suteva ne smije da bude negativan broj!");
        }
        this.brojPromasenihSuteva = brojPromasenihSuteva;
    }

    public int getBrojProvedenihMinuta() {
        return brojProvedenihMinuta;
    }

    public void setBrojProvedenihMinuta(int brojProvedenihMinuta) {
        if (brojProvedenihMinuta < 0) {
            throw new IllegalArgumentException("Broj provedenih minuta ne smije da bude negativan broj!");
        }
        this.brojProvedenihMinuta = brojProvedenihMinuta;
    }

    public Boolean isPrvaPostava() {
        return prvaPostava;
    }

    public void setPrvaPostava(Boolean prvaPostava) {
        if (prvaPostava == null) {
            throw new NullPointerException("Prva postava ne smije da bude null!");
        }
        this.prvaPostava = prvaPostava;
    }

    public int getBrojOdbrana() {
        return brojOdbrana;
    }

    public void setBrojOdbrana(int brojOdbrana) {
        if (brojOdbrana < 0) {
            throw new IllegalArgumentException("Broj odbrana ne smije da bude negativan broj!");
        }
        this.brojOdbrana = brojOdbrana;
    }

    public int getBrojPrimljenihGolova() {
        return brojPrimljenihGolova;
    }

    public void setBrojPrimljenihGolova(int brojPrimljenihGolova) {
        if (brojPrimljenihGolova < 0) {
            throw new IllegalArgumentException("Broj primljenih ne smije da bude negativan broj!");
        }
        this.brojPrimljenihGolova = brojPrimljenihGolova;
    }

    public double getOcjena() {
        return ocjena;
    }

    public void setOcjena(double ocjena) {
        if (ocjena < 0) {
            throw new IllegalArgumentException("Ocjena ne smije da bude negativan broj!");
        }
        this.ocjena = ocjena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fudbaler);
        hash = 97 * hash + Objects.hashCode(this.treningUtakmica);
        hash = 97 * hash + this.brojGolova;
        hash = 97 * hash + this.brojAsistencija;
        hash = 97 * hash + this.brojPromasenihSuteva;
        hash = 97 * hash + this.brojProvedenihMinuta;
        hash = 97 * hash + Objects.hashCode(this.prvaPostava);
        hash = 97 * hash + this.brojOdbrana;
        hash = 97 * hash + this.brojPrimljenihGolova;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.ocjena) ^ (Double.doubleToLongBits(this.ocjena) >>> 32));
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
        final StatistikaFudbalera other = (StatistikaFudbalera) obj;
        if (this.brojGolova != other.brojGolova) {
            return false;
        }
        if (this.brojAsistencija != other.brojAsistencija) {
            return false;
        }
        if (this.brojPromasenihSuteva != other.brojPromasenihSuteva) {
            return false;
        }
        if (this.brojProvedenihMinuta != other.brojProvedenihMinuta) {
            return false;
        }
        if (this.brojOdbrana != other.brojOdbrana) {
            return false;
        }
        if (this.brojPrimljenihGolova != other.brojPrimljenihGolova) {
            return false;
        }
        if (Double.doubleToLongBits(this.ocjena) != Double.doubleToLongBits(other.ocjena)) {
            return false;
        }
        if (!Objects.equals(this.fudbaler, other.fudbaler)) {
            return false;
        }
        if (!Objects.equals(this.treningUtakmica, other.treningUtakmica)) {
            return false;
        }
        return Objects.equals(this.prvaPostava, other.prvaPostava);
    }

    @Override
    public String toString() {
        return "StatistikaFudbalera{" + "fudbaler=" + fudbaler + ", treningUtakmica=" + treningUtakmica + ", brojGolova=" + brojGolova + ", brojAsistencija=" + brojAsistencija + ", brojPromasenihSuteva=" + brojPromasenihSuteva + ", brojProvedenihMinuta=" + brojProvedenihMinuta + ", prvaPostava=" + prvaPostava + ", brojOdbrana=" + brojOdbrana + ", brojPrimljenihGolova=" + brojPrimljenihGolova + ", ocjena=" + ocjena + '}';
    }

    @Override
    public String getTableName() {
        return "statistika_fudbalera";
    }

    @Override
    public String getInsertColumns() {
        return "fudbaler_id,trening_utakmica_id,broj_golova,broj_asistencija,broj_promasenih_suteva,broj_provedenih_minuta,broj_odbrana,broj_primljenih_golova,prva_postava,ocjena";
    }

    @Override
    public String getInsertValues() {
        return "'" + fudbaler.getObjID() + "','" + treningUtakmica.getObjID() + "','" + brojGolova + "','" + brojAsistencija + "','" + brojPromasenihSuteva + "','" + brojProvedenihMinuta + "','" + brojOdbrana + "','" + brojPrimljenihGolova + "','" + (prvaPostava ? 1 : 0) + "','" + ocjena + "'";
    }

    @Override
    public void setId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long getObjID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereDvaParametra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAlijas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
