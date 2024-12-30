import java.util.ArrayList;
import java.util.List;

public class Board {

    //declare variables with objects defined in other java files
    private List<Wall> walls; // List to save multiple wall
    private List<Gold> golds; 
    private List<BotPlayer> botPlayers;
    private List<HumanPlayer> humanPlayers;
    

    
    private EmptyFloor emptyFloor;//the only one  singular is emptyFloor because is just for the dimensions

    public Board(){
         //we use new because we are not longer working with primitive variables
        this.emptyFloor = new EmptyFloor(0, 0);
        this.walls = new ArrayList<>();
        this.golds = new ArrayList<>();
        this.botPlayers = new ArrayList<>();
        this.humanPlayers = new ArrayList<>();
    }



    

    public void initializeBoard(String filePath){ 

        List<String> lines = emptyFloor.getValidLines(filePath);

        if (lines.isEmpty()) {
            System.out.println("No valid lines where found");
            return;
        }
        getPositions(lines);

    }



    public void getPositions (List<String> lines) {

        int boardHeight = emptyFloor.getHeight();
        int boardWidth = emptyFloor.getWidth();


        for ( int y=0; y< boardHeight; y ++) {
            String line = lines.get(y); //get y coordinate



            for (int x = 0; x < boardWidth; x++) {
                char currentChar = line.charAt(x); // Get the character at position x
    
                // Create objects based on the character
                switch (currentChar) {
                    case 'P': // Human Player
                        HumanPlayer humanPlayer = new HumanPlayer(x, y, 0); // Create a player  object 0 because no gold yet has been collected
                        humanPlayers.add(humanPlayer);  //add it to the  human list
                        System.out.println("Human Player created at: (" + x + ", " + y + ")");
                        break;
    
                    case 'B': // Bot Player
                        BotPlayer botPlayer = new BotPlayer(x, y, 0); // Create a bot object
                        botPlayers.add(botPlayer); //add it to the botPlayer list
                        System.out.println("Bot Player created at: (" + x + ", " + y + ")");
                        break;
    
                    case 'G': // Gold
                        Gold gold = new Gold(1, x, y); //create a gold object with value 1 
                        golds.add(gold); //add it to the gold list
                        System.out.println("Gold created at: (" + x + ", " + y + ")");
                        break;
    
                    case '#': // Wall
                        Wall wall = new Wall(1);
                        walls.add(wall);
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
