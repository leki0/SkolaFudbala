/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.modelitabele;

import rs.ac.bg.fon.ai.skolafudbala.klijent.Klijent;
import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Korisnik
 */
public class ModelTabeleFudbalerTG extends AbstractTableModel {

    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
    private List<Fudbaler> listaFudbalera = new ArrayList<>();
    private String[] kolone = {"Ime", "Prezime", "JMBG", "Pozicija", "Datum rođenja", "Trening grupa", "Trener"};

    public ModelTabeleFudbalerTG() throws Exception {
        listaFudbalera = Klijent.getInstance().ucitajListuFudbalera();

    }

    public ModelTabeleFudbalerTG(List<Fudbaler> listaFudbalera) {
        this.listaFudbalera = listaFudbalera;
        System.out.println("br:" + this.listaFudbalera.size());
    }

    @Override
    public int getRowCount() {
        return listaFudbalera.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaFudbalera.get(rowIndex).getIme();
            case 1:
                return listaFudbalera.get(rowIndex).getPrezime();
            case 2:
                return listaFudbalera.get(rowIndex).getJmbg();
            case 3:
                return listaFudbalera.get(rowIndex).getPozicija();
            case 4:
                return formater.format(listaFudbalera.get(rowIndex).getDatumRodjenja());
            case 5:
                return listaFudbalera.get(rowIndex).getTreningGrupa();
            case 6:
                return listaFudbalera.get(rowIndex).getTreningGrupa().getTrener().getIme() + " " + listaFudbalera.get(rowIndex).getTreningGrupa().getTrener().getPrezime();
            default:
                return "NaN";

        }
    }

    public List<Fudbaler> getListaFudbalera() {
        return listaFudbalera;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Fudbaler get(int selectedRow) {
        return listaFudbalera.get(selectedRow);
    }
}
