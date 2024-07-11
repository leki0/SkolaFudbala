/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import com.google.gson.annotations.SerializedName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Klasa koja predstavlja statistiku fudbalera na trening utakmici. Implementira
 * interfejs GenerickiEntitet.
 *
 * Sadrži informacije o broju golova, asistencija, promašenih šuteva, broju
 * provedenih minuta, da li je fudbaler bio u prvoj postavi, broju odbrana,
 * broju primljenih golova i ocjeni.
 *
 * @autor Aleksa Stancic
 */
public class StatistikaFudbalera implements GenerickiEntitet {

    /**
     * Fudbaler na kojeg se odnosi statistika.
     */
    @SerializedName("FUDBALER: ")
    private Fudbaler fudbaler;

    /**
     * Trening utakmica na kojoj je fudbaler učestvovao.
     */
    @SerializedName("TRENING UTAKMICA: ")
    private TreningUtakmica treningUtakmica;

    /**
     * Broj postignutih golova kao int.
     */
    @SerializedName("BROJ GOLOVA: ")
    private int brojGolova;

    /**
     * Broj asistencija kao int.
     */
    @SerializedName("BROJ ASISTENCIJA: ")
    private int brojAsistencija;

    /**
     * Broj promašenih šuteva kao int.
     */
    @SerializedName("BROJ PROMASENIH SUTEVA: ")
    private int brojPromasenihSuteva;

    /**
     * Broj provedenih minuta na terenu kao int.
     */
    @SerializedName("BROJ PROVEDENIH MINUTA: ")
    private int brojProvedenihMinuta;

    /**
     * Da li je fudbaler bio u prvoj postavi.
     */
    @SerializedName("DA LI FUDBALER BIO PRVA POSTAVA: ")
    private Boolean prvaPostava;

    /**
     * Broj odbrana golmana kao int.
     */
    @SerializedName("BROJ ODBRANA GOLMANA: ")
    private int brojOdbrana;

    /**
     * Broj primljenih golova kao int.
     */
    @SerializedName("BROJ PRIMLJENIH GOLOVA GOLMANA: ")
    private int brojPrimljenihGolova;

    /**
     * Ocjena fudbalera za utakmicu kao double.
     */
    @SerializedName("OCJENA ZA FUDBALERA: ")
    private double ocjena;

    /**
     * Pravi nov objekat klase StatistikaFudbalera.
     *
     * ID, Fudbaler, Trening utakmica, broj golova, broj asistencija, broj
     * promasenih suteva, broj provedenih minuta, da li je fudbaler prva
     * postava, broj odbrana, broj primljenih golova, ocjena fudbalera ostaju
     * neinicijalizovani.
     */
    public StatistikaFudbalera() {
    }

    /**
     * Pravi nov objekat klase StatistikaFudbalera.
     *
     * ID, Fudbaler, Trening utakmica, broj golova, broj asistencija, broj
     * promasenih suteva, broj provedenih minuta, da li je fudbaler prva
     * postava, broj odbrana, broj primljenih golova, ocjena fudbalera se
     * inicijalizuju na unete vrednosti.
     *
     * @param fudbaler Fudbaler na kojeg se odnosi statistika
     * @param treningUtakmica Trening utakmica na kojoj je fudbaler učestvovao
     * @param brojGolova Broj golova kao int
     * @param brojAsistencija Broj asistencija kao int
     * @param brojPromasenihSuteva Broj promašenih šuteva kao int
     * @param brojProvedenihMinuta Broj provedenih minuta kao int
     * @param prvaPostava Da li je fudbaler bio u prvoj postavi kao Boolean
     * @param brojOdbrana Broj odbrana kao int
     * @param brojPrimljenihGolova Broj primljenih golova kao int
     * @param ocjena Ocena fudbalera kao double
     */
    public StatistikaFudbalera(Fudbaler fudbaler, TreningUtakmica treningUtakmica, int brojGolova, int brojAsistencija, int brojPromasenihSuteva,
            int brojProvedenihMinuta, Boolean prvaPostava, int brojOdbrana, int brojPrimljenihGolova, double ocjena) {
        this.fudbaler = fudbaler;
        this.treningUtakmica = treningUtakmica;
        this.brojGolova = brojGolova;
        this.brojAsistencija = brojAsistencija;
        this.brojPromasenihSuteva = brojPromasenihSuteva;
        this.brojProvedenihMinuta = brojProvedenihMinuta;
        this.prvaPostava = prvaPostava;
        this.brojOdbrana = brojOdbrana;
        this.brojPrimljenihGolova = brojPrimljenihGolova;
        this.ocjena = ocjena;
    }

