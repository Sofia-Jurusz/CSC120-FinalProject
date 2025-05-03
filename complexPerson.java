import java.util.ArrayList;

public class complexPerson extends Person {
    
    //Attributes
    protected ArrayList<Thing> inventory;


    /**
     * constructor for complex person
     * @param location
     */
    public complexPerson(Place location){
        super(location);
        this.inventory = new ArrayList<Thing>();
    }

    /**
     * alternate constructor for a complex person
     * @param names the names they go by
     * @param location
     */
    public complexPerson(String[] names, Place location){
        super(names,location);
        this.inventory = new ArrayList<Thing>();
    }

    //Methods

    /**
     * adds a thing to a player's inventory and prints a string so the use knows it is in their inventory
     * @param thing what we want to add to the inventory
     */
    public void addToInventory(Thing thing){
        this.inventory.add(thing);
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

}
