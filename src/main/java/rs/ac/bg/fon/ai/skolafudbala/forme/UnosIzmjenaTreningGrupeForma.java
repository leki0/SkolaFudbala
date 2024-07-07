/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.forme;

import java.io.IOException;
import rs.ac.bg.fon.ai.skolafudbala.enums.TipTreninga;
import rs.ac.bg.fon.ai.skolafudbala.klijent.Klijent;
import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import rs.ac.bg.fon.ai.skolafudbala.modelitabele.ModelTabeleFudbalerTG;
import rs.ac.bg.fon.ai.skolafudbala.modelitabele.ModelTabeleRaspored;
import rs.ac.bg.fon.ai.skolafudbala.nacinprikazaforme.Prikaz;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;



/**
 *
 * @author Korisnik
 */
public class UnosIzmjenaTreningGrupeForma extends javax.swing.JFrame {

    String patern = "dd-MM-yyyy";
    SimpleDateFormat formater = new SimpleDateFormat(patern);
    private long tgIzmj;
    TreningGrupa treningGrupaIzmjena;
    ModelTabeleFudbalerTG mtf;
    List<Raspored> listaRasporeda = new ArrayList<>();
    List<Fudbaler> listaFudbalera = new ArrayList<>();
    Prikaz nacinPrikaza;
    PregledTreningGrupaForma ptgf;

