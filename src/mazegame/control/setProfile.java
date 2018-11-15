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
public class setProfile {

    String addre = "C:\\Users\\sudishrestha\\Documents\\NetBeansProjects\\mazegame\\src\\mazegame\\profile.txt";

    public setProfile() {

    }

    public void newProfile(String name) {
        try (FileWriter fw = new FileWriter(addre);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(name);
            //more codelabel
            out.println("null");

            out.println("null");
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void getItem(String item) {
        String[] data1 = new String[5];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(addre), "Cp1252"));

            data1[0] = br.readLine();
            data1[1] = br.readLine();
            data1[2] = br.readLine();
            if (data1[1].trim().equals("null")) {
                data1[1] = item;
            } else if (data1[2].trim().equals("null")) {
                data1[2] = item;
            } else {
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
public void listItem()
{
String[] data = new String[5];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(addre), "Cp1252"));

            data[0] = br.readLine();
            data[1] = br.readLine();
            data[2] = br.readLine();
             if (!data[2].trim().equals("null")) {
                System.out.println("+++++++++++++++++++++++++++");
                System.out.println("++ You have " + data[1] + " and  " + data[2] + " ++" );
                System.out.println("+++++++++++++++++++++++++++");
            } else if (!data[1].trim().equals("null") && data[2].trim().equals("null")) {
                System.out.println("+++++++++++++++++++++++++++");
                System.out.println("++You have " + data[1] + " ++");
                System.out.println("+++++++++++++++++++++++++++");
            }
          else if (data[1].trim().equals("null") && data[2].trim().equals("null")) {
                System.out.println("+++++++++++++++++++++++++++");
                 System.out.println("++ You have nothing in list ++");
                System.out.println("+++++++++++++++++++++++++++");
            }
            br.close();
        } catch (Exception ex) {
            

        }
}
    public void dropItem() {
        String[] data = new String[5];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(addre), "Cp1252"));

            data[0] = br.readLine();
            data[1] = br.readLine();
            data[2] = br.readLine();
            System.out.println("drop: item 1 " + data[1] + " abd item 2 =" + data[2]);
            if (!data[2].trim().toLowerCase().equals("null")) {
                data[2] = "null";
            } else if (!data[1].trim().equals("null") && data[2].trim().equals("null")) {
                data[1] = "null";
            }
            else if(data[1].trim().equals("null") && data[2].trim().equals("null"))
            {
            System.out.println("Nothing to drop!!!");
            }
            br.close();
        } catch (Exception ex) {

        }

        try (FileWriter fw = new FileWriter(addre);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(data[0]);
            //more codelabel
            out.println(data[1]);

            out.println(data[2]);
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }
}
