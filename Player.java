import java.util.ArrayList;

public class Player extends Person{

    //Attributes for Player
    protected ArrayList<Thing> inventory;
    protected String name;


    /**
     * constructor for PLayer
     * @param name
     * @param location where the player is currently located
     */
    public Player(String name, Place location){
        super(location);
        this.name = name;
        this.inventory = new ArrayList<Thing>(); 
        
    }

    //Methods

    /**
     * prints the players current location
     */
    public void printLocation(){
        System.out.println();
        System.out.println("You are at "+this.location.getName()); 
    }

    /**
     * allows the player to 'swim' to certain locations
     * @param direction the way they'd like to swim
     * @param map the map the user is trying to move within
     */
    public void swim(String direction, Map map){
        System.out.println("Swimming "+direction+"....");
        int currentRowNum = map.getRow(this.location);
        int currentColumnNum = map.getColumn(this.location);
        if (this.location.checkDirections(direction)){

            if (direction.equalsIgnoreCase("north")){
                this.location = map.getLocation(currentRowNum-1,currentColumnNum);

            } else if (direction.equalsIgnoreCase("east")){
                this.location = map.getLocation(currentRowNum,currentColumnNum+1);

            } else if (direction.equalsIgnoreCase("south")){
                this.location = map.getLocation(currentRowNum+1,currentColumnNum);

            } else if (direction.equalsIgnoreCase("west")){
                this.location = map.getLocation(currentRowNum,currentColumnNum-1);

            }
        } else {
            System.out.println("Sorry, you can't go "+ direction + " from "+ this.location.getName());
            return;
        }
        this.printLocation();
    } 

    /**
     * adds a thing to a player's inventory and prints a string so the use knows it is in their inventory
     * @param thing what we want to add to the inventory
     */
    public void addToInventory(Thing thing){
        this.inventory.add(thing);
        if (this.inventory.contains(thing)) {
            System.out.println(thing.getName()+" is in your inventory");
        } else {
            System.out.println(thing+ " was not added to your inventory");
        }  
    }

    /**
     * removes a thing from a player's inventory
     * @param thing what we want to remove
     */
    public void removeFromInventory (Thing thing){
        this.inventory.remove(thing);
    }

    /**
     * removes a list of things from a player's inventory
     * @param things the list of what we want to remove
     */
    public void removeFromInventory(ArrayList<Thing> things){
        for (int i = 0; i< things.size();i++){
            this.removeFromInventory(things.get(i));
        }
    }

    /**
     * accessor for player's inventory
     * @return the player's inventory
     */
    public ArrayList<Thing> getInventory(){
        return this.inventory;
    }

    /**
     * Print's the player's current inventory
     */
    public void printInventory(){
        System.out.println(" ");
        if (this.inventory.size()==0){
            System.out.println("Your inventory is empty");
        } else {
            System.out.println("Your inventory: ");
            System.out.println("----------------");
            for (int i = 0; i<this.inventory.size();i++) {
                System.out.println(this.inventory.get(i).getName());
            }
            System.out.println("----------------");
            System.out.println(" ");

        }
    }

    /**
     * Accessor for a player's name
     * @return player's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Prints the availible commands of the player
     */
    public void printOptions(){
        System.out.println("Greetings Mermaid!");
        System.out.println("Availible commands are:");
        System.out.println("Swim [north, east, south, west] -- to move between locations");
        System.out.println("Explore -- gives you more information about your current location");
        System.out.println("Talk to [person] -- have a conversation!");
        System.out.println("check inventory -- see what you've got!");
        System.out.println("Exit -- getting bored? Leave the game");
        System.out.println();
    }
      
}