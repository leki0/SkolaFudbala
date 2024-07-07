/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.server;

import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ai.skolafudbala.controller.Controller;
import rs.ac.bg.fon.ai.skolafudbala.komunikacija.KlijentskiZahtjev;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.DODAJ_FUDBALERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.DODAJ_TRENERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.IZMJENA_FUDBALERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.IZMJENA_TRENERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.IZMJENA_TRENING_GRUPE;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.NADJI_FUBALERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.NADJI_TRENERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.NADJI_TRENING_GRUPU;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.OBRISI_FUDBALERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.OBRISI_TRENERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.OBRISI_TRENING_GRUPU;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.ODJAVA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.PRIJAVA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.UCITAJ_FUDBALERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.UCITAJ_LISTU_FUDBALERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.UCITAJ_LISTU_TRENERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.UCITAJ_LISTU_TRENING_GRUPE;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.UCITAJ_LISTU_TRENING_UTAKMICA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.UCITAJ_TRENERA;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.UCITAJ_TRENING_GRUPU;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.ZAPAMTI_TRENING_GRUPU;
import static rs.ac.bg.fon.ai.skolafudbala.komunikacija.Operacija.ZAPAMTI_TRENING_UTAKMICU;
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
public class ObradaKlijentskogZahtjeva extends Thread {

    private Socket socket;
    private Primalac primalac;
    private Posiljalac posiljalac;
    private Server server;
    private boolean signal = true;
    Korisnik trenutnoUlogovani;

    public Socket getSocket() {
        return socket;
    }

