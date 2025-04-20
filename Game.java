import java.util.Scanner;
import java.util.ArrayList;

public class Game{

    //Attributes for Game
    Map gameMap; 

    Thing krabbyPatty;
    Thing anglerFish;
    Thing sword;
    Thing shell;
    Thing amulet;

    Place krustyKrab;
    Place kingsCastle;
    Place yourHouse;
    Place market;
    Place oldLadyHouse;
    Place shipwreck;
    Place caveEntrance;
    Place sharkPlace;
    Place queensLair;


    public Game(){
        
        //Things
        this.krabbyPatty = new Thing("Krabby Patty");
        this.anglerFish = new Thing("Angler Fish");
        this.sword = new Thing("Sword");
        this.shell = new Thing("Sea Shell");
        this.amulet = new Thing ("Amulet");

        //Lists of availible directions that a player can go from certain locations
        //they are used for when we initialize each location
        String[][] directions = new String [7][]; 
        directions[0] = new String[] {"south", "west"};
        directions[1] = new String[] {"north", "east"};
        directions[2] = new String[]{"north","east","south"};
        directions[3] = new String[] {"north", "west"};
        directions[4] = new String[] {"east", "west"};
        directions[5] = new String[] {"north", "south"};
        directions[6] = new String[] {"north"};


        //Places
        this.krustyKrab = new Place("the Krusty Krab", krabbyPatty,directions[0],"Welcome to the Krusty Krab! Mr. Tenticles is at the counter, ready to take your order.");
        this.kingsCastle = new Place("the King's Castle",directions[1],"The King's Castle is ornate and beautiful! But nothing here can help you.");
        this.yourHouse = new Place("your house", anglerFish,directions[2], "Your sister, mer-Maya, stands in the kitchen");
        this.market = new Place("the Market", shell,directions[3],"The Market is bustling today! Your friend, Mr. Dolphin, is operating the Sea-Shell-Shack");
        this.oldLadyHouse = new Place("the Wise-Mer-Lady's House", amulet,directions[4],"The Wise-Mer-Lady sits in a rocking chair on her porch.");
        this.shipwreck = new Place("the Shipwreck", sword,directions[4],"the shipwreck is loaded with human treasures!");
        this.caveEntrance = new Place("the Cave Entrance",directions[0],"dd");
        this.sharkPlace = new Place("the Shark's Lair",directions[5],"You see the Queen's Lair just passed you, but a large shark floats in the way.");
        this.queensLair = new Place("the Queen's Lair", directions[6],"gggg");

        //Making the game Map
        ArrayList<Place> rowZero = new ArrayList<Place>();
            rowZero.add(oldLadyHouse);
            rowZero.add(shipwreck);
            rowZero.add(caveEntrance);

        ArrayList<Place> rowOne = new ArrayList<Place>();
            rowOne.add(yourHouse);
            rowOne.add(krustyKrab);
            rowOne.add(sharkPlace);
        
        ArrayList<Place> rowTwo = new ArrayList<Place>();
            rowTwo.add(kingsCastle);
            rowTwo.add(market);
            rowTwo.add(queensLair);

        this.gameMap = new Map();

        this.gameMap.addToMap(rowZero);
        this.gameMap.addToMap(rowOne);
        this.gameMap.addToMap(rowTwo);

        //People
        WiseLady wiseLady = new WiseLady(oldLadyHouse);
    }

    /**
     * Game Playing loop
     */
    public void gameLoop(){

        //Get player information
        Scanner myScanner = new Scanner (System.in);
        System.out.println("Welcome to Mermaid Adventure! What is your mer-sona?");
        
        String playerName = myScanner.nextLine();
        Player player = new Player(playerName, this.kingsCastle);

        //welcome and mission message
        System.out.println();
        player.printLocation();
        System.out.println("King Neptune:");
        System.out.println("Greetings "+playerName+"! I fear I have not summoned you out of joy. ");
        System.out.println("My mer-daughter, Aqua Pearl, has been kidnapped by my wretched sister, The Evil Mer-Queen.");
        System.out.println("I've heard of your bravery and I am tasking you with rescuing her.");
        System.out.println("You must seek the wise mer-lady in the north for more instructions. If you need assistance, type 'help' in the console");
        System.out.println("Good luck to you, "+playerName+". As a reward I will give you the entire Pacific Ocean, I don't really need it anyways.");
        System.out.println();

        //Game playing loop
        int counter = 1;
        while (counter == 1){
            
            String playerInputString = myScanner.nextLine();
            playerInputString = playerInputString.toLowerCase();
            String[] playerInputList = playerInputString.split(" ");

            if (playerInputList[0].equalsIgnoreCase("swim")){
                player.swim(playerInputList[1],this.gameMap);

            } else if (playerInputList[0].equalsIgnoreCase("help")){
                player.printOptions();

            } else if (playerInputList[0].equalsIgnoreCase("explore")){
                player.location.explore();

            } else if(playerInputList[0].equalsIgnoreCase("talk")) {
                player.talkTo(playerInputList[3]);

            }else if (playerInputList[0].equalsIgnoreCase("exit")){
                counter = 0;
            } else {
                System.out.println("Sorry, I do not recognize that command. Type 'help' to print the availible commands.");
            }
        }
        System.out.println("Thank you for playing!");
        
        myScanner.close();
        
    }
    public static void main(String[] args) {
        System.out.println();
        Game game = new Game();
        game.gameLoop();
        
        
        
        }
}