    /**
     * Creates new form UnosTreningGrupe
     */
    public UnosIzmjenaTreningGrupeForma(PregledTreningGrupaForma ptgf, Prikaz nacinPrikaza, TreningGrupa tg) {
        initComponents();
        this.treningGrupaIzmjena = tg;
        this.nacinPrikaza = nacinPrikaza;
        try {
            popuniComboBox(0, treningGrupaIzmjena.getTrener());
        } catch (Exception ex) {
            if (ex instanceof IOException) {
                JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        try {
            prikaz(nacinPrikaza);
        } catch (Exception ex) {
            if (ex instanceof IOException) {
                JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        this.ptgf = ptgf;

    }

    public UnosIzmjenaTreningGrupeForma(Prikaz nacinPrikaza, TreningGrupa tg) {
        initComponents();
        this.treningGrupaIzmjena = tg;
        this.nacinPrikaza = nacinPrikaza;
        try {
            //popuniComboBox(0, null);
            prikaz(nacinPrikaza);
        } catch (Exception ex) {
            if (ex instanceof IOException) {
                JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNazivTreningGrupe = new javax.swing.JTextField();
        jTextFieldKapacitet = new javax.swing.JTextField();
        jComboBoxTrener = new javax.swing.JComboBox<>();
        jButtonDodaj = new javax.swing.JButton();
        jButtonPonisti = new javax.swing.JButton();
        jButtonSacuvajIzmjene = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldDatumOd = new javax.swing.JTextField();
        jLabelDatOd = new javax.swing.JLabel();
        jLabelDatDo = new javax.swing.JLabel();
        jTextFieldDatumDo = new javax.swing.JTextField();
        jLabelTip = new javax.swing.JLabel();
        jComboBoxTipTreninga = new javax.swing.JComboBox<>();
        jButtonDodajRaspored = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRaspored = new javax.swing.JTable();
        jButtonIzbaciTabelaRasp = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();
        jButtonObrisi1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelUnosRasporeda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Naziv trening grupe:");

        jLabel2.setText("Kapacitet:");

        jLabel3.setText("Trener:");

        jTextFieldKapacitet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKapacitetActionPerformed(evt);
            }
        });

        jButtonDodaj.setText("Dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonPonisti.setText("Poništi");
        jButtonPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPonistiActionPerformed(evt);
            }
        });

        jButtonSacuvajIzmjene.setText("Sačuvaj izmjene");
        jButtonSacuvajIzmjene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacuvajIzmjeneActionPerformed(evt);
            }
        });

        jLabelDatOd.setText("Od datuma:");

        jLabelDatDo.setText("Do datuma:");

        jTextFieldDatumDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDatumDoActionPerformed(evt);
            }
        });

        jLabelTip.setText("Tip treninga:");

        jButtonDodajRaspored.setText("Dodaj");
        jButtonDodajRaspored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajRasporedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTip, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipTreninga, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDatOd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDatDo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonDodajRaspored, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTip)
                    .addComponent(jComboBoxTipTreninga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDatOd)
                    .addComponent(jTextFieldDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDatDo)
                    .addComponent(jTextFieldDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonDodajRaspored)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableRaspored.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableRaspored);

        jButtonIzbaciTabelaRasp.setText("Izbaci iz tabele");
        jButtonIzbaciTabelaRasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzbaciTabelaRaspActionPerformed(evt);
            }
        });

        jButtonOdustani.setText("Odustani");
        jButtonOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdustaniActionPerformed(evt);
            }
        });

        jButtonObrisi1.setText("Obriši");
        jButtonObrisi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisi1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Raspored");

        jLabelUnosRasporeda.setText("Unos rasporeda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNazivTreningGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldKapacitet, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxTrener, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonObrisi1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSacuvajIzmjene, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonOdustani, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonIzbaciTabelaRasp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabelUnosRasporeda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNazivTreningGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldKapacitet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxTrener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabelUnosRasporeda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIzbaciTabelaRasp)
                    .addComponent(jButtonSacuvajIzmjene))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonObrisi1)
                    .addComponent(jButtonOdustani))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonPonisti))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldKapacitetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldKapacitetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldKapacitetActionPerformed

    private void jButtonPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPonistiActionPerformed
        ponovniUnos();
    }//GEN-LAST:event_jButtonPonistiActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        String nazivGrupe = jTextFieldNazivTreningGrupe.getText();
        String kapacitetString = jTextFieldKapacitet.getText();
        Trener trener = (Trener) jComboBoxTrener.getSelectedItem();
        boolean validneTabele = validirajTabele(listaRasporeda);
        if (validneTabele) {
            String validan = validirajTG(nazivGrupe, kapacitetString, trener);
            if (validan.equals("")) {
                String validanFormat = validirajFormat(nazivGrupe, kapacitetString);
                if (validanFormat.equals("")) {
                    try {
                        int kapacitet = Integer.parseInt(kapacitetString);
                        TreningGrupa tg = new TreningGrupa(nazivGrupe, kapacitet, trener, listaRasporeda);
                        long tgId = Klijent.getInstance().zapamtiTreningGrupu(tg);
                        JOptionPane.showMessageDialog(this, "Sistem je zapamtio trening grupu!", "Zapamćena trening grupa", JOptionPane.INFORMATION_MESSAGE);
                        ponovniUnos();
                    } catch (Exception ex) {
                        if (ex instanceof IOException) {
                            JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        } else {
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti trening grupu!", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(this, "Neispravan format unosa: " + validanFormat, "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti trening grupu!", "GRESKA", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Morate da popunite polja: " + validan, "GRESKA", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Morate napraviti bar jedan Raspored za trening grupu!", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonSacuvajIzmjeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajIzmjeneActionPerformed
        String nazivGrupe = jTextFieldNazivTreningGrupe.getText();
        String kapacitetString = jTextFieldKapacitet.getText();
        Trener trener = (Trener) jComboBoxTrener.getSelectedItem();
        if (validirajTabele(listaRasporeda)) {
            String validan = validirajTG(nazivGrupe, kapacitetString, trener);
            if (validan.equals("")) {
                String validanFormat = validirajFormat(nazivGrupe, kapacitetString);
                if (validanFormat.equals("")) {
                    try {
                        int kapacitet = Integer.parseInt(kapacitetString);
                        TreningGrupa tgUpdate = new TreningGrupa(tgIzmj, nazivGrupe, kapacitet, trener, listaRasporeda);
                        int brojIzmjena = Klijent.getInstance().zapamtiIzmjeneTreningGrupe(tgUpdate);
                        JOptionPane.showMessageDialog(this, "Sistem je zapamtio trening grupu!", "Trening grupa zapamcena", JOptionPane.INFORMATION_MESSAGE);
                        ptgf.osvjezi();
                        this.dispose();
                    } catch (Exception ex) {
                        if (ex instanceof IOException) {
                            JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        } else {
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti fudbalera!", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(this, "Neispravan format unosa: " + validanFormat, "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti trening grupu!", "GRESKA", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Morate da popunite polja: " + validan, "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Morate da napravite bar jedan Raspored za trening grupu!", "GRESKA", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_jButtonSacuvajIzmjeneActionPerformed

    private void jTextFieldDatumDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDatumDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDatumDoActionPerformed

    private void jButtonDodajRasporedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajRasporedActionPerformed
        TipTreninga tipTreninga = (TipTreninga) jComboBoxTipTreninga.getSelectedItem();
        String datumOd = jTextFieldDatumOd.getText();
        String datumDo = jTextFieldDatumDo.getText();
        boolean vecPostoji = postoji(tipTreninga, datumOd, datumDo);
        if (vecPostoji) {
            JOptionPane.showMessageDialog(this, "Ovaj raspored je vec unijet!", "GRESKA", JOptionPane.ERROR_MESSAGE);
        } else {
            String validan = validirajRaspored(tipTreninga, datumOd, datumDo);
            if (validan.equals("")) {
                String validanFormat = validirajRasporedFormat(tipTreninga, datumOd, datumDo);
                if (validanFormat.equals("")) {
                    try {
                        Raspored r = new Raspored(null, formater.parse(datumOd), formater.parse(datumDo), tipTreninga.toString());
                        listaRasporeda.add(r);
                        ModelTabeleRaspored mtr = new ModelTabeleRaspored(listaRasporeda);
                        jTableRaspored.setModel(mtr);
                        osvjeziRaspored();
                    } catch (ParseException ex) {
                        //JOptionPane.showMessageDialog(this, "Niste unijeli datum u ispravnom formatu! Ispravan format: (dd-MM-yyyy)", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Pogrešan format unosa: " + validanFormat, "GREšKA", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Morate da popunite polja: " + validan, "GREŠKA", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonDodajRasporedActionPerformed

    private void jButtonIzbaciTabelaRaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzbaciTabelaRaspActionPerformed
        if (jTableRaspored.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Morate da selektujete raspored!", "GREšKA", JOptionPane.ERROR_MESSAGE);
        } else {
            Raspored raspored = new Raspored();
            ModelTabeleRaspored mtr = new ModelTabeleRaspored();
            raspored = listaRasporeda.get(jTableRaspored.getSelectedRow());
            listaRasporeda.remove(raspored);
            mtr = new ModelTabeleRaspored(listaRasporeda);
            jTableRaspored.setModel(mtr);

        }
    }//GEN-LAST:event_jButtonIzbaciTabelaRaspActionPerformed

    private void jButtonOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdustaniActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOdustaniActionPerformed

    private void jButtonObrisi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisi1ActionPerformed
        String nazivGrupe = jTextFieldNazivTreningGrupe.getText();
        String kapacitetString = jTextFieldKapacitet.getText();
        Trener trener = (Trener) jComboBoxTrener.getSelectedItem();

        try {
            int kapacitet = Integer.parseInt(kapacitetString);
            TreningGrupa tgDelete = new TreningGrupa(treningGrupaIzmjena.getObjID(), nazivGrupe, kapacitet, trener, listaRasporeda);
            int brojBrisanje = Klijent.getInstance().obrisiTreningGrupu(tgDelete);
            JOptionPane.showMessageDialog(this, "Sistem je obrisao trening grupu!", "Trening grupa zapamćena", JOptionPane.INFORMATION_MESSAGE);
            ptgf.osvjezi();
            this.dispose();
        } catch (Exception ex) {
            if (ex instanceof IOException) {
                JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "GREšKA", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_jButtonObrisi1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonDodajRaspored;
    private javax.swing.JButton jButtonIzbaciTabelaRasp;
    private javax.swing.JButton jButtonObrisi1;
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JButton jButtonPonisti;
    private javax.swing.JButton jButtonSacuvajIzmjene;
    private javax.swing.JComboBox<TipTreninga> jComboBoxTipTreninga;
    private javax.swing.JComboBox<Trener> jComboBoxTrener;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelDatDo;
    private javax.swing.JLabel jLabelDatOd;
    private javax.swing.JLabel jLabelTip;
    private javax.swing.JLabel jLabelUnosRasporeda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableRaspored;
    private javax.swing.JTextField jTextFieldDatumDo;
    private javax.swing.JTextField jTextFieldDatumOd;
    private javax.swing.JTextField jTextFieldKapacitet;
    private javax.swing.JTextField jTextFieldNazivTreningGrupe;
    // End of variables declaration//GEN-END:variables

    private void prikaz(Prikaz nacinPrikaza) throws Exception {
        if (nacinPrikaza == Prikaz.DODAJ_FORMA) {
            /*listaRasporeda = new ArrayList<>();
            ModelTabeleRaspored mtr = new ModelTabeleRaspored(listaRasporeda);
            jTableRaspored.setModel(mtr);*/
            popuniComboBox(0, null);
            jButtonDodaj.setVisible(true);
            jButtonSacuvajIzmjene.setVisible(false);
            jButtonIzbaciTabelaRasp.setVisible(false);
            jButtonObrisi1.setVisible(false);
            jButtonOdustani.setVisible(false);
            this.setTitle("Unos podataka o trening grupi");

        } else if (nacinPrikaza == Prikaz.IZMJENI_FORMA) {
            jComboBoxTrener.removeAllItems();
            popuniComboBox(1, treningGrupaIzmjena.getTrener());
            Trener t6 = new Trener(treningGrupaIzmjena.getTrener().getIme(), treningGrupaIzmjena.getTrener().getPrezime(), treningGrupaIzmjena.getTrener().getJmbg(), treningGrupaIzmjena.getTrener().getGodineIskustva());
            System.out.println(t6.getPrezime());
            jComboBoxTrener.setSelectedItem(t6);
            jButtonDodaj.setVisible(false);
            jButtonSacuvajIzmjene.setVisible(true);
            listaRasporeda = treningGrupaIzmjena.getListaRasporeda();
            System.out.println("RASPORED: " + listaRasporeda.size());
            ModelTabeleFudbalerTG mtf = new ModelTabeleFudbalerTG(listaFudbalera);
            ModelTabeleRaspored mtr = new ModelTabeleRaspored(listaRasporeda);
            jTableRaspored.setModel(mtr);
            jButtonIzbaciTabelaRasp.setVisible(false);
            jTextFieldNazivTreningGrupe.setText(treningGrupaIzmjena.getNazivGrupe());
            jTextFieldKapacitet.setText(String.valueOf(treningGrupaIzmjena.getKapacitet()));
            jButtonIzbaciTabelaRasp.setVisible(true);
            jButtonObrisi1.setVisible(false);
            jButtonOdustani.setVisible(false);
            this.setTitle("Izmjena podataka o trening grupi");

        } else if (nacinPrikaza == Prikaz.OBRISI_FORMA) {
            listaRasporeda = treningGrupaIzmjena.getListaRasporeda();
            ModelTabeleFudbalerTG mtf = new ModelTabeleFudbalerTG(listaFudbalera);
            ModelTabeleRaspored mtr = new ModelTabeleRaspored(listaRasporeda);
            jTableRaspored.setModel(mtr);
            jPanel1.setVisible(false);
            jButtonDodaj.setVisible(false);
            jButtonPonisti.setVisible(false);
            jButtonSacuvajIzmjene.setVisible(false);
            jButtonObrisi1.setVisible(true);
            jButtonOdustani.setVisible(true);
            jTextFieldNazivTreningGrupe.setEditable(false);
            jTextFieldKapacitet.setEditable(false);
            jComboBoxTrener.setEnabled(false);
            jButtonIzbaciTabelaRasp.setVisible(false);
            jLabelUnosRasporeda.setVisible(false);
            jTextFieldNazivTreningGrupe.setText(treningGrupaIzmjena.getNazivGrupe());
            jTextFieldKapacitet.setText(String.valueOf(treningGrupaIzmjena.getKapacitet()));
            jComboBoxTrener.removeAllItems();
            popuniComboBox(1, treningGrupaIzmjena.getTrener());
            this.setTitle("Potvrda brisanja trening grupe");

        }
    }

    private String validirajRasporedFormat(TipTreninga tipTreninga, String datumOd, String datumDo) {
        String validan = "";

        if (datumOd.equals("")) {
            validan += "Datum od | ";
        }

        if (datumDo.equals("")) {
            validan += "Datum do | ";
        }

        if (tipTreninga == null) {
            validan += "Tip treninga | ";
        }
        try {
            Date datumOdDate = formater.parse(datumOd);
            Date datumDoDate = formater.parse(datumDo);
            if (datumOdDate.before(new Date()) || datumDoDate.before(new Date())) {
                validan += "Datum mora da bude trenutak u buducnosti!";
            } else {
                if (datumDoDate.before(datumOdDate) || datumDoDate == datumOdDate) {
                    validan += "Datum od mora biti trenutak prije datuma do | ";
                }
            }

        } catch (ParseException ex) {
            validan += "Datum mora da bude u formatu: dd-MM-yyyy";
        }
        return validan;
    }

    private String validirajTG(String nazivGrupe, String kapacitetString, Trener trener) {
        String validan = "";
        if (nazivGrupe.equals("")) {
            validan += "Naziv grupe | ";
        }
        if (kapacitetString.equals("")) {
            validan += "Kapacitet | ";
        }
        if (trener == null) {
            validan += "Trener | ";
        }

        return validan;
    }

    private boolean validirajTabele(List<Raspored> listaRasporeda) {
        if (listaRasporeda.size() == 0) {
            return false;
        }
        return true;
    }

    public TreningGrupa getTreningGrupaIzmjena() {
        return treningGrupaIzmjena;
    }

    public void setTreningGrupaIzmjena(TreningGrupa treningGrupaIzmjena) {
        this.treningGrupaIzmjena = treningGrupaIzmjena;
    }

    public long getTgIzmj() {
        return tgIzmj;
    }

    public void setTgIzmj(long tgIzmj) {
        this.tgIzmj = tgIzmj;
    }

    private boolean postoji(TipTreninga tipTreninga, String datumOd, String datumDo) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        for (Raspored r : listaRasporeda) {

            if (r.getTipTreninga().equals(String.valueOf(tipTreninga)) && formater.format(r.getDatumOd()).equals(datumOd)
                    && formater.format(r.getDatumDo()).equals(datumDo)) {
                return true;
            }
        }
        return false;
    }

    private String validirajFormat(String nazivGrupe, String kapacitetString) {
        String validanFormat = "";
        if (!nazivGrupe.matches("[a-zA-Z]+")) {
            validanFormat += "Naziv trening grupe | ";
        }

        if (!kapacitetString.matches("\\d+")) {
            validanFormat += "Godine iskustva | ";
        }
        return validanFormat;
    }

    private void ponovniUnos() {
        listaRasporeda = new ArrayList<>();
        jTextFieldNazivTreningGrupe.setText("");
        jTextFieldKapacitet.setText("");
        jComboBoxTrener.setSelectedIndex(-1);
        jComboBoxTipTreninga.setSelectedItem(-1);
        jTextFieldDatumOd.setText("");
        jTextFieldDatumDo.setText("");
        ModelTabeleRaspored mtr = new ModelTabeleRaspored(listaRasporeda);
        jTableRaspored.setModel(mtr);
        ModelTabeleFudbalerTG mtf = new ModelTabeleFudbalerTG(new ArrayList<>());
    }

    private void osvjeziRaspored() {
        jTextFieldDatumOd.setText("");
        jTextFieldDatumDo.setText("");
        jComboBoxTipTreninga.setSelectedIndex(-1);
    }

    private String validirajRaspored(TipTreninga tipTreninga, String datumOd, String datumDo) {
        String validan = "";
        if (tipTreninga == null) {
            validan += "Tip treninga | ";
        }
        if (datumOd.equals("")) {
            validan += "Datum od | ";
        }
        if (datumDo.equals("")) {
            validan += "Datum do | ";
        }
        return validan;
    }

    private void popuniComboBox(int i, Trener trener) throws Exception {

        List<Trener> listaTrenera = new ArrayList<>();
        listaTrenera = Klijent.getInstance().ucitajListuTrenera();
        jComboBoxTipTreninga.setModel(new DefaultComboBoxModel<>(TipTreninga.values()));
        jComboBoxTipTreninga.setSelectedIndex(-1);

        if (i == 0) {
            for (Trener t : listaTrenera) {
                jComboBoxTrener.addItem(t);
            }
            jComboBoxTrener.setSelectedIndex(-1);
        } else {
            for (Trener t : listaTrenera) {
                jComboBoxTrener.addItem(t);
            }
            jComboBoxTrener.setSelectedItem(trener);
        }

    }
}
