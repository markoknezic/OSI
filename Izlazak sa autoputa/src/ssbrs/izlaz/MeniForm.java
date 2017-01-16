/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssbrs.izlaz;

/**
 *
 * @author PC
 */
public class MeniForm extends ssbrs.ulaz.MeniForm {

     public MeniForm(Logovanje l) {
    super();
         this.l=l;
 
    }
    private ssbrs.ulaz.Logovanje l;
    
    
    @Override
   public void callRad(){
   new Rad().setVisible(true);
   }
}
