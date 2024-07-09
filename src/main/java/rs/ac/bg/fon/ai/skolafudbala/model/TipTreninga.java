/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Predstavlja tip treninga u školi fudbala. Svaki tip treninga ima jedinstveni
 * ID i naziv. Implementira interfejs GenerickiEntitet koji definiše osnovne
 * metode za rad sa entitetima u bazi podataka.
 *
 * @autor Aleksa Stancic
 */
public class TipTreninga implements GenerickiEntitet {

    /**
     * Jedinstveni identifikator tipa treninga tipa long.
     */
    private long tipId;
    /**
     * Naziv tipa treninga kao String.
     */
    private String nazivTipa;

    /**
     * Pravi nov objekat klase TipTreninga.
     *
     * ID, nazivTipa ostaju neinicijalizovani.
     */
    public TipTreninga() {
    }

    /**
     * Konstruktor koji postavlja naziv tipa treninga na unetu vrednost.
     *
     * @param nazivTipa naziv tipa treninga kao String
     */
    public TipTreninga(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }

    /**
     * Konstruktor koji postavlja ID i naziv tipa treninga na unete vrednosti.
     *
     * @param tipId ID tipa treninga kao long
     * @param nazivTipa naziv tipa treninga kao String
     */
    public TipTreninga(long tipId, String nazivTipa) {
        this.tipId = tipId;
        this.nazivTipa = nazivTipa;
    }

    /**
     * Vraća ID tipa treninga.
     *
     * @return ID tipa treninga kao long
     */
    public long getTipId() {
        return tipId;
    }

    /**
     * Postavlja ID tipa treninga.
     *
     * @param tipId ID tipa treninga kao long
     */
    public void setTipId(long tipId) {
        this.tipId = tipId;
    }

    /**
     * Vraća naziv tipa treninga.
     *
     * @return naziv tipa treninga kao String
     */
    public String getNazivTipa() {
        return nazivTipa;
    }

    /**
     * Postavlja naziv tipa treninga.
     *
     * @param nazivTipa naziv tipa treninga kao String
     * @throws NullPointerException ako je naziv tipa treninga null
     */
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

    /**
     * Poredi dva objekta tipa TipTreninga.
     *
     * @param obj objekat sa kojim se poredi
     * @return
     * <ul>
     * <li><b>true</b> - ako su oba objekta inicijalizovana, klase su
     * TipTreninga i imaju isti ID i naziv tipa</li>
     * <li><b>false</b> - ako nisu klase TipTreninga, ako je drugi objekat null
     * ili ako ID ili naziv tipa nisu jednaki</li>
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

    /**
     * Vraća string reprezentaciju naziva tipa treninga.
     *
     * @return naziv tipa treninga kao String
     */
    @Override
    public String getTableName() {
        return "tip_treninga";
    }

    /**
     * Vraća nazive kolona za unos podataka u tabelu.
     *
     * @return nazivi kolona za unos kao String
     */
    @Override
    public String getInsertColumns() {
        return "tip_id,naziv_tipa";
    }

    /**
     * Vraća vrednosti za unos u tabelu.
     *
     * @return vrednosti za unos kao String
     */
    @Override
    public String getInsertValues() {
        return "'" + tipId + "','" + nazivTipa + "'";
    }

    /**
     * Postavlja ID objekta.
     *
     * @param id ID objekta kao long
     */
    @Override
    public void setId(long id) {
        this.tipId = id;
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
     * Vraća tekst za spajanje tabela.
     *
     * @return tekst za spajanje tabela
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
     * Vraća naziv ID kolone u tabeli.
     *
     * @return naziv ID kolone kao String
     */
    @Override
    public String getID() {
        return "tip_id";
    }

    /**
     * Kreira i vraća entitet na osnovu rezultata iz baze podataka.
     *
     * @param rs rezultat iz baze podataka kao ResultSet
     * @return entitet kreiran na osnovu rezultata iz baze podataka
     * @throws SQLException ako dođe do greške pri radu sa bazom podataka
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new TipTreninga(Integer.parseInt(rs.getString("tt.tip_id")), rs.getString("tt.naziv_tipa"));
    }

    /**
     * Kreira i vraća entitet za spajanje(JOIN) tabela na osnovu rezultata iz
     * baze podataka.
     *
     * @param rs rezultat iz baze podataka tipa ResultSet
     * @return entitet za spajanje tabela kreiran na osnovu rezultata iz baze
     * podataka
     * @throws SQLException ako dođe do greške pri radu sa bazom podataka
     */
    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new TipTreninga(rs.getInt(getAlijas() + ".tip_id"), rs.getString(getAlijas() + ".naziv_tipa"));
    }

    /**
     * Vraća ID objekta.
     *
     * @return ID objekta kao long
     */
    @Override
    public long getObjID() {
        return tipId;
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
     * Vraća alijas tabele.
     *
     * @return alijas tabele kao String
     */
    @Override
    public String getAlijas() {
        return "tt";
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
