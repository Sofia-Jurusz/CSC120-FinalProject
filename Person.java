import java.util.Scanner;
import java.util.ArrayList;

public class Person{

    //Attributes

    protected String[] names; //person's name
    protected Place location; //person's location
    protected Thing item; //the item a person has
    protected Thing requirement; //if the person has a 'challenge' that must be met, this is the thing the player must bring to  them in order to get passed the character
    protected ArrayList<String> conversationBits; //list of phrases that a person says
    protected int talkToCount; //the number of times a player has talked to a person
    
    //Constructors for Person

    /**
     * constructor for person
     * @param names list of names a person can be refered to as
     * @param location the location of the person
     * @param item a person's item
     * @param requirement the item the player needs to surpass a person's 'challenge'
     */
    public Person(String[] names, Place location, Thing item, Thing requirement){
        this.names = names;
        this.location = location;
        this.conversationBits = new ArrayList<String>();
        this.item = item;
        this.requirement = requirement;
        this.talkToCount = 0;
    }

    /**
     * Alternate constructor for Person who does not have Things
     * @param names list of names a person can be refered to as
     * @param location the location of the person
     */
    public Person(String[] names, Place location){
        this.names = names;
        this.location = location;
        this.conversationBits = new ArrayList<String>();
        this.item = null;
        this.requirement = null;
    }

    /**
     * Alternate constructor for a Person
     * @param location
     */
    public Person (Place location){
        this.location = location;
    }

    //Methods

    /**
     * Accessor for Person's name;
     * @return Person's name
     */
    public String getName(){
        return this.names[0];
    }

    /**
     * Accessor for a Person's Place
     * @return Person's place
     */
    public Place getLocation(){
        return this.location;
    }

    /**
     * Accessor for a Person's list of referencable names
     * @return list of names a Person can be called on by
     */
    public String[] getNameList(){
        return this.names;
    }

    /**
     * Adds a conversation string to the list of conversation bits
     * @param conversationBit the string we want to add to conversationBits list
     */
    public void addToConversationBits(String conversationBit){
        this.conversationBits.add(conversationBit);
    }

    /**
     * Checks if a name is in the list of names a Person goes by
     * @param potentialName the name we want to know is in the Person's list of names
     * @return whether the potentialName is in the list
     */
    public Boolean checkName(String potentialName){
        for (int i = 0; i<this.names.length;i++){
            if (potentialName.equalsIgnoreCase(this.names[i])){
                return true; //returns true if the name is in the list
            } else {
                continue;
            }
        }
        return false; //returns false if the name is not present in the list
    }

    /**
     * Runs a conversation between the player and a select Person
     * @param player the player who is having the conversation
     * @param myScanner so we can obtain user inputs
     */
    public void conversation(Player player, Scanner myScanner){
        if (this.talkToCount==0) { //if the payer is talking to the Person for the first time
            if (this.requirement == null && this.item == null){ //if the Person has no items associated with them, there is only one way for the player to interact with them
                System.out.println(this.names[0]+this.conversationBits.get(0));
                return;
            } else if (player.getInventory().contains(this.requirement)||this.requirement == null) { //for some Persons, you need to have the requirement to engage in certain conversations with them. For others, you may not need a requirement but they might still give you something at the end of the conversation.
                System.out.println(this.names[0]+this.conversationBits.get(0));
                String response = myScanner.nextLine();

                if (response.equalsIgnoreCase("yes")) { //the player agrees to whatever the Person has asked them
                    System.out.println(this.names[0]+this.conversationBits.get(1));
                    player.addToInventory(this.item);
                    this.talkToCount = 1+this.talkToCount;

                } else if (response.equalsIgnoreCase("no")) {  //the player does not agree to whatever the Person has asked them. but they can still go back and have the same conversation with a different player input
                    System.out.println(this.names[0]+": Alright see you another time!");

                } else {
                    System.out.println(this.names[0]+": Sorry, I don't know what you mean by that");
                }
                
            } else { //if the player is talking to a person who has a requirement, but the player does not have said requirement
                System.out.println(this.names[0]+this.conversationBits.get(2));
            }

        } else { // if the player has already met the 'challenge' associated with the Person, they cannot re-engage with the same challenege
            System.out.println(this.names[0]+": Good seeing you again "+player.getName()+"! But I don't have anything else for you.");
        }      
    }

    /**
     * Alternate conversation method where the availible directions for a location are changed
     * @param player who's having the conversation 
     * @param myScanner for user interaction
     * @param newAvailibleDirections the new directions we want a player to be able to go from a location
     */
    public void conversation(Player player, Scanner myScanner, String[] newAvailibleDirections){
        if (this.talkToCount==0) { //if this is the first time the player is talking to the character
            if (player.getInventory().contains(this.requirement)) {
                System.out.println(this.names[0]+this.conversationBits.get(1));
                this.location.changeAvailibleDirections(newAvailibleDirections);
                this.talkToCount=this.talkToCount+1;
            } else { 
                System.out.println(this.names[0]+this.conversationBits.get(0));
            }
        } else { // if the player has already met the 'challenge' associated with the Person, they cannot re-engage with the same challenege
            System.out.println(this.names[0]+this.conversationBits.get(2));
        }
             
    }
}


