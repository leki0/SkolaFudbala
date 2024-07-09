/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja entitet trening utakmice u sistemima za vođenje fudbalske škole.
 * Sadrži informacije o identifikatoru utakmice, rednom broju, datumu
 * održavanja, broju golova za svaki tim, kao i timovima koji učestvuju i
 * statistici fudbalera. Implementira interfejs GenerickiEntitet.
 *
 * @author Aleksa Stancic
 */
public class TreningUtakmica implements GenerickiEntitet {

    /**
     * ID utakmice kao long.
     */
    private long treningUtakmicaId;

    /**
     * Redni broj utakmice kao int.
     */
    private int redniBroj;

    /**
     * Datum održavanja utakmice.
     */
    private Date datum;

    /**
     * Broj golova postignutih od strane tima 1 kao int.
     */
    private int brojGolovaTim1;

    /**
     * Broj golova postignutih od strane tima 2 kao int.
     */
    private int brojGolovaTikm2;

    /**
     * Prvi tim koji učestvuje na utakmici
     */
    private TreningGrupa tim1 = new TreningGrupa();

    /**
     * Drugi tim koji učestvuje na utakmici.
     */
    private TreningGrupa tim2 = new TreningGrupa();

    /**
     * Lista statistika fudbalera koji su učestvovali na utakmici.
     */
    private List<StatistikaFudbalera> listaStatistika;

    /**
     * Pravi nov objekat klase TreningUtakmica.
     *
     * ID, redni broj, datum, bro golova tim 1 i tim 2 ostaju neinicijalizovani,
     * dok se tim1, tim2, i lista rasporeda inicijalizuju na default.
     */
    public TreningUtakmica() {
    }

    /**
     * Konstruktor koji inicijalizuje sve atribute trening utakmice.
     *
     * @param treningUtakmicaId Identifikator utakmice
     * @param redniBroj Redni broj utakmice
     * @param datum Datum održavanja utakmice
     * @param brojGolovaTim1 Broj golova postignutih od strane tima 1
     * @param brojGolovaTikm2 Broj golova postignutih od strane tima 2
     * @param tim1 Prvi tim koji učestvuje na utakmici
     * @param tim2 Drugi tim koji učestvuje na utakmici
     * @param listaStatistika Lista statistika fudbalera koji su učestvovali na
     * utakmici
     */
    public TreningUtakmica(long treningUtakmicaId, int redniBroj, Date datum, int brojGolovaTim1, int brojGolovaTikm2, TreningGrupa tim1, TreningGrupa tim2, List<StatistikaFudbalera> listaStatistika) {
        this.treningUtakmicaId = treningUtakmicaId;
        this.datum = datum;
        this.brojGolovaTim1 = brojGolovaTim1;
        this.brojGolovaTikm2 = brojGolovaTikm2;
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.listaStatistika = listaStatistika;
        this.redniBroj = redniBroj;
    }

    /**
     * Konstruktor koji inicijalizuje sve atribute trening utakmice osim liste
     * statistika.
     *
     * @param treningUtakmicaId Identifikator utakmice
     * @param redniBroj Redni broj utakmice
     * @param datum Datum održavanja utakmice
     * @param brojGolovaTim1 Broj golova postignutih od strane tima 1
     * @param brojGolovaTikm2 Broj golova postignutih od strane tima 2
     * @param tim1 Prvi tim koji učestvuje na utakmici
     * @param tim2 Drugi tim koji učestvuje na utakmici
     */
    public TreningUtakmica(long treningUtakmicaId, int redniBroj, Date datum, int brojGolovaTim1, int brojGolovaTikm2, TreningGrupa tim1, TreningGrupa tim2) {
        this.treningUtakmicaId = treningUtakmicaId;
        this.datum = datum;
        this.brojGolovaTim1 = brojGolovaTim1;
        this.brojGolovaTikm2 = brojGolovaTikm2;
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.redniBroj = redniBroj;

    }

    /**
     * Konstruktor koji inicijalizuje sve atribute trening utakmice osim
     * identifikatora i liste statistika.
     *
     * @param redniBroj Redni broj utakmice
     * @param datum Datum održavanja utakmice
     * @param brojGolovaTim1 Broj golova postignutih od strane tima 1
     * @param brojGolovaTikm2 Broj golova postignutih od strane tima 2
     * @param tim1 Prvi tim koji učestvuje na utakmici
     * @param tim2 Drugi tim koji učestvuje na utakmici
     * @param listaStatistika Lista statistika fudbalera koji su učestvovali na
     * utakmici
     */
    public TreningUtakmica(int redniBroj, Date datum, int brojGolovaTim1, int brojGolovaTikm2, TreningGrupa tim1, TreningGrupa tim2, List<StatistikaFudbalera> listaStatistika) {
        this.datum = datum;
        this.brojGolovaTim1 = brojGolovaTim1;
        this.brojGolovaTikm2 = brojGolovaTikm2;
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.listaStatistika = listaStatistika;
        this.redniBroj = redniBroj;
    }

