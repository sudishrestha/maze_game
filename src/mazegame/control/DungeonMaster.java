package mazegame.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import mazegame.SimpleConsoleClient;
import mazegame.boundary.IMazeClient;
import mazegame.boundary.IMazeData;
import mazegame.entity.Player;
import mazegame.entity.Location;
import mazegame.getnewLocation;

public class DungeonMaster {
	private IMazeClient gameClient;
	private IMazeData gameData;
	private Player thePlayer;
        int en = 5;
        int pl = 5;
        setProfile spf =new setProfile();
        String currentLocation = "Main Junction";
        String paths = "C:\\Users\\sudishrestha\\Documents\\NetBeansProjects\\mazegame\\src\\mazegame\\";
	 String addre= paths +  "addre.txt";
	 public DungeonMaster(IMazeData gameData, IMazeClient gameClient)
     {
         this.gameData = gameData;
         this.gameClient = gameClient;
     }

     public void printWelcome()
     {
         gameClient.playerMessage(gameData.getWelcomeMessage());
     }

     public void setupPlayer()
     {
         String playerName = gameClient.getReply("What name do you choose to be known by?");
         spf.newProfile(playerName);
         thePlayer = new Player(playerName);
         gameClient.playerMessage("Welcome " + playerName + "\n\n");
         //gameClient.playerMessage("You find yourself looking at ");
        // gameClient.playerMessage(gameData.getStartingLocation().getDescription());

        String ans = "";
        while(!ans.trim().toLowerCase().equals("esc"))
           
        {    String crnt1 = new getnewLocation().getnewLocation(currentLocation);
            System.out.println("\r\n ****************************************************************** \r\nYou are in "+ crnt1 );
            System.out.println(" ******************************************************************");
            ans = gameClient.getReply("<<Hit esc to exit else give direction you want to move to>>");
            String a = currentLocation;
      
       try {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(paths + "direction.txt"), "Cp1252"));         

        String line;
     
        while ((line = br.readLine()) != null) {
          if(line.trim().equals(a.trim()) && ans.trim().equals(br.readLine().trim()))
          {
              currentLocation = br.readLine();
              System.out.println(br.readLine());
          }
        }
        
        br.close();
 System.out.println("you are in " + currentLocation );
    } catch (IOException e) {
        e.printStackTrace();
    }   
       String crnt = new getnewLocation().getnewLocation(currentLocation);
         //System.out.println("You are in "+ crnt);
         if(currentLocation.trim().equals("Area L2"))
         {
         //System.out.print("");
         String choice = gameClient.getReply("You found a gun here do you want to pick it?(yes/no)");
         if(choice.trim().toLowerCase().equals("yes"))
         {
          new setProfile().getItem("gun");
         }
         }
        if(currentLocation.trim().equals("Area L4"))
         {
          String choice = gameClient.getReply("You found a knife here do you want to pick it?(yes/no)");
          if(choice.trim().toLowerCase().equals("yes"))
         {
          new setProfile().getItem("knife");
         }
         }
         if(currentLocation.trim().equals("Area L6"))
         { String choice = gameClient.getReply("You found a sword here do you want to pick it? (yes/no)");
          if(choice.trim().toLowerCase().equals("yes"))
         {
          new setProfile().getItem("sword");
         }
         }
         if(currentLocation.trim().equals("Weapon Shop"))
          {
              String choice1 = gameClient.getReply("You are in weapon shop? (buy/sell)");
          if(choice1.toLowerCase().trim().equals("buy"))
          {
           String choice2 = gameClient.getReply("What do you want to buy? (gun/knife/sword/armour)");
           if(choice2.trim().toLowerCase().equals("armour"))
           {
           pl = 5;
           }
           else{
           new weaponShop().buyItem(choice2);
           }
          }
          else if(choice1.toLowerCase().trim().equals("sell"))
          {
          new setProfile().listItem();
          String choice3 = gameClient.getReply("What do you want to sell?");
          new weaponShop().sellItem(choice3);
          }
          }
         
       if(currentLocation.trim().equals("Area L7"))
          {
              while(pl > 0)
              {
                  System.out.println("--------------------------");
                  System.out.println("Player : "  + pl + "/5 VS Enemy:" + en + "/5"  );
                  System.out.println("--------------------------");
          String ch = gameClient.getReply("What do you want to do flee or fight? (flee/fight)");
          if(ch.trim().toLowerCase().equals("flee"))
          {
          break;
          }
          if(ch.trim().toLowerCase().equals("fight"))
          {String[] enemy =  new String[4];
          enemy[0] = "gun";
          enemy[1] = "knife";
          enemy[2] = "sword";
          enemy[3] = "null";
           new setProfile().listItem();
            String choice3 = gameClient.getReply("What do you want to fight with?");
            Random rand = new Random();
            int  n = rand.nextInt(3) + 0;
            System.out.println(playerName + "-" + choice3 + " Vs " + "enemy: " + enemy[n]);          
            new weaponShop().sellItem(choice3);
            if(choice3.equals("gun") && enemy[n].equals("knife"))
            {
            en--;
            }
            else if(choice3.equals("knife") && enemy[n].equals("gun"))
            {
            pl--;
            }
            else if(choice3.equals("sword") && enemy[n].equals("knife"))
            {
            en--;
            }
            else if(choice3.equals("gun") && enemy[n].equals("sword"))
            {
            en--;
            }
            else if(choice3.equals("gun") && enemy[n].equals("null"))
            {
            en--;
            }
            else if(choice3.equals("knife") && enemy[n].equals("sword"))
            {
            pl--;
            }
            else if(choice3.equals("knife") && enemy[n].equals("null"))
            {
            en--;
            }
            else if(choice3.equals("sword") && enemy[n].equals("gun"))
            {
            pl--;
            }
            else if(choice3.equals("sword") && enemy[n].equals("null"))
            {
            en--;
            }
             else if(choice3.equals("null") && enemy[n].equals("gun"))
            {
            pl--;
            }
            else if(choice3.equals("null") && enemy[n].equals("knife"))
            {
            pl--;
            }
            else if(choice3.equals("null") && enemy[n].equals("sword"))
            {
            pl--;
            }
          }
              }
          }
         
         
         if(pl < 1)
         {
         break;
         }
          String cho = gameClient.getReply("list available item or drop item? (list/drop) ");
          
           if(cho.trim().toLowerCase().equals("list"))
          {
          new setProfile().listItem();
          }
          else if(cho.trim().toLowerCase().equals("drop"))
          {
               new setProfile().listItem();
                String choice3 = gameClient.getReply("What do you want to drop?");
          new weaponShop().sellItem(choice3);
         
          }
     }
        
     }

     public void runGame()
     {
         printWelcome();
         setupPlayer();
     }
}
