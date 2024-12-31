public class Gold {
    private int amount; // current amount of gold collected by the player
    private static final int goalGold = 5; // total gold required to win (constant)
    private int positionX;
    private int positionY;


    public  Gold (int amount,  int positionX, int positionY) {
        this.amount = amount;
        this.positionX = positionX;
        this.positionY = positionY;

    }



    public int  requiredGold(){ 
    //triggered with hello 
        return goalGold;
    
    }


    public int addGold() {
        amount ++;
        return amount;
    }

    public int eliminateGold() {
        amount --;
        return amount;
    }






//setters for the variables 


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