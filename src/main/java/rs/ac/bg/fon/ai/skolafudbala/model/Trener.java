/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Predstavlja trenera u školi fudbala. Svaki trener ima jedinstveni ID, ime,
 * prezime, JMBG i godine iskustva. Implementira interfejs GenerickiEntitet koji
 * definiše osnovne metode za rad sa entitetima u bazi podataka.
 *
 * @author Aleksa Stancic
 */
public class Trener implements GenerickiEntitet {

    /**
     * ID trenera tipa long.
     */
    private long trenerId;

    /**
     * Ime trenera kao String.
     */
    private String ime;

    /**
     * Prezime trenera kao String.
     */
    private String prezime;

    /**
     * JMBG trenera kao String.
     */
    private String jmbg;

    /**
     * Godine iskustva trenera kao int.
     */
    private int godineIskustva;

    /**
     * Pravi nov objekat klase Trener.
     *
     * ID, ime, prezime, jmbg, godine iskustva ostaju neinicijalizovani.
     */
    public Trener() {
    }

    /**
     * Postavlja ID, ime, prezime, jmbg, godine iskustva na unete vrednosti.
     *
     * @param trenerId jedinstveni identifikator trenera kao long
     * @param ime ime trenera kao String
     * @param prezime prezime trenera kao String
     * @param jmbg JMBG trenera kao String
     * @param godineIskustva godine iskustva trenera kao int
     */
    public Trener(long trenerId, String ime, String prezime, String jmbg, int godineIskustva) {
        this.trenerId = trenerId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.godineIskustva = godineIskustva;
    }

