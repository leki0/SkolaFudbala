/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import com.google.gson.annotations.SerializedName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja trening grupu u školi fudbala. Svaka trening grupa ima
 * jedinstveni ID, naziv grupe, kapacitet, trenera i listu rasporeda.
 * Implementira interfejs GenerickiEntitet koji definiše osnovne metode za rad
 * sa entitetima u bazi podataka.
 *
 * @author Aleksa Stancic
 */
public class TreningGrupa implements GenerickiEntitet {

    /**
     * ID trening grupe kao long.
     */
    @SerializedName("ID TRENING GRUPE: ")
    private long grupaId;

    /**
     * Naziv trening grupe kao String.
     */
    @SerializedName("NAZIV TRENING GRUPE: ")
    private String nazivGrupe;

    /**
     * Kapacitet trening grupe kao int.
     */
    @SerializedName("KAPACITET TRENING GRUPE: ")
    private int kapacitet;

    /**
     * Trener koji vodi trening grupu.
     */
    @SerializedName("TRENER: ")
    private Trener trener = new Trener();

    /**
     * Lista rasporeda za trening grupu.
     */
    @SerializedName("LISTA RASPOREDA: ")
    private List<Raspored> listaRasporeda = new ArrayList<>();

    /**
     * Pravi nov objekat klase Trener.
     *
     * ID, naziv grupe, kapacitet ostaju neinicijalizovani, dok se trener i
     * listaRasporeda inicijalizuju na default.
     */
    public TreningGrupa() {
    }

    /**
     * ID, naziv grupe, kapacitet, trener, lista rasporeda se inicijalizuju na
     * unete vrednosti.
     *
     * @param grupaId jedinstveni identifikator trening grupe
     * @param nazivGrupe naziv trening grupe
     * @param kapacitet kapacitet trening grupe
     * @param trener trener koji vodi trening grupu
     * @param listaRasporeda lista rasporeda za trening grupu
     */
    public TreningGrupa(long grupaId, String nazivGrupe, int kapacitet, Trener trener, List<Raspored> listaRasporeda) {
        this.grupaId = grupaId;
        this.nazivGrupe = nazivGrupe;
        this.kapacitet = kapacitet;
        this.trener = trener;
        this.listaRasporeda = listaRasporeda;
    }

    /**
     * naziv grupe, kapacitet, trener, lista rasporeda se inicijalizuju na unete
     * vrednosti.
     *
     * @param nazivGrupe naziv trening grupe
     * @param kapacitet kapacitet trening grupe
     * @param trener trener koji vodi trening grupu
     * @param listaRasporeda lista rasporeda za trening grupu
     */
    public TreningGrupa(String nazivGrupe, int kapacitet, Trener trener, List<Raspored> listaRasporeda) {
        this.nazivGrupe = nazivGrupe;
        this.kapacitet = kapacitet;
        this.trener = trener;
        this.listaRasporeda = listaRasporeda;
    }

    /**
     * ID, naziv grupe, kapacitet, trener se inicijalizuju na unete vrednosti.
     *
     * @param grupaId jedinstveni identifikator trening grupe
     * @param nazivGrupe naziv trening grupe
     * @param kapacitet kapacitet trening grupe
     * @param trener trener koji vodi trening grupu
     */
    public TreningGrupa(long grupaId, String nazivGrupe, int kapacitet, Trener trener) {
        this.grupaId = grupaId;
        this.nazivGrupe = nazivGrupe;
        this.kapacitet = kapacitet;
        this.trener = trener;
        this.listaRasporeda = listaRasporeda;
    }

    /**
     * Vraća jedinstveni identifikator trening grupe.
     *
     * @return jedinstveni identifikator trening grupe
     */
    public long getGrupaId() {
        return grupaId;
    }

    /**
     * Postavlja jedinstveni identifikator trening grupe.
     *
     * @param grupaId jedinstveni identifikator trening grupe
     */
    public void setGrupaId(int grupaId) {
        this.grupaId = grupaId;
    }

