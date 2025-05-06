import java.util.Scanner;
import java.util.ArrayList;

public class Game{

    //Attributes for Game
    Player player;

    //Things
    Thing twoKrabbyPatty;
    Thing oneKrabbyPatty;
    Thing anglerFish;
    Thing sword;
    Thing oysters;
    Thing amulet;
    Thing kelpCard;

    //Places
    Place krustyKrab;
    Place kingsCastle;
    Place yourHouse;
    Place market;
    Place wiseLadyHouse;
    Place shipwreck;
    Place caveEntrance;
    Place sharkPlace;
    Place queensLair;

    //People
    Person king;
    Person squidward;
    Person mrDolphin;
    Person merMaya;
    Person jellyFish;

    Queen queen;
    Shark shark;
    WiseLady delphine;

    ArrayList<Person> people;

    /**
     * Constructor for game
     */
    public Game(){
        
        //Creating Things
        this.oneKrabbyPatty = new Thing("Krabby Patty");
        this.twoKrabbyPatty = new Thing("Two Krabby Patties");
        this.anglerFish = new Thing("Jörmungandr");
        this.sword = new Thing("Sword");
        this.oysters = new Thing("Bag of Oyseters");
        this.amulet = new Thing ("Amulet");
        this.kelpCard = new Thing("Kelp Card");

        //Places
      
        this.kingsCastle = new Place("the King's Castle","The King's Castle is ornate and beautiful! But nothing here can help you.");
        this.yourHouse = new Place("your house", "Your sister, mer-Maya, stands in the kitchen with her pet angler fish, Jörmungandr.");
        this.wiseLadyHouse = new Place("Delphine's House","The Wise Mer-Lady, Delphine, sits in a rocking chair on her porch.");
        this.market = new Place("the Market","The Market is bustling today! Your friend, Dolphin Dave, is operating the Sea-Shell-Shack");
        this.krustyKrab = new Place("the Krusty Krab","Welcome to the Krusty Krab! Squidward is at the counter, ready to take your order.");
        this.shipwreck = new Place("the Shipwreck","the shipwreck is loaded with human treasures! But nothing here can help you.");
        this.caveEntrance = new Place("the Cave Entrance","The cave is very dark, but you see Jellyfish Jack hanging out nearby.");
        this.sharkPlace = new Place("the Shark's Lair","You see Queen Hydra's Lair just south of you, but a large shark floats in the way.");
        this.queensLair = new Place("Queen Hydra's Lair","Queen Hydra stands looming over you.");
            

        //adding neighbors to each place
        this.kingsCastle.addToNeighbors("north", this.yourHouse);
        this.kingsCastle.addToNeighbors("east", this.market);
    
        this.yourHouse.addToNeighbors("north", this.wiseLadyHouse);
        this.yourHouse.addToNeighbors("east", this.krustyKrab);
        this.yourHouse.addToNeighbors("south", this.kingsCastle);

        this.wiseLadyHouse.addToNeighbors("south", this.yourHouse);

        this.market.addToNeighbors("north", this.krustyKrab);
        this.market.addToNeighbors("west", this.kingsCastle);  
        
        this.krustyKrab.addToNeighbors("west",this.yourHouse);
        this.krustyKrab.addToNeighbors("south", this.market);

        this.shipwreck.addToNeighbors("east", this.caveEntrance);
        this.shipwreck.addToNeighbors("west",this.wiseLadyHouse);

        this.caveEntrance.addToNeighbors("west", this.shipwreck);

        this.sharkPlace.addToNeighbors("north", this.caveEntrance);  
        
        this.queensLair.addToNeighbors("north", this.sharkPlace);

        //Making the People
        //the order in which the conversationBits is added to the person matters. 
        //different the conversation class runs in a certain order
        this.people = new ArrayList<Person>();

        String[] delphineNames = new String[]{"delphine","lady","wise"};
        this.delphine = new WiseLady(delphineNames,wiseLadyHouse);

            delphine.addToInventory(this.kelpCard);
            delphine.addToInventory(this.sword);
            delphine.addToInventory(this.oneKrabbyPatty);
            delphine.addToInventory(this.amulet); 
            delphine.addToRequirements(this.twoKrabbyPatty);
            delphine.addToRequirements(this.oysters);
            
        String[] squidwardNames = new String[]{"squidward","squid"};
        this.squidward = new Person(squidwardNames,krustyKrab, this.twoKrabbyPatty,this.kelpCard);
            squidward.addToConversationBits(": Hello, Welcome to the Krusty Krab. Are you picking up Delphine's order?");
            squidward.addToConversationBits(": Two Krabby Patties coming right up!");
            squidward.addToConversationBits(": I'd offer to take your order, but you don't have anyway to pay.");
            people.add(this.squidward);

        String[] mrDolphinNames = new String []{"dolphin dave", "dolphin","dave"};
        this.mrDolphin = new Person(mrDolphinNames,this.market, this.oysters, this.kelpCard);
            mrDolphin.addToConversationBits(": Hey friend! What's up with you? Got a call from Ms. Delphine that you'll be picking up her order."+System.lineSeparator()+"Is that the case?");
            mrDolphin.addToConversationBits(": One big bag of oysters coming right up");
            mrDolphin.addToConversationBits(": What up dude!! These oysters are sellin' like hotcakes today!");
            people.add(this.mrDolphin);

        String[] merMayaNames = new String[]{"mer-maya", "maya"};
        this.merMaya = new Person(merMayaNames,this.yourHouse,this.anglerFish,null);
            merMaya.addToConversationBits(": Hey there mer-sib. Would you be able to take Jörmungandr on a swim? I have to go to polo practice.");
            merMaya.addToConversationBits(": Alright here you go. Don't be out too long though, he has a poker game tonight.");
            people.add(this.merMaya);

        String [] jellyFishNames = new String[]{"jellyfish jack","jellyfish", "jelly","jack"};
        this.jellyFish = new Person (jellyFishNames,this.caveEntrance,null,anglerFish);
            jellyFish.addToConversationBits(": You can't travel down this cave without something to light the way."+System.lineSeparator()+ "I'd help but I have a poker game tonight. Sorry babe."+System.lineSeparator()+"But my buddy Jörmungandr might be able to help.");
            jellyFish.addToConversationBits(": Good thing you have Jörmungandr to light up the cave!"+System.lineSeparator()+"I would DEFINETLY NOT go south. That's where the queen lives **shutters**");
            jellyFish.addToConversationBits("I'm gonna win big tonight at poker!");
            people.add(this.jellyFish);

        String [] kingNames = new String[]{"king neptune","king", "neptune"};
        this.king = new Person(kingNames,this.kingsCastle,null, null);
            king.addToConversationBits(": Oh Aqua Pearl I miss you so much **sobs**");
            people.add(king);

        String [] sharkNames = new String[]{"carl the sharkle","carl","shark", "sharkle"};
        this.shark = new Shark(sharkNames, this.sharkPlace,this.oneKrabbyPatty);

        String [] queenNames = new String[]{"queen hydra","queen", "hydra","evil"};
        this.queen = new Queen(queenNames,this.queensLair);
    
    }

