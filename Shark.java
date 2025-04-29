import java.util.Scanner;

public class Shark extends Person {

    //constructor for Shark
    public Shark (String[] names, Place location, Thing requirement){
        super(names,location,null,requirement);
        
    }

    /**
     * Override constructor for conversation
     * @param player 
     * @param scanner so the player can interact with Shark
     */
    public void conversation(Player player, Scanner scanner){
        if (this.talkToCount== 0){ //if the player has not yet completed the sharks' 'challenge'
            System.out.println(this.names[0]+": Hey so like, I can't let you go by. Its kinda my job to guard this passage");
            System.out.println();

            int continueLoop = 0;
            while (continueLoop==0){
            System.out.println("[You have both a krabby patty and a sword, which will you choose to get passed the shark?]");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("krabby patty")){
                System.out.println(this.names[0]+": whoaaa is that a krabby patty?! my mom never lets me have those"+System.lineSeparator()+"Can I have it if I let you into the cave?");
                String responseTwo = scanner.nextLine();
                if (responseTwo.equalsIgnoreCase("yes")) {
                    player.removeFromInventory(this.requirement);
                    System.out.println(this.names[0]+": yumm this is soooooo good! Thank you mermaid! I guess I have to let you through now");
                    String[] newDirections = new String[]{"south","north"};
                    this.location.changeAvailibleDirections(newDirections);
                    this.talkToCount = this.talkToCount+1;
                    continueLoop = 1;

                } else if (responseTwo.equalsIgnoreCase("no")){
                    System.out.println(this.names[0]+": okay lame.");
                    continueLoop = 1;
                }
            } else if (response.equalsIgnoreCase("sword")){
                System.out.println(this.names[0]+": Nice try but that sword is like a tooth pick to me.");
                continueLoop = 1;
            } else {
            System.out.println("Sorry, I don't know what you mean");
            }
            }
            
            
        } else {
        System.out.println(this.names[0]+": that Krabby Patty was delicious!");
        }
    }
}
