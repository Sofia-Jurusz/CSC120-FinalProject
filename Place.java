import java.util.Hashtable;

public class Place {

    // Place Attributes
    private String name; //place's name
    private String exploreString; //gives description of the place to the player
    private Hashtable <String, Place> neighbors; //Hashtable of a Place's neighbors and how to get there

    /**
     * Constructor for Place
     * @param name
     * @param availibleDirections
     * @param exploreString
     */
    public Place(String name, String exploreString){
        this.name = name;
        this.exploreString = exploreString;
        // this.availibleDirections = availibleDirections;
        this.neighbors = new Hashtable<String, Place>();
    }

    //Methods

    /**
     * accessor for Place's name
     * @return Place's name
     */
    public String getName(){
        return this.name.toString();
    }

    /**
     * Accessor for a place's neighbors
     * @param direction the direction player wants to go from current location
     * @return the Place assocciate with going a certain direction
     */
    public Place getNeighbor(String direction){
        return this.neighbors.get(direction);
    }

    /**
     * Adds a neighbor to the Hashtable neighbors
     * @param direction the direction associated with a place
     * @param place the Place we want to beocme a neighbor
     */
    public void addToNeighbors(String direction, Place place){
        this.neighbors.put(direction, place);
    }

    /** 
     * Prints out the explore string associated with a place
     */
    public void explore(){
       System.out.println(this.exploreString);
        
    }

}