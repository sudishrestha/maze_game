package mazegame;

import java.util.Scanner;

import mazegame.boundary.IMazeClient;

public class SimpleConsoleClient implements IMazeClient {
	
	public String getReply (String question)
	{
		System.out.println("\n" + question + " ");
		Scanner in = new Scanner (System.in);
                String a = in.next();
                //System.out.println(a);
		return a;
	}
	
	public void playerMessage (String message)
	{
		System.out.print(message);
		
	}
}
