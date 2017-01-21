/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssbrs.ulaz.forme;

import ssbrs.ulaz.forme.Rad;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pomocneklase.FileParser;

/**
 *
 * @author Knezic
 */
public class IzdajPotvrdu extends javax.swing.JFrame {

    /**
     * Creates new form IzdajPotvrdu
     */
    public IzdajPotvrdu() {
        initComponents();
    }
    private Rad r;
    private static int naplatnaKarticaBr;
    private String nazivUlaznogCvora;
    private LocalDate ld;
    private LocalTime lt;
    List<String> test = new ArrayList<String>();

    public IzdajPotvrdu(Rad r, String nazivUlaznogCvora) {
        naplatnaKarticaBr++;
        this.r = r;
        this.nazivUlaznogCvora = nazivUlaznogCvora;
        initComponents();
        jLabel5.setVisible(false);
        ld = LocalDate.now();
        lt = LocalTime.now();
        jTextField1.setText("Naziv ulaznog čvora : " + nazivUlaznogCvora);
        jTextField2.setText("Datum : " + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        jTextField3.setText("Vrijeme : " + lt.format(DateTimeFormatter.ofPattern("hh:mm a")));
        String filePath = new File("").getAbsolutePath();
        filePath = filePath + "\\IzdatePotvrde" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        System.out.println(filePath);
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            System.out.println("POSTOJI");
            test = FileParser.ucitajPodatke(file);
            naplatnaKarticaBr = test.size() + 1;
        } else {
            System.out.println("NE POSTOJI");
            naplatnaKarticaBr = 1;
        }
        jLabel3.setText("Naplatna kartica broj: " + naplatnaKarticaBr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                closed(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("PREGLED POTVRDE");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 40, 320, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Autoput - Bosna i Hercegovina");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 100, 360, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 130, 320, 30);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 153, 153));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(100, 180, 600, 40);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 153, 153));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(100, 230, 600, 40);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 153, 153));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(100, 280, 600, 40);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Štampaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(240, 450, 160, 60);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Odustani");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(410, 450, 160, 60);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Potvrda je uspješno oštampana");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 340, 360, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssbrs/ulaz/slike/radIPomoc.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        naplatnaKarticaBr--;
        this.setVisible(false);
        r.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void closed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closed
        System.out.println("Zatvoren");
    }//GEN-LAST:event_closed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s = "" + naplatnaKarticaBr + ";" + nazivUlaznogCvora + ";" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ";" + lt.format(DateTimeFormatter.ofPattern("hh:mm a"));
        test.add(s);
        String t = "";
        for (int i = 0; i < test.size(); i++) {
            t += (test.get(i).toString() + "\n");
            System.out.println(t);
        }
        String filePath = new File("").getAbsolutePath();
        filePath = filePath + "\\IzdatePotvrde" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        System.out.println(filePath);
        File file = new File(filePath);
        try {
            FileParser.upisiUFile(file, t);
        } catch (IOException ex) {
            Logger.getLogger(IzdajPotvrdu.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel5.setVisible(true);
        jButton1.setVisible(false);
        jButton2.setText("OK");
    }//GEN-LAST:event_jButton1ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
