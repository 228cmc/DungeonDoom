import java.util.List;

public class BotPlayer extends Player { 
    public BotPlayer(int positionX, int positionY, int goldCollected ){
        super(positionX, positionY, goldCollected);
    }


    public void chaseHuman(HumanPlayer human, List<String> validLines) {
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
                //     check if moving south is valid
                if (validLines.get(botY + 1).charAt(botX) != '#') {
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
    
        System.out.println("Bot cant move due to obstacles.");
    }
    







    
}

