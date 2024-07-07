/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.forme;

import rs.ac.bg.fon.ai.skolafudbala.klijent.Klijent;
import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import rs.ac.bg.fon.ai.skolafudbala.model.LekarskiPregled;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Korisnik
 */
public class UnosLekarskogPregledaForma extends javax.swing.JFrame {

    String patern = "dd-MM-yyyy";
    SimpleDateFormat formater = new SimpleDateFormat(patern);

    /**
     * Creates new form UnosLekarskogPregleda
     */
    public UnosLekarskogPregledaForma() {
        initComponents();
        try {
            popuniComboBox(0);
        } catch (Exception ex) {
            Logger.getLogger(UnosLekarskogPregledaForma.class.getName()).log(Level.SEVERE, null, ex);
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
        jTextFieldDatum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldVisina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTezina = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldStanje = new javax.swing.JTextField();
        jButtonPonisti = new javax.swing.JButton();
        jButtonDodaj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Datum pregleda:");

        jTextFieldDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDatumActionPerformed(evt);
            }
        });

        jLabel2.setText("Visina:");

        jLabel3.setText("Tezina:");

        jTextFieldTezina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTezinaActionPerformed(evt);
            }
        });

        jLabel4.setText("Stanje:");

        jButtonPonisti.setText("Poništi");
        jButtonPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPonistiActionPerformed(evt);
            }
        });

        jButtonDodaj.setText("Dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jLabel5.setText("Fudbaler:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jTextFieldTezina, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldStanje, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 103, Short.MAX_VALUE)
                                .addComponent(jButtonPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDatum)
                            .addComponent(jTextFieldVisina)
                            .addComponent(jComboBox1, 0, 178, Short.MAX_VALUE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldVisina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTezina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPonisti)
                    .addComponent(jButtonDodaj))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDatumActionPerformed

    private void jTextFieldTezinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTezinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTezinaActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        Fudbaler f = (Fudbaler) jComboBox1.getSelectedItem();
        String datumPregleda = jTextFieldDatum.getText();
        String visina = jTextFieldVisina.getText();
        String tezina = jTextFieldTezina.getText();
        String stanje = jTextFieldStanje.getText();

        double visinaDoub = Double.parseDouble(visina);
        double tezinaDoub = Double.parseDouble(tezina);

        try {
            LekarskiPregled lp = new LekarskiPregled(visinaDoub, f, tezinaDoub, stanje, formater.parse(datumPregleda));
            long pregledId = Klijent.getInstance().zapamtiPregled(lp);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio lekarski pregled", "Fudbaler zapamcen", JOptionPane.INFORMATION_MESSAGE);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti lekarski pregled jer nije uspjesno parsiranje!", "GRESKA", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti lekarski pregled!", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPonistiActionPerformed
        ponovniUnos();
    }//GEN-LAST:event_jButtonPonistiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonPonisti;
    private javax.swing.JComboBox<Fudbaler> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldDatum;
    private javax.swing.JTextField jTextFieldStanje;
    private javax.swing.JTextField jTextFieldTezina;
    private javax.swing.JTextField jTextFieldVisina;
    // End of variables declaration//GEN-END:variables

    private void ponovniUnos() {
        jTextFieldDatum.setText("");
        jTextFieldStanje.setText("");
        jTextFieldTezina.setText("");
        jTextFieldVisina.setText("");
        jComboBox1.setSelectedIndex(-1);
    }

    private void popuniComboBox(int i) throws Exception {

        List<Fudbaler> listaFudbalera = new ArrayList<>();
        listaFudbalera = Klijent.getInstance().ucitajListuFudbalera();

        if (i == 0) {
            for (Fudbaler f : listaFudbalera) {
                jComboBox1.addItem(f);
            }
            jComboBox1.setSelectedIndex(-1);
        } else {
            for (Fudbaler f : listaFudbalera) {
                jComboBox1.addItem(f);
            }
        }

    }
}
