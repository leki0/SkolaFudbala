/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public interface GenerickiEntitet extends Serializable {

    public String getTableName();

    public String getInsertColumns();

    public String getInsertValues();

    public void setId(long id);

    public String getUpdateValues();

    public String getJoinText();

    public String getSelectedText();

    public String getID();

    public GenerickiEntitet getEntity(ResultSet rs) throws SQLException;

    public GenerickiEntitet getJoinEntity(ResultSet rs) throws SQLException;

    public long getObjID();

    public String getWhereDvaParametra();

    public String getAlijas();

    public String getWhere();

}
