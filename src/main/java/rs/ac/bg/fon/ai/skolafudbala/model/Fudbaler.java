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
 * Predstavlja fudbalera u školi fudbala.
 *
 * Fudbaler ima ID, ime, prezime, JMBG, poziciju, trening grupu i datum rođenja.
 * Implementira interfejs GenerickiEntitet za rad sa bazom podataka.
 *
 * @autor Aleksa Stancic
 */
public class Fudbaler implements GenerickiEntitet {

    /**
     * ID fudbalera tipa long
     */
    @SerializedName("ID FUDBALERA: ")
    private long fudbalerId;

    /**
     * Ime fudbalera kao String
     */
    @SerializedName("IME FUDBALERA: ")
    private String ime;

    /**
     * Prezime fudbalera kao String
     */
    @SerializedName("PREZIME FUDBALERA: ")
    private String prezime;

    /**
     * JMBG fudbalera kao String
     */
    @SerializedName("JMBG FUDBALERA: ")
    private String jmbg;

    /**
     * Pozicija fudbalera kao String
     */
    @SerializedName("POZICIJA FUDBALERA: ")
    private String pozicija;

    /**
     * Trening grupa kojoj fudbaler pripada, tipa TreningGrupa
     */
    @SerializedName("TRENING GRUPA FUDBALERA: ")
    private TreningGrupa treningGrupa = new TreningGrupa();

    /**
     * Datum rođenja fudbalera tipa Date
     */
    @SerializedName("DATUM RODJENJA FUDBALERA: ")
    private Date datumRodjenja;

    /**
     * Pravi nov objekat klase Fudbaler.
     *
     * ID, ime, prezime, JMBG, pozicija i datum rođenja ostaju
     * neinicijalizovani. Trening grupa se inicijalizuje.
     */
    public Fudbaler() {
    }

    /**
     * Pravi nov objekat klase Fudbaler i postavlja sve atribute na unete
     * vrednosti.
     *
     * @param fudbalerId ID fudbalera kao long
     * @param ime ime fudbalera kao String
     * @param prezime prezime fudbalera kao String
     * @param jmbg JMBG fudbalera kao String
     * @param pozicija pozicija fudbalera kao String
     * @param treningGrupa trening grupa kojoj fudbaler pripada kao TreningGrupa
     * @param datumRodjenja datum rođenja fudbalera kao Date
     */
    public Fudbaler(long fudbalerId, String ime, String prezime, String jmbg, String pozicija, TreningGrupa treningGrupa, Date datumRodjenja) {
        this.fudbalerId = fudbalerId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.pozicija = pozicija;
        this.treningGrupa = treningGrupa;
        this.datumRodjenja = datumRodjenja;
    }

    /**
     * Pravi nov objekat klase Fudbaler bez ID-ja i postavlja sve atribute na
     * unete vrednosti.
     *
     * @param ime ime fudbalera kao String
     * @param prezime prezime fudbalera kao String
     * @param jmbg JMBG fudbalera kao String
     * @param pozicija pozicija fudbalera kao String
     * @param treningGrupa trening grupa kojoj fudbaler pripada kao TreningGrupa
     * @param datumRodjenja datum rođenja fudbalera kao Date
     */
    public Fudbaler(String ime, String prezime, String jmbg, String pozicija, TreningGrupa treningGrupa, Date datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.pozicija = pozicija;
        this.treningGrupa = treningGrupa;
        this.datumRodjenja = datumRodjenja;
    }

    /**
     * Vraca ID fudbalera.
     *
     * @return trenutno ID fudbalera kao long
     */
    public long getFudbalerId() {
        return fudbalerId;
    }

    /**
     * Vraca ime fudbalera.
     *
     * @return trenutno ime fudbalera kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Vraca prezime fudbalera.
     *
     * @return trenutno prezime fudbalera kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Vraca JMBG fudbalera.
     *
     * @return trenutno JMBG fudbalera kao String
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * Vraca poziciju fudbalera.
     *
     * @return trenutna pozicija fudbalera kao String
     */
    public String getPozicija() {
        return pozicija;
    }