    /**
     * Vraća fudbalera na kojeg se odnosi statistika.
     *
     * @return fudbaler na kojeg se odnosi statistika
     */
    public Fudbaler getFudbaler() {
        return fudbaler;
    }

    /**
     * Postavlja fudbalera na kojeg se odnosi statistika.
     *
     * @param fudbaler fudbaler na kojeg se odnosi statistika
     * @throws java.lang.NullPointerException ako je uneti fudbaler null
     */
    public void setFudbaler(Fudbaler fudbaler) {
        if (fudbaler == null) {
            throw new NullPointerException("Fudbaler ne smije da bude null!");
        }
        this.fudbaler = fudbaler;
    }

    /**
     * Vraća broj golova postignutih na trening utakmici.
     *
     * @return broj golova postignutih na trening utakmici
     */
    public int getBrojGolova() {
        return brojGolova;
    }

    /**
     * Postavlja broj golova postignutih na trening utakmici.
     *
     * @param brojGolova broj golova postignutih na trening utakmici
     * @throws java.lang.IllegalArgumentException ako je broj golova negativan
     */
    public void setBrojGolova(int brojGolova) {
        if (brojGolova < 0) {
            throw new IllegalArgumentException("Broj golova ne smije da bude negativan broj!");
        }
        this.brojGolova = brojGolova;
    }

    /**
     * Vraća broj asistencija ostvarenih na trening utakmici.
     *
     * @return broj asistencija ostvarenih na trening utakmici
     */
    public int getBrojAsistencija() {
        return brojAsistencija;
    }

    /**
     * Postavlja broj asistencija ostvarenih na trening utakmici.
     *
     * @param brojAsistencija broj asistencija ostvarenih na trening utakmici
     * @throws java.lang.IllegalArgumentException ako je broj asistencija
     * negativan
     */
    public void setBrojAsistencija(int brojAsistencija) {
        if (brojAsistencija < 0) {
            throw new IllegalArgumentException("Broj asistencija ne smije da bude negativan broj!");
        }
        this.brojAsistencija = brojAsistencija;
    }

    /**
     * Vraća trening utakmicu na kojoj je fudbaler učestvovao.
     *
     * @return trening utakmica na kojoj je fudbaler učestvovao
     */
    public TreningUtakmica getTreningUtakmica() {
        return treningUtakmica;
    }

    /**
     * Postavlja trening utakmicu na kojoj je fudbaler učestvovao.
     *
     * @param treningUtakmica trening utakmica na kojoj je fudbaler učestvovao
     * @throws java.lang.NullPointerException ako je uneta trening utakmica null
     */
    public void setTreningUtakmica(TreningUtakmica treningUtakmica) {
        if (treningUtakmica == null) {
            throw new NullPointerException("Trening utakmica ne smije da bude null!");
        }
        this.treningUtakmica = treningUtakmica;
    }

    /**
     * Vraća broj promašenih šuteva na trening utakmici.
     *
     * @return broj promašenih šuteva na trening utakmici
     */
    public int getBrojPromasenihSuteva() {
        return brojPromasenihSuteva;
    }

    /**
     * Postavlja broj promašenih šuteva na trening utakmici.
     *
     * @param brojPromasenihSuteva broj promašenih šuteva na trening utakmici
     * @throws java.lang.IllegalArgumentException ako je broj promašenih šuteva
     * negativan
     */
    public void setBrojPromasenihSuteva(int brojPromasenihSuteva) {
        if (brojPromasenihSuteva < 0) {
            throw new IllegalArgumentException("Broj promasenih suteva ne smije da bude negativan broj!");
        }
        this.brojPromasenihSuteva = brojPromasenihSuteva;
    }

