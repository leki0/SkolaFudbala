/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.modelitabele;

import rs.ac.bg.fon.ai.skolafudbala.klijent.Klijent;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Korisnik
 */
public class ModelTabeleTreningGrupa extends AbstractTableModel {

    List<TreningGrupa> listaTreningGrupa = new ArrayList<>();
    String[] kolone = {"Naziv grupe", "Kapacitet", "Trener"};

    public ModelTabeleTreningGrupa() throws Exception {

        listaTreningGrupa = Klijent.getInstance().ucitajListuTreningGrupe();

    }

    public ModelTabeleTreningGrupa(List<TreningGrupa> listaTreningGrupa) {
        System.out.println("VELICINA MODEL: " + listaTreningGrupa.size());
        this.listaTreningGrupa = listaTreningGrupa;
    }

    @Override
    public int getRowCount() {
        return listaTreningGrupa.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaTreningGrupa.get(rowIndex).getNazivGrupe();
            case 1:
                return listaTreningGrupa.get(rowIndex).getKapacitet();
            case 2:
                return (listaTreningGrupa.get(rowIndex).getTrener().getIme() + " " + listaTreningGrupa.get(rowIndex).getTrener().getPrezime());
            default:
                return "NaN";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public TreningGrupa get(int selectedRow) {
        return listaTreningGrupa.get(selectedRow);
    }

}
