import java.util.ArrayList;

public class Player extends ComplexPerson{

    //Attributes for Player
    protected String name;


    /**
     * constructor for PLayer
     * @param name
     * @param location where the player is currently located
     */
    public Player(String name, Place location){
        super(location);
        this.name = name; 
        
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
     * Allows a player to "swim" from one Place to another Place, if there is a pathway between two places
     * @param direction the direction the player wants to swim
     */
    public void swim(String direction) {
        System.out.println("Swimming "+direction+"....");
        if (this.location.getNeighbor(direction) == null) {
            System.out.println("You cannot swim "+direction+" from "+this.location.getName());
            return;
        } else {
            this.location = this.location.getNeighbor(direction);
            this.printLocation();
            return;
        }    
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