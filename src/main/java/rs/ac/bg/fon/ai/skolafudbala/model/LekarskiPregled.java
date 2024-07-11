/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import com.google.gson.annotations.SerializedName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 * Klasa koja predstavlja lekarski pregled fudbalera u sistemu škole fudbala.
 *
 * Lekarski pregled uključuje visinu, težinu, stanje, datum pregleda, i povezani
 * fudbaler. Implementira interfejs GenerickiEntitet za rad sa bazom podataka.
 *
 * @autor Aleksa Stancic
 */
public class LekarskiPregled implements GenerickiEntitet {

    /**
     * ID lekarskog pregleda tipa long.
     */
    @SerializedName("ID LEKARSKOG PREGLEDA: ")
    private long pregledId;

    /**
     * Fudbaler koji je prošao lekarski pregled tipa Fudbaler.
     */
    @SerializedName("FUDBALER: ")
    private Fudbaler fudbaler = new Fudbaler();

    /**
     * Visina fudbalera u centimetrima.
     */
    @SerializedName("VISINA FUDBALERA: ")
    private double visina;

    /**
     * Težina fudbalera u kilogramima.
     */
    @SerializedName("TEZINA FUDBALERA: ")
    private double tezina;

    /**
     * Zdravstveno stanje fudbalera kao String.
     */
    @SerializedName("STANJE FUDBALERA: ")
    private String stanje;

    /**
     * Datum lekarskog pregleda kao Date.
     */
    @SerializedName("DATUM OBAVLJANJA LEKARSKOG PREGLEDA: ")
    private Date datum;

    /**
     * Pravi nov objekat klase LekarskiPregled.
     *
     * ID, tezina, visina, stanje ostaju neinicijalizovani. Fudbaler se
     * inicijalizuje.
     */
    public LekarskiPregled() {
    }

    /**
     * Pravi nov objekat klase Fudbaler i postavlja sve atribute na unete
     * vrednosti.
     *
     * @param pregledId jedinstveni identifikator lekarskog pregleda tipa long
     * @param fudbaler fudbaler koji je prošao lekarski pregled
     * @param datum datum lekarskog pregleda tipa Date
     * @param visina visina fudbalera u centimetrima
     * @param tezina težina fudbalera u kilogramima
     * @param stanje zdravstveno stanje fudbalera kao String
     */
    public LekarskiPregled(long pregledId, Fudbaler fudbaler, Date datum, double visina, double tezina, String stanje) {
        this.pregledId = pregledId;
        this.fudbaler = fudbaler;
        this.visina = visina;
        this.tezina = tezina;
        this.stanje = stanje;
        this.datum = datum;
    }

    /**
     * Pravi nov objekat klase Fudbaler i postavlja sve atribute na unete
     * vrednosti, osim Id-a
     *
     * @param fudbaler fudbaler koji je prošao lekarski pregled
     * @param datum datum lekarskog pregleda tipa Date
     * @param visina visina fudbalera u centimetrima
     * @param tezina težina fudbalera u kilogramima
     * @param stanje zdravstveno stanje fudbalera kao String
     */
    public LekarskiPregled(double visina, Fudbaler fudbaler, double tezina, String stanje, Date datum) {
        this.fudbaler = fudbaler;
        this.visina = visina;
        this.tezina = tezina;
        this.stanje = stanje;
        this.datum = datum;
    }

    /**
     * Vraća jedinstveni identifikator lekarskog pregleda.
     *
     * @return jedinstveni identifikator lekarskog pregleda kao long
     */
    public long getPregledId() {
        return pregledId;
    }

    /**
     * Postavlja jedinstveni identifikator lekarskog pregleda.
     *
     * @param pregledId jedinstveni identifikator lekarskog pregleda kao long
     */
    public void setPregledId(long pregledId) {
        this.pregledId = pregledId;
    }

    /**
     * Vraća fudbalera koji je prošao lekarski pregled.
     *
     * @return fudbaler
     */
    public Fudbaler getFudbaler() {
        return fudbaler;
    }

    /**
     * Postavlja fudbalera koji je prošao lekarski pregled.
     *
     * @param fudbaler fudbaler
     * @throws NullPointerException ako je fudbaler null
     */
    public void setFudbaler(Fudbaler fudbaler) {
        if (fudbaler == null) {
            throw new NullPointerException("Fudbaler ne moze da bude null!");
        }
        this.fudbaler = fudbaler;
    }

    /**
     * Vraća visinu fudbalera.
     *
     * @return visina fudbalera u centimetrima
     */
    public double getVisina() {
        return visina;
    }

