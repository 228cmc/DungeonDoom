public class Wall {


/*The class board represents a wall in the board game,
 it has an atribute a numeral that is the character that represents a wall in the board 
 The human and the bot are not able to be place over it 
 
 
 Some methods include manipulation of the atribute such as add, delete */



    private int numeral;


    public Wall (int numeral){

    /** this method is a constructor of the class  with an specific value of the numeral 
     * @param  is  the initial value of the  wall atribute
     */

        this.numeral = numeral;
    }
    
    public int  addNumeral() { 
    
    /*This method was created to manipulate the atribute wall, specifically its quantity by incrementing it in 1
     * @return the value of the numeral changed 
     */
        numeral++; // increase numeral

        return numeral;
    }



    public int deleteNumeral(){

    /*This method was created to manipulate the atribute wall, specifically its quantity by decreasing it in 1
     * @return the value of the numeral changed 
     */

        numeral --; // decrease in 1
        return numeral; 
    }
    }