    /**
     * Vraća identifikator trening utakmice.
     *
     * @return Identifikator utakmice kao long
     */
    public long getTreningUtakmicaId() {
        return treningUtakmicaId;
    }

    /**
     * Postavlja identifikator trening utakmice.
     *
     * @param treningUtakmicaId Identifikator utakmice kao long
     */
    public void setTreningUtakmicaId(long treningUtakmicaId) {
        this.treningUtakmicaId = treningUtakmicaId;
    }

    /**
     * Vraća datum održavanja trening utakmice.
     *
     * @return Datum održavanja utakmice
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Postavlja datum održavanja trening utakmice.
     *
     * @param datum Datum održavanja utakmice
     * @throws NullPointerException ako je datum null
     * @throws IllegalArgumentException ako je datum u budućnosti
     */
    public void setDatum(Date datum) {
        if (datum == null) {
            throw new NullPointerException("Datum ne smije da bude null!");
        }
        if (datum.after(new Date())) {
            throw new IllegalArgumentException("Datum mora biti iz prošlosti");
        }
        this.datum = datum;
    }

    /**
     * Vraća broj golova postignutih od strane tima 1 na trening utakmici.
     *
     * @return Broj golova tima 1
     */
    public int getBrojGolovaTim1() {
        return brojGolovaTim1;
    }

    /**
     * Postavlja broj golova postignutih od strane tima 1 na trening utakmici.
     *
     * @param brojGolovaTim1 Broj golova tima 1
     * @throws IllegalArgumentException ako je broj golova tima 1 manji od 0
     */
    public void setBrojGolovaTim1(int brojGolovaTim1) {
        if (brojGolovaTim1 < 0) {
            throw new IllegalArgumentException("Broj golova tim1 ne smije da bude negativan broj!");
        }

        this.brojGolovaTim1 = brojGolovaTim1;
    }

    /**
     * Vraća broj golova postignutih od strane tima 2 na trening utakmici.
     *
     * @return Broj golova tima 2
     */
    public int getBrojGolovaTikm2() {

        return brojGolovaTikm2;
    }

    /**
     * Postavlja broj golova postignutih od strane tima 2 na trening utakmici.
     *
     * @param brojGolovaTikm2 Broj golova tima 2
     * @throws IllegalArgumentException ako je broj golova tima 2 manji od 0
     */
    public void setBrojGolovaTikm2(int brojGolovaTikm2) {
        if (brojGolovaTikm2 < 0) {
            throw new IllegalArgumentException("Broj golova tim2 ne smije da bude negativan broj!");
        }
        this.brojGolovaTikm2 = brojGolovaTikm2;
    }

    /**
     * Vraća prvi tim koji učestvuje na trening utakmici.
     *
     * @return Prvi tim
     */
    public TreningGrupa getTim1() {
        return tim1;
    }

    /**
     * Postavlja prvi tim koji učestvuje na trening utakmici.
     *
     * @param tim1 Prvi tim
     * @throws NullPointerException ako je tim1 null
     */
    public void setTim1(TreningGrupa tim1) {
        if (tim1 == null) {
            throw new NullPointerException("Tim1 ne smije da bude null!");
        }
        this.tim1 = tim1;
    }

    /**
     * Vraća drugi tim koji učestvuje na trening utakmici.
     *
     * @return Drugi tim
     */
    public TreningGrupa getTim2() {
        return tim2;
    }

    /**
     * Postavlja drugi tim koji učestvuje na trening utakmici.
     *
     * @param tim2 Drugi tim
     * @throws NullPointerException ako je tim2 null
     */
    public void setTim2(TreningGrupa tim2) {
        if (tim2 == null) {
            throw new NullPointerException("Tim2 ne smije da bude null!");
        }
        this.tim2 = tim2;
    }

    /**
     * Vraća listu statistika fudbalera koji su učestvovali na trening utakmici.
     *
     * @return Lista statistika fudbalera
     */
    public List<StatistikaFudbalera> getListaStatistika() {
        return listaStatistika;
    }

    /**
     * Postavlja listu statistika fudbalera koji su učestvovali na trening
     * utakmici.
     *
     * @param listaStatistika Lista statistika fudbalera
     */
    public void setListaStatistika(List<StatistikaFudbalera> listaStatistika) {
        this.listaStatistika = listaStatistika;
    }

