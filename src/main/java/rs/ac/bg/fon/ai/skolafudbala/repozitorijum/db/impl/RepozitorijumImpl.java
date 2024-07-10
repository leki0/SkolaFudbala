/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db.impl;

import rs.ac.bg.fon.ai.skolafudbala.model.GenerickiEntitet;
import rs.ac.bg.fon.ai.skolafudbala.model.StatistikaFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db.DBConnection;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db.RepozitorijumDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class RepozitorijumImpl implements RepozitorijumDb<GenerickiEntitet, Object> {

    @Override
    public List<GenerickiEntitet> getAll(GenerickiEntitet odo) throws Exception {
        List<GenerickiEntitet> lista = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").
                    append(odo.getTableName()).
                    append(" ").
                    append(odo.getAlijas()).append(" ").
                    append(odo.getJoinText());
            String sqlUpit = sb.toString();
            System.out.println("SQL upit:" + sqlUpit);
            ResultSet rs = statement.executeQuery(sqlUpit);
            while (rs.next()) {
                lista.add(odo.getEntity(rs));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(RepozitorijumImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public GenerickiEntitet getWhere(GenerickiEntitet odo) throws Exception {
        GenerickiEntitet obj = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").
                    append(odo.getTableName()).
                    append(" ").
                    append(odo.getAlijas()).append(" ").
                    append(odo.getJoinText()).append(" ").
                    append(odo.getWhere()).append(odo.getObjID());
            String sqlUpit = sb.toString();
            System.out.println("SQL upit:" + sqlUpit);
            ResultSet rs = statement.executeQuery(sqlUpit);
            while (rs.next()) {
                obj = odo.getEntity(rs);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(RepozitorijumImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public long add(GenerickiEntitet odo) throws Exception {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ").
                    append(odo.getTableName()).
                    append('(').
                    append(odo.getInsertColumns()).
                    append(')').
                    append(" VALUES ").
                    append('(').
                    append(odo.getInsertValues()).
                    append(')');
            String sqlUpit = sb.toString();
            System.out.println(sqlUpit);

            long id = -1;
            if (odo instanceof StatistikaFudbalera) {
                try {
                    id = statement.executeUpdate(sqlUpit);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                statement.executeUpdate(sqlUpit, Statement.RETURN_GENERATED_KEYS);
                ResultSet rsKeys = statement.getGeneratedKeys();
                while (rsKeys.next()) {
                    id = rsKeys.getLong(1);
                    odo.setId(id);
                }
                rsKeys.close();
            }
            statement.close();
            return id;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public int addUpdate(GenerickiEntitet odo) throws Exception{
        int broj = -1;
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ").
                    append(odo.getTableName()).
                    append(" ").
                    append(odo.getAlijas()).
                    append(" SET ").
                    append(odo.getUpdateValues()).
                    append(" WHERE ").
                    append(odo.getAlijas()).
                    append(".").
                    append(odo.getID()).
                    append("=").
                    append(odo.getObjID());
            String sqlUpit = sb.toString();
            System.out.println(sqlUpit);
            broj = statement.executeUpdate(sqlUpit);
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(RepozitorijumImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RepozitorijumImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return broj;
    }

    @Override
    public int delete(GenerickiEntitet odo) throws Exception {
        int broj = -1;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").
                    append(odo.getTableName()).
                    append(" WHERE ").
                    append(odo.getID()).
                    append("=").
                    append(odo.getObjID());
            String sqlUpit = sb.toString();
            System.out.println(sqlUpit);
            broj = statement.executeUpdate(sqlUpit);
            statement.close();

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("Ne mozete obrisati objekat zbog ograničenja baze podataka!");
        } catch (Exception ex) {
            Logger.getLogger(RepozitorijumImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return broj;
    }

    @Override
    public List<GenerickiEntitet> pretraga(GenerickiEntitet odo) throws Exception {
        List<GenerickiEntitet> lista = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").
                    append(odo.getTableName()).append(" ").append(odo.getAlijas()).
                    append(" ").
                    append(odo.getJoinText()).
                    append(" WHERE ").
                    append(odo.getWhereDvaParametra());
            String sqlUpit = sb.toString();
            System.out.println(sqlUpit);
            ResultSet rs = statement.executeQuery(sqlUpit);
            while (rs.next()) {
                lista.add(odo.getEntity(rs));
            }
            statement.close();

        } catch (Exception ex) {
            Logger.getLogger(RepozitorijumImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
