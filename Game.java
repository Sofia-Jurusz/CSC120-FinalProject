import java.util.Scanner;
import java.util.ArrayList;

public class Game{

    //Attributes for Game
    Player player;

    Map gameMap; 

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
    Place oldLadyHouse;
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

        //Lists of availible directions that a player can go from certain locations
        //they are used for when we initialize each Place
        String[][] directions = new String [9][]; 
        directions[0] = new String[] {"south", "west"};
        directions[1] = new String[] {"north", "east"};
        directions[2] = new String[]{"north","east","south"};
        directions[3] = new String[] {"north", "west"};
        directions[4] = new String[] {"east", "west"};
        directions[5] = new String[] {"north"};
        directions[6] = new String[] {"south"};
        directions[7] = new String[] {"west"};


        //Places
        this.krustyKrab = new Place("the Krusty Krab",directions[0],"Welcome to the Krusty Krab! Squidward is at the counter, ready to take your order.");
        this.kingsCastle = new Place("the King's Castle",directions[1],"The King's Castle is ornate and beautiful! But nothing here can help you.");
        this.yourHouse = new Place("your house",directions[2], "Your sister, mer-Maya, stands in the kitchen with her pet angler fish, Jörmungandr.");
        this.market = new Place("the Market",directions[3],"The Market is bustling today! Your friend, Dolphin Dave, is operating the Sea-Shell-Shack");
        this.oldLadyHouse = new Place("Delphine's House",directions[6],"The Wise Mer-Lady, Delphine, sits in a rocking chair on her porch.");
        this.shipwreck = new Place("the Shipwreck",directions[4],"the shipwreck is loaded with human treasures! But nothing here can help you.");
        this.caveEntrance = new Place("the Cave Entrance",directions[7],"The cave is very dark, but you see a glow in the dark jellyfish.");
        this.sharkPlace = new Place("the Shark's Lair",directions[5],"You see Queen Hydra's Lair just passed you, but a large shark floats in the way.");
        this.queensLair = new Place("Queen Hydra's Lair", directions[5],"Queen Hydra stands looming over you.");

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

        //Making the People
        this.people = new ArrayList<Person>();

        String[] delphineNames = new String[]{"delphine","lady"};
        this.delphine = new WiseLady(delphineNames,oldLadyHouse);

            delphine.addToInventory(this.kelpCard);
            delphine.addToInventory(this.sword);
            delphine.addToInventory(this.oneKrabbyPatty);
            delphine.addToInventory(this.amulet); 
            delphine.addToRequirements(this.twoKrabbyPatty);
            delphine.addToRequirements(this.oysters);
            
        String[] squidwardNames = new String[]{"squidward"};
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
            // merMaya.addToConversationBits(": this should not be happening");
            people.add(this.merMaya);

        String [] jellyFishNames = new String[]{"jellyfish jack","jellyfish", "jelly","jack"};
        this.jellyFish = new Person (jellyFishNames,this.caveEntrance,null,anglerFish);
            jellyFish.addToConversationBits(": You can't travel down this cave without something to light the way."+System.lineSeparator()+ "I'd help but I have a poker game tonight. Sorry babe.");
            jellyFish.addToConversationBits(": This cave is pretty dark without something to light the way!!!"+System.lineSeparator()+"Oh JK you have Jörmungandr with you. See you at poker Jo!"+System.lineSeparator()+"I would DEFINETLY NOT go south. That's where the queen lives **shutters**");
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
 
            if (playerInputList[0].equalsIgnoreCase("swim")){ 
                this.player.swim(playerInputList[1],this.gameMap);

            } else if (playerInputList[0].equalsIgnoreCase("help")){
                this.player.printOptions();

            } else if (playerInputList[0].equalsIgnoreCase("explore")){
                this.player.location.explore();

            } else if(playerInputList[0].equalsIgnoreCase("talk") && playerInputList[1].equalsIgnoreCase("to")) {
    
                if (listLength == 2){
                    System.out.println("Sorry, I don't know who you want to talk to.");
                
                } else {
                    Boolean talkToSomeone = false;
                    for (int i = 0; i < this.people.size(); i++){ 
                        Person convoPerson = this.people.get(i);

                        for (int k = 0; k < convoPerson.getNameList().length;k++) {

                            if (convoPerson.getNameList()[k].equalsIgnoreCase(playerInputList[2])) {
                                if (convoPerson.getLocation()==player.getLocation()) {
                                    if (convoPerson == this.jellyFish){
                                        String[] newAvailibleDirections = new String[]{"west", "south"};
                                        convoPerson.conversation(this.player,myScanner,newAvailibleDirections);
                                        talkToSomeone = true;
                                        break;
                                    } else {
                                        convoPerson.conversation(this.player,myScanner);
                                        talkToSomeone = true;
                                        break;
                                    }  
                                } else {
                                    System.out.println("Sorry, "+convoPerson.getName()+" is not at "+player.getLocation().getName());
                                    talkToSomeone = true;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } if (delphine.getName().equalsIgnoreCase(playerInputList[2])) {
                            if (player.getLocation()==this.oldLadyHouse) {
                                delphine.conversation(this.player);
                                talkToSomeone = true;
                                break;
                            } else {
                                System.out.println("Sorry, Delphine is not at "+player.getLocation().getName());
                                talkToSomeone = true;
                                break;
                            }
                        } if (this.shark.checkName(playerInputList[2])) {
                            if (player.getLocation()==this.sharkPlace) {
                                this.shark.conversation(this.player,myScanner);
                                talkToSomeone = true;
                                break;
                            } else {
                                System.out.println("Sorry, Carl the Shark is not at "+player.getLocation().getName());
                                talkToSomeone = true;
                                break;
                            }
                        } if (this.queen.checkName(playerInputList[2])){
                            if (player.getLocation()==this.queensLair) {
                                this.queen.conversation(this.player,myScanner);
                                talkToSomeone = true;
                                counter = 0;
                                break;
                            } else {
                                System.out.println("Sorry, the Queen is not at "+player.getLocation().getName());
                                talkToSomeone = true;
                                break;
                            }
                        }
                    }
                    if (talkToSomeone == false) {
                        System.out.println("I don't know who you want to talk to, try typing the command again.");
                        continue;
                    }
                }
            } else if (playerInputList[0].equalsIgnoreCase("exit")){

                counter = 0;
            } else if(playerInputList[0].equalsIgnoreCase("check") && playerInputList[1].equalsIgnoreCase("inventory") ){

                this.player.printInventory();

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