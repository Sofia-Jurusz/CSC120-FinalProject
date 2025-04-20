import java.util.ArrayList;

//I am unsure if i want to make every character that the player interacts with its own extension of person or not. 
//Each character has its own conversation bits, so i don't know the best way to do that rn. 
//I also am debating on who will be responsible for the things. I am starting to think that having a person class is not the right move
// and maybe the characters should just be associated with each location. 

public class WiseLady extends Person {

    int conversationNumber;
    Thing kelpCard;

    public WiseLady (Place location){
        super("Wise Mer-Lady", location);
        this.kelpCard = kelpCard;
    }

    public void conversation(Player player){
        System.out.println("Greetings young mer. I am the Wise Mer Lady.");
        System.out.println("I will help you save the princess, but I need you to run a couple errands for me first. This old tail doesn't get around like it used to.");
        System.out.println("I need two Krabby Patties and a fresh bag of oysters.");
        System.out.println("Here is my Kelp Card. Don't spend too much, I'm alittle in debt from online shopping.");
        player.addToInventory(this.kelpCard);

    }
    
    
}
