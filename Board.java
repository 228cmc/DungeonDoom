import java.util.ArrayList;
import java.util.List;
import java.util.Random; // for assigning position of the player and bot
import java.util.Scanner; // for movement

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


    private Scanner scanner;




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
        this.scanner = new Scanner(System.in);


    }



    

    public void initializeBoard(String filePath){ 

        this.validLines = emptyFloor.getValidLines(filePath);

        if (validLines.isEmpty()) {
            System.out.println("No valid lines where found");
            return;
        }
        getPositions(validLines);


        lookBoard();

        positionPlayers();

        // Update the board with the initial positions of players
        for (HumanPlayer human : humanPlayers) {
            updateBoard(human, 'P');
        }
        for (BotPlayer bot : botPlayers) {
            updateBoard(bot, 'B');
        }
        lookBoard();

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
      


    private void updateBoard(Player player, char newChar) {
        int x = player.getPositionX();
        int y = player.getPositionY();
        
        // modifies the board to update player position
        StringBuilder line = new StringBuilder(validLines.get(y));
        line.setCharAt(x, newChar); // update with the new character
        validLines.set(y, line.toString());
    }


    public void lookBoard() {
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
        System.out.println("you have exited the game. Bye");// general method to quit the game
        System.exit(0); 
    }


    public void win() {
        HumanPlayer humanPlayer = humanPlayers.get(0); // The humanPlayers list is used to store human player objects, but the method assumes that only the first player (index 0) is the active or relevant one.
        int x = humanPlayer.getPositionX();
        int y = humanPlayer.getPositionY();
    
        // check if the human player has collected enough gold to win
        if (humanPlayer.getGoldCollected() >= Gold.requiredGold()) {
            // check if the player is on an Exit tile
            for (int[] exit : exits) {
                if (exit[0] == x && exit[1] == y) {
                    System.out.println("congratulations! You've collected enough gold and reached the exit. You win!");
                    quit(); // call quit to end the game
                    return;
                }
            }
            // player has enough gold but is not on an exit
            System.out.println("you have collected enough gold, but you need to reach an exit to win");
        } else {
            // player doesn't have enough gold yet
            System.out.println("you need to collect more gold before you can win");
        }
    }
    




    private void processMove(String direction) {
        HumanPlayer human = humanPlayers.get(0); // get the human player
        BotPlayer bot = botPlayers.get(0); // get the bot player
    
        // clear the human's previous position
        updateBoard(human, '.'); 
    
        // determine new position based on direction
        switch (direction) { 
            case "NORTH":
                human.moveNorth();
                break;
            case "SOUTH":
                human.moveSouth();
                break;
            case "EAST":
                human.moveEast();
                break;
            case "WEST":
                human.moveWest();
                break;
            default:
                System.out.println("Invalid direction");
                updateBoard(human, 'P'); // restore the player's position if invalid direction
                return;
        }
    
        // check if the new position is valid (not a wall)
        int humanNewX = human.getPositionX();
        int humanNewY = human.getPositionY();
        if (validLines.get(humanNewY).charAt(humanNewX) == '#') { 
            System.out.println("You can't move, there's a wall.");
            updateBoard(human, 'P'); // restore the original position
            return;
        }
    
        // update the human's position on the board
        updateBoard(human, 'P'); 
        System.out.println("You moved " + direction);
    
        // handle bot movement
        updateBoard(bot, '.'); 
        bot.chaseHuman(human, validLines); // move the bot towards the human
        updateBoard(bot, 'B'); // update the bot's new position
    }
    

    private void processCollection(Player player) {
        int x = player.getPositionX(); // get the player's current X position
        int y = player.getPositionY(); // get the player's current Y position
    
        // search for gold at the current position
        Gold goldToCollect = null;
        for (Gold gold : golds) {
            // check if the gold's position matches the player's position
            if (gold.getPositionX() == x && gold.getPositionY() == y) {
                goldToCollect = gold; // store the gold to collect
                break; // stop searching as we found the gold
            }
        }
    
        // if there is gold to collect, handle collection
        if (goldToCollect != null) {
            player.pickUpGold(); // increment the player's gold count
            golds.remove(goldToCollect); // remove the gold from the list
            updateBoard(player, 'P'); // update the board to remove the gold
            System.out.println("sucess! Current total: " + player.getGoldCollected());
        } 
        // check if the player is at an exit
        else if (validLines.get(y).charAt(x) == 'E' && player instanceof HumanPlayer) {
            System.out.println("You reached the exit!"); // inform the player they reached the exit
            win(); // call the win method to end the game
        } 
        // if there's nothing to collect
        else {
            System.out.println("fail, nothing to collect."); // inform the player that the cell is empty
        }
    }
    


    public void processCommand(String command) {
        HumanPlayer human = humanPlayers.get(0);

        switch (command.toUpperCase()) {
            case "QUIT":
                quit(); // checks if the player wins, then calls quit
                break;
            case "LOOK":
                lookBoard();
                break;
                case "HELLO":
                 System.out.println("Gold to win: " + Gold.requiredGold());
                 break;
                
                
                //to work on 
            case "MOVE":
                System.out.print("Direction (NORTH, SOUTH, EAST, WEST): "); //explain the instructions of the movements
                String direction = scanner.nextLine().toUpperCase();
                processMove(direction); // process the movement


                break;
            case "PICKUP":
                processCollection(human); // explicitly pick up items
                break;


            case "GOLD":
                System.out.println("w");
                System.out.println("Gold owned: " + humanPlayers.get(0).getGoldCollected());
                break;
            default:
                System.out.println("Unknown command. Please try again.");
                break;
        }
    }
    
    


}
