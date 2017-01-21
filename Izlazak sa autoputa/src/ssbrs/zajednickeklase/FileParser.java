/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssbrs.zajednickeklase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class FileParser {
   
    
  static  public void upisiUFile(File file, String s) throws FileNotFoundException, IOException{
    
        OutputStream outputStream = new FileOutputStream(file);
        Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
        writer.write(s);
        writer.close();
    }
  
    static public List<String> ucitajPodatke(File file){


         BufferedReader br;
          List<String> red = new ArrayList<String>();
   
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
             String line = br.readLine();
       
        

        while (line != null) {


        red.add(line);
                

            
  
     line=br.readLine();


        }
        br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Logovanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Logovanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Logovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return red;
    }
  
  
  
}
