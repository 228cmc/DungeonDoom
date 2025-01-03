import java.util.List;

public class BotPlayer extends Player { 
/**it is build from the abstract class Player 
 * therefore it inherits its attributes and methods
 * positionX, positionY, gold collection and its movement methods
 */
    public BotPlayer(int positionX, int positionY, int goldCollected ){
    /*the constructor is a new botPlayer  with an specific position an intial gold
     * @param positionX the initial x coordinate of the bot
     * @param positionY the initial y coordinate of the bot
     * @param gold collected the amount of gold  of gold collected by the player
     */
        super(positionX, positionY, goldCollected);
    }


    public void chaseHuman(HumanPlayer human, List<String> validLines) {
    /*this method was build to chase the human accross the board
     it prioritize horizontal movement first and then vertical movement
    

     * @param  human object representing the target to chase.
     * @param validLines list of strings repserenting the lines fo the game board
     */
        int botX = this.getPositionX();
        int botY = this.getPositionY();
        int humanX = human.getPositionX();
        int humanY = human.getPositionY();
    
        // prioritize movement in the x-direction first

        if (botX != humanX) { // if bot and human x-coordinates are different
            if (humanX > botX) {

                
                //check if moving east is valid
                if (validLines.get(botY).charAt(botX + 1) != '#') {
                    this.moveEast();
                    return;
                }
            } else {
                //   check if moving west is valid
                if (validLines.get(botY).charAt(botX - 1) != '#') {
                    this.moveWest();
                    return;
                }
            }
        }
    
        // prioritize movement in the y-direction next

        if (botY != humanY) { //   if bot and human y-coordinates are different
            if (humanY > botY) {
                //  check if moving south is valid
                if (validLines.get(botY + 1).charAt(botX) != '#') { // { charAt(botX + 1) != '#' conditional  where we verify that the character where we want to move is not a wall
                this.moveEast();
                    this.moveSouth();
                    return;
                }
            } else {
                // check if moving north is valid
                if (validLines.get(botY - 1).charAt(botX) != '#') {
                    this.moveNorth();
                    return;
                }
            }
        }
    
        //System.out.println("Bot cant move due to obstacles.");
    }
    







    
}

