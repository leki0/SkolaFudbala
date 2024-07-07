/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.klijent;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import rs.ac.bg.fon.ai.skolafudbala.komunikacija.KlijentskiZahtjev;
import rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija;
import rs.ac.bg.fon.ai.skolafudbala.komunikacija.Posiljalac;
import rs.ac.bg.fon.ai.skolafudbala.komunikacija.Primalac;
import rs.ac.bg.fon.ai.skolafudbala.komunikacija.ServerskiOdgovor;
import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;
import rs.ac.bg.fon.ai.skolafudbala.model.LekarskiPregled;
import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;


/**
 *
 * @author Korisnik
 */
public class Klijent {

    private List<TreningGrupa> listaTreningGrupe;
    private List<Trener> listaTrenera;
    private List<Fudbaler> listaFudbalera;
    private static Klijent instance;
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private Klijent() throws Exception {
        socket = new Socket("localhost", 9000);
        System.out.println("Klijent povezan na serverski socket!");
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }

    public static Klijent getInstance() throws Exception {
        if (instance == null) {
            instance = new Klijent();
        }
        return instance;
    }

    public Korisnik prijava(String korisnickoIme, String lozinka) throws Exception {
        Korisnik k = new Korisnik(-1, null, null, korisnickoIme, lozinka);
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.PRIJAVA, k);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (Korisnik) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public String odjava() throws IOException, Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.ODJAVA, null);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            socket.close();
            instance = null;
            return (String) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public List<TreningGrupa> ucitajListuTreningGrupe() throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.UCITAJ_LISTU_TRENING_GRUPE, null);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (List<TreningGrupa>) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public long zapamtiFudbalera(Fudbaler f) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.DODAJ_FUDBALERA, f);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (long) so.getRezultat();
        } else {
            throw so.getException();
        }

    }
    
     public long zapamtiPregled(LekarskiPregled lp) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.DODAJ_LEKARSKI_PREGLED, lp);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (long) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public long zapamtiTrenera(Trener t) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.DODAJ_TRENERA, t);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (long) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public List<Trener> ucitajListuTrenera() throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.UCITAJ_LISTU_TRENERA, null);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (List<Trener>) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public long zapamtiTreningGrupu(TreningGrupa tg) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.ZAPAMTI_TRENING_GRUPU, tg);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (long) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public List<Fudbaler> ucitajListuFudbalera() throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.UCITAJ_LISTU_FUDBALERA, null);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            listaFudbalera = (List<Fudbaler>) so.getRezultat();
            return (List<Fudbaler>) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public int zapamtiIzmjeneTrenera(Trener trenerIzmjena) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.IZMJENA_TRENERA, trenerIzmjena);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (int) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public List<Fudbaler> getListaFudbalera() {
        return listaFudbalera;
    }

    public List<Trener> getListaTrenera() {
        return listaTrenera;
    }

    public List<TreningGrupa> getListaTreningGrupe() {
        return listaTreningGrupe;
    }

    public int obrisiTrenera(Trener trenerBrisanje) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.OBRISI_TRENERA, trenerBrisanje);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (int) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public List<Trener> nadjiTrenere(Trener trenerPretraga) throws Exception {
        System.out.println(trenerPretraga.getIme() + " " + trenerPretraga.getJmbg());
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.NADJI_TRENERA, trenerPretraga);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (List<Trener>) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public List<Fudbaler> nadjiFudbalere(Fudbaler fudbalerPretraga) throws Exception {
        System.out.println(fudbalerPretraga.getIme() + " " + fudbalerPretraga.getJmbg());
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.NADJI_FUBALERA, fudbalerPretraga);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (List<Fudbaler>) so.getRezultat();
        } else {
            throw so.getException();
        }

    }

    public int zapamtiIzmjeneFudbalera(Fudbaler fudbalerUpdate) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.IZMJENA_FUDBALERA, fudbalerUpdate);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (int) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public int obrisiFudbalera(Fudbaler fudbalerBrisanje) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.OBRISI_FUDBALERA, fudbalerBrisanje);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (int) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public List<TreningGrupa> nadjiTreningGrupe(TreningGrupa treningGrupaPretraga) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.NADJI_TRENING_GRUPU, treningGrupaPretraga);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (List<TreningGrupa>) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public int zapamtiIzmjeneTreningGrupe(TreningGrupa tgUpdate) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.IZMJENA_TRENING_GRUPE, tgUpdate);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (int) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public int obrisiTreningGrupu(TreningGrupa tgDelete) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.OBRISI_TRENING_GRUPU, tgDelete);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (int) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public Trener ucitajTrenera(Trener trener) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.UCITAJ_TRENERA, trener);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (Trener) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public Fudbaler ucitajFudbalera(Fudbaler fudbaler) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.UCITAJ_FUDBALERA, fudbaler);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (Fudbaler) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public TreningGrupa ucitajTreningGrupu(TreningGrupa treningGrupa) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.UCITAJ_TRENING_GRUPU, treningGrupa);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (TreningGrupa) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public long zapamtiTreningUtakmicu(TreningUtakmica tu) throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.ZAPAMTI_TRENING_UTAKMICU, tu);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (long) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

    public List<TreningUtakmica> ucitajListuTreningUtakmica() throws Exception {
        KlijentskiZahtjev kz = new KlijentskiZahtjev(Operacija.UCITAJ_LISTU_TRENING_UTAKMICA, null);
        posiljalac.posaljiPoruku(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primiPoruku();
        if (so.getException() == null) {
            return (List<TreningUtakmica>) so.getRezultat();
        } else {
            throw so.getException();
        }
    }

}
