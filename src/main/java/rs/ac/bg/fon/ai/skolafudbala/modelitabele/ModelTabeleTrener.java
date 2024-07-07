/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.modelitabele;

import rs.ac.bg.fon.ai.skolafudbala.klijent.Klijent;
import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Korisnik
 */
public class ModelTabeleTrener extends AbstractTableModel {

    List<Trener> listaTrenera = new ArrayList<>();
    String[] kolone = {"Ime", "Prezime", "JMBG", "Godine iskustva"};

    public ModelTabeleTrener() throws Exception {
      
            listaTrenera = Klijent.getInstance().ucitajListuTrenera();
        
    }

    public ModelTabeleTrener(List<Trener> listaTrenera) {
        
        this.listaTrenera = listaTrenera;
    }

    @Override
    public int getRowCount() {
        return listaTrenera.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaTrenera.get(rowIndex).getIme();
            case 1:
                return listaTrenera.get(rowIndex).getPrezime();
            case 2:
                return listaTrenera.get(rowIndex).getJmbg();
            case 3:
                return listaTrenera.get(rowIndex).getGodineIskustva();
            default:
                return "NaN";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Trener get(int selectedRow) {
        return listaTrenera.get(selectedRow);
    }

}
