/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Primalac {

    private Socket socket;

    public Primalac(Socket socket) {
        this.socket = socket;
    }

    public Object primiPoruku() throws IOException, ClassNotFoundException {
        ObjectInputStream socketIn;
        //try {
        socketIn = new ObjectInputStream(socket.getInputStream());
        //} catch (Exception ex) {
        // throw new Exception("Error receiving object!\n" );
        //}
        return socketIn.readObject();
    }
}
