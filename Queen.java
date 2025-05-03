import java.util.Scanner;


public class Queen extends Person {

    /**
     * constructor for queen
     * @param names
     * @param location
     */
    public Queen (String[] names, Place location) {
        super(names, location);
    }

    //Methods

    /**
     * Override conversation method for Queen
     * @param player
     * @param scanner so the conversation requires player input
     */
    public void conversation(Player player, Scanner scanner){
        System.out.println("**********************************************************");
        System.out.println("[sword in hand, you face the mighty Evil Mer-Queen]");
        System.out.println(this.names[0]+": Greetings young mer! I am Queen Hydra. How you surpassed my many guards alludes me!!");
        System.out.println("My ANNOYING brother must have sent you to 'rescue' his poor daughter");
        System.out.println("Ahhh, but by that hideous amulet I see you have been sent by my good friend Delphine.");
        System.out.println("Aqua Pearl, it is safe to come out!");
        System.out.println();
        System.out.println("[Aqua Pearl enters the room, not the least bit distressed!]");
        System.out.println("Aqua Pearl: Greetings brave mer, for I am princess Aqua Pearl");
        System.out.println("Despit what my father has told you, I was not kidnapped. I ran away from the castle.");
        System.out.println("My greatest dream is to attend the Atlantic University of the Arts and study watercolors,");
        System.out.println("but father beleives art is useless and wants me to study finance **eye roll**");
        System.out.println("My only choice was to run away to my aunt's cave. Please, you mus'nt return me to the castle!");
        System.out.println("**********************************************************");
        System.out.println("[you are faced with the impossible decision;"+System.lineSeparator()+ "do you return Aqua Pearl to her father and gain the entire Pacific Ocean,"+System.lineSeparator()+"or do you allow her to live out her dream and study the arts?!?!?!?]");
        System.out.println(this.names[0]+": So young mer, will you return Aqua Pearl to the Castle? Your fate lies in this decision");
        
        int continueLoop = 1;
        while (continueLoop == 1) { // the final challenge of the game, the player must decide if they will let Aqua Pearl free or not
            String playerResponse = scanner.nextLine();
            if (playerResponse.equalsIgnoreCase("yes")) { // if the brings her back to the castle, the player loses
                System.out.println(this.names[0]+": You have disappointed me young mer, I thought your moral standings would be higher. I have no choice but to execute you.");
                System.out.println("[You let your desire for material goods outway the happiness of others!! Sorry "+player.getName()+" you have lost!]");
                continueLoop = 0;
                break;

            } else if (playerResponse.equalsIgnoreCase("no")) { // if they let her follow her dreams, the player wins!!
                System.out.println("**********************");
                System.out.println("CONGRATULATIONS!!!!!!");
                System.out.println("**********************");
                System.out.println(this.names[0]+": Delphine was correct in choosing you for this journery young mer!! I applaud you and your righteousness!");
                System.out.println("Aqua Pearl: Oh thank you "+player.getName()+", I will forever be indepted to your kindess!");
                System.out.println();
                System.out.println("[Congratulations "+player.getName()+"! You have won the game for your excellent moral standards!"+System.lineSeparator()+"The princess was so impressed by your goodness that she fell in love with you!"+System.lineSeparator()+"Now you both live happily in a cute little mer-cottage.]");
                continueLoop = 0;
                break;
    
            } else { //The player will not be able to leave this point until they answer the question
                System.out.println("Answer the question mer!! My poker game can't wait all day!");
                continue;
            }
    
        }
        
        
    }
}
