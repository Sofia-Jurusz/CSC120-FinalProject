import java.util.ArrayList;

public class Place {

    // Place Attributes
    private String name; //place's name
    private Thing thingOne; //first item in each place's inventory
    private Thing thingTwo; //second item in each place's inventory. might condense to just a list
    private String exploreString; //gives description of the place to the player
    private String[] availibleDirections; //the directions you can move in a place

    /**
     * Constructor for Place
     * @param name 
     * @param thingOne
     * @param availibleDirections
     * @param exploreString
     */
    public Place(String name, Thing thingOne, String[] availibleDirections, String exploreString){
        this.name = name;
        this.exploreString = exploreString;
        this.thingOne = thingOne;
        this.thingTwo = null;
        this.availibleDirections = availibleDirections;
    }

    /**
     * Alternate Constructor for Place
     * @param name
     * @param availibleDirections
     * @param exploreString
     */
    public Place(String name, String[] availibleDirections, String exploreString){
        this.name = name;
        this.exploreString = exploreString;
        this.thingOne = null;
        this.thingTwo = null;
        this.availibleDirections = availibleDirections;
    }

    /**
     * Alternate Constructor for Place
     * @param name
     * @param thingOne
     * @param thingTwo
     * @param availibleDirections
     * @param exploreString
     */
    public Place (String name, Thing thingOne, Thing thingTwo, String[] availibleDirections, String exploreString){
        this.name = name;
        this.exploreString = exploreString;
        this.thingOne = thingOne;
        this.thingTwo = thingTwo;
        this.availibleDirections = availibleDirections;
    }

    /**
     * accessor for Place's name
     * @return Place's name
     */
    public String getName(){
        return this.name.toString();
    }

    /**
     * Prints directions availible for a place
     */
    public void printDirections(){
        System.out.println();
        System.out.println( "From the " +this.name+ " you can go:");
        for (int i = 0; i < availibleDirections.length;i++){
            System.out.println(availibleDirections[i]);
        }
    }

    /**
     * Accessor for availible directions
     * @return availible Directions
     */
    public String[] getDirections(){
        return this.availibleDirections;
    }

    /**
     * might delete (for testing)
     * prints the availible items in a place. 
     */
    public void printThings(){
        System.out.println();
        System.out.println("The "+this.name+" has:");
        if(thingOne == null){
            if (thingTwo == null) {
                System.out.println("there is nothing here!");
                return;
            }     
        } else if (thingTwo == null){
            System.out.println(this.thingOne.getName());
            return;
        } else {
            System.out.println(this.thingOne.getName()+" and "+ this.thingTwo.getName());
        }
        
    }

    /**
     * checks if a user can go to a certain direction from a place
     * @param direction the direction the user wants to move
     * @return true if the direction is valid
     */
    public boolean checkDirections(String direction){
        direction = direction.toLowerCase();
        for (int i = 0;i<this.availibleDirections.length;i++){
            String listDirection = this.availibleDirections[i];
            if (listDirection.equalsIgnoreCase(direction)){
                return true;
            } else {
                continue;
            }
        } 
        return false;
    }

    public void explore(){
        System.out.println(this.exploreString);
    }

    public static void main(String[] args) {
        // //Things
        // Thing krabbyPatty = new Thing("Krabby Patty");
        // Thing anglerFish = new Thing("Angler Fish");
        // Thing sword = new Thing("Sword");
        // Thing shell = new Thing("Sea Shell");
        // Thing amulet = new Thing ("Amulet");

        // String[][] directions = new String [8][]; 
        // directions[0] = new String[] {"south", "west"};
        // directions[1] = new String[] {"north", "east"};
        // directions[2] = new String[]{"north","east","south"};
        // directions[3] = new String[] {"north", "west"};
        // directions[4] = new String[] {"east", "west"};
        // directions[5] = new String[] {"north", "south"};
        // directions[6] = new String[] {};


        // //Places
        // Place krustyKrab = new Place("the Krusty Krab", krabbyPatty,directions[0]);
        // Place kingsCastle = new Place("the King's Castle",directions[1]);
        // Place yourHouse = new Place("your house", anglerFish,directions[2]);
        // Place market = new Place("the Market", shell,directions[3]);
        // Place oldLadyHouse = new Place("the Wise Lady's House", amulet,directions[4]);
        // Place shipwreck = new Place("the Shipwreck", sword,directions[4]);
        // Place caveEntrance = new Place("the Cave Entrance",directions[0]);
        // Place sharkPlace = new Place("the Shark's Lair",directions[5]);
        // Place queensLair = new Place("the Queen's Liar", directions[6]);

        // //Map
        // ArrayList<Place> rowZero = new ArrayList<Place>();
        //     rowZero.add(oldLadyHouse);
        //     rowZero.add(shipwreck);
        //     rowZero.add(caveEntrance);

        // ArrayList<Place> rowOne = new ArrayList<Place>();
        //     rowOne.add(yourHouse);
        //     rowOne.add(krustyKrab);
        //     rowOne.add(sharkPlace);
        
        // ArrayList<Place> rowTwo = new ArrayList<Place>();
        //     rowTwo.add(kingsCastle);
        //     rowTwo.add(market);
        //     rowTwo.add(queensLair);

        // Map gameMap = new Map();
        // gameMap.addToMap(rowZero);
        // gameMap.addToMap(rowOne);
        // gameMap.addToMap(rowTwo);

        // System.out.println(krustyKrab.checkDirections("south"));
        // System.out.println(krustyKrab.checkDirections("west"));
        // System.out.println(krustyKrab.checkDirections("east"));
        // System.out.println(krustyKrab.checkDirections("north"));  
    }

}