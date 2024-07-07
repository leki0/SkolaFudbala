 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.repozitorijum.db;

import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;



/**
 *
 * @author Korisnik
 */
public interface RepozitorijumDb <T, K> extends Repozitorijum<T, K>{
    default void connect() throws Exception {
        DBConnection.getInstance().getConnection();
    }
    
    default void disconnect() throws Exception {
        DBConnection.getInstance().getConnection().close();
    }
    
    default void commit() throws Exception {
        DBConnection.getInstance().getConnection().commit();
    }
    
    default void rollback() throws Exception {
        DBConnection.getInstance().getConnection().rollback();
    }
}
