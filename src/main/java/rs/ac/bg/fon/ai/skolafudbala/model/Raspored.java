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
 * Predstavlja raspored treninga za određenu trening grupu. Sadrži informacije o
 * ID-u rasporeda, grupi, datumima početka i završetka, kao i tipu treninga.
 * Implementira interfejs GenerickiEntitet za operacije nad bazom podataka.
 *
 * @autor Aleksa Stancic
 */
public class Raspored implements GenerickiEntitet {

    /**
     * ID rasporeda tipa long.
     */
    @SerializedName("ID RASPOREDA: ")
    private long rasporedId;

    /**
     * Trening grupa za koju se pravi raspored.
     */
    @SerializedName("TRENING GRUPA: ")
    private TreningGrupa grupa = new TreningGrupa();

    /**
     * Datum početka rasporeda tipa Date.
     */
    @SerializedName("DATUM POČETKA ")
    private Date datumOd;

    /**
     * Datum završetka rasporeda tipa Date.
     */
    @SerializedName("DATUM ZAVRŠETKA: ")
    private Date datumDo;

    /**
     * Tip treninga koji je predvidjen za tu grupu u sklopu tog rasporeda.
     */
    @SerializedName("TIP TRENINGA: ")
    private TipTreninga tipTreninga = new TipTreninga();

    /**
     * Pravi nov objekat klase Raspored.
     *
     * ID, datum pocetka i datum zavrsetka ostaju neinicijalizovani. Trening
     * grupa se inicijalizuje, kao i tip treninga.
     */
    public Raspored() {
    }

    /**
     * Konstruktor sa svim parametrima. Kreira novi objekat klase Raspored sa
     * zadatim vrednostima.
     *
     * @param rasporedId ID rasporeda tipa kao long
     * @param grupa Trening grupa
     * @param datumOd Datum početka rasporeda tipa Date
     * @param datumDo Datum završetka rasporeda tipa Date
     * @param tipTreninga Tip treninga
     */
    public Raspored(int rasporedId, TreningGrupa grupa, Date datumOd, Date datumDo, TipTreninga tipTreninga) {
        this.rasporedId = rasporedId;
        this.grupa = grupa;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.tipTreninga = tipTreninga;
    }

    /**
     * Konstruktor sa svim parametrima, osim ID-a. Kreira novi objekat klase
     * Raspored sa zadatim vrednostima.
     *
     * @param grupa Trening grupa
     * @param datumOd Datum početka rasporeda tipa Date
     * @param datumDo Datum završetka rasporeda tipa Date
     * @param tipTreninga Tip treninga
     */
    public Raspored(TreningGrupa grupa, Date datumOd, Date datumDo, TipTreninga tipTreninga) {
        this.rasporedId = rasporedId;
        this.grupa = grupa;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.tipTreninga = tipTreninga;
    }

    /**
     * Vraća ID rasporeda.
     *
     * @return ID rasporeda tipa long
     */
    public long getRasporedId() {
        return rasporedId;
    }

    /**
     * Postavlja ID rasporeda.
     *
     * @param rasporedId ID rasporeda tipa int
     */
    public void setRasporedId(int rasporedId) {
        this.rasporedId = rasporedId;
    }

    /**
     * Vraća trening grupu.
     *
     * @return Trening grupa tipa TreningGrupa
     */
    public TreningGrupa getGrupa() {
        return grupa;
    }

    /**
     * Postavlja Trening grupu. Ne sme biti null.
     *
     * @param grupa Grupa treninga tipa
     * @throws NullPointerException ako je grupa null
     */
    public void setGrupa(TreningGrupa grupa) {
        if (grupa == null) {
            throw new NullPointerException("Trening grupa ne smije da bude null!");
        }
        this.grupa = grupa;
    }

    /**
     * Vraća datum početka rasporeda.
     *
     * @return Datum početka rasporeda
     */
    public Date getDatumOd() {
        return datumOd;
    }

    /**
     * Postavlja datum početka rasporeda. Ne sme biti null i mora biti u
     * budućnosti.
     *
     * @param datumOd Datum početka rasporeda
     * @throws NullPointerException ako je datumOd null
     * @throws IllegalArgumentException ako datumOd nije u budućnosti
     */
    public void setDatumOd(Date datumOd) {
        if (datumOd == null) {
            throw new NullPointerException("Datum od ne smije da bude null!");
        }
        if (datumOd.before(new Date()) || datumOd.equals(new Date())) {
            throw new IllegalArgumentException("Datum od mora da bude trenutak u buducnosti!");
        }
        this.datumOd = datumOd;
    }

    /**
     * Vraća datum završetka rasporeda.
     *
     * @return Datum završetka rasporeda
     */
    public Date getDatumDo() {
        return datumDo;
    }

    /**
     * Postavlja datum završetka rasporeda. Ne sme biti null i mora biti u
     * budućnosti.
     *
     * @param datumDo Datum završetka rasporeda
     * @throws NullPointerException ako je datumDo null
     * @throws IllegalArgumentException ako datumDo nije u budućnosti
     */
    public void setDatumDo(Date datumDo) {
        if (datumDo == null) {
            throw new NullPointerException("Datum do ne smije da bude null!");
        }
        if (datumDo.before(new Date()) || datumDo.equals(new Date())) {
            throw new IllegalArgumentException("Datum do mora da bude trenutak u buducnosti!");
        }
        this.datumDo = datumDo;
    }

