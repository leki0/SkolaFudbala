/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db;

import java.io.FileInputStream;
import rs.ac.bg.fon.ai.skolafudbala.konstante.ServerKonstante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



/**
 *
 * @author Korisnik
 */
public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream(ServerKonstante.PROPERTY_PATH));
            String url = properties.getProperty(ServerKonstante.DB_URL);
            String username = properties.getProperty(ServerKonstante.DB_USERNAME);
            String password = properties.getProperty(ServerKonstante.DB_PASSWORD);
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/skola_fudbala", "root", "");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }

}
