/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Posiljalac {

    private Socket socket;

    public Posiljalac(Socket socket) {
        this.socket = socket;
    }

    public void posaljiPoruku(Object objekat) throws IOException {
        ObjectOutputStream socketOut = new ObjectOutputStream(socket.getOutputStream());
        socketOut.writeObject(objekat);
        socketOut.flush();

    }

}
