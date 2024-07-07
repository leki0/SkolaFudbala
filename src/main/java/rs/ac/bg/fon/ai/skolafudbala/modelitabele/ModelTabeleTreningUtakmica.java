/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.modelitabele;

import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;





/**
 *
 * @author Korisnik
 */
public class ModelTabeleTreningUtakmica extends AbstractTableModel {

    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
    List<TreningUtakmica> listaTreningUtakmica = new ArrayList<>();
    String[] kolone = {"Redni broj", "Datum", "Broj golova tim1", "Broj golova tim2", "Tim 1", "Tim 2"};

    public ModelTabeleTreningUtakmica() {
    }

    public ModelTabeleTreningUtakmica(List<TreningUtakmica> listaTreningUtakmica) {
        this.listaTreningUtakmica = listaTreningUtakmica;
    }

    @Override
    public int getRowCount() {
        return listaTreningUtakmica.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaTreningUtakmica.get(rowIndex).getRedniBroj();
            case 1:
                return formater.format(listaTreningUtakmica.get(rowIndex).getDatum());
            case 2:
                return listaTreningUtakmica.get(rowIndex).getBrojGolovaTim1();
            case 3:
                return listaTreningUtakmica.get(rowIndex).getBrojGolovaTikm2();
            case 4:
                return listaTreningUtakmica.get(rowIndex).getTim1().getNazivGrupe();
            case 5:
                return listaTreningUtakmica.get(rowIndex).getTim2().getNazivGrupe();
            default:
                return "NaN";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public TreningUtakmica get(int selectedRow) {
        return listaTreningUtakmica.get(selectedRow);
    }

}
