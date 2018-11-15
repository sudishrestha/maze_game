package mazegame.entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Location {
	private HashMap exits;
	private String description;
	private String label;
	String addre= "C:\\Users\\sudishrestha\\Documents\\NetBeansProjects\\mazegame\\src\\mazegame\\";
	public Location () { }
	
	public Location (String description, String label)
	{
		this.setDescription(description);
		this.setLabel(label);
              
                 
             try(FileWriter fw = new FileWriter(addre + "addre.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println(label);
    //more codelabel
    out.println(description + "\r\nsplitter");
    //more code
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
		exits = new HashMap();
	}
	
	public boolean addExit (String exitLabel, Exit theExit)
	{
              
		if (exits.containsKey(exitLabel))
			return false;
		exits.put(exitLabel, theExit);
		return true;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
