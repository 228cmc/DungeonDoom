public class Wall {
    private int numeral;


    public Wall (int numeral){
        this.numeral = numeral;
    }
    public int  addNumeral() { 
        numeral++; // Incrementa numeral

        return numeral;
    }
    public int deleteNumeral(){
        numeral --;
        return numeral; 
    }
    }