    /**
     * Game Playing loop
     */
    public void gameLoop(){

        //Get player information
        Scanner myScanner = new Scanner (System.in);
        System.out.println("Welcome to Mermaid Adventure! What is your mer-sona?");
        
        String playerName = myScanner.nextLine();
        this.player = new Player(playerName, this.kingsCastle);

        //welcome and mission message
        System.out.println();
        this.player.printLocation();
        System.out.println("King Neptune: Greetings "+playerName+"! I fear I have not summoned you out of joy. ");
        System.out.println("My mer-daughter, Aqua Pearl, has been kidnapped by my wretched sister, The Evil Mer-Queen, aka Queen Hydra.");
        System.out.println("I've heard of your bravery and I am tasking you with rescuing her.");
        System.out.println("You must seek the wise mer-lady, Delphine, in the north for more instructions.");
        System.out.println("If you need assistance, type 'help' in the console");
        System.out.println("Good luck to you, "+playerName+". As a reward I will give you the entire Pacific Ocean, I don't really need it anyways.");
        System.out.println();


        //Game playing loop
        int counter = 1;
        while (counter == 1){ //The game loop will continue plaing UNLESS the player finishes or chooses to exit
            
            String playerInputString = myScanner.nextLine();
            playerInputString = playerInputString.toLowerCase();
            String[] playerInputList = playerInputString.split(" ");
            int listLength = playerInputList.length;
 
            if (playerInputList[0].equalsIgnoreCase("swim")){ // if the player wants to move to a new Place
                if (listLength == 1) {
                    System.out.println("Sorry, I don't know where you want swim."+System.lineSeparator()+ "Make sure you type a direction[north, east, south, west] after swim");
                } else {
                    this.player.swim(playerInputList[1]);
                }
                
            } else if (playerInputList[0].equalsIgnoreCase("help")){ // prints out the availible commands
                this.player.printOptions();

            } else if (playerInputList[0].equalsIgnoreCase("explore")){ // gives description of their current location
                this.player.location.explore();

            } else if(playerInputList[0].equalsIgnoreCase("talk")) { // if the player talks to someone
    
                if (listLength == 2 || listLength == 1){ // if the player only types 'talk to'
                    System.out.println("Sorry, I don't know who you want to talk to.");
                
                } else if (playerInputList[1].equalsIgnoreCase("to")) {
                    Boolean talkToSomeone = false; // this value decides whether the player successfully tried to initiate a conversation with a valid person
                    for (int i = 0; i < this.people.size(); i++){ //first sees if they want to talk to a regular person
                        Person convoPerson = this.people.get(i);

                        for (int k = 0; k < convoPerson.getNameList().length;k++) { 

                            if (convoPerson.getNameList()[k].equalsIgnoreCase(playerInputList[2])) {
                                if (convoPerson.getLocation()==player.getLocation()) {
                                    if (convoPerson == this.jellyFish){ // the jellyfish has a special conversation method
                                        convoPerson.conversation(this.player,myScanner,"south",this.sharkPlace);
                                        talkToSomeone = true;
                                        break;
                                    } else { // if the player wants to talk to a regular person
                                        convoPerson.conversation(this.player,myScanner);
                                        talkToSomeone = true;
                                        break;
                                    }  
                                } else { // if the player tries to talk to someone outside of their current location
                                    System.out.println("Sorry, "+convoPerson.getName()+" is not at "+player.getLocation().getName());
                                    talkToSomeone = true;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } if (delphine.getName().equalsIgnoreCase(playerInputList[2])) { // if the player wants to talk to delphine
                            if (player.getLocation()==this.wiseLadyHouse) {
                                delphine.conversation(this.player, this.shipwreck);
                                talkToSomeone = true;
                                break;
                            } else { // if the player tries to talk to delphine while not at her house
                                System.out.println("Sorry, Delphine is not at "+player.getLocation().getName());
                                talkToSomeone = true;
                                break;
                            }
                        } if (this.shark.checkName(playerInputList[2])) { // if the player wants to talk to the shark
                            if (player.getLocation()==this.sharkPlace) {
                                this.shark.conversation(this.player,myScanner,this.queensLair);
                                talkToSomeone = true;
                                break;
                            } else { // if the player tries to talk to the shark outside of his lair
                                System.out.println("Sorry, Carl the Shark is not at "+player.getLocation().getName());
                                talkToSomeone = true;
                                break;
                            }
                        } if (this.queen.checkName(playerInputList[2])){ // if the player tries to talk to the queen
                            if (player.getLocation()==this.queensLair) {
                                this.queen.conversation(this.player,myScanner);
                                talkToSomeone = true;
                                counter = 0;
                                break;
                            } else { // if the player tries to talk to the queen outside her lair
                                System.out.println("Sorry, the Queen is not at "+player.getLocation().getName());
                                talkToSomeone = true;
                                break;
                            } 
                        }
                    }
                    if (talkToSomeone == false) { // if the player tries to talk to a character that is not apart of the game
                        System.out.println("I don't know who you want to talk to, try typing the command again.");
                        continue;
                    }
                } else {
                    System.out.println("I don't know who you want to talk to, try typing the command again.");
                    continue;
                }
            } else if (playerInputList[0].equalsIgnoreCase("exit")){ // if the player wants to leave the game
                counter = 0;

            } else if(playerInputList[0].equalsIgnoreCase("check") && playerInputList[1].equalsIgnoreCase("inventory") ){ // print's players inventory

                this.player.printInventory();

            } else { // if the player tries any other command that cannot be used in the game
                System.out.println("Sorry, I do not recognize that command. Type 'help' to print the availible commands.");
            }
        }
        System.out.println("Thank you for playing!");
        
        myScanner.close();
        
    }

    //main for testing
    public static void main(String[] args) {
        System.out.println();
        Game game = new Game();
        game.gameLoop();

    }
}