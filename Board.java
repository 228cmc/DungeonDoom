import java.util.ArrayList;
import java.util.List;
import java.util.Random; // for assigning position of the player and bot
import java.util.Scanner; // for movement

public class Board {
    // declare variables with objects defined in other java files
    private List<Wall> walls;
    private List<Gold> golds; 
    private List<BotPlayer> botPlayers;
    private List<HumanPlayer> humanPlayers;
    private EmptyFloor emptyFloor;//the only one  singular is emptyFloor because is just for the dimensions
    private List<int[]> exits;  // to store coordinates
    private List<int[]> dots;
    private List<String> validLines; 
    private Scanner scanner;

    // global references for human and bot
    private HumanPlayer human;
    private BotPlayer bot;

    public Board() {
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
    public void getPositions(List<String> lines) {
        int boardHeight = emptyFloor.getHeight();
        int boardWidth = emptyFloor.getWidth();
    
        for (int y = 0; y < boardHeight; y++) {
            String line = lines.get(y); //get y coordinate
    
            for (int x = 0; x < boardWidth; x++) {
                char currentChar = line.charAt(x); // Get the character at position x
    
                // create objects based on the character
                switch (currentChar) {
                    case 'P': // Human Player
                        // create and add a human player at this position
                        HumanPlayer humanPlayer = new HumanPlayer(x, y, 0);
                        humanPlayers.add(humanPlayer);
                        break;
                    case 'B': // Bot Player
                        // create and add a bot player at this position
                        BotPlayer botPlayer = new BotPlayer(x, y, 0); // Create a bot object
                        botPlayers.add(botPlayer); //add it to the botPlayer list
                        break;
                    case 'G': // gold
                        // create and add gold at this position
                        Gold gold = new Gold(1, x, y);  //create a gold object with value 1 
                        golds.add(gold); //add it to the gold list
                        break;
                    case '#':  // Wall
                        // add a wall object
                        Wall wall = new Wall(1);
                        walls.add(wall);
                        break;
                    case 'E': // Exit
                        // store exit coordinates
                        exits.add(new int[]{x, y});
                        break;
                    case '.': // Empty floor
                        // store empty floor coordinates
                        dots.add(new int[]{x, y}); // store the coordinate
                        break;
                    default:
                        System.out.println("Unknown character in map: " + currentChar);
                        break;
                }
            }
        }
    }

    public void lookBoard5X5() {
        if (validLines == null || validLines.isEmpty()) {
            System.out.println("no data available to show");
            return;
        }
    
        int playerX = human.getPositionX();
        int playerY = human.getPositionY();
    
        // grid size and center offset
        int gridSize = 5;
        int halfGrid = gridSize / 2;
    
        System.out.println("current view (5x5):");
    
        // iterate over the rows of the grid
        for (int y = playerY - halfGrid; y <= playerY + halfGrid; y++) {
            StringBuilder line = new StringBuilder();
    
            // iterate over the columns of the grid
            for (int x = playerX - halfGrid; x <= playerX + halfGrid; x++) {
                // add '#' for out-of-bound positions
                if (y < 0 || y >= validLines.size() || x < 0 || x >= validLines.get(y).length()) {
                    line.append('#');
                } else {
                    // add character from the map
                    line.append(validLines.get(y).charAt(x));
                }
            }
    
            // print the constructed line for the current row
            System.out.println(line);
        }
    }
    

    private void updateBoard(Player player, char newChar) {
        int x = player.getPositionX(); // get the player's X position
        int y = player.getPositionY(); // same for the the player's y position
        // Actualiza el carácter en la posición especificada
        StringBuilder line = new StringBuilder(validLines.get(y));
        line.setCharAt(x, newChar); // replaces character at position
        validLines.set(y, line.toString()); //  update the line on the dashboard
    }
    
    private void positionPlayers() {
        Random random = new Random();
    
        // combine valid positions from dots and exits
        List<int[]> validPositions = new ArrayList<>(dots);
        validPositions.addAll(exits);
    
        // assign a random position to the human player
        int[] humanPos = validPositions.remove(random.nextInt(validPositions.size()));
        HumanPlayer humanPlayer = new HumanPlayer(humanPos[0], humanPos[1], 0);
        humanPlayers.add(humanPlayer);
    
        // check if there are still valid positions for the bot
        if (validPositions.isEmpty()) {
            System.out.println("No valid positions available for the bot.");
            return;
        }
    
        // assign a random position to the bot player
        int[] botPos = validPositions.remove(random.nextInt(validPositions.size()));
        BotPlayer botPlayer = new BotPlayer(botPos[0], botPos[1], 0);
        botPlayers.add(botPlayer);
    
        // assign references to global variables (optional, as this will be set in initializeBoard)
        this.human = humanPlayer;
        this.bot = botPlayer;
    }
    

    public void initializeBoard(String filePath) {
        this.validLines = emptyFloor.getValidLines(filePath);

        if (validLines.isEmpty()) {
            System.out.println("No valid lines where found");
            return;
        }
        getPositions(validLines);


        positionPlayers();

        // initialize global references
        this.human = humanPlayers.get(0);
        this.bot = botPlayers.get(0);

        // update the board
        updateBoard(human, 'P');
        updateBoard(bot, 'B');

        lookBoard5X5();
    }

    public void processCommand(String command) {
        switch (command.toUpperCase()) {
            case "QUIT":
                quit();
                break;
            case "LOOK":
                lookBoard5X5();
                break;
            case "MOVE":
                System.out.print("Direction (NORTH, SOUTH, EAST, WEST): ");
                String direction = scanner.nextLine().toUpperCase();
                processMove(direction);
                break;
            case "PICKUP":
                processCollection(human);
                break;
            case "GOLD":
                System.out.println("Gold owned: " + human.getGoldCollected());
                break;
                case "HELLO":
                System.out.println("Gold to win " + Gold.requiredGold() + " gold to win.");
                break;
            default:
                System.out.println("Unknown command. Please try again.");
                break;
        }
    }

    private void processMove(String direction) {
        // save current position of the human player
        int currentX = human.getPositionX();
        int currentY = human.getPositionY();
    
        // update the position of the human based on the direction
        switch (direction) {
            case "NORTH":
                human.moveNorth();   // move up
                break;
            case "SOUTH":
                human.moveSouth();   // move down
                break;
            case "EAST":
                human.moveEast();    // move right
                break;
            case "WEST":
                human.moveWest();    // move left
                break;
            default:
                System.out.println("invalid direction");    // handle invalid input
                return;
        }
    
        // check if the new position is valid (not a wall)
        if (validLines.get(human.getPositionY()).charAt(human.getPositionX()) == '#') {
            System.out.println("Fail!, you can't move, there's a wall.");  // inform user
            // revert to original position if movement is invalid
            human.setPositionX(currentX);
            human.setPositionY(currentY);
            return;
        }
    
        // preserve gold if present at the previous position
        StringBuilder line = new StringBuilder(validLines.get(currentY));
        if (golds.stream().anyMatch(g -> g.getPositionX() == currentX && g.getPositionY() == currentY)) {
            // if there is gold, keep it
            line.setCharAt(currentX, 'G');
        } else {
            // otherwise, replace with a dot
            line.setCharAt(currentX, '.');
        }
        validLines.set(currentY, line.toString());
    
        // update the board to show the new position of the human
        line = new StringBuilder(validLines.get(human.getPositionY()));
        line.setCharAt(human.getPositionX(), 'P');    // place 'P' for the player
        validLines.set(human.getPositionY(), line.toString());
    
        System.out.println(" Sucess! you moved " + direction); // inform the user of the movement
    






        // Move the bot
        StringBuilder botLine = new StringBuilder(validLines.get(bot.getPositionY()));

        // check if the bot is leaving a position with gold
        if (golds.stream().anyMatch(g -> g.getPositionX() == bot.getPositionX() && g.getPositionY() == bot.getPositionY())) {
            // restore gold at the bot's previous position
            botLine.setCharAt(bot.getPositionX(), 'G');
        } else {
            // clear the bot's previous position
            botLine.setCharAt(bot.getPositionX(), '.');
        }
        validLines.set(bot.getPositionY(), botLine.toString());

        bot.chaseHuman(human, validLines);   // move the bot closer to the human

        // update the board with the bot's new position
        botLine = new StringBuilder(validLines.get(bot.getPositionY()));
        botLine.setCharAt(bot.getPositionX(), 'B');  // place 'B' for the bot
        validLines.set(bot.getPositionY(), botLine.toString());

    
        // check if the bot caught the human
        lose();
    }
    




    private void processCollection(Player player) {
        int x = player.getPositionX();
        int y = player.getPositionY();
    
        // search for gold at the current position
        Gold goldToCollect = null;
        for (Gold gold : golds) {
            if (gold.getPositionX() == x && gold.getPositionY() == y) {
                goldToCollect = gold;
                break;
            }
        }
    
        // if there is gold to collect, handle collection
        if (goldToCollect != null) {
            player.pickUpGold();
            golds.remove(goldToCollect);
            System.out.println("Success! You have now gold! Total: " + player.getGoldCollected());
    
            // clear the gold from the board but keep the player 'P'
            StringBuilder line = new StringBuilder(validLines.get(y));
            line.setCharAt(x, 'P'); // retain 'P' for the player
            validLines.set(y, line.toString());
        } else if (validLines.get(y).charAt(x) == 'E' && player instanceof HumanPlayer) {
            System.out.println("You reached the exit!");
            win();
        } else {
            System.out.println("Nothing to collect here.");
        }
    }
    



    public void win() {
        boolean isOnExit = false;
        for (int[] exit : exits) {
            if (exit[0] == human.getPositionX() && exit[1] == human.getPositionY()) {
                isOnExit = true;
                break;
            }
        }

        if (isOnExit && human.getGoldCollected() >= Gold.requiredGold()) {
            System.out.println("Congratulations! You've collected enough gold and reached the exit. You win!");
            quit();
        } else if (isOnExit) {
            System.out.println("You reached the exit, but you don't have enough gold. You lose!");
            quit();
        } else {
            System.out.println("You need to reach an exit with enough gold to win!");
        }
    }

    public void quit() {
        boolean isOnExit = false;
    
        // verificar si el humano está en una salida
        for (int[] exit : exits) {
            if (exit[0] == human.getPositionX() && exit[1] == human.getPositionY()) {
                isOnExit = true;
                break;
            }
        }
    
        if (isOnExit) {
            if (human.getGoldCollected() >= Gold.requiredGold()) {
                System.out.println("You have WIN! Congratulations, you collected enough gold and reached an exit.");
            } else {
                System.out.println("LOSE! You reached the exit but don't have enough gold.");
            }
        } else {
            System.out.println("You quit the game without reaching an exit.");
        }
    
        System.exit(0);
    }


    public void lose() {
        // check if the bot's position is the same as the human's position
        if (bot.getPositionX() == human.getPositionX() && bot.getPositionY() == human.getPositionY()) {
            System.out.println("you lost! the bot caught you!"); // inform the player they lost
            System.exit(0); // terminate the game
        }
    }
    
    
}
