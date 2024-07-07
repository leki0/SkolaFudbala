/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.controller;

import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;
import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ApstraktnaSistemskaOperacija;
import rs.ac.bg.fon.ai.skolafudbala.operacije.NadjiFudbalere;
import rs.ac.bg.fon.ai.skolafudbala.operacije.NadjiTrenere;
import rs.ac.bg.fon.ai.skolafudbala.operacije.NadjiTreningGrupe;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ObrisiFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ObrisiTrenera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ObrisiTreningGrupu;
import rs.ac.bg.fon.ai.skolafudbala.operacije.Prijava;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajListuFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajListuTrenera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajListuTreningGrupe;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajListuTreningUtakmica;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajTrenera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajTreningGrupu;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiIzmjeneFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiIzmjeneTrenera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiIzmjeneTreningGrupe;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiTrenera;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiTreningGrupu;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiTreningUtakmicu;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db.impl.RepozitorijumImpl;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ai.skolafudbala.model.LekarskiPregled;
import rs.ac.bg.fon.ai.skolafudbala.model.TipTreninga;
import rs.ac.bg.fon.ai.skolafudbala.operacije.UcitajListuTipovaTreninga;
import rs.ac.bg.fon.ai.skolafudbala.operacije.ZapamtiPregled;

/**
 *
 * @author Korisnik
 */
public class Controller {

