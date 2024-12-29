public class Gold {
    private int amount;


    public  Gold (int amount){
        this.amount = amount;
    }



    public int  requiredGold(){ 
    //triggered with hello 
        return  amount;
    }

    public int currentGold() {
        return amount;
    }

    public int addGold() {
        amount ++;
        return amount;
    }

    public int eliminateGold() {
        amount --;
        return amount;
    }
}