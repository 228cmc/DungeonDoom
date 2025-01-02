public class Gold {
    private int amount; // current amount of gold collected by the player
    private static final int goalGold = 2; // total gold required to win (constant)
    private int positionX;
    private int positionY;


    public  Gold (int amount,  int positionX, int positionY) {
        this.amount = amount;
        this.positionX = positionX;
        this.positionY = positionY;

    }



    public static int  requiredGold(){  // is tied to the concept of "total gold required to win,"therefore is static, as this value does not vary between instances.
    //triggered with hello 
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