    /**
     * Vraća naziv trening grupe.
     *
     * @return naziv trening grupe kao String
     */
    public String getNazivGrupe() {
        return nazivGrupe;
    }

    /**
     * Postavlja naziv trening grupe.
     *
     * @param nazivGrupe naziv trening grupe
     * @throws NullPointerException ako je naziv grupe null
     * @throws IllegalArgumentException ako naziv grupe nije validan (mora da
     * sadrži samo slova)
     */
    public void setNazivGrupe(String nazivGrupe) {
        if (nazivGrupe == null) {
            throw new NullPointerException("Naziv grupe ne smije da bude null!");

        }
        if (!nazivGrupe.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Naziv grupe ne smije da sadrzi brojeve!");
        }
        this.nazivGrupe = nazivGrupe;
    }

    /**
     * Vraća kapacitet trening grupe.
     *
     * @return kapacitet trening grupe
     */
    public int getKapacitet() {
        return kapacitet;
    }

    /**
     * Postavlja kapacitet trening grupe.
     *
     * @param kapacitet kapacitet trening grupe
     * @throws IllegalArgumentException ako kapacitet nije pozitivan broj
     */
    public void setKapacitet(int kapacitet) {
        if (kapacitet < 0) {
            throw new IllegalArgumentException("Kapacitet ne smije da bude negativan!");

        }
        this.kapacitet = kapacitet;
    }

    /**
     * Vraća trenera koji vodi trening grupu.
     *
     * @return trener koji vodi trening grupu
     */
    public Trener getTrener() {
        return trener;
    }

    /**
     * Postavlja trenera koji vodi trening grupu.
     *
     * @param trener trener koji vodi trening grupu
     */
    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    /**
     * Vraća listu rasporeda za trening grupu.
     *
     * @return lista rasporeda za trening grupu
     */
    public List<Raspored> getListaRasporeda() {
        return listaRasporeda;
    }

    /**
     * Postavlja listu rasporeda za trening grupu.
     *
     * @param listaRasporeda lista rasporeda za trening grupu
     */
    public void setListaRasporeda(List<Raspored> listaRasporeda) {
        this.listaRasporeda = listaRasporeda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (this.grupaId ^ (this.grupaId >>> 32));
        hash = 43 * hash + Objects.hashCode(this.nazivGrupe);
        hash = 43 * hash + this.kapacitet;
        hash = 43 * hash + Objects.hashCode(this.trener);
        return hash;
    }

    /**
     * Poredi dva objekta tipa TreningGrupa.
     *
     * @param obj objekat sa kojim se poredi
     * @return
     * <ul>
     * <li><b>true</b> - ako su oba objekta inicijalizovana, klase su
     * TreningGrupa i imaju isti ID, naziv grupe, kapacitet i trener</li>
     * <li><b>false</b> - ako nisu klase TreningGrupa, ako je drugi objekat null
     * ili ako atributi nisu jednaki</li>
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
        final TreningGrupa other = (TreningGrupa) obj;
        if (this.grupaId != other.grupaId) {
            return false;
        }
        if (this.kapacitet != other.kapacitet) {
            return false;
        }
        if (!Objects.equals(this.nazivGrupe, other.nazivGrupe)) {
            return false;
        }
        return Objects.equals(this.trener, other.trener);
    }

    @Override
    public String toString() {
        return nazivGrupe;
    }

    /**
     * Vraća naziv tabele u bazi podataka za entitet TreningGrupa.
     *
     * @return naziv tabele kao String
     */
    @Override
    public String getTableName() {
        return "trening_grupa";
    }

    /**
     * Vraća nazive kolona u bazi podataka za INSERT upit za entitet
     * TreningGrupa.
     *
     * @return nazivi kolona za INSERT kao String
     */
    @Override
    public String getInsertColumns() {
        return "grupa_id,naziv_grupe,kapacitet,trener_id";
    }

