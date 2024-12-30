public class Main{ // main doesn't have a constructor it is an special method
// to execute test javac Main.java ... java Main


public static  void main (String[] args) {  //main  lowercase is a method
    Gold gold = new Gold(5,2,3);

    EmptyFloor floor = new EmptyFloor(1,2);// 1 and 2 values for test purposes
    floor.getValidLines("exampleBoard.txt");
    
    System.out.println("Gold amount : " + gold.currentGold());
    gold.addGold();
    System.out.println("Gold amount : " + gold.currentGold());
    }

}