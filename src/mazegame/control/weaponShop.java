/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author sudishrestha
 */
public class weaponShop {
     String addre = "C:\\Users\\sudishrestha\\Documents\\NetBeansProjects\\mazegame\\src\\mazegame\\profile.txt";
   public void sellItem(String item)
   {
   String[] data1 = new String[5];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(addre), "Cp1252"));

            data1[0] = br.readLine();
            data1[1] = br.readLine();
            data1[2] = br.readLine();
            if(data1[1].trim().toLowerCase().equals(item.trim().toLowerCase()))
            {
            data1[1] = "null";
            }
            else if(data1[2].trim().toLowerCase().equals(item.trim().toLowerCase()))
            {
            data1[2] = "null";
            }
            br.close();
        } catch (Exception ex) {

        }

        try (FileWriter fw = new FileWriter(addre);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(data1[0]);
            //more codelabel
            out.println(data1[1]);

            out.println(data1[2]);
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

   }
   public void buyItem(String item)
   {
       
      String[] data1 = new String[5];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(addre), "Cp1252"));

            data1[0] = br.readLine();
            data1[1] = br.readLine();
            data1[2] = br.readLine();
            if (!data1[1].trim().equals(item) && !data1[2].trim().equals(item) && !data1[1].trim().equals("null") && data1[2].trim().equals("null") ) {
                data1[2] = item;
            } 
             else if (data1[1].trim().equals("null") && data1[2].trim().equals("null") ) {
                data1[1] = item;
            } 
            else {
                System.out.print("No place for extra item, please drop existing item first!!!");
            }
            br.close();
        } catch (Exception ex) {

        }

        try (FileWriter fw = new FileWriter(addre);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(data1[0]);
            //more codelabel
            out.println(data1[1]);

            out.println(data1[2]);
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

   }
}
