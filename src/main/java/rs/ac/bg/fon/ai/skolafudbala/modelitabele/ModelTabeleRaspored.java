/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.modelitabele;

import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Korisnik
 */
public class ModelTabeleRaspored extends AbstractTableModel {

    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
    List<Raspored> listaRasporeda;
    String[] kolone = {"Tip treninga", "Datum početka", "Datum završetka"};

    public ModelTabeleRaspored() {
    }

    public ModelTabeleRaspored(List<Raspored> listaRasporeda) {
        this.listaRasporeda = listaRasporeda;
    }

    @Override
    public int getRowCount() {
        return listaRasporeda.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaRasporeda.get(rowIndex).getTipTreninga();
            case 1:
                return formater.format(listaRasporeda.get(rowIndex).getDatumOd());
            case 2:
                return formater.format(listaRasporeda.get(rowIndex).getDatumDo());
            default:
                return "NaN";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Raspored get(int selectedRow) {
        return listaRasporeda.get(selectedRow);
    }

}
