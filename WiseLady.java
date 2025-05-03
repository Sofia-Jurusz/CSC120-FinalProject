import java.util.ArrayList;

public class WiseLady extends complexPerson{

    //Attributes
    protected ArrayList<Thing> requirements;
    protected Boolean completedTask;
    

    /**
     * Constructor for wise lady
     * @param names the names she goes by
     * @param location the place she is at
     */
    public WiseLady (String[] names, Place location){
        super(names, location);
        this.requirements = new ArrayList<Thing>();
        this.talkToCount = 0;
        this.completedTask = false;
        
    }

    //Methods

    /**
     * adds Thing to wiselady's requirements
     * @param thing we want to add
     */
    public void addToRequirements(Thing thing){
        this.requirements.add(thing);
    }

    /**
     * holds a conversation between player and wiseLady
     * @param player 
     * @param newNeighbor once the challenge is complete, the wiseLady adds a new pathway the player can travel to
     */
    public void conversation(Player player, Place newNeighbor){
        if (this.talkToCount==0){ //welcome message for the first time the player talks to her
            System.out.println();
            System.out.println(this.names[0]+": Greetings young mer. I am the Wise Mer-Lady Delphine.");
            System.out.println("I will help you save the princess, but I need you to run a couple errands for me first.");
            System.out.println("This old tail doesn't get around like it used to. I need two Krabby Patties and a fresh bag of oysters.");
            System.out.println("Here is my Kelp Card. Don't spend too much, I'm planning on betting big at poker tonight.");
            player.addToInventory(this.inventory.get(0));
            this.talkToCount = 1+this.talkToCount;
            return;
            
        } else if (this.completedTask==false) { 
            if (player.getInventory().contains(requirements.get(0)) && player.getInventory().contains(requirements.get(1))) { //once the player has the items delphine asks for
                System.out.println();
                System.out.println("************************");
                System.out.println(this.names[0]+": Thank you dearly "+player.getName()+". ");
                System.out.println("Your willingness to help an old mer out tells me you are worthy of taking on this journey");
                System.out.println("I have uncovered my secret passage to the east,");
                System.out.println("You must follow it to get to the queen's lair.");
                System.out.println("In the depth of her cave the princess will be.");
                System.out.println("The cave is dark, so you will need something to light the way");
                System.out.println("You may need this sword, and I will give you one krabby patty for the road.");
                System.out.println("Also, what the heck, have this amulet necklace too. ");
                System.out.println("It's alittle gaudy for my taste, but you could pull it off.");
                System.out.println("************************");
                System.out.println();
                player.removeFromInventory(this.requirements);
                player.removeFromInventory(this.inventory.get(0));
                player.addToInventory(this.inventory.get(1));
                player.addToInventory(this.inventory.get(2));
                player.addToInventory(this.inventory.get(3));

                this.location.addToNeighbors("east", newNeighbor); //opening up her secret passage so the player can travel to the cave
                this.completedTask = true;
                return;

            } else if (this.completedTask==false) { //if the player tries to talk to delphine before they have her groceries
                System.out.println();
                System.out.println(this.names[0]+": Doesn't look like you have what I asked for.");
                return;
                
            }
        } else { //if the player talks to delphine after completeing her challenge
            System.out.println(this.names[0]+": Good luck on your journey young mer!");
                      
        }  
    }   
}
