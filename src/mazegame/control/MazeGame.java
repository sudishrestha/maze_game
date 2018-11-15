package mazegame.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import mazegame.HardCodedData;
import mazegame.SimpleConsoleClient;

public class MazeGame {
static String paths = "C:\\Users\\sudishrestha\\Documents\\NetBeansProjects\\mazegame\\src\\mazegame\\";
	public static void main (String[] args) {
	try(FileWriter fw = new FileWriter(paths + "addre.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.print("");
    //more code
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
 try(FileWriter fw = new FileWriter(paths + "direction.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.print("");
    //more code
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}           
            
        DungeonMaster theDm = new DungeonMaster(new HardCodedData(), new SimpleConsoleClient());
        theDm.runGame();
        System.out.println ("Game is over - thanks for playing");
        System.out.println ("----------------------------------");
        
	}
}
