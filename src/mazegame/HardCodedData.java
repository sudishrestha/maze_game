package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.Exit;
import mazegame.entity.Location;
import mazegame.entity.defineExit;

public class HardCodedData implements IMazeData {
	private Location startUp,l2,l3,l4,l5,l6,l7;
	defineExit defx = new defineExit();
	public HardCodedData()
	{
		createLocations();
	}
	
	public Location getStartingLocation()
	{
		return startUp;
	}
	
	public String getWelcomeMessage()
	{
		return "Welcome to the ABC CITY";
	}
	public Location getLocation2()
        {
        return l2;
        }
        public Location getLocation3()
        {
        return l3;
        }public Location getLocation4()
        {
        return l4;
        }
        public Location getLocation5()
        {
        return l5;
        }
        public Location getLocation6()
        {
        return l6;
        }
        public Location getLocation7()
        {
        return l7;
        }
        
        
        
	private void createLocations () 
	{
		startUp = new Location ("Main junction, you can go either west,south,north or east", "Main Junction");
                 l2 = new Location("A dead End,you can see a Gun and you can go only to south direction","Area L2");
                l3 = new Location("A weapon shop,for Buy or Sell the weapon, you can only go to west direction from here","Weapon Shop");
                 l4 = new Location ("A dead End you can see a knife which you can pick up, , you can only go to east direction from here","Area L4");
                l5 = new Location("A junction from where you can go either north,east or west","Area L5");
              l6 = new Location("A dead end you can see a sword which you can pick up,and you can only go to west direction from here","Area L6");
                l7 = new Location("Dead End where you can see bunch of mafias that are trying to attack you, , you can only go to east direction from here","Area L7");
				
		// Connect Locations
		startUp.addExit("south",  new Exit ("you are in a junction", l5));
                new defineExit("Main Junction","Area L5","south");
		l5.addExit("north", new Exit("you are in Main Junction", startUp));
                new defineExit("Area L5","Main Junction","north");
                l5.addExit("east", new Exit("you are in dead end and can find a sword",l6));
                new defineExit("Area L5","Area L6","east");
                l5.addExit("west",new Exit("You are inside the enemy teritory",l7));
                new defineExit("Area L5","Area L7","west");
                new defineExit("Area L7","Area L5","east");
               startUp.addExit("west", new Exit("you are in dead end and can find a knife", l4));
               new defineExit("Main Junction","Area L4","west");
               l4.addExit("east", new Exit("you are in main junction", startUp));
               new defineExit("Area L4","Main Junction","east");

                startUp.addExit("north",new Exit("you are in dead end and you can see a gun here",l2));
                new defineExit("Main Junction","Area L2","north");
                l2.addExit("south", new Exit("you are in main junction",startUp));
                new defineExit("Area L2","Main Junction","south");
                
                startUp.addExit("east",new Exit("You are in weapon shop",l3));
                                new defineExit("Main Junction","Weapon Shop","east");

                l3.addExit("west", new Exit("you are in main junction",startUp));
                                new defineExit("Weapon Shop","Main Junction","west");
                      new defineExit("Area L6","Area L5","west");
			
	}
}
