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
public class Trener implements GenerickiEntitet {

    private long trenerId;
    private String ime;
    private String prezime;
    private String jmbg;
    private int godineIskustva;

    public Trener() {
    }

    public Trener(long trenerId, String ime, String prezime, String jmbg, int godineIskustva) {
        this.trenerId = trenerId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.godineIskustva = godineIskustva;
    }

    public Trener(String ime, String prezime, String jmbg, int godineIskustva) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.godineIskustva = godineIskustva;
    }

    public long getTrenerId() {
        return trenerId;
    }

    public void setTrenerId(long trenerId) {
        this.trenerId = trenerId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if (ime == null) {
            throw new NullPointerException("Ime ne smije da bude null!");
        }
        if (!ime.matches("[a-zA-Z]+") || !Character.isUpperCase(ime.charAt(0))) {
            throw new IllegalArgumentException("Ime mora da sadrzi samo slova i prvo slovo mora da bude veliko!");
        }
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        if (prezime == null) {
            throw new NullPointerException("Prezime ne smije da bude null!");
        }
        if (!prezime.matches("[a-zA-Z]+") || !Character.isUpperCase(prezime.charAt(0))) {
            throw new IllegalArgumentException("Prezime mora da sadrzi samo slova i prvo slovo mora da bude veliko!");
        }
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        if (jmbg == null) {
            throw new NullPointerException("JMBG ne smije da bude null!");
        }
        if (!jmbg.matches("\\d+")) {
            throw new IllegalArgumentException("JMBG mora da sadrzi samo cifre!");
        }
        if (jmbg.length() != 13) {
            throw new IllegalArgumentException("JMBG mora da ima tacno 13 cifara!");
        }
        this.jmbg = jmbg;
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        if(godineIskustva<0){
            throw new IllegalArgumentException("Godine iskustva moraju da budu pozitivan broj!");
        }
        this.godineIskustva = godineIskustva;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.trenerId ^ (this.trenerId >>> 32));
        hash = 41 * hash + Objects.hashCode(this.ime);
        hash = 41 * hash + Objects.hashCode(this.prezime);
        hash = 41 * hash + Objects.hashCode(this.jmbg);
        hash = 41 * hash + this.godineIskustva;
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
        final Trener other = (Trener) obj;
        if (this.trenerId != other.trenerId) {
            return false;
        }
        if (this.godineIskustva != other.godineIskustva) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.jmbg, other.jmbg);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "trener";
    }

    @Override
    public String getInsertColumns() {
        return "trener_id,ime,prezime,jmbg,godine_iskustva";
    }

    @Override
    public String getInsertValues() {
        return "'" + trenerId + "','" + ime + "','" + prezime + "','" + jmbg + "','" + godineIskustva + "'";
    }

    @Override
    public void setId(long id) {
        this.trenerId = id;
    }

    @Override
    public String getUpdateValues() {
        return "ime='" + getIme() + "',prezime='" + getPrezime() + "',jmbg='" + getJmbg() + "',godine_iskustva=" + getGodineIskustva();
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
        return "trener_id";
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new Trener(rs.getInt("t2.trener_id"), rs.getString("t2.ime"), rs.getString("t2.prezime"), rs.getString("t2.jmbg"), rs.getInt("t2.godine_iskustva"));
    }

    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new Trener(rs.getInt(getAlijas() + ".trener_id"), rs.getString(getAlijas() + ".ime"), rs.getString(getAlijas() + ".prezime"), rs.getString(getAlijas() + ".jmbg"), rs.getInt(getAlijas() + ".godine_iskustva"));
    }

    @Override
    public long getObjID() {
        return trenerId;
    }

    @Override
    public String getWhereDvaParametra() {
        System.out.println(getIme() + " " + getJmbg());
        if (getIme() == null || getIme().equals("")) {
            return getAlijas() + ".jmbg LIKE " + "'" + getJmbg() + "%'";
        } else if (getJmbg() == null || getJmbg().equals("")) {
            return getAlijas() + ".ime LIKE " + "'" + getIme() + "%'";
        }
        return getAlijas() + ".ime LIKE " + "'" + getIme() + "%' AND " + getAlijas() + ".jmbg LIKE " + "'" + getJmbg() + "%'";
    }

    @Override
    public String getAlijas() {
        return "t";
    }

    @Override
    public String getWhere() {
        return "WHERE " + getAlijas() + "." + getID() + "=";
    }

}
