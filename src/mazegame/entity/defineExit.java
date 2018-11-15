/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author sudishrestha
 */
public class defineExit {
    String addre= "C:\\Users\\sudishrestha\\Documents\\NetBeansProjects\\mazegame\\src\\mazegame\\";
    public defineExit()
    {}
    public defineExit(String label1, String label2, String label3)
    {
    try(FileWriter fw = new FileWriter(addre + "direction.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println(label1);
    //more code
    out.println(label3);
    
    out.println(label2 + "\r\n");
    //more code
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
}
