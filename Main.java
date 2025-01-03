import java.util.Scanner;

public class Main { 

/**This class was build  to be a entry point of the game Dungeon of Doom
 * it takes the user input, firstly the filepath is asked and then the game commands are provided
 * it initializes the game board and process the commands in a loop
 */

    public static void main(String[] args) {  

        //variables fo store the user input for the file processing
        String filePath;
        Scanner fileScanner = new Scanner(System.in); // scanner for reading file path
        Scanner commandScanner = null; // scanner for game commands

        try {


            // get file path
            if (args.length < 1) { //validate that is not empty
                System.out.println("please type the name of the file:");
                filePath = fileScanner.nextLine(); //read path from the user input


            } else {
                filePath = args[0]; // Use the first command-line argument as the file path
            }

            
            Board board = new Board();// initialize the board
            board.initializeBoard(filePath);// create a biard using the file

            
            commandScanner = new Scanner(System.in); // initialize scanner for commands
            String command;

            System.out.println("Type a command (QUIT, LOOK, MOVE NORTH, MOVE SOUTH, MOVE EAST, MOVE WEST, HELLO, PICKUP, GOLD):"); //specify which commmands the user can type
            while (true) {
                System.out.print("your turn: ");
                command = commandScanner.nextLine(); // read a command
                board.processCommand(command); //pass the command  to the game for processing it
            }


        //error handling
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();



        } finally {
            
            if (fileScanner != null) { //close scanners
                fileScanner.close();
            }


            if (commandScanner != null) {
                commandScanner.close();
            }
        }
    }
}