    /**
     * Postavlja visinu fudbalera.
     *
     * @param visina visina fudbalera
     * @throws IllegalArgumentException ako je visina manja od 0
     */
    public void setVisina(double visina) {
        if (visina < 0) {
            throw new IllegalArgumentException("Visina ne smije da bude manja od 0!");
        }
        this.visina = visina;
    }

    /**
     * Vraća težinu fudbalera.
     *
     * @return težina fudbalera u kilogramima
     */
    public double getTezina() {
        return tezina;
    }

    /**
     * Postavlja težinu fudbalera.
     *
     * @param tezina težina fudbalera u kilogramima
     * @throws IllegalArgumentException ako je težina manja od 0
     */
    public void setTezina(double tezina) {
        if (tezina < 0) {
            throw new IllegalArgumentException("Tezina ne smije da bude manja od 0!");
        }
        this.tezina = tezina;
    }

    /**
     * Vraća zdravstveno stanje fudbalera.
     *
     * @return zdravstveno stanje fudbalera kao String
     */
    public String getStanje() {
        return stanje;
    }

    /**
     * Postavlja zdravstveno stanje fudbalera.
     *
     * @param stanje zdravstveno stanje fudbalera kao String
     * @throws NullPointerException ako je stanje null
     */
    public void setStanje(String stanje) {
        if (stanje == null) {
            throw new NullPointerException("Stanje ne moze da bude null!");
        }
        this.stanje = stanje;
    }

    /**
     * Vraća datum lekarskog pregleda.
     *
     * @return datum lekarskog pregleda kao Date
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Postavlja datum lekarskog pregleda.
     *
     * @param datum datum lekarskog pregleda kao Date
     * @throws NullPointerException ako je datum null
     * @throws IllegalArgumentException ako je datum u budućnosti
     */
    public void setDatum(Date datum) {
        if (datum == null) {
            throw new NullPointerException("Datum ne moze da bude null!");
        }
        if (datum.after(new Date())) {
            throw new IllegalArgumentException("Datum mora biti iz prošlosti");
        }
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

    /**
     * Poređuje trenutni lekarski pregled sa drugim objektom radi utvrđivanja da
     * li su jednaki.
     *
     * @param obj objekat sa kojim se poredi trenutni lekarski pregled
     * @return
     * <ul>
     * <li><b>true</b> - ako su oba objekta inicijalizovana, klase su
     * LekarskiPregled i imaju isti pregledId, visinu, težinu, stanje, fudbalera
     * i datum</li>
     * <li><b>false</b> - ako nisu iste klase ili ako neki od atributa nije
     * isti</li>
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

    /**
     * Vraća naziv tabele u bazi podataka za lekarski pregled.
     *
     * @return naziv tabele za lekarski pregled kao String
     */
    @Override
    public String getTableName() {
        return "lekarski_pregled";
    }

    /**
     * Vraća nazive kolona za unos podataka u bazu za lekarski pregled.
     *
     * @return nazivi kolona za unos podataka kao String
     */
    @Override
    public String getInsertColumns() {
        return "pregled_id,fudbaler_id,datum,visina,tezina,stanje";
    }

    /**
     * Vraća vrednosti koje se ubacuju u bazu za lekarski pregled.
     *
     * @return vrednosti za unos u bazu kao String
     */
    @Override
    public String getInsertValues() {
        return "'" + pregledId + "','" + fudbaler.getFudbalerId() + "','" + new java.sql.Date(datum.getTime()) + "','" + visina + "','" + tezina + "','" + stanje + "'";
    }

    /**
     * Postavlja jedinstveni identifikator lekarskog pregleda.
     *
     * @param id jedinstveni identifikator lekarskog pregleda
     */
    @Override
    public void setId(long id) {
        this.pregledId = id;
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public String getJoinText() {
        throw new UnsupportedOperationException("Not supported yet.");
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
     * Vraća naziv identifikatora (ID) za lekarski pregled.
     *
     * @return naziv ID kolone kao String
     */
    @Override
    public String getID() {
        return "pregled_id";
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Vraća jedinstveni identifikator entiteta.
     *
     * @return jedinstveni identifikator entiteta kao long
     */
    @Override
    public long getObjID() {
        return pregledId;
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public String getWhereDvaParametra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Vraća tekst za ALIAS u upitu za lekarski pregled.
     *
     * @return tekst za ALIAS kao String
     */
    @Override
    public String getAlijas() {
        return "lp";
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