    /**
     * Vraća vrednosti koje se ubacuju u bazu podataka za INSERT upit za entitet
     * TreningGrupa.
     *
     * @return vrednosti za INSERT kao String
     */
    @Override
    public String getInsertValues() {
        return "'" + grupaId + "','" + nazivGrupe + "','" + kapacitet + "','" + trener.getTrenerId() + "'";
    }

    /**
     * Postavlja ID trening grupe.
     *
     * @param id ID trening grupe kao long
     */
    @Override
    public void setId(long id) {
        this.grupaId = id;
    }

    /**
     * Vraća vrednosti koje se ažuriraju u bazi podataka za UPDATE upit za
     * entitet TreningGrupa.
     *
     * @return vrednosti za UPDATE kao String
     */
    @Override
    public String getUpdateValues() {
        return "naziv_grupe='" + nazivGrupe + "',kapacitet=" + kapacitet + ",trener_id=" + trener.getObjID();
    }

    /**
     * Vraća tekst za JOIN u SQL upitu sa tabelom Trener.
     *
     * @return tekst za JOIN kao String
     */
    @Override
    public String getJoinText() {
        return "JOIN trener t ON tg.trener_id=t.trener_id";
    }

    /**
     * Vraća tekst za SELECT u SQL upitu.
     *
     * @return tekst za SELECT u SQL upitu kao String
     */
    @Override
    public String getSelectedText() {
        return "";
    }

    /**
     * Vraća naziv ID kolone za entitet TreningGrupa.
     *
     * @return naziv ID kolone kao String
     */
    @Override
    public String getID() {
        return "grupa_id";
    }

    /**
     * Kreira novi entitet TreningGrupa na osnovu rezultata upita iz baze
     * podataka.
     *
     * @param rs rezultat upita iz baze podataka kao ResultSet
     * @return novi entitet TreningGrupa
     * @throws SQLException ako dođe do greške prilikom čitanja rezultata iz
     * baze
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new TreningGrupa(rs.getInt(getAlijas() + ".grupa_id"), rs.getString(getAlijas()
                + ".naziv_grupe"), rs.getInt(getAlijas() + ".kapacitet"), (Trener) trener.getEntity(rs));
    }

    /**
     * Kreira novi entitet TreningGrupa na osnovu rezultata JOIN upita iz baze
     * podataka.
     *
     * @param rs rezultat JOIN upita iz baze podataka kao ResultSet
     * @return novi entitet TreningGrupa
     * @throws SQLException ako dođe do greške prilikom čitanja rezultata iz
     * baze
     */
    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new TreningGrupa(rs.getInt("tg2.grupa_id"), rs.getString("tg2.naziv_grupe"),
                rs.getInt("tg2.kapacitet"), (Trener) trener.getJoinEntity(rs));
    }

    /**
     * Vraća jedinstveni ID objekta TreningGrupa.
     *
     * @return jedinstveni ID kao long
     */
    @Override
    public long getObjID() {
        return grupaId;
    }

    /**
     * Vraća deo WHERE uslova za SQL upit sa dva parametra (naziv grupe i ID
     * trenera).
     *
     * @return deo WHERE uslova sa dva parametra kao String
     */
    @Override
    public String getWhereDvaParametra() {

        if ((getNazivGrupe() == null || getNazivGrupe().equals("")) && getTrener().getObjID() == -1) {
            return getAlijas() + ".naziv_grupe LIKE " + "'%'";
        } else if (getNazivGrupe() == null || getNazivGrupe().equals("")) {
            return getAlijas() + ".trener_id=" + getTrener().getObjID();
        } else if (getTrener() == null || getTrener().getObjID() == -1) {
            return getAlijas() + ".naziv_grupe LIKE " + "'" + getNazivGrupe() + "%'";
        }
        return getAlijas() + ".naziv_grupe LIKE " + "'" + getNazivGrupe() + "%' AND " + getAlijas() + ".trener_id =" + getTrener().getObjID();
    }

    /**
     * Vraća alias za entitet TreningGrupa.
     *
     * @return alias
     */
    @Override
    public String getAlijas() {
        return "tg";
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
