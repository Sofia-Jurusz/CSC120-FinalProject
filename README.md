# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.


Reflection:

design justification:

This game's driving force is the user's interactions with different characters. Some player-person interactions were simple, and in that case, the conversations between the player and those People were relatively simple and the same. However, I wanted some of the Person interactions to be more complex and engaging. Therefore, I decided to make separate classes for the more important People: Delphine, Shark, and the Queen. I made the complexPerson class so that the Player and wiseLady classes could share some of their methods. Initially, I created one conversation method and tried to have every character operate under the same one. This, however, limited my ability for unique interactions. Since I am new to a lot of these concepts, I am sure there was a more straightforward way for me to implement these ideas. However, it made sense to do it this way at the time since I wanted the user to be on their toes. 


To tackle this project, I started by outlining all the simple classes, Person, Place, and Thing, and filling them with basic methods. I knew I wanted some of the methods in the game, but others were just for testing. Then, once I had a general outline of the Thing, Person, Place, and Player classes, I started making the whole game loop. I knew that making the game interactive would be the most challenging part for me, so I wanted to get started on it early. This way, I wouldn't need to change my methods to be interactive. This was a good approach for me because going back to change things takes more time than it's worth.

Through the project, I became much more comfortable using input and scanners. Using the scanners was difficult for me during the chatbot, but in the final project, I got a much better understanding of how to use them by passing them through different methods. Second, I originally had a class called 'map' that was an ArrayList of ArrayLists containing the locations in my game. This ended up being a little unnecessary and confusing, so I implemented 'neighbors' as an attribute for a Place. 'Neighbors' is a hash table that stores a place's neighbors and the direction you need to move to get to them. I became more comfortable with ArrayLists after implementing the map class, but I also learned a lot when I switched to the neighbor method. I learned to be really careful with my code when making changes. The most important skill I learned was being able to plan ahead and think abstractly about how my classes would work together.

If I could change something, I would try to improve the conversation classes. Right now, I have six conversation classes because the interactions between the player and different characters are different. If I could go back, I would 

If I had unlimited time, I would add a couple more challenges for the player to get to the end. For example, there is a Place called Shipwreck that does not have any real purpose. Initially, I wanted the player to have to find something in the shipwreck, but I ran out of time to implement this. I also was struggling a little bit on exactly what the next challenge would be. I think it would be fun to implement a riddle. There is a point in the game where the player needs to get through the shark, and the only way to do it is to use a krabby patty (and not the sword) I was thinking about making the second krabby patty something the user has to go back to the krusty krab and get themselves, but unfortunalty I ran out of time.

I got two really good pieces of feedback. The first was from Jazmine in my class. In her game, every command had a list of words that a user could input to get the same command. For example, a user can type 'go' or 'walk' to move to a new location. She said she thought this could be helpful for me. Instead of for directions, I used this strategy for my Person names so it would be easier for the user to interact with them. Second, Jordan told me to do a hashtable of neighbors for each location instead of the map class. This cleaned up my code a lot and made it much easier to understand from an outsider's perspective.

If I could go back in time, I would tell myself not to stress too much. It was really fun making my game. I actually really like computer science. I would tell myself to use the hashtable for neighbors instead of the map because I would save a lot of time, and maybe get to implement some of the other parts that I didn't get to before.
