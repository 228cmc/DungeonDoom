public abstract class Player {


/**This class serves as a mold for the bot player and human player class
 * a player in general can move around a board. 
 * 
 The atributes of this class are: the positionX, positionY corresponding a the coordinates of the board
 and the goldCollected that is the total amount of gold of the bot.
 
 The class has different methods such as a constructor to initialize the player position and gold collected
 getters an setters of each of the atttribute in order to manipulate the attributes accross the game
 movement methods suck as moveEast(), moveWest(), moveNorth(), move South(),  to move around the board*/

    //atributes
    private int positionX;
    private int positionY;
    private int goldCollected;

    public Player( int positionX, int  positionY, int goldCollected) {

    /*ths method serves a the constructor of the class, it initializes the players position and the amount of gold collected
    * @param positionX : initial x coordinate of the player
    * @param positionY: initial y coordinate of the player
    * @param goldCollected the initial amount of gold that the player has*/
 
        this.setPositionX(positionX); //we use setters to ensure encapsulation 
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

/*This method was build modify the quantity of the gold. 
it uses the getter of the goldCollected and increments in 1 the quantity  
it prints a sucess message to allow feedback*/  


    this.setGoldCollected(this.getGoldCollected() + 1); // increment the player's collected gold



    System.out.println("Success! You have now gold! Total: " + this.getGoldCollected());
}



//movement methods
        public void moveEast() {

        /**This method  manipulates the position of the player
         * it uses the getter of the coordinate x   to take the value and the setter  to modify it
         * it modifies the position adding 1 meaning moving to the east
        */
            this.setPositionX(this.getPositionX() + 1);
        }
                            

                    
        public void moveWest() {

        /**This method  manipulates the position of the player
         * it uses the getter of the coordinate x   to take the value and the setter  to modify it
         * it modifies the position decreasing in  1 meaning moving to the west in
        */

            this.setPositionX(this.getPositionX() - 1);
        }


        public void moveNorth() {

        /**This method  manipulates the position of the player
         * it uses the getter of the coordinate y   to take the value and the setter  to modify it
         * it modifies the position adding 1 meaning moving to the north
        */

            this.setPositionY(this.getPositionY() - 1);
        }
        
                    
        public void moveSouth() {


        /**This method  manipulates the position of the player
         * it uses the getter of the coordinate y   to take the value and the setter  to modify it
         * it modifies the position decreasing 1 meaning moving to the south
        */

            this.setPositionY(this.getPositionY() + 1);
        }



    }

 
