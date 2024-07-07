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

    public List<T> getAll(T odo);

    public T getWhere(T odo);

    public long add(T odo) throws Exception;

    public int addUpdate(T odo);

    public int delete(T odo);

    public List<GenerickiEntitet> pretraga(T odo);

}
