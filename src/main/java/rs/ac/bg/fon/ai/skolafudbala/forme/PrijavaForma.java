/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.forme;

import java.io.IOException;
import rs.ac.bg.fon.ai.skolafudbala.klijent.Klijent;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;
import javax.swing.JOptionPane;



/**
 *
 * @author Korisnik
 */
public class PrijavaForma extends javax.swing.JFrame {
    
    Korisnik korisnik = null;

    /**
     * Creates new form PrijavaForma
     */
    public PrijavaForma() {
        initComponents();
        this.setTitle("Prijava");
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
        jButtonPrijava = new javax.swing.JButton();
        jTextFieldKorisnickoIme = new javax.swing.JTextField();
        jPasswordFieldLozinka = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Unesite Vaše podatke:");

        jLabel2.setText("Korisničko ime:");

        jLabel3.setText("Lozinka:");

        jButtonPrijava.setText("Prijavi se");
        jButtonPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrijavaActionPerformed(evt);
            }
        });

        jTextFieldKorisnickoIme.setText("leki");

        jPasswordFieldLozinka.setText("leki");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKorisnickoIme)
                            .addComponent(jPasswordFieldLozinka, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButtonPrijava, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordFieldLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButtonPrijava)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrijavaActionPerformed
        String korisnickoIme = jTextFieldKorisnickoIme.getText();
        String lozinka = String.valueOf(jPasswordFieldLozinka.getPassword());
        if (provjeriPodatke(korisnickoIme, lozinka)) {
            try {
                korisnik = Klijent.getInstance().prijava(korisnickoIme, lozinka);
                JOptionPane.showMessageDialog(this, "Uspjesno ste se ulogovali! Dobrodisli!", "Uspjesna prijava", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                MainForma mf = new MainForma(korisnik);
                //mf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                mf.setVisible(true);
                
            } catch (Exception ex) {
                if (ex instanceof IOException) {
                    JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                if (ex instanceof NullPointerException) {
                    JOptionPane.showMessageDialog(this, "Greska! Server nije pokrenut!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                }
                JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "GRESKA! Morate unijeti vrijednost za korisnicko ime i lozinku!", "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPrijavaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrijava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordFieldLozinka;
    private javax.swing.JTextField jTextFieldKorisnickoIme;
    // End of variables declaration//GEN-END:variables

    private boolean provjeriPodatke(String korisnickoIme, String lozinka) {
        boolean nijePrazno = false;
        if (korisnickoIme != null && !korisnickoIme.trim().isEmpty() && lozinka != null && !lozinka.isEmpty()) {
            nijePrazno = true;
        }
        return nijePrazno;
        
    }
}
