/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssbrs.izlaz.forme;

import ssbrs.zajednickeklase.forme.MeniForm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import java.lang.Exception;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import pomocneklase.FileParser;
import ssbrs.ulaz.forme.IzdajPotvrdu;

/**
 *
 * @author Knezic
 */
public class Rad extends javax.swing.JFrame {

    /**
     * Creates new form Rad
     */
    public Rad(MeniForm mf) {
        this.mf=mf;
        initComponents();
        jCheckBox1.setSelected(true);
        String filePath = new File("").getAbsolutePath();
        filePath = filePath + "\\UlazniCvorovi.txt";
        System.out.println(filePath);
        File file = new File(filePath);
        ulazniCvorovi = FileParser.ucitajPodatke(file);
        for (int i = 0; i < ulazniCvorovi.size(); i++) {
            choice1.add(ulazniCvorovi.get(i));
        }
//
        ld = LocalDate.now();
        //
         String izdateKarte = new File("").getAbsolutePath();
        izdateKarte = izdateKarte + "\\IzdateKarte" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        System.out.println(filePath);
        File file3 = new File(izdateKarte);
        if (file3.exists() && !file3.isDirectory()) {
        this.izdateKarte=FileParser.ucitajPodatke(file3);
            
        }
        //
        String danasnjiDatum = new File("").getAbsolutePath();
        danasnjiDatum = danasnjiDatum + "\\IzdatePotvrde" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        System.out.println(filePath);
        File file1 = new File(danasnjiDatum);
        String nazivUlCvora = null;
        String datumUL = null;
        String vrijemeUl = null;
        izdatePotvrdeDanas = FileParser.ucitajPodatke(file1);
        for (int i = 0; i < izdatePotvrdeDanas.size(); i++) {
            System.out.println(izdatePotvrdeDanas.get(i));
            String pom[] = izdatePotvrdeDanas.get(i).split(";");
            choice2.add(pom[0]);
            brojUlCvora.add(pom[0]);
            this.nazivUlCvora.add(pom[1]);
            datumULCvora.add(pom[2]);
            vrijemeULCvora.add(pom[3]);
            if (i == 0) {
                nazivUlCvora = pom[1];
                datumUL = datumULCvora.get(0);
                vrijemeUl = pom[3];
            }
        }
        //
        ld = ld.minusDays(1);
        System.out.println(ld);
        String jucerasnjiDatum = new File("").getAbsolutePath();
        jucerasnjiDatum = jucerasnjiDatum + "\\IzdatePotvrde" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        System.out.println(jucerasnjiDatum);
        File file2 = new File(jucerasnjiDatum);
        if (file2.exists() && !file2.isDirectory()) {
            izdatePotvrdeJuce = FileParser.ucitajPodatke(file2);
            for (int i = 0; i < izdatePotvrdeJuce.size(); i++) {
                System.out.println(izdatePotvrdeJuce.get(i));
                String pom[] = izdatePotvrdeJuce.get(i).split(";");
                choice2.add(pom[0]);
                brojUlCvora.add(pom[0]);
                this.nazivUlCvora.add(pom[1]);
                datumULCvora.add(pom[2]);
                vrijemeULCvora.add(pom[3]);
            }
        }
        //
        jLabel12.setText(nazivUlCvora);
        jLabel13.setText(datumUL);
        jLabel14.setText(vrijemeUl);
        ShowTime();
        ShowDate();
        this.initCijena();
    }
    private List<String> ulazniCvorovi;
     private List<String> cjenovnik;
    private List<String> izdatePotvrdeDanas;
    private List<String> izdateKarte;
    private List<String> izdatePotvrdeJuce;
    private List<String> brojUlCvora = new ArrayList();
    private List<String> nazivUlCvora = new ArrayList();
    private List<String> datumULCvora = new ArrayList();
    private List<String> vrijemeULCvora = new ArrayList();
    private MeniForm mf;
    private LocalDate ld;
    private String matrica[][]={{"0","1.00","1.20","1.30","1.40","1.50","1.60","1.70","1.80","1.90"},
                            {"1.00","0","1.00","1.20","1.30","1.40","1.50","1.60","1.70","1.80"},
                            {"1.20","1.00","0","1.00","1.20","1.30","1.40","1.50","1.60","1.70"},
                            {"1.30","1.20","1.00","0","1.00","1.20","1.30","1.40","1.50","1.60"},
                            {"1.40","1.30","1.20","1.00","0","1.00","1.20","1.30","1.40","1.50"},
                            {"1.50","1.40","1.30","1.20","1.00","0","1.00","1.20","1.30","1.40"},
                            {"1.60","1.50","1.40","1.30","1.20","1.00","0","1.00","1.20","1.30"},
                            {"1.70","1.60","1.50","1.40","1.30","1.20","1.00","0","1.00","1.20"},
                            {"1.80","1.70","1.60","1.50","1.40","1.30","1.20","1.00","0","1.00"},
                            {"1.90","1.80","1.70","1.60","1.50","1.40","1.30","1.20","1.00","0"}};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        choice2 = new java.awt.Choice();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Izlazni čvor:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 110, 100, 22);

        choice1.setBackground(new java.awt.Color(0, 153, 153));
        choice1.setForeground(new java.awt.Color(255, 255, 255));
        choice1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemStateChangedChoice1(evt);
            }
        });
        jPanel1.add(choice1);
        choice1.setBounds(180, 110, 240, 30);

        choice2.setBackground(new java.awt.Color(0, 153, 153));
        choice2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choice2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Rad.this.itemStateChanged(evt);
            }
        });
        jPanel1.add(choice2);
        choice2.setBounds(240, 360, 160, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(140, 144, 90, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(150, 170, 90, 20);

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(500, 310, 190, 50);

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Obračun troškova");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(503, 240, 190, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Kategorija vozila:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(470, 110, 140, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Broj naplatne karte:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(70, 360, 170, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Vrijeme ulaska:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 320, 130, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Datum ulaska:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 280, 120, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Naziv ulaznog čvora:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 240, 170, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Vrijeme:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 170, 65, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Datum:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 140, 80, 22);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(240, 240, 130, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(200, 280, 160, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jLabel14);
        jLabel14.setBounds(210, 320, 130, 20);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssbrs/izlaz/slike/ap1.jpg"))); // NOI18N
        jPanel1.add(jLabel15);
        jLabel15.setBounds(480, 140, 40, 30);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssbrs/izlaz/slike/ap2.jpg"))); // NOI18N
        jPanel1.add(jLabel16);
        jLabel16.setBounds(540, 140, 40, 40);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssbrs/izlaz/slike/ap3.jpg"))); // NOI18N
        jPanel1.add(jLabel18);
        jLabel18.setBounds(600, 140, 50, 50);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssbrs/izlaz/slike/ap4.jpg"))); // NOI18N
        jPanel1.add(jLabel19);
        jLabel19.setBounds(670, 140, 50, 50);

        jCheckBox1.setBackground(new java.awt.Color(0, 204, 255));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(490, 200, 20, 21);

        jCheckBox2.setBackground(new java.awt.Color(0, 204, 255));
        jCheckBox2.setText("jCheckBox2");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2);
        jCheckBox2.setBounds(550, 200, 20, 20);

        jCheckBox3.setBackground(new java.awt.Color(0, 204, 255));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3);
        jCheckBox3.setBounds(620, 200, 20, 21);

        jCheckBox4.setBackground(new java.awt.Color(0, 204, 255));
        jCheckBox4.setToolTipText("");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox4);
        jCheckBox4.setBounds(680, 200, 20, 21);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 153, 153));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(510, 380, 180, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssbrs/izlaz/slike/Rad_izlazak.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.obrisiPotvrdu();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        mf.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemStateChanged
       
        for (int i = 0; i < izdatePotvrdeDanas.size(); i++) {
     
          if (evt.getItem().toString().equals(brojUlCvora.get(i))) {
                jLabel12.setText(nazivUlCvora.get(i));
                System.out.println("TESTNITEST");
                jLabel13.setText(datumULCvora.get(i));
                jLabel14.setText(vrijemeULCvora.get(i));
            }
            this.initCijena();
        }
        LocalDate ldLocal = LocalDate.now();
        LocalDate ldJuce = ldLocal.minusDays(1);
        System.out.println(ld);
        String jucerasnjiDatum = new File("").getAbsolutePath();
        jucerasnjiDatum = jucerasnjiDatum + "\\IzdatePotvrde" + ldJuce.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        System.out.println(jucerasnjiDatum);
        File file2 = new File(jucerasnjiDatum);
        if (file2.exists() && !file2.isDirectory()) {
            for (int i = 0; i < izdatePotvrdeJuce.size(); i++) {
                System.out.println("BROJ UL C " + brojUlCvora.get(i) + "evt " + evt.getItem().toString());
                if (evt.getItem().toString().equals(brojUlCvora.get(i))) {
                    jLabel12.setText(nazivUlCvora.get(izdatePotvrdeDanas.size() + i));
                    System.out.println("TESTNITEST123");
                    jLabel13.setText(datumULCvora.get(izdatePotvrdeDanas.size() + i));
                    jLabel14.setText(vrijemeULCvora.get(izdatePotvrdeDanas.size() + i));
                }
            }
        }
    }//GEN-LAST:event_itemStateChanged

    private void initCijena(){
   /* String filePath = new File("").getAbsolutePath();
        filePath = filePath + "\\Cijenovnik.txt";
        System.out.println(filePath);
        File file = new File(filePath);
        cjenovnik = FileParser.ucitajPodatke(file);
        //String ulazniCvorovi[]=cjenovnik.get(0).split(";");*/
        int x=0,y=0;
        for(int i=0;i<matrica.length;i++){
            if(choice1.getSelectedItem().equals(ulazniCvorovi.get(i)))
            { x=i;System.out.println("X "+x);}
            if( jLabel12.getText().equals(ulazniCvorovi.get(i)))
            { y=i;System.out.println("Y "+y);}
        }
       
        
System.out.println("X "+x+" "+y);
           for(int z=0;z<10;z++) System.out.println(matrica[x][z]);
       jTextField1.setText(""+matrica[x][y]);
           if(jCheckBox1.isSelected())     
         jTextField1.setText(""+matrica[x][y]);
      else if(jCheckBox2.isSelected()){
          Double d=round(2*Double.parseDouble(jTextField1.getText()),2);
        jTextField1.setText(d.toString());}
      else if(jCheckBox3.isSelected()){
          Double d=round(3*Double.parseDouble(jTextField1.getText()),2);
        jTextField1.setText(d.toString());}
      else if(jCheckBox4.isSelected()){
          Double d=round(4*Double.parseDouble(jTextField1.getText()),2);
        jTextField1.setText(d.toString());}
    }
    
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
      deselect(jCheckBox2);
        deselect(jCheckBox3);
        deselect(jCheckBox4);
        this.initCijena();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        deselect(jCheckBox1);
        deselect(jCheckBox3);
        deselect(jCheckBox4);
        this.initCijena();
        
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
         deselect(jCheckBox1);
        deselect(jCheckBox2);
        deselect(jCheckBox4);
         this.initCijena();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
         deselect(jCheckBox1);
        deselect(jCheckBox3);
        deselect(jCheckBox2);
         this.initCijena();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void itemStateChangedChoice1(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemStateChangedChoice1
      this.initCijena();
    }//GEN-LAST:event_itemStateChangedChoice1