    /**
     * Vraća tip treninga.
     *
     * @return Tip treninga
     */
    public TipTreninga getTipTreninga() {
        return tipTreninga;
    }

    /**
     * Postavlja tip treninga. Ne sme biti null.
     *
     * @param tipTreninga Tip treninga
     * @throws NullPointerException ako je tipTreninga null
     */
    public void setTipTreninga(TipTreninga tipTreninga) {
        if (tipTreninga == null) {
            throw new NullPointerException("Tip treninga od ne smije da bude null!");
        }
        this.tipTreninga = tipTreninga;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.rasporedId ^ (this.rasporedId >>> 32));
        hash = 53 * hash + Objects.hashCode(this.grupa);
        hash = 53 * hash + Objects.hashCode(this.datumOd);
        hash = 53 * hash + Objects.hashCode(this.datumDo);
        hash = 53 * hash + Objects.hashCode(this.tipTreninga);
        return hash;
    }

    /**
     * Poredi trenutni raspored sa drugim objektom radi utvrđivanja da li su
     * jednaki.
     *
     * @param obj objekat sa kojim se upoređuje trenutni raspored
     * @return
     * <ul>
     * <li><b>true</b> - ako su oba objekta inicijalizovana i imaju isti
     * rasporedId, grupa, datumOd, datumDo i tipTreninga</li>
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
        final Raspored other = (Raspored) obj;
        if (this.rasporedId != other.rasporedId) {
            return false;
        }
        if (!Objects.equals(this.grupa, other.grupa)) {
            return false;
        }
        if (!Objects.equals(this.datumOd, other.datumOd)) {
            return false;
        }
        if (!Objects.equals(this.datumDo, other.datumDo)) {
            return false;
        }
        return Objects.equals(this.tipTreninga, other.tipTreninga);
    }

    @Override
    public String toString() {
        return "Raspored{" + "rasporedId=" + rasporedId + ", grupa=" + grupa + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", tipTreninga=" + tipTreninga + '}';
    }

    /**
     * Vraća ime tabele u bazi podataka za entitet Raspored.
     *
     * @return Ime tabele kao String
     */
    @Override
    public String getTableName() {
        return "raspored";
    }

    /**
     * Vraća imena kolona koje se koriste prilikom unosa novog zapisa u bazu
     * podataka.
     *
     * @return String koji predstavlja imena kolona za insert
     */
    @Override
    public String getInsertColumns() {
        return "raspored_id,grupa_id,tip_treninga_id,datum_od,datum_do";
    }

    /**
     * Vraća vrednosti koje se koriste prilikom unosa novog zapisa u bazu
     * podataka.
     *
     * @return String koji predstavlja vrednosti za insert
     */
    @Override
    public String getInsertValues() {
        return "'" + rasporedId + "','" + grupa.getObjID() + "','" + tipTreninga.getObjID() + "','" + new java.sql.Date(datumOd.getTime()) + "','" + new java.sql.Date(datumDo.getTime()) + "'";
    }

    /**
     * Postavlja ID rasporeda.
     *
     * @param id ID rasporeda
     */
    @Override
    public void setId(long id) {
        this.rasporedId = id;
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
     * Vraća tekst za JOIN upit u SQL-u.
     *
     * @return tekst za JOIN upit kao String
     */
    @Override
    public String getJoinText() {
        return "JOIN trening_grupa tg ON r.grupa_id = tg.grupa_id JOIN trener t ON tg.trener_id = t.trener_id JOIN tip_treninga tt ON r.tip_treninga_id = tt.tip_id";
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
     * Vraća naziv ID kolone u bazi podataka.
     *
     * @return naziv ID kolone kao String
     */
    @Override
    public String getID() {
        return "raspored_id";
    }

    /**
     * Kreira i vraća entitet na osnovu rezultata SQL upita.
     *
     * @param rs ResultSet koji sadrži rezultate SQL upita
     * @return novi entitet tipa Raspored
     * @throws SQLException ako dođe do greške prilikom obrade ResultSet-a
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new Raspored(Integer.parseInt(rs.getString("r.raspored_id")), (TreningGrupa) grupa.getEntity(rs), new java.util.Date(rs.getDate("r.datum_od").getTime()), new java.util.Date(rs.getDate("r.datum_do").getTime()), (TipTreninga) tipTreninga.getEntity(rs));
    }

    /**
     * Kreira i vraća entitet na osnovu rezultata SQL upita sa JOIN operacijom.
     *
     * @param rs ResultSet koji sadrži rezultate SQL upita sa JOIN operacijom
     * @return novi entitet tipa Raspored
     * @throws SQLException ako dođe do greške prilikom obrade ResultSet-a
     */
    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new Raspored(Integer.parseInt(rs.getString("r.raspored_id")), (TreningGrupa) grupa.getEntity(rs), new java.util.Date(rs.getDate("r.datum_od").getTime()), new java.util.Date(rs.getDate("r.datum_do").getTime()), (TipTreninga) tipTreninga.getEntity(rs));
    }

    /**
     * Vraća ID objekta.
     *
     * @return ID objekta kao long
     */
    @Override
    public long getObjID() {
        return rasporedId;
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
     * Vraća alias koji se koristi u SQL upitima.
     *
     * @return alias kao String
     */
    @Override
    public String getAlijas() {
        return "r";
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