    /**
     * Vraća redni broj trening utakmice.
     *
     * @return Redni broj utakmice
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * Postavlja redni broj trening utakmice.
     *
     * @param redniBroj Redni broj utakmice
     * @throws IllegalArgumentException ako je redni broj manji od 0
     */
    public void setRedniBroj(int redniBroj) {
        if (redniBroj < 0) {
            throw new IllegalArgumentException("Redni broj utakmice ne moze da bude negativan");
        }
        this.redniBroj = redniBroj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.treningUtakmicaId ^ (this.treningUtakmicaId >>> 32));
        hash = 53 * hash + this.redniBroj;
        hash = 53 * hash + Objects.hashCode(this.datum);
        hash = 53 * hash + this.brojGolovaTim1;
        hash = 53 * hash + this.brojGolovaTikm2;
        hash = 53 * hash + Objects.hashCode(this.tim1);
        hash = 53 * hash + Objects.hashCode(this.tim2);
        hash = 53 * hash + Objects.hashCode(this.listaStatistika);
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
        final TreningUtakmica other = (TreningUtakmica) obj;
        if (this.treningUtakmicaId != other.treningUtakmicaId) {
            return false;
        }
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        if (this.brojGolovaTim1 != other.brojGolovaTim1) {
            return false;
        }
        if (this.brojGolovaTikm2 != other.brojGolovaTikm2) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.tim1, other.tim1)) {
            return false;
        }
        if (!Objects.equals(this.tim2, other.tim2)) {
            return false;
        }
        return Objects.equals(this.listaStatistika, other.listaStatistika);
    }

    @Override
    public String toString() {
        return "TreningUtakmica{" + "treningUtakmicaId=" + treningUtakmicaId + ", redniBroj=" + redniBroj + ", datum=" + datum + ", brojGolovaTim1=" + brojGolovaTim1 + ", brojGolovaTikm2=" + brojGolovaTikm2 + ", tim1=" + tim1 + ", tim2=" + tim2 + ", listaStatistika=" + listaStatistika + '}';
    }

    /**
     * Vraća naziv tabele u bazi podataka za trening utakmice.
     *
     * @return Naziv tabele kao String
     */
    @Override
    public String getTableName() {
        return "trening_utakmica";
    }

    /**
     * Vraća nazive kolona u bazi podataka za unos podataka o trening
     * utakmicama.
     *
     * @return Nazivi kolona za unos podataka o trening utakmicama kao String
     */
    @Override
    public String getInsertColumns() {
        return "trening_utakmica_id,redni_broj,datum,broj_golova_tim1,broj_golova_tim2,tim1_id,tim2_id";
    }

    /**
     * Vraća vrednosti koje se unose u bazu podataka za dati entitet trening
     * utakmice.
     *
     * @return Vrednosti koje se unose u bazu podataka za entitet trening
     * utakmice kao String
     */
    @Override
    public String getInsertValues() {
        return "'" + treningUtakmicaId + "','" + redniBroj + "','" + new java.sql.Date(datum.getTime()) + "','" + brojGolovaTim1 + "','" + brojGolovaTikm2 + "','" + tim1.getObjID() + "','" + tim2.getObjID() + "'";
    }

    /**
     * Postavlja jedinstveni identifikator trening utakmice.
     *
     * @param id Jedinstveni identifikator trening utakmice kao long
     */
    @Override
    public void setId(long id) {
        this.treningUtakmicaId = id;
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
     * Vraća SQL kod koji se koristi pri spajanju(JOIN) tabela u upitima za
     * trening utakmice.
     *
     * @return SQL kod za spajanje tabela u upitu za trening utakmice kao String
     */
    @Override
    public String getJoinText() {
        return "JOIN trening_grupa tg ON tu.tim1_id=tg.grupa_id JOIN trening_grupa tg2 ON tu.tim2_id=tg2.grupa_id JOIN trener t ON tg.trener_id=t.trener_id JOIN trener t2 ON tg2.trener_id = t2.trener_id";
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
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public String getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Kreira instancu TreningUtakmica objekta na osnovu podataka iz ResultSet
     * objekta.
     *
     * @param rs ResultSet objekat koji sadrži podatke iz baze
     * @return Kreirani TreningUtakmica objekat
     * @throws SQLException Izuzetak koji može biti bačen pri pristupu podacima
     * u ResultSet-u
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
        return new TreningUtakmica(rs.getInt(getAlijas() + ".trening_utakmica_id"), rs.getInt(getAlijas() + ".redni_broj"), new java.util.Date(rs.getDate(getAlijas() + ".datum").getTime()), rs.getInt(getAlijas() + ".broj_golova_tim1"), rs.getInt(getAlijas() + ".broj_golova_tim2"), (TreningGrupa) tim1.getEntity(rs), (TreningGrupa) tim2.getJoinEntity(rs));
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Vraća jedinstveni identifikator entiteta.
     *
     * @return Jedinstveni identifikator entiteta
     */
    @Override
    public long getObjID() {
        return treningUtakmicaId;
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
     * Vraća alijas tabele u bazi podataka za entitet trening utakmice.
     *
     * @return Alijas tabele za entitet trening utakmice kao String
     */
    @Override
    public String getAlijas() {
        return "tu";
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