private void deselect(JCheckBox jCB){
    if(jCB.isSelected()) jCB.setSelected(false);
}
    public void ShowTime() {
        Thread t = new Thread() {
            public void run() {
                for (;;) {
                    Calendar calendar = new GregorianCalendar();
                    int hour = calendar.get(Calendar.HOUR);
                    int minute = calendar.get(Calendar.MINUTE);
                    int second = calendar.get(Calendar.SECOND);
                    jLabel10.setText(hour + ":" + minute + ":" + second);
                    /*try{
                        sleep(1000);
                    }catch(Exception ex){JOptionPane.showMessageDialog)(null,ex);}*/
                }
            }
        };
        t.start();
    }

    public void ShowDate() {
        Thread t = new Thread() {
            public void run() {
                for (;;) {
                    Calendar calendar = new GregorianCalendar();
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);
                    jLabel11.setText(day + "." + (month + 1) + "." + year);

                }
            }
        };
        t.start();
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
private static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
private void  obrisiPotvrdu(){
    LocalDate ld=LocalDate.now();
    String s="";
for(int i=0;i<izdatePotvrdeDanas.size();i++){
String pom[]=izdatePotvrdeDanas.get(i).split(";");
if(pom[0].equals(choice2.getSelectedItem()) && pom[1].equals(jLabel12.getText()) && pom[2].equals(jLabel13.getText()) && pom[3].equals(jLabel14.getText()))
{izdatePotvrdeDanas.remove(i);
choice2.remove(choice2.getSelectedItem());
this.setVisible(false);
}
    s+=izdatePotvrdeDanas.get(i).toString()+"\n";
}
String filePath = new File("").getAbsolutePath();
        filePath = filePath + "\\IzdatePotvrde" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        System.out.println(filePath);
        File file = new File(filePath);
        try {
            FileParser.upisiUFile(file, s);
        } catch (IOException ex) {
            Logger.getLogger(IzdajPotvrdu.class.getName()).log(Level.SEVERE, null, ex);
        }
        String t=""+jLabel2.getText()+choice1.getSelectedItem()+";"+jLabel3.getText()+jLabel11.getText()+";"+jLabel4.getText()+""+jLabel10.getText()+"\n";
String izdateKarte = new File("").getAbsolutePath();
        izdateKarte = izdateKarte + "\\IzdateKarte" + ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".txt";
        if(this.izdateKarte!=null)
        this.izdateKarte.add(t);
        else {this.izdateKarte=new ArrayList();this.izdateKarte.add(t);}
        String t1="";
        for(int i=0;i<this.izdateKarte.size();i++){
        t1+=this.izdateKarte.get(i)+"\n";
        }
        File fileKarte = new File(izdateKarte);
        try {
            FileParser.upisiUFile(fileKarte, t1);
        } catch (IOException ex) {
            Logger.getLogger(IzdajPotvrdu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
new Rad(mf).setVisible(true);
}
}
