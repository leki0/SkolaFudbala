/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class TreningGrupa implements GenerickiEntitet {

    private long grupaId;
    private String nazivGrupe;
    private int kapacitet;
    private Trener trener = new Trener();
    private List<Raspored> listaRasporeda = new ArrayList<>();

    public TreningGrupa() {
    }

    public TreningGrupa(long grupaId, String nazivGrupe, int kapacitet, Trener trener, List<Raspored> listaRasporeda) {
        this.grupaId = grupaId;
        this.nazivGrupe = nazivGrupe;
        this.kapacitet = kapacitet;
        this.trener = trener;
        this.listaRasporeda = listaRasporeda;
    }

    public TreningGrupa(String nazivGrupe, int kapacitet, Trener trener, List<Raspored> listaRasporeda) {
        this.nazivGrupe = nazivGrupe;
        this.kapacitet = kapacitet;
        this.trener = trener;
        this.listaRasporeda = listaRasporeda;
    }

    public TreningGrupa(long grupaId, String nazivGrupe, int kapacitet, Trener trener) {
        this.grupaId = grupaId;
        this.nazivGrupe = nazivGrupe;
        this.kapacitet = kapacitet;
        this.trener = trener;
        this.listaRasporeda = listaRasporeda;
    }

    public long getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(int grupaId) {
        this.grupaId = grupaId;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public List<Raspored> getListaRasporeda() {
        return listaRasporeda;
    }

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

    @Override
    public String getTableName() {
        return "trening_grupa";
    }

    @Override
    public String getInsertColumns() {
        return "grupa_id,naziv_grupe,kapacitet,trener_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + grupaId + "','" + nazivGrupe + "','" + kapacitet + "','" + trener.getTrenerId() + "'";
    }

    @Override
    public void setId(long id) {
        this.grupaId = id;
    }

    @Override
    public String getUpdateValues() {
        return "naziv_grupe='" + nazivGrupe + "',kapacitet=" + kapacitet + ",trener_id=" + trener.getObjID();
    }

    @Override
    public String getJoinText() {
        return "JOIN trener t ON tg.trener_id=t.trener_id";
    }

    @Override
    public String getSelectedText() {
        return "";
    }

    @Override
    public String getID() {
        return "grupa_id";
    }

    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new TreningGrupa(rs.getInt(getAlijas() + ".grupa_id"), rs.getString(getAlijas() + 
                ".naziv_grupe"), rs.getInt(getAlijas() + ".kapacitet"), (Trener) trener.getEntity(rs));
    }

    @Override
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
        return new TreningGrupa(rs.getInt("tg2.grupa_id"), rs.getString("tg2.naziv_grupe"), 
                rs.getInt("tg2.kapacitet"), (Trener) trener.getJoinEntity(rs));
    }

    @Override
    public long getObjID() {
        return grupaId;
    }

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

    @Override
    public String getAlijas() {
        return "tg";
    }

    @Override
    public String getWhere() {
        return "WHERE " + getAlijas() + "." + getID() + "=";
    }

}
