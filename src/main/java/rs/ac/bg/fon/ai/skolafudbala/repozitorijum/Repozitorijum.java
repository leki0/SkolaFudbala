/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.repozitorijum;

import rs.ac.bg.fon.ai.skolafudbala.model.GenerickiEntitet;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface Repozitorijum<T, K> {

    public List<T> getAll(T odo) throws Exception;

    public T getWhere(T odo) throws Exception;

    public long add(T odo) throws Exception;

    public int addUpdate(T odo) throws Exception;

    public int delete(T odo) throws Exception;

    public List<GenerickiEntitet> pretraga(T odo) throws Exception;

}