    /**
     * Postavlja ime, prezime, jmbg, godine iskustva na unete vrednosti.
     *
     * @param ime ime trenera kao String
     * @param prezime prezime trenera kao String
     * @param jmbg JMBG trenera kao String
     * @param godineIskustva godine iskustva trenera kao int
     */
    public Trener(String ime, String prezime, String jmbg, int godineIskustva) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.godineIskustva = godineIskustva;
    }

    /**
     * Vraća jedinstveni identifikator trenera.
     *
     * @return jedinstveni identifikator trenera kao int
     */
    public long getTrenerId() {
        return trenerId;
    }

    /**
     * Postavlja jedinstveni identifikator trenera.
     *
     * @param trenerId jedinstveni identifikator trenera
     */
    public void setTrenerId(long trenerId) {
        this.trenerId = trenerId;
    }

    /**
     * Vraća ime trenera.
     *
     * @return ime trenera kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime trenera.
     *
     * @param ime ime trenera
     * @throws NullPointerException ako je ime null
     * @throws IllegalArgumentException ako ime nije validno (mora da sadrži
     * samo slova i prvo slovo veliko)
     */
    public void setIme(String ime) {
        if (ime == null) {
            throw new NullPointerException("Ime ne smije da bude null!");
        }
        if (!ime.matches("[a-zA-Z]+") || !Character.isUpperCase(ime.charAt(0))) {
            throw new IllegalArgumentException("Ime mora da sadrzi samo slova i prvo slovo mora da bude veliko!");
        }
        this.ime = ime;
    }

    /**
     * Vraća prezime trenera.
     *
     * @return prezime trenera kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime trenera.
     *
     * @param prezime prezime trenera
     * @throws NullPointerException ako je prezime null
     * @throws IllegalArgumentException ako prezime nije validno (mora da sadrži
     * samo slova i prvo slovo veliko)
     */
    public void setPrezime(String prezime) {
        if (prezime == null) {
            throw new NullPointerException("Prezime ne smije da bude null!");
        }
        if (!prezime.matches("[a-zA-Z]+") || !Character.isUpperCase(prezime.charAt(0))) {
            throw new IllegalArgumentException("Prezime mora da sadrzi samo slova i prvo slovo mora da bude veliko!");
        }
        this.prezime = prezime;
    }

    /**
     * Vraća JMBG trenera.
     *
     * @return JMBG trenera kao String
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * Postavlja JMBG trenera.
     *
     * @param jmbg JMBG trenera
     * @throws NullPointerException ako je JMBG null
     * @throws IllegalArgumentException ako JMBG nije validan (mora da sadrži
     * samo cifre i tačno 13 cifara)
     */
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

    /**
     * Vraća godine iskustva trenera.
     *
     * @return godine iskustva trenera kao int
     */
    public int getGodineIskustva() {
        return godineIskustva;
    }

    /**
     * Postavlja godine iskustva trenera.
     *
     * @param godineIskustva godine iskustva trenera kao int
     * @throws IllegalArgumentException ako godine iskustva nisu pozitivan broj
     */
    public void setGodineIskustva(int godineIskustva) {
        if (godineIskustva < 0) {
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

    /**
     * Poredi dva objekta tipa Trener.
     *
     * @param obj objekat sa kojim se poredi
     * @return
     * <ul>
     * <li><b>true</b> - ako su oba objekta inicijalizovana, klase su Trener i
     * imaju isti ID, ime, prezime, JMBG i godine iskustva</li>
     * <li><b>false</b> - ako nisu klase Trener, ako je drugi objekat null ili
     * ako atributi nisu jednaki</li>
     * </ul>
     */
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

    /**
     * Vraća naziv tabele u bazi podataka za entitet Trener.
     *
     * @return naziv tabele kao String
     */
    @Override
    public String getTableName() {
        return "trener";
    }

    /**
     * Vraća naziv tabele u bazi podataka za entitet Trener.
     *
     * @return naziv tabele kao String
     */
    @Override
    public String getInsertColumns() {
        return "trener_id,ime,prezime,jmbg,godine_iskustva";
    }

    /**
     * Vraća vrednosti koje se ubacuju u bazu podataka za INSERT upit za entitet
     * Trener.
     *
     * @return vrednosti za INSERT kao String
     */
    @Override
    public String getInsertValues() {
        return "'" + trenerId + "','" + ime + "','" + prezime + "','" + jmbg + "','" + godineIskustva + "'";
    }

    /**
     * Postavlja ID trenera.
     *
     * @param id ID trenera
     */
    @Override
    public void setId(long id) {
        this.trenerId = id;
    }

    /**
     * Vraća vrednosti koje se ažuriraju u bazi podataka za UPDATE upit za
     * entitet Trener.
     *
     * @return vrednosti za UPDATE kao String
     */
    @Override
    public String getUpdateValues() {
        return "ime='" + getIme() + "',prezime='" + getPrezime() + "',jmbg='" + getJmbg() + "',godine_iskustva=" + getGodineIskustva();
    }

    /**
     * Vraća tekst za JOIN u SQL upitu.
     *
     * @return tekst za JOIN kao String
     */
    @Override
    public String getJoinText() {
        return "";
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public String getSelectedText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Vraća naziv ID kolone za entitet Trener.
     * 
     * @return naziv ID kolone kao String
     */
    @Override
    public String getID() {
        return "trener_id";
    }

    /**
     * Kreira novi entitet Trener na osnovu rezultata upita iz baze podataka.
     * 
     * @param rs rezultat upita iz baze podataka kao ResultSet
     * @return novi entitet Trener
     * @throws SQLException ako dođe do greške prilikom čitanja rezultata iz baze
     */
    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new Trener(rs.getInt("t2.trener_id"), rs.getString("t2.ime"), rs.getString("t2.prezime"), rs.getString("t2.jmbg"), rs.getInt("t2.godine_iskustva"));
    }

    /**
     * Kreira novi entitet Trener na osnovu rezultata JOIN upita iz baze podataka.
     * 
     * @param rs rezultat JOIN upita iz baze podataka
     * @return novi entitet Trener
     * @throws SQLException ako dođe do greške prilikom čitanja rezultata iz baze
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new Trener(rs.getInt(getAlijas() + ".trener_id"), rs.getString(getAlijas() + ".ime"), rs.getString(getAlijas() + ".prezime"), rs.getString(getAlijas() + ".jmbg"), rs.getInt(getAlijas() + ".godine_iskustva"));
    }

    /**
     * Vraća jedinstveni ID objekta Trener.
     * 
     * @return jedinstveni ID
     */
    @Override
    public long getObjID() {
        return trenerId;
    }

    /**
     * Vraća deo WHERE uslova za SQL upit sa dva parametra (ime i JMBG).
     * 
     * @return deo WHERE uslova sa dva parametra kao String
     */
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

    /**
     * Vraća alias za entitet Trener.
     * 
     * @return alias kao String
     */
    @Override
    public String getAlijas() {
        return "t";
    }

    /**
     * Vraća deo WHERE uslova za SQL upit.
     * 
     * @return deo WHERE uslova kao String
     */
    @Override
    public String getWhere() {
        return "WHERE " + getAlijas() + "." + getID() + "=";
    }

}
