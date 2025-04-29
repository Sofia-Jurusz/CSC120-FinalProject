public class Place {

    // Place Attributes
    private String name; //place's name
    private String exploreString; //gives description of the place to the player
    private String[] availibleDirections; //the directions you can move in a place

    /**
     * Constructor for Place
     * @param name
     * @param availibleDirections
     * @param exploreString
     */
    public Place(String name, String[] availibleDirections, String exploreString){
        this.name = name;
        this.exploreString = exploreString;
        this.availibleDirections = availibleDirections;
    }

    //Methods
    
    /**
     * accessor for Place's name
     * @return Place's name
     */
    public String getName(){
        return this.name.toString();
    }

    // /**
    //  * Prints directions availible for a place
    //  */
    // public void printDirections(){
    //     System.out.println();
    //     System.out.println( "From the " +this.name+ " you can go:");
    //     for (int i = 0; i < availibleDirections.length;i++){
    //         System.out.println(availibleDirections[i]);
    //     }
    // }

    /**
     * Accessor for availible directions
     * @return availible Directions
     */
    public String[] getDirections(){
        return this.availibleDirections;
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

    /** 
     * Prints out the explore string associated with a place
     */
    public void explore(){
       System.out.println(this.exploreString);
        
    }

    /**
     * Changes the directions you can go from a place
     * @param newAvailibleDirection
     */
    public void changeAvailibleDirections(String[] newAvailibleDirection){
        this.availibleDirections= newAvailibleDirection;
    }

}