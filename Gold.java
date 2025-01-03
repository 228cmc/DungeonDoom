public class Gold {

/**This class represent gold in the board
 * it has 4 atributes: the amount of gold, the position of the gold and the final goal of the gold to collect
 * the class count with getters and setters for the majority of the attributes except the static variable
 * it has a method to review the static variable called requiredGold
 */


    //atributes
    private int amount; // current amount of gold collected by the player
    private static final int goalGold = 2; // total gold required to win (constant)
    private int positionX;
    private int positionY;


    public  Gold (int amount,  int positionX, int positionY) {

    /** constructor of the class with the specific amount of gold and its position
     * @param amount : the value of the gold item
     * @param positionX: coordinate x of the gold
     * @param positionY : coordinate y of the gold */ 
        this.amount = amount;
        this.positionX = positionX;
        this.positionY = positionY;

    }



    public static int  requiredGold(){  // i

    /**this method gives the total value of gold required to win  and it's triggered by the command  HELLO
     * because is tied to the concept of total gold required to win,therefore is static, as this value does not vary between instances.
     * 
     * @return  the goalGold variable  meaning the number of gold to win
     */

        return goalGold;
    
    }




// setters for the variables 


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

public int getAmount(){
    return amount;
}

public void setAmount(int amount){
    this.amount= amount;
}
}