    /**
     * Vraca trening grupu fudbalera.
     *
     * @return trenutna trening grupa fudbalera kao TreningGrupa
     */
    public TreningGrupa getTreningGrupa() {
        return treningGrupa;
    }

    /**
     * Postavlja ID fudbalera na unetu vrednost.
     *
     * @param fudbalerId ID fudbalera kao long
     */
    public void setFudbalerId(int fudbalerId) {
        this.fudbalerId = fudbalerId;
    }

    /**
     * Postavlja ime fudbalera na unetu vrednost.
     *
     * Uneto ime ne sme biti null niti sadržati karaktere koji nisu slova. Prvo
     * slovo mora biti veliko.
     *
     * @param ime ime fudbalera kao String
     *
     * @throws java.lang.NullPointerException ako je uneto ime null
     * @throws java.lang.IllegalArgumentException ako ime sadrži karaktere koji
     * nisu slova ili prvo slovo nije veliko
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
     * Postavlja prezime fudbalera na unetu vrednost.
     *
     * Uneto prezime ne sme biti null niti sadržati karaktere koja nisu slova.
     * Prvo slovo mora biti veliko.
     *
     * @param prezime prezime fudbalera kao String
     *
     * @throws java.lang.NullPointerException ako je uneto prezime null
     * @throws java.lang.IllegalArgumentException ako prezime sadrži karaktere
     * koja nisu slova ili prvo slovo nije veliko
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
     * Postavlja JMBG fudbalera na unetu vrednost.
     *
     * Uneti JMBG ne sme biti null, mora sadržati samo cifre i mora imati tačno
     * 13 cifara.
     *
     * @param jmbg JMBG fudbalera kao String
     *
     * @throws java.lang.NullPointerException ako je uneti JMBG null
     * @throws java.lang.IllegalArgumentException ako JMBG sadrži karaktere osim
     * cifara ili nema tačno 13 cifara
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
     * Postavlja poziciju fudbalera na unetu vrednost.
     *
     * Uneta pozicija ne sme biti null.
     *
     * @param pozicija pozicija fudbalera kao String
     *
     * @throws java.lang.NullPointerException ako je uneta pozicija null
     */
    public void setPozicija(String pozicija) {
        if (pozicija == null) {
            throw new NullPointerException("Pozicija ne smije da bude null!");
        }
        this.pozicija = pozicija;
    }

    /**
     * Postavlja trening grupu fudbalera na unetu vrednost.
     *
     * Uneta trening grupa ne sme biti null.
     *
     * @param treningGrupa trening grupa kao TreningGrupa
     *
     * @throws java.lang.NullPointerException ako je uneta trening grupa null
     */
    public void setTreningGrupa(TreningGrupa treningGrupa) {
        if (treningGrupa == null) {
            throw new NullPointerException("Trening grupa ne smije da bude null!");
        }
        this.treningGrupa = treningGrupa;
    }

