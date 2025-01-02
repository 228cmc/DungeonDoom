public abstract class Player {

    private int positionX;
    private int positionY;
    private int goldCollected;

    public Player( int positionX, int  positionY, int goldCollected) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.setGoldCollected(goldCollected);


    }

// getters and setters for all the variables

public int getPositionX() {
    return positionX;
}

public void setPositionX(int positionX){
    this.positionX = positionX;
}


public int getPositionY() {
    return positionY;
}

public void setPositionY(int positionY){
    this.positionY= positionY;
}


public int getGoldCollected(){
    return goldCollected;
}

public void setGoldCollected(int goldCollected){
    this.goldCollected = goldCollected;
}



public void pickUpGold() {

           
    this.setGoldCollected(this.getGoldCollected() + 1); // increment the player's collected gold



    System.out.println("Success! You have now gold! Total: " + this.getGoldCollected());
}



//movement methods
        public void moveEast() {
            this.setPositionX(this.getPositionX() + 1);
        }
                            

                    
        public void moveWest() {
            this.setPositionX(this.getPositionX() - 1);
        }


        public void moveNorth() {
            this.setPositionY(this.getPositionY() - 1);
        }
        
                    
        public void moveSouth() {
            this.setPositionY(this.getPositionY() + 1);
        }



    }

 
