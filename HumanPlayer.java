import java.util.List;

public class HumanPlayer extends Player { 
    public HumanPlayer(int positionX, int positionY, int goldCollected ){
        super(positionX, positionY, goldCollected);
    }

    public void pickUpGold() {

           
        this.setGoldCollected(this.getGoldCollected() + 1); // increment the player's collected gold



        System.out.println("Success! You have now gold! Total: " + this.getGoldCollected());
    }

    

}