import java.util.ArrayList;

public class Player extends Person{

    //Attributes for Player
    private ArrayList<Thing> inventory; //location of what the user has collected
    // private ArrayList<Person> people; //idkkkk

    /**
     * constructor for PLayer
     * @param name
     * @param location where the player is currently located
     */
    public Player(String name, Place location){
        super(name,location);
        this.inventory = new ArrayList<Thing>();
    }

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
        System.out.println();
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

    public void talkTo(String personName){
        

    }

    public void addToInventory(Thing thing){
        this.inventory.add(thing);
        System.out.println("You have added "+thing.getName()+" to your inventory");
    }

    /**
     * Print's the player's current inventory
     */
    public void checkInventory(){
        if (this.inventory.size()==0){
            System.out.println("Your inventory is empty");
        } else {
            System.out.println("Your inventory: ");
            System.out.println("----------------");
            for (int i = 0; i<this.inventory.size();i++) {
                System.out.println(this.inventory.get(i));
            }
            System.out.println("----------------");

        }
    }

    /**
     * Prints the availible commands of the player
     */
    public void printOptions(){
        System.out.println();
        System.out.println("Greetings Mermaid!");
        System.out.println("Availible commands are: Swim [north, east, south, west], Explore, Grab [thing], Talk to [person], check inventory, and Exit");
    }
      
}