    /**
     * Vraća broj provedenih minuta na terenu.
     *
     * @return broj provedenih minuta na terenu
     */
    public int getBrojProvedenihMinuta() {
        return brojProvedenihMinuta;
    }

    /**
     * Postavlja broj provedenih minuta na terenu.
     *
     * @param brojProvedenihMinuta broj provedenih minuta na terenu
     * @throws java.lang.IllegalArgumentException ako je broj provedenih minuta
     * negativan
     */
    public void setBrojProvedenihMinuta(int brojProvedenihMinuta) {
        if (brojProvedenihMinuta < 0) {
            throw new IllegalArgumentException("Broj provedenih minuta ne smije da bude negativan broj!");
        }
        this.brojProvedenihMinuta = brojProvedenihMinuta;
    }

    /**
     * Vraća informaciju da li je fudbaler bio u prvoj postavi.
     *
     * @return true ako je fudbaler bio u prvoj postavi, false inače
     */
    public Boolean isPrvaPostava() {
        return prvaPostava;
    }

    /**
     * Postavlja informaciju da li je fudbaler bio u prvoj postavi.
     *
     * @param prvaPostava true ako je fudbaler bio u prvoj postavi, false inače
     * @throws java.lang.NullPointerException ako je informacija o tome da li je
     * prva postava Null
     *
     */
    public void setPrvaPostava(Boolean prvaPostava) {
        if (prvaPostava == null) {
            throw new NullPointerException("Prva postava ne smije da bude null!");
        }
        this.prvaPostava = prvaPostava;
    }

    /**
     * Vraća broj odbrana golmana.
     *
     * @return broj odbrana golmana
     */
    public int getBrojOdbrana() {
        return brojOdbrana;
    }

    /**
     * Postavlja broj odbrana golmana.
     *
     * @param brojOdbrana broj odbrana golmana
     * @throws java.lang.IllegalArgumentException ako je broj odbrana negativan
     */
    public void setBrojOdbrana(int brojOdbrana) {
        if (brojOdbrana < 0) {
            throw new IllegalArgumentException("Broj odbrana ne smije da bude negativan broj!");
        }
        this.brojOdbrana = brojOdbrana;
    }

    /**
     * Vraća broj primljenih golova.
     *
     * @return broj primljenih golova
     */
    public int getBrojPrimljenihGolova() {
        return brojPrimljenihGolova;
    }

    /**
     * Postavlja broj primljenih golova.
     *
     * @param brojPrimljenihGolova broj primljenih golova
     * @throws java.lang.IllegalArgumentException ako je broj primljenih golova
     * negativan
     */
    public void setBrojPrimljenihGolova(int brojPrimljenihGolova) {
        if (brojPrimljenihGolova < 0) {
            throw new IllegalArgumentException("Broj primljenih ne smije da bude negativan broj!");
        }
        this.brojPrimljenihGolova = brojPrimljenihGolova;
    }

    /**
     * Vraća ocenu fudbalera za utakmicu.
     *
     * @return ocena fudbalera za utakmicu
     */
    public double getOcjena() {
        return ocjena;
    }

    public TreningUtakmica getTreningUtakmicaId() {
        return treningUtakmica;
    }

    public void setTreningUtakmicaId(TreningUtakmica treningUtakmica) {
        this.treningUtakmica = treningUtakmica;
    }

