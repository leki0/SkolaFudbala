/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.modelitabele;

import rs.ac.bg.fon.ai.skolafudbala.enums.Pozicija;
import rs.ac.bg.fon.ai.skolafudbala.model.StatistikaFudbalera;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Korisnik
 */
public class ModelTabeleStatistika extends AbstractTableModel {

    List<StatistikaFudbalera> listaStatistika = new ArrayList<>();
    String[] kolone = {"Igrač", "Broj golova", "Broj asistencija", "Promašeni šutevi", "Provedeni minuti", "Prva postava", "Broj odbrana", "Primljeni golovi", "Ocjena", "Tim", "Pozicija"};

    public ModelTabeleStatistika() {
    }

    public ModelTabeleStatistika(List<StatistikaFudbalera> listaStatistika) {
        this.listaStatistika = listaStatistika;
    }

    @Override
    public int getRowCount() {
        return listaStatistika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaStatistika.get(rowIndex).getFudbaler().getIme() + " " + listaStatistika.get(rowIndex).getFudbaler().getPrezime();
            case 1:
                return listaStatistika.get(rowIndex).getBrojGolova();
            case 2:
                return listaStatistika.get(rowIndex).getBrojAsistencija();
            case 3:
                return listaStatistika.get(rowIndex).getBrojPromasenihSuteva();
            case 4:
                return listaStatistika.get(rowIndex).getBrojProvedenihMinuta();
            case 5:
                return (listaStatistika.get(rowIndex).isPrvaPostava() ? "DA" : "NE");
            case 6:
                if (listaStatistika.get(rowIndex).getBrojOdbrana() == 0) {
                    if (listaStatistika.get(rowIndex).getFudbaler().getPozicija().equals(String.valueOf(Pozicija.GOLMAN))
                            || listaStatistika.get(rowIndex).getFudbaler().getPozicija().equals(String.valueOf(Pozicija.STOPER))) {
                        return 0;
                    } else {
                        return "/";
                    }
                } else {
                    return listaStatistika.get(rowIndex).getBrojOdbrana();
                }
            case 7:
                if (listaStatistika.get(rowIndex).getBrojPrimljenihGolova() == 0) {
                    if (listaStatistika.get(rowIndex).getFudbaler().getPozicija().equals(String.valueOf(Pozicija.GOLMAN))) {
                        return 0;
                    } else {
                        return "/";
                    }
                } else {
                    return listaStatistika.get(rowIndex).getBrojPrimljenihGolova();
                }

            case 8:
                return listaStatistika.get(rowIndex).getOcjena();
            case 9:
                return listaStatistika.get(rowIndex).getFudbaler().getTreningGrupa();
            case 10:
                return listaStatistika.get(rowIndex).getFudbaler().getPozicija();
            default:
                return "NaN";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public StatistikaFudbalera get(int selectedRow) {
        return listaStatistika.get(selectedRow);
    }

}
