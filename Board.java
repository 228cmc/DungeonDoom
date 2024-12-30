import java.util.ArrayList;
import java.util.List;

public class Board {

    //declare variables with objects defined in other java files
    private  EmptyFloor emptyFloor; // Declare a variable named emptyFloor that will hold an object of type EmptyFloor
    private  Wall wall; 
    private  int titles;
    private Gold gold; 
    private BotPlayer botPlayer;
    private HumanPlayer humanPlayer;

    public Board(){
        this.emptyFloor = new EmptyFloor(0,0); //we use new because we are not longer working with primitive variables
        this.wall = new Wall(titles);  //
        this.botPlayer = new BotPlayer(titles, titles, titles);
        this.humanPlayer  = new HumanPlayer(titles, titles, titles);
    }

    public void initializeBoard(String filePath){ 

        List<String> lines = emptyFloor.getValidLines(filePath);

        if (lines.isEmpty()) {
            System.out.println("No valid lines where found");
            return;
        }
    }



    public void getPostitions (List<String> lines) {

        int boardHeight = emptyFloor.getHeight();
        int boardWidth = emptyFloor.getWidth();


        for ( int y=0; y< boardHeight; y ++) {
            String line = lines.get(y); //get y coordinate



        }
    }




    public void LookGrid(){

    }

    public void quit() {
        
    }
}
