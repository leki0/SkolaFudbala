/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import rs.ac.bg.fon.ai.skolafudbala.formeServer.ServerForma;
import rs.ac.bg.fon.ai.skolafudbala.konstante.ServerKonstante;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



/**
 *
 * @author Korisnik
 */
public class Server extends Thread {

    private List<ObradaKlijentskogZahtjeva> listaNiti = new ArrayList<>();
    private List<Korisnik> listaPrijavljenih = new ArrayList<>();
    private ServerSocket sSocket;
    private Properties properties;
    private ServerForma forma;
    private boolean signal = true;
    private Socket socket;

    public Server(ServerForma forma) {
        try {
            this.forma = forma;
            int port = getPort();
            sSocket = new ServerSocket(port);
            start();
        } catch (IOException ex) {
            System.out.println("Greska prilikom pokretanja servera!" + ex);
        }
    }

    private int getPort(){
        int port = 0;
        try {
            properties = new Properties();
            properties.load(new FileInputStream(ServerKonstante.PROPERTY_PATH));
            port = Integer.parseInt(properties.getProperty(ServerKonstante.DB_PORT));
        } catch (FileNotFoundException ex) {
            System.out.println("Greska prilikom ucitavanja PORT-a iz fajla!" + ex);
        } catch (IOException ex) {
            System.out.println("Greska prilikom ucitavanja PORT-a iz fajla!" + ex);
        }
        return port;
    }

    public int dodajKorisnika(Korisnik k) {
        if (listaPrijavljenih.contains(k)) {
            return -1;
        }
        listaPrijavljenih.add(k);
        return 0;
    }

    public List<ObradaKlijentskogZahtjeva> getListaNiti() {
        return listaNiti;
    }

    public List<Korisnik> getListaPrijavljenih() {
        return listaPrijavljenih;
    }

    public ServerSocket getsSocket() {
        return sSocket;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isSignal() {
        return signal;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public void odjava(ObradaKlijentskogZahtjeva okz) {
        listaNiti.remove(okz);
        listaPrijavljenih.remove(okz.getTrenutnoUlogovani());
    }

    @Override
    public void run() {
        try {
                System.out.println("Server pokrenut! Server ceka klijente da se povezu!");
                while (true) {
                    socket = sSocket.accept();
                    System.out.println("Klijent uspjesno povezan na server!");
                    ObradaKlijentskogZahtjeva nit = new ObradaKlijentskogZahtjeva(socket, this);
                    listaNiti.add(nit);
                    nit.start();
                }

        }catch(SocketException se){
            
        }
        catch (IOException ex) {
            System.out.println("Neuspjesno povezivanje klijenta na socket!" + ex);
        } finally {
            for (ObradaKlijentskogZahtjeva nit : listaNiti) {
                try {
                    nit.getSocket().close();
                } catch (IOException ex) {
                    System.out.println("Neuspjesno povezivanje klijenta na socket!" + ex);
                }
            }

        }

    }
}
