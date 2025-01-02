import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {  
        String filePath;
        Scanner fileScanner = new Scanner(System.in); // scanner for file path
        Scanner commandScanner = null; // scanner for game commands

        try {
            // get file path
            if (args.length < 1) {
                System.out.println("No file path given, please type the path:");
                filePath = fileScanner.nextLine();
            } else {
                filePath = args[0];
            }

            
            Board board = new Board();// initialize the board
            board.initializeBoard(filePath);

            
            commandScanner = new Scanner(System.in); // initialize scanner for commands
            String command;

            System.out.println("Type a command (QUIT, LOOK, MOVE, HELLO, PICKUP, GOLD):");
            while (true) {
                System.out.print("your turn: ");
                command = commandScanner.nextLine();
                board.processCommand(command);
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // close scanners
            if (fileScanner != null) {
                fileScanner.close();
            }
            if (commandScanner != null) {
                commandScanner.close();
            }
        }
    }
}

