
public class HumanPlayer extends Player { 
/**
 This class was build using the mold Player
 it represents a human player in the board that  is controlled by the user inputs 
 it iherits all the attributes and method of the player class such as coordinates,gold collected and the different methods of movement and picking gold
*/
    public HumanPlayer(int positionX, int positionY, int goldCollected ){
    /** 
     constructor method to build a new humanPlayer with the specified position and intial gold collected
    @param positionX
    @param positionY
    @param goldCollected
        */
        super(positionX, positionY, goldCollected); // we use super to access the constructor of the parent class 
    }



    

}