    private static Controller instance;
    private final Repozitorijum repozitorijumImpl;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
        this.repozitorijumImpl = new RepozitorijumImpl();
    }

    public Korisnik prijava(String korisnickoIme, String lozinka) throws Exception {
        ApstraktnaSistemskaOperacija ao = new Prijava();
        ao.izvrsi(new Korisnik());
        List<Korisnik> listaKorisnika = ((Prijava) ao).getKorisnici();
        for (Korisnik k : listaKorisnika) {
            if (korisnickoIme.equals(k.getKorisnickoIme()) && lozinka.equals(k.getLozinka())) {
                System.out.println("KORISNIK JE PRONAĐEN!");
                return k;
            }
        }
        throw new Exception("Ovaj korisnik ne postoji!");
    }

    public List<TreningGrupa> ucitajListuTreningGrupe() throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajListuTreningGrupe();
        ao.izvrsi(new TreningGrupa());
        List<TreningGrupa> listaTreningGrupa = ((UcitajListuTreningGrupe) ao).getListaTreningGrupa();
        List<Raspored> listaRasporeda = ((UcitajListuTreningGrupe) ao).getListaRasporeda();
        for (TreningGrupa tg : listaTreningGrupa) {
            for (Raspored r : listaRasporeda) {
                if (tg.getObjID() == r.getGrupa().getObjID()) {
                    tg.getListaRasporeda().add(r);
                }
            }
        }
        if (listaTreningGrupa.isEmpty()) {
            throw new Exception("Lista trening grupa je prazna!");
        }
        return listaTreningGrupa;
    }

    public long zapamtiFudbalera(Fudbaler fudbalerInsert) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiFudbalera();
        ao.izvrsi(fudbalerInsert);
        long id = ((ZapamtiFudbalera) ao).getId();
        if (id == -1) {
            throw new Exception("Fudbaler nije ubačen!");
        }
        return id;
    }

    public long zapamtiTrenera(Trener trenerInsert) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiTrenera();
        ao.izvrsi(trenerInsert);
        long id = ((ZapamtiTrenera) ao).getId();
        if (id == -1) {
            throw new Exception("Trener nije ubačen!");
        }
        return id;

    }

    public List<Trener> ucitajListuTrenera() throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajListuTrenera();
        ao.izvrsi(new Trener());
        List<Trener> listaTrenera = new ArrayList<>();
        listaTrenera = ((UcitajListuTrenera) ao).getListaTrenera();
        if (listaTrenera.size() == 0) {
            throw new Exception("Treneri nisu pronađeni!");
        } else {
            return listaTrenera;
        }

    }

    public long zapamtiTreningGrupu(TreningGrupa tgInsert) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiTreningGrupu();
        ao.izvrsi(tgInsert);
        long id = ((ZapamtiTreningGrupu) ao).getId();
        if (id == -1) {
            throw new Exception("Trening grupa nije zapamćena!");
        } else {
            return id;
        }
    }

    public List<Fudbaler> ucitajListuFudbalera() throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajListuFudbalera();
        ao.izvrsi(new Fudbaler());
        List<Fudbaler> listaFudbalera = ((UcitajListuFudbalera) ao).getListaFudbalera();
        if (listaFudbalera.size() == 0) {
            throw new Exception("Fudbaleri nisu pronađeni!");
        } else {
            return listaFudbalera;
        }

    }

    public int zapamtiIzmjeneTrenera(Trener trenerUpdate) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiIzmjeneTrenera();
        ao.izvrsi(trenerUpdate);
        int izmjenjenTrener = ((ZapamtiIzmjeneTrenera) ao).getIzmjenjenTrener();
        if (izmjenjenTrener <= 0) {
            throw new Exception("Sistem ne može da izmjeni trenera!");
        } else {
            return izmjenjenTrener;
        }
    }

    public int obrisiTrenera(Trener trenerDelete) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ObrisiTrenera();
        ao.izvrsi(trenerDelete);
        int obrisanTrener = ((ObrisiTrenera) ao).getObrisanTrener();
        if (obrisanTrener <= 0) {
            throw new Exception("Sistem ne može da obriše trenera!");
        } else {
            return obrisanTrener;
        }
    }

    public List<Trener> nadjiTrenere(Trener trenerPretraga) throws Exception {
        ApstraktnaSistemskaOperacija ao = new NadjiTrenere();
        ao.izvrsi(trenerPretraga);
        List<Trener> listaTreneraPretraga = ((NadjiTrenere) ao).getListaTreneraPretraga();
        if (listaTreneraPretraga.size() == 0) {
            throw new Exception("Sistem ne može da pronađe trenera po zadatoj vrijednosti!");
        } else {
            return listaTreneraPretraga;
        }
    }

    public List<Fudbaler> nadjiFudbalere(Fudbaler fudbalerPretraga) throws Exception {
        ApstraktnaSistemskaOperacija ao = new NadjiFudbalere();
        ao.izvrsi(fudbalerPretraga);
        List<Fudbaler> listaFudbaleraPretraga = ((NadjiFudbalere) ao).getListaFudbaleraPretraga();
        if (listaFudbaleraPretraga.size() == 0) {
            throw new Exception("Sistem ne može da pronađe fudbalera po zadatoj vrijednosti!");
        } else {
            return listaFudbaleraPretraga;
        }
    }

    public int zapamtiIzmjeneFudbalera(Fudbaler fudbalerUpdate) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiIzmjeneFudbalera();
        ao.izvrsi(fudbalerUpdate);
        int izmjenjenTrener = ((ZapamtiIzmjeneFudbalera) ao).getIzmjenjenFudbaler();
        if (izmjenjenTrener <= 0) {
            throw new Exception("Sistem ne može da izmjeni fudbalera!");
        } else {
            return izmjenjenTrener;
        }
    }

    public int obrisiFudbalera(Fudbaler fudbalerDelete) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ObrisiFudbalera();
        ao.izvrsi(fudbalerDelete);
        int obrisanFudbaler = ((ObrisiFudbalera) ao).getObrisanFudbaler();
        if (obrisanFudbaler <= 0) {
            throw new Exception("Sistem ne može da obriše fudbalera!");
        } else {
            return obrisanFudbaler;
        }
    }

    public List<TreningGrupa> nadjiTreningGrupe(TreningGrupa treningGrupaPretraga) throws Exception {
        ApstraktnaSistemskaOperacija ao = new NadjiTreningGrupe();
        ao.izvrsi(treningGrupaPretraga);
        List<TreningGrupa> listaTreningGrupaPretraga = ((NadjiTreningGrupe) ao).getListaTreningGrupaPretraga();
        List<Raspored> listaRasporeda = ((NadjiTreningGrupe) ao).getListaRasporeda();
        for (TreningGrupa tg : listaTreningGrupaPretraga) {
            for (Raspored r : listaRasporeda) {
                if (tg.getObjID() == r.getGrupa().getObjID()) {
                    tg.getListaRasporeda().add(r);
                }
            }
        }
        if (listaTreningGrupaPretraga.size() == 0) {
            throw new Exception("Sistem ne može da pronađe trening grupu po zadatoj vrijednosti!");
        } else {
            return listaTreningGrupaPretraga;
        }
    }

    public int zapamtiIzmjeneTreningGrupe(TreningGrupa treningGrupaUpdate) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiIzmjeneTreningGrupe();
        ao.izvrsi(treningGrupaUpdate);
        int izmjenjenaTreningGrupa = ((ZapamtiIzmjeneTreningGrupe) ao).getIzmjenjenaTG();
        if (izmjenjenaTreningGrupa <= 0) {
            throw new Exception("Sistem ne može da izmjeni trening grupu!");
        } else {
            return izmjenjenaTreningGrupa;
        }
    }

    public int obrisiTreningGrupu(TreningGrupa treningGrupaDelete) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ObrisiTreningGrupu();
        ao.izvrsi(treningGrupaDelete);
        int obrisanaTreningGrupa = ((ObrisiTreningGrupu) ao).getObrisanaTreningGrupa();
        if (obrisanaTreningGrupa <= 0) {
            throw new Exception("Sistem ne može da obriše Trening grupu!");
        } else {
            return obrisanaTreningGrupa;
        }
    }

    public Trener ucitajTrenera(Trener trener) throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajTrenera();
        ao.izvrsi(trener);
        Trener trenerBaza = new Trener();
        trenerBaza = ((UcitajTrenera) ao).getTrenerBaza();
        if (trenerBaza == null) {
            throw new Exception("Trener nije pronađen!");
        } else {
            return trenerBaza;
        }
    }

    public Fudbaler ucitajFudbalera(Fudbaler fudbaler) throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajFudbalera();
        ao.izvrsi(fudbaler);
        Fudbaler fudbalerBaza = new Fudbaler();
        fudbalerBaza = ((UcitajFudbalera) ao).getFudbalerBaza();
        if (fudbalerBaza == null) {
            throw new Exception("Fudbaler nije pronađen!");
        } else {
            return fudbalerBaza;
        }
    }

    public TreningGrupa ucitajTreningGrupu(TreningGrupa treningGrupa) throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajTreningGrupu();
        ao.izvrsi(treningGrupa);
        TreningGrupa treningGrupaBaza = new TreningGrupa();
        treningGrupaBaza = ((UcitajTreningGrupu) ao).getTreningGrupaBaza();
        if (treningGrupaBaza == null) {
            throw new Exception("Trening grupa nije pronađena!");
        } else {
            return treningGrupaBaza;
        }
    }

    public long zapamtiTreningUtakmicu(TreningUtakmica tuInsert) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiTreningUtakmicu();
        ao.izvrsi(tuInsert);
        long id = ((ZapamtiTreningUtakmicu) ao).getId();
        if (id == -1) {
            throw new Exception("Trening utakmica nije zapamćena!");
        } else {
            return id;
        }
    }

    public List<TreningUtakmica> ucitajListuTreningUtakmica() throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajListuTreningUtakmica();
        ao.izvrsi(new TreningUtakmica());
        List<TreningUtakmica> listaTreningUtakmica = ((UcitajListuTreningUtakmica) ao).getListaTreningUtakmica();
        if (listaTreningUtakmica.size() == 0) {
            throw new Exception("Trening utakmice nisu pronađene!");
        } else {
            return listaTreningUtakmica;
        }
    }

    public long zapamtiPregled(LekarskiPregled pregledInsert) throws Exception {
        ApstraktnaSistemskaOperacija ao = new ZapamtiPregled();
        ao.izvrsi(pregledInsert);
        long id = ((ZapamtiPregled) ao).getId();
        if (id == -1) {
            throw new Exception("Lekarski pregled nije zapamćena!");
        } else {
            return id;
        }
    }

    public List<TipTreninga> ucitajListuTipova() throws Exception {
        ApstraktnaSistemskaOperacija ao = new UcitajListuTipovaTreninga();
        ao.izvrsi(new TipTreninga());
        List<TipTreninga> listaTipova = ((UcitajListuTipovaTreninga) ao).getListaTipova();
        if (listaTipova.size() == 0) {
            throw new Exception("Tipovi treninga nisu pronađeni!");
        } else {
            return listaTipova;
        }
    }

}