    /**
     * Vraca datum rođenja fudbalera.
     *
     * @return datum rođenja fudbalera kao Date
     */
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Postavlja datum rođenja fudbalera na unetu vrednost.
     *
     * Uneti datum ne sme biti null i mora biti u prošlosti.
     *
     * @param datumRodjenja datum rođenja fudbalera kao Date
     *
     * @throws java.lang.NullPointerException ako je uneti datum rođenja null
     * @throws java.lang.IllegalArgumentException ako datum rođenja nije u
     * prošlosti
     */
    public void setDatumRodjenja(Date datumRodjenja) {
        if (datumRodjenja == null) {
            throw new NullPointerException("Datum rodjenja ne smije da bude null!");
        }
        if (!datumRodjenja.before(new Date())) {
            throw new IllegalArgumentException("Datum rodjenja mora da bude datum u proslosti!");
        }
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.fudbalerId ^ (this.fudbalerId >>> 32));
        hash = 79 * hash + Objects.hashCode(this.ime);
        hash = 79 * hash + Objects.hashCode(this.prezime);
        hash = 79 * hash + Objects.hashCode(this.jmbg);
        hash = 79 * hash + Objects.hashCode(this.pozicija);
        hash = 79 * hash + Objects.hashCode(this.treningGrupa);
        hash = 79 * hash + Objects.hashCode(this.datumRodjenja);
        return hash;
    }

    /**
     * Poredi dva fudbalera prema imenu i prezimenu.
     *
     * @param obj Drugi fudbaler sa kojim se poredi
     *
     * @return
     * <ul>
     * <li><b>true</b> - ako su oba objekta inicijalizovana, klase su Fudbaler i
     * imaju isto ime i prezime</li>
     * <li><b>false</b> - ako nisu klase Fudbaler, ako je uneti fudbaler null
     * ili ako nije isto ime ili prezime</li>
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
        final Fudbaler other = (Fudbaler) obj;
        if (this.fudbalerId != other.fudbalerId) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.jmbg, other.jmbg)) {
            return false;
        }
        if (!Objects.equals(this.pozicija, other.pozicija)) {
            return false;
        }

        return Objects.equals(this.datumRodjenja, other.datumRodjenja);
    }

    @Override
    public String toString() {
        if (treningGrupa != null) {
            return ime + " " + prezime + "(" + treningGrupa.getNazivGrupe() + ")" + " - " + pozicija;
        } else {
            return ime + " " + prezime + " - " + pozicija;

        }
    }

    /**
     * Vraća naziv tabele u bazi podataka koja odgovara ovom entitetu.
     *
     * @return naziv tabele kao String
     */
    @Override
    public String getTableName() {
        return "fudbaler";
    }

    /**
     * Vraća imena kolona za unos novog fudbalera u bazu podataka.
     *
     * @return imena kolona kao String
     */
    @Override
    public String getInsertColumns() {
        return "fudbaler_id,ime,prezime,jmbg,pozicija,datum_rodjenja,grupa_id";
    }

    /**
     * Vraća vrednosti atributa za unos novog fudbalera u bazu podataka.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String getInsertValues() {
        return "'" + fudbalerId + "','" + ime + "','" + prezime + "','" + jmbg + "','" + pozicija + "','" + new java.sql.Date(datumRodjenja.getTime()) + "','" + treningGrupa.getGrupaId() + "'";

    }

    /**
     * Postavlja ID entiteta na unetu vrednost.
     *
     * @param id ID entiteta kao long
     */
    @Override
    public void setId(long id) {
        fudbalerId = id;
    }

    /**
     * Vraća vrednosti atributa za ažuriranje postojećeg fudbalera u bazi
     * podataka.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String getUpdateValues() {
        return "ime = '" + ime + "' , prezime= '" + prezime + "', jmbg= '" + jmbg + "', pozicija= '" + pozicija + "'" + ", datum_rodjenja= '" + new java.sql.Date(datumRodjenja.getTime()) + "', grupa_id= '" + treningGrupa.getObjID() + "'";
    }

    /**
     * Vraća SQL kod za JOIN sa drugim tabelama u SQL upitu.
     *
     * @return SQL kod za JOIN kao String
     */
    @Override
    public String getJoinText() {
        return "JOIN trening_grupa tg ON f.grupa_id=tg.grupa_id JOIN trener t ON tg.trener_id=t.trener_id";

    }

    /**
     * Vraća selekcioni tekst za SQL upit.
     *
     * @return selekcioni tekst kao String
     */
    @Override
    public String getSelectedText() {
        return "";
    }

    /**
     * Vraća ime kolone koja predstavlja ID u tabeli baze podataka.
     *
     * @return ime kolone kao String
     */
    @Override
    public String getID() {
        return "fudbaler_id";
    }

    /**
     * Kreira i vraća entitet na osnovu rezultata SQL upita.
     *
     * @param rs rezultat SQL upita kao ResultSet
     * @return generički entitet kao GenerickiEntitet
     * @throws SQLException ako dođe do greške pri čitanju rezultata SQL upita
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new Fudbaler(rs.getInt("f.fudbaler_id"), rs.getString("f.ime"), rs.getString("f.prezime"),
                rs.getString("f.jmbg"), rs.getString("f.pozicija"), (TreningGrupa) treningGrupa.getEntity(rs),
                new java.util.Date(rs.getDate("f.datum_rodjenja").getTime()));
    }

    /**
     * Kreira i vraća entitet na osnovu rezultata SQL upita sa pridruženim
     * tabelama.
     *
     * @param rs rezultat SQL upita kao ResultSet
     * @return generički entitet kao GenerickiEntitet
     * @throws SQLException ako dođe do greške pri čitanju rezultata SQL upita
     */
    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new Fudbaler(rs.getInt("f.fudbaler_id"), rs.getString("f.ime"), rs.getString("f.prezime"),
                rs.getString("f.jmbg"), rs.getString("f.pozicija"), (TreningGrupa) treningGrupa.getEntity(rs),
                new java.util.Date(rs.getDate("f.datum_rodjenja").getTime()));
    }

    /**
     * Vraća ID entiteta.
     *
     * @return ID entiteta kao long
     */
    @Override
    public long getObjID() {
        return fudbalerId;
    }

    /**
     * Vraća uslove za WHERE klauzulu u SQL upitu sa dva parametra.
     *
     * @return uslovi za WHERE klauzulu kao String
     */
    @Override
    public String getWhereDvaParametra() {
        System.out.println("aaa");
        System.out.println(getIme().equals(""));
        System.out.println(getJmbg().equals(""));
        System.out.println(treningGrupa.getObjID() == -1);
        if (getIme().equals("") && getJmbg().equals("") && getTreningGrupa().getObjID() == -1) {
            return getAlijas() + ".jmbg LIKE " + "'%'";
        }
        if ((getIme() == null || getIme().equals("")) && getTreningGrupa().getObjID() == -1) {
            return getAlijas() + ".jmbg LIKE " + "'" + getJmbg() + "%'";
        } else if ((getJmbg() == null || getJmbg().equals("")) && getTreningGrupa().getObjID() == -1) {
            return getAlijas() + ".ime LIKE " + "'" + getIme() + "%'";
        } else if (getTreningGrupa().getObjID() == -1) {
            return getAlijas() + ".ime LIKE " + "'" + getIme() + "%' AND " + getAlijas() + ".jmbg LIKE " + "'" + getJmbg() + "%'";
        } else if (getIme() == null || getIme().equals("")) {
            return getAlijas() + ".jmbg LIKE " + "'" + getJmbg() + "%' AND "
                    + getAlijas() + ".grupa_id = " + "" + getTreningGrupa().getGrupaId() + "";
        } else if (getJmbg() == null || getJmbg().equals("")) {
            return getAlijas() + ".ime LIKE " + "'" + getIme() + "%' AND " + getAlijas() + ".grupa_id = " + "" + getTreningGrupa().getGrupaId() + "";
        }

        return getAlijas() + ".ime LIKE " + "'" + getIme() + "%' AND " + getAlijas() + ".jmbg LIKE " + "'" + getJmbg() + "%' AND "
                + getAlijas() + ".grupa_id = " + "" + getTreningGrupa().getGrupaId() + "";
    }

    /**
     * Vraća alijas koji se koristi za ovu tabelu u SQL upitima.
     *
     * @return alijas kao String
     */
    @Override
    public String getAlijas() {
        return "f";
    }

    /**
     * Vraća WHERE klauzulu za SQL upit sa jednim parametrom.
     *
     * @return WHERE klauzula kao String
     */
    @Override
    public String getWhere() {
        return "WHERE " + getAlijas() + "." + getID() + "=";
    }

}
