

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
public class Fudbaler implements GenerickiEntitet {

    private long fudbalerId;
    private String ime;
    private String prezime;
    private String jmbg;
    private String pozicija;
    private TreningGrupa treningGrupa = new TreningGrupa();
    private Date datumRodjenja;

    public Fudbaler() {
    }

    public Fudbaler(long fudbalerId, String ime, String prezime, String jmbg, String pozicija, TreningGrupa treningGrupa, Date datumRodjenja) {
        this.fudbalerId = fudbalerId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.pozicija = pozicija;
        this.treningGrupa = treningGrupa;
        this.datumRodjenja = datumRodjenja;
    }

    public Fudbaler(String ime, String prezime, String jmbg, String pozicija, TreningGrupa treningGrupa, Date datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.pozicija = pozicija;
        this.treningGrupa = treningGrupa;
        this.datumRodjenja = datumRodjenja;
    }

    public long getFudbalerId() {
        return fudbalerId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getPozicija() {
        return pozicija;
    }

    public TreningGrupa getTreningGrupa() {
        return treningGrupa;
    }

    public void setFudbalerId(int fudbalerId) {
        this.fudbalerId = fudbalerId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public void setTreningGrupa(TreningGrupa treningGrupa) {
        this.treningGrupa = treningGrupa;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
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

    @Override
    public String getTableName() {
        return "fudbaler";
    }

    @Override
    public String getInsertColumns() {
        return "fudbaler_id,ime,prezime,jmbg,pozicija,datum_rodjenja,grupa_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + fudbalerId + "','" + ime + "','" + prezime + "','" + jmbg + "','" + pozicija + "','" + new java.sql.Date(datumRodjenja.getTime()) + "','" + treningGrupa.getGrupaId() + "'";

    }

    @Override
    public void setId(long id) {
        fudbalerId = id;
    }

    @Override
    public String getUpdateValues() {
        return "ime = '" + ime + "' , prezime= '" + prezime + "', jmbg= '" + jmbg + "', pozicija= '" + pozicija + "'" + ", datum_rodjenja= '" + new java.sql.Date(datumRodjenja.getTime()) + "', grupa_id= '" + treningGrupa.getObjID() + "'";
    }

    @Override
    public String getJoinText() {
        return "JOIN trening_grupa tg ON f.grupa_id=tg.grupa_id JOIN trener t ON tg.trener_id=t.trener_id";

    }

    @Override
    public String getSelectedText() {
        return "";
    }

    @Override
    public String getID() {
        return "fudbaler_id";
    }

    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new Fudbaler(rs.getInt("f.fudbaler_id"), rs.getString("f.ime"), rs.getString("f.prezime"),
                rs.getString("f.jmbg"), rs.getString("f.pozicija"), (TreningGrupa) treningGrupa.getEntity(rs),
                new java.util.Date(rs.getDate("f.datum_rodjenja").getTime()));
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new Fudbaler(rs.getInt("f.fudbaler_id"), rs.getString("f.ime"), rs.getString("f.prezime"),
                rs.getString("f.jmbg"), rs.getString("f.pozicija"), (TreningGrupa) treningGrupa.getEntity(rs), 
                new java.util.Date(rs.getDate("f.datum_rodjenja").getTime()));
    }

    @Override
    public long getObjID() {
        return fudbalerId;
    }

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

    @Override
    public String getAlijas() {
        return "f";
    }

    @Override
    public String getWhere() {
        return "WHERE " + getAlijas() + "." + getID() + "=";
    }

}
