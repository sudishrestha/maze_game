/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sudishrestha
 */
public class getnewLocation {
    String descrip = "";
    public String getnewLocation(String lbl)
    {
     try {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\sudishrestha\\Documents\\NetBeansProjects\\mazegame\\src\\mazegame\\addre.txt"), "Cp1252"));         

        String line;
     
        while ((line = br.readLine()) != null) {
          if(line.trim().equals(lbl.trim()))
          {
             descrip = br.readLine();
          }
        }
        
        br.close();

    } catch (IOException e) {
        e.printStackTrace();
    }   
     return descrip;
    }
}