    public ObradaKlijentskogZahtjeva(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.primalac = new Primalac(socket);
        this.posiljalac = new Posiljalac(socket);
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                KlijentskiZahtjev klijentskiZahtjev = (KlijentskiZahtjev) primalac.primiPoruku();
                ServerskiOdgovor serverskiOdgovor = null;
                try {
                    switch (klijentskiZahtjev.getOperacija()) {
                        case PRIJAVA:
                            Korisnik k = (Korisnik) klijentskiZahtjev.getObjekat();
                            trenutnoUlogovani = Controller.getInstance().prijava(k.getKorisnickoIme(), k.getLozinka());
                            if (server.dodajKorisnika(trenutnoUlogovani) == 0) {
                                serverskiOdgovor = new ServerskiOdgovor(trenutnoUlogovani, null);
                            } else {
                                serverskiOdgovor = new ServerskiOdgovor(null, new Exception("Ovaj korisnik je vec prijavljen!"));
                            }
                            break;
                        case ODJAVA:
                            server.odjava(this);
                            serverskiOdgovor = new ServerskiOdgovor("Korisnik uspjesno odjavljen!", null);
                            signal = false;
                            break;
                        case UCITAJ_LISTU_TRENING_GRUPE:
                            List<TreningGrupa> listaTreningGrupe = Controller.getInstance().ucitajListuTreningGrupe();
                            serverskiOdgovor = new ServerskiOdgovor(listaTreningGrupe, null);
                            break;
                        case DODAJ_FUDBALERA:
                            Fudbaler fudbalerInsert = (Fudbaler) klijentskiZahtjev.getObjekat();
                            long id = Controller.getInstance().zapamtiFudbalera(fudbalerInsert);
                            serverskiOdgovor = new ServerskiOdgovor(id, null);
                            break;
                        case DODAJ_TRENERA:
                            Trener trenerInsert = (Trener) klijentskiZahtjev.getObjekat();
                            long idT = Controller.getInstance().zapamtiTrenera(trenerInsert);
                            serverskiOdgovor = new ServerskiOdgovor(idT, null);
                            break;
                        case UCITAJ_LISTU_TRENERA:
                            List<Trener> listaTrenera = new ArrayList<>();
                            listaTrenera = Controller.getInstance().ucitajListuTrenera();
                            serverskiOdgovor = new ServerskiOdgovor(listaTrenera, null);
                            break;
                        case ZAPAMTI_TRENING_GRUPU:
                            TreningGrupa tgInsert = (TreningGrupa) klijentskiZahtjev.getObjekat();
                            long tgID = Controller.getInstance().zapamtiTreningGrupu(tgInsert);
                            serverskiOdgovor = new ServerskiOdgovor(tgID, null);
                            break;
                        case UCITAJ_LISTU_FUDBALERA:
                            List<Fudbaler> listaFudbalera = Controller.getInstance().ucitajListuFudbalera();
                            serverskiOdgovor = new ServerskiOdgovor(listaFudbalera, null);
                            break;
                        case IZMJENA_TRENERA:
                            Trener trenerUpdate = (Trener) klijentskiZahtjev.getObjekat();
                            int izmjenjen = Controller.getInstance().zapamtiIzmjeneTrenera(trenerUpdate);
                            serverskiOdgovor = new ServerskiOdgovor(izmjenjen, null);
                            break;
                        case OBRISI_TRENERA:
                            Trener trenerDelete = (Trener) klijentskiZahtjev.getObjekat();
                            int obrisan = Controller.getInstance().obrisiTrenera(trenerDelete);
                            serverskiOdgovor = new ServerskiOdgovor(obrisan, null);
                            break;
                        case NADJI_TRENERA:
                            Trener trenerPretraga = (Trener) klijentskiZahtjev.getObjekat();
                            List<Trener> listaTreneraPretraga = Controller.getInstance().nadjiTrenere(trenerPretraga);
                            serverskiOdgovor = new ServerskiOdgovor(listaTreneraPretraga, null);
                            break;
                        case NADJI_FUBALERA:
                            Fudbaler fudbalerPretraga = (Fudbaler) klijentskiZahtjev.getObjekat();
                            List<Fudbaler> listaFudbaleraPretraga = Controller.getInstance().nadjiFudbalere(fudbalerPretraga);
                            serverskiOdgovor = new ServerskiOdgovor(listaFudbaleraPretraga, null);
                            break;
                        case IZMJENA_FUDBALERA:
                            Fudbaler fudbalerUpdate = (Fudbaler) klijentskiZahtjev.getObjekat();
                            int izmjenjenFudb = Controller.getInstance().zapamtiIzmjeneFudbalera(fudbalerUpdate);
                            serverskiOdgovor = new ServerskiOdgovor(izmjenjenFudb, null);
                            break;
                        case OBRISI_FUDBALERA:
                            Fudbaler fudbalerDelete = (Fudbaler) klijentskiZahtjev.getObjekat();
                            int obrisanFudb = Controller.getInstance().obrisiFudbalera(fudbalerDelete);
                            serverskiOdgovor = new ServerskiOdgovor(obrisanFudb, null);
                            break;
                        case NADJI_TRENING_GRUPU:
                            TreningGrupa treningGrupaPretraga = (TreningGrupa) klijentskiZahtjev.getObjekat();
                            List<TreningGrupa> listaTreningGrupaPretraga = Controller.getInstance().nadjiTreningGrupe(treningGrupaPretraga);
                            serverskiOdgovor = new ServerskiOdgovor(listaTreningGrupaPretraga, null);
                            break;
                        case IZMJENA_TRENING_GRUPE:
                            TreningGrupa treningGrupaUpdate = (TreningGrupa) klijentskiZahtjev.getObjekat();
                            int izmjenjenaTG = Controller.getInstance().zapamtiIzmjeneTreningGrupe(treningGrupaUpdate);
                            serverskiOdgovor = new ServerskiOdgovor(izmjenjenaTG, null);
                            break;
                        case OBRISI_TRENING_GRUPU:
                            TreningGrupa treningGrupaDelete = (TreningGrupa) klijentskiZahtjev.getObjekat();
                            int obrisanaTreningGrupa = Controller.getInstance().obrisiTreningGrupu(treningGrupaDelete);
                            serverskiOdgovor = new ServerskiOdgovor(obrisanaTreningGrupa, null);
                            break;
                        case UCITAJ_TRENERA:
                            Trener trener = (Trener) klijentskiZahtjev.getObjekat();
                            Trener trenerBaza = Controller.getInstance().ucitajTrenera(trener);
                            serverskiOdgovor = new ServerskiOdgovor(trenerBaza, null);
                            break;
                        case UCITAJ_FUDBALERA:
                            Fudbaler fudbaler = (Fudbaler) klijentskiZahtjev.getObjekat();
                            Fudbaler fudbalerBaza = Controller.getInstance().ucitajFudbalera(fudbaler);
                            serverskiOdgovor = new ServerskiOdgovor(fudbalerBaza, null);
                            break;
                        case UCITAJ_TRENING_GRUPU:
                            TreningGrupa treningGrupa = (TreningGrupa) klijentskiZahtjev.getObjekat();
                            TreningGrupa treningGrupaBaza = Controller.getInstance().ucitajTreningGrupu(treningGrupa);
                            serverskiOdgovor = new ServerskiOdgovor(treningGrupaBaza, null);
                            break;
                        case ZAPAMTI_TRENING_UTAKMICU:
                            TreningUtakmica tuInsert = (TreningUtakmica) klijentskiZahtjev.getObjekat();
                            long tuID = Controller.getInstance().zapamtiTreningUtakmicu(tuInsert);
                            serverskiOdgovor = new ServerskiOdgovor(tuID, null);
                            break;
                        case UCITAJ_LISTU_TRENING_UTAKMICA:
                            List<TreningUtakmica> listaTreningUtakmica = Controller.getInstance().ucitajListuTreningUtakmica();
                            serverskiOdgovor = new ServerskiOdgovor(listaTreningUtakmica, null);
                            break;
                        case DODAJ_LEKARSKI_PREGLED:
                            LekarskiPregled pregledInsert = (LekarskiPregled) klijentskiZahtjev.getObjekat();
                            long pregledId = Controller.getInstance().zapamtiPregled(pregledInsert);
                            serverskiOdgovor = new ServerskiOdgovor(pregledId, null);
                            break;

                    }
                } catch (Exception ex) {

                    serverskiOdgovor = new ServerskiOdgovor(null, ex);
                }
                posiljalac.posaljiPoruku(serverskiOdgovor);
            }
        } catch (SocketException se) {
            server.getListaNiti().remove(this);
        } catch (Exception ex) {
        }
    }

    public Korisnik getTrenutnoUlogovani() {
        return trenutnoUlogovani;
    }

}
