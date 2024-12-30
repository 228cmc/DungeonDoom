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



            for (int x = 0; x < boardWidth; x++) {
                char currentChar = line.charAt(x); // Get the character at position x
    
                // Create objects based on the character
                switch (currentChar) {
                    case 'P': // Human Player
                        humanPlayer = new HumanPlayer(x, y, 0); // Create a player object
                        System.out.println("Human Player created at: (" + x + ", " + y + ")");
                        break;
    
                    case 'B': // Bot Player
                        botPlayer = new BotPlayer(x, y, 0); // Create a bot object
                        System.out.println("Bot Player created at: (" + x + ", " + y + ")");
                        break;
    
                    case 'G': // Gold
                        Gold gold = new Gold(1, x, y); // Create a gold object with 1 unit
                        System.out.println("Gold created at: (" + x + ", " + y + ")");
                        break;
    
                    case '#': // Wall
                        Wall wall = new Wall(1); 
                        System.out.println("Wall created at: (" + x + ", " + y + ")");
                        break;
    
                    case '.': // Empty floor 
                        System.out.println("Empty floor at: (" + x + ", " + y + ")");
                        break;
    
                    default:
                        System.err.println("Unknown character '" + currentChar + "' at: (" + x + ", " + y + ")");
                        break;


                }
            }


        }
    }
    public void LookGrid(){

    }

    public void quit() {
        
    }
}