    /**
     * Postavlja ocenu fudbalera za utakmicu.
     *
     * @param ocjena ocena fudbalera za utakmicu
     * @throws java.lang.IllegalArgumentException ako je ocena negativan broj
     */
    public void setOcjena(double ocjena) {
        if (ocjena < 0) {
            throw new IllegalArgumentException("Ocjena ne smije da bude negativan broj!");
        }
        this.ocjena = ocjena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fudbaler);
        hash = 97 * hash + Objects.hashCode(this.treningUtakmica);
        hash = 97 * hash + this.brojGolova;
        hash = 97 * hash + this.brojAsistencija;
        hash = 97 * hash + this.brojPromasenihSuteva;
        hash = 97 * hash + this.brojProvedenihMinuta;
        hash = 97 * hash + Objects.hashCode(this.prvaPostava);
        hash = 97 * hash + this.brojOdbrana;
        hash = 97 * hash + this.brojPrimljenihGolova;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.ocjena) ^ (Double.doubleToLongBits(this.ocjena) >>> 32));
        return hash;
    }

    /**
     * Poredi dve instance klase StatistikaFudbalera na osnovu atributa.
     *
     * @param obj Drugi objekat sa kojim se poredi
     *
     * @return
     * <ul>
     * <li><b>true</b> - ako su oba objekta inicijalizovana, klase su
     * StatistikaFudbalera i svi atributi su im jednaki</li>
     * <li><b>false</b> - ako nisu klase StatistikaFudbalera, ako je drugi
     * objekat null ili ako neki od atributa nisu jednaki</li>
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
        final StatistikaFudbalera other = (StatistikaFudbalera) obj;
        if (this.brojGolova != other.brojGolova) {
            return false;
        }
        if (this.brojAsistencija != other.brojAsistencija) {
            return false;
        }
        if (this.brojPromasenihSuteva != other.brojPromasenihSuteva) {
            return false;
        }
        if (this.brojProvedenihMinuta != other.brojProvedenihMinuta) {
            return false;
        }
        if (this.brojOdbrana != other.brojOdbrana) {
            return false;
        }
        if (this.brojPrimljenihGolova != other.brojPrimljenihGolova) {
            return false;
        }
        if (Double.doubleToLongBits(this.ocjena) != Double.doubleToLongBits(other.ocjena)) {
            return false;
        }
        if (!Objects.equals(this.fudbaler, other.fudbaler)) {
            return false;
        }
        if (!Objects.equals(this.treningUtakmica, other.treningUtakmica)) {
            return false;
        }
        return Objects.equals(this.prvaPostava, other.prvaPostava);
    }

    @Override
    public String toString() {
        return "StatistikaFudbalera{" + "fudbaler=" + fudbaler + ", treningUtakmica=" + treningUtakmica + ", brojGolova=" + brojGolova + ", brojAsistencija=" + brojAsistencija + ", brojPromasenihSuteva=" + brojPromasenihSuteva + ", brojProvedenihMinuta=" + brojProvedenihMinuta + ", prvaPostava=" + prvaPostava + ", brojOdbrana=" + brojOdbrana + ", brojPrimljenihGolova=" + brojPrimljenihGolova + ", ocjena=" + ocjena + '}';
    }

    /**
     * Vraća naziv tabele u bazi podataka za entitet statistike fudbalera.
     *
     * @return Naziv tabele kao String.
     */
    @Override
    public String getTableName() {
        return "statistika_fudbalera";
    }

    /**
     * Vraća kolone koje se koriste za unos podataka u tabelu statistike
     * fudbalera.
     *
     * @return String sa imenima kolona odvojenih zarezom.
     */
    @Override
    public String getInsertColumns() {
        return "fudbaler_id,trening_utakmica_id,broj_golova,broj_asistencija,broj_promasenih_suteva,broj_provedenih_minuta,broj_odbrana,broj_primljenih_golova,prva_postava,ocjena";
    }

    /**
     * Vraća vrednosti koje se koriste za unos podataka u tabelu statistike
     * fudbalera.
     *
     * @return String za formiranje SQL upita za Insert.
     */
    @Override
    public String getInsertValues() {
        return "'" + fudbaler.getObjID() + "','" + treningUtakmica.getObjID() + "','" + brojGolova + "','" + brojAsistencija + "','" + brojPromasenihSuteva + "','" + brojProvedenihMinuta + "','" + brojOdbrana + "','" + brojPrimljenihGolova + "','" + (prvaPostava ? 1 : 0) + "','" + ocjena + "'";
    }

    /**
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public void setId(long id) {
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
     * Nije podržano.
     *
     * @return ništa
     * @throws UnsupportedOperationException uvek baca ovaj izuzetak jer metoda
     * nije implementirana
     */
    @Override
    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException {
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
    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException {
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
    public long getObjID() {
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
    public String getWhereDvaParametra() {
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
    public String getAlijas() {
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
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
