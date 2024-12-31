import java.util.ArrayList;
import java.util.List;
import java.util.Random; // for assigning position of the player and bot


public class Board {

    //declare variables with objects defined in other java files
    private List<Wall> walls; // List to save multiple wall
    private List<Gold> golds; 
    private List<BotPlayer> botPlayers;
    private List<HumanPlayer> humanPlayers;
     
    private EmptyFloor emptyFloor;//the only one  singular is emptyFloor because is just for the dimensions

    private List<int[]> exits; // to store coordinates
    private List<int[]> dots;

    private List<String> validLines; 


    public Board(){
         //we use new because we are not longer working with primitive variables
        this.emptyFloor = new EmptyFloor(0, 0);
        this.walls = new ArrayList<>();
        this.golds = new ArrayList<>();
        this.botPlayers = new ArrayList<>();
        this.humanPlayers = new ArrayList<>();
        this.exits = new ArrayList<>(); 
        this.dots = new ArrayList<>();
        this.validLines = new ArrayList<>();


    }



    

    public void initializeBoard(String filePath){ 

        this.validLines = emptyFloor.getValidLines(filePath);

        if (validLines.isEmpty()) {
            System.out.println("No valid lines where found");
            return;
        }
        getPositions(validLines);

        LookBoard();

        positionPlayers();

        LookBoard();

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
    
                    case 'E': // Exit
                        exits.add(new int[]{x, y}); //store the coordinate
                        System.out.println("Exit at: (" + x + ", " + y + ")");
                        break;

                    case '.': // Empty floor
                        dots.add(new int[]{x, y}); // store the coordinate
                        System.out.println("Empty floor at: (" + x + ", " + y + ")");
                        break;
    
                    default:
                        System.err.println("Unknown character '" + currentChar + "' at: (" + x + ", " + y + ")");
                        break;


                }
            }


        }
    }


    private void positionPlayers() {
        Random random = new Random();
    
        // Validate if players are already positioned
        if (!humanPlayers.isEmpty()) {
            System.out.println("human player is already positioned");
            return;
        }
        if (!botPlayers.isEmpty()) {
            System.out.println("bot player is already positioned");
            return;
        }
    
        
        List<int[]> validPositions = new ArrayList<>(dots); // Combine the  dots and exits to determine valid positions
        validPositions.addAll(exits);
    
        
    
        // position the human player
        int[] humanPos = validPositions.remove(random.nextInt(validPositions.size()));
        HumanPlayer humanPlayer = new HumanPlayer(humanPos[0], humanPos[1], 0); // 0 since no gold collected yet
        humanPlayers.add(humanPlayer);
        System.out.println("Human player is at: (" + humanPos[0] + ", " + humanPos[1] + ")");
    
        // Check if there are still valid positions for the bot
        if (validPositions.isEmpty()) {
            System.out.println("No valid positions available for the bot.");
            return;
        }
    
        int[] botPos = validPositions.remove(random.nextInt(validPositions.size()));        //put the bot in a different location

        BotPlayer botPlayer = new BotPlayer(botPos[0], botPos[1], 0);
        botPlayers.add(botPlayer);
        System.out.println("bot player is at: (" + botPos[0] + ", " + botPos[1] + ")");
    }
    

    public void LookBoard() {
        if (validLines == null || validLines.isEmpty()) {
            System.out.println("No  data available to show");
            return;
        }

        System.out.println("current board:");
        for (String line : validLines) {
            System.out.println(line);
        }
    }



    public void quit() {
        
